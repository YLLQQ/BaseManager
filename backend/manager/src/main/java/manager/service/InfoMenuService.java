package manager.service;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import manager.dto.InfoMenuDTO;
import manager.mapper.TbInfoMenuMapper;
import manager.model.TbInfoMenu;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.unity.response.exception.UnifiedInteractiveException;
import self.unity.tool.util.BeanCopierUtil;
import self.unity.tool.util.CollectionUtil;
import self.unity.tool.util.MainUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static manager.mapper.TbInfoMenuDynamicSqlSupport.*;
import static manager.response.ManagerCodeEnum.MENU_INFO_LIST_MISSING;
import static manager.response.ManagerCodeEnum.MENU_INFO_NOT_EXISTS;
import static org.mybatis.dynamic.sql.select.SelectDSL.select;
import static org.mybatis.dynamic.sql.select.SelectDSL.selectDistinct;

@Slf4j
@Service
public class InfoMenuService {

	public Set<InfoMenuDTO> packAllMenuByRoleId(Integer roleId) {
		List<Integer> allMenuIdByRoleId = relationMenuRoleService.getAllMenuIdByRoleId(roleId);

		if (null == allMenuIdByRoleId || allMenuIdByRoleId.isEmpty()) {
			return Sets.newHashSet();
		}

		List<TbInfoMenu> all = getAll();

		HashMap<Integer, TbInfoMenu> menuHashMap = Maps.newHashMap();

		all.forEach(item -> menuHashMap.put(item.getId(), item));

		Set<TbInfoMenu> tempSet = Sets.newHashSet();

		allMenuIdByRoleId.forEach(menuId -> {
			TbInfoMenu tbInfoMenu = menuHashMap.get(menuId);

			while (true) {
				tempSet.add(tbInfoMenu);

				if (0 == tbInfoMenu.getParentMenuId()) {
					break;
				}

				tbInfoMenu = menuHashMap.get(tbInfoMenu.getParentMenuId());
			}
		});

		ArrayList<TbInfoMenu> tbInfoMenus = new ArrayList<>(tempSet);

		return pack(tbInfoMenus);
	}

	public InfoMenuDTO getById(Integer id) {
		TbInfoMenu tbInfoMenu =
				tbMenuInfoMapper
						.selectByPrimaryKey(id)
						.orElseThrow(() -> new UnifiedInteractiveException(MENU_INFO_NOT_EXISTS));

		return BeanCopierUtil.copyS2T(tbInfoMenu, InfoMenuDTO.class);
	}

	public List<Integer> getAllParentId() {
		SelectStatementProvider selectStatementProvider =
				selectDistinct(parentMenuId)
						.from(tbInfoMenu).build()
						.render(RenderingStrategies.MYBATIS3);

		List<TbInfoMenu> tbInfoMenus = tbMenuInfoMapper.selectMany(selectStatementProvider);

		List<Integer> parentIdList =
				tbInfoMenus.stream().map(item -> item.getParentMenuId()).collect(Collectors.toList());

		return parentIdList;
	}

	public Set<InfoMenuDTO> packAll() {
		List<TbInfoMenu> all = this.getAll();

		return pack(all);
	}

	public Set<InfoMenuDTO> pack(List<TbInfoMenu> all) {
		List<InfoMenuDTO> menuInfoDTOS = BeanCopierUtil.copyS2TList(all, InfoMenuDTO.class);

		HashMultimap<Integer, InfoMenuDTO> multiMap = HashMultimap.create();

		for (InfoMenuDTO dto : menuInfoDTOS) {
			multiMap.put(dto.getParentMenuId(), dto);
		}

		Set<InfoMenuDTO> tbInfoMenus = multiMap.get(0);

		for (InfoMenuDTO infoMenu : tbInfoMenus) {
			Integer firstLevelId = infoMenu.getId();

			Set<InfoMenuDTO> secondLevelMenus = multiMap.get(firstLevelId);

			if (null == secondLevelMenus) {
				continue;
			}

			for (InfoMenuDTO secondLevelMenu : secondLevelMenus) {
				Integer secondLevelId = secondLevelMenu.getId();

				Set<InfoMenuDTO> thirdLevelMenus = multiMap.get(secondLevelId);


				if (null == thirdLevelMenus) {
					continue;
				}

				secondLevelMenu.setChildren(thirdLevelMenus);
			}

			infoMenu.setChildren(secondLevelMenus);
		}

		return tbInfoMenus;
	}

	public List<TbInfoMenu> getAll() {
		SelectStatementProvider selectStatementProvider =
				select(id, menuName, parentMenuId, menuIconPath, menuLinkPath)
						.from(tbInfoMenu).build()
						.render(RenderingStrategies.MYBATIS3);

		List<TbInfoMenu> tbInfoMenus = tbMenuInfoMapper.selectMany(selectStatementProvider);

		CollectionUtil.collectionIsNotEmpty(tbInfoMenus, MENU_INFO_LIST_MISSING);

		return tbInfoMenus;
	}

	public boolean add(String menuName, Integer parentMenuId, String menuIconPath, String menuLinkPath) {
		TbInfoMenu tbInfoMenu = new TbInfoMenu();

		tbInfoMenu.setMenuIconPath(menuIconPath);
		tbInfoMenu.setMenuLinkPath(menuLinkPath);
		tbInfoMenu.setMenuName(menuName);
		tbInfoMenu.setParentMenuId(parentMenuId);

		int row = tbMenuInfoMapper.insertSelective(tbInfoMenu);

		return MainUtil.insertOrUpdateSuccess(row);
	}

	public boolean update(Integer id, String menuName, Integer parentMenuId, String menuIconPath,
						  String menuLinkPath) {
		TbInfoMenu tbInfoMenu = new TbInfoMenu();

		tbInfoMenu.setId(id);
		tbInfoMenu.setMenuIconPath(menuIconPath);
		tbInfoMenu.setMenuLinkPath(menuLinkPath);
		tbInfoMenu.setMenuName(menuName);
		tbInfoMenu.setParentMenuId(parentMenuId);

		int row = tbMenuInfoMapper.updateByPrimaryKeySelective(tbInfoMenu);

		return MainUtil.insertOrUpdateSuccess(row);
	}

	private RelationMenuRoleService relationMenuRoleService;

	@Autowired
	public void setRelationMenuRoleService(RelationMenuRoleService relationMenuRoleService) {
		this.relationMenuRoleService = relationMenuRoleService;
	}

	private TbInfoMenuMapper tbMenuInfoMapper;

	@Autowired
	public void setTbMenuInfoMapper(TbInfoMenuMapper tbMenuInfoMapper) {
		this.tbMenuInfoMapper = tbMenuInfoMapper;
	}
}
