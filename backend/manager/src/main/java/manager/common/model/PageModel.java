package manager.common.model;

import lombok.Data;

import java.util.List;

/**
 * @author yangguoqing
 */
@Data
public class PageModel<T> {

	private int pageNum;

	private int pageSize;

	private long total;

	private List<T> list;
}
