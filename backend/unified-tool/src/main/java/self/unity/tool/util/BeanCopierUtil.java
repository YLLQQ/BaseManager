package self.unity.tool.util;

import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yangguoqing
 */
public class BeanCopierUtil {

	private static final Map<String, BeanCopier> BEAN_COPIER_MAP = new ConcurrentHashMap<>();

	public static <S, T> List<T> copyS2TList(List<S> sList, Class<T> tClass) {
		ArrayList<T> tList = new ArrayList<>(sList.size());

		sList.forEach(item -> {
			tList.add(copyS2T(item, tClass));
		});

		return tList;
	}

	public static <S, T> T copyS2T(S source, T target) {
		BeanCopier beanCopier = getBeanCopier(source.getClass(), target.getClass());

		beanCopier.copy(source, target, null);

		return target;
	}

	public static <S, T> T copyS2T(S source, Class<T> tClass) {
		T t;

		try {
			t = tClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException("create new instance of " + tClass + " failed: %s");
		}

		BeanCopier beanCopier = getBeanCopier(source.getClass(), tClass);

		beanCopier.copy(source, t, null);

		return t;
	}

	private static BeanCopier getBeanCopier(Class sourceClass, Class targetClass) {
		String copierKey = generateKey(sourceClass, targetClass);
		BeanCopier copier = BEAN_COPIER_MAP.get(copierKey);

		if (null == copier) {
			copier = BeanCopier.create(sourceClass, targetClass, false);

			BEAN_COPIER_MAP.put(copierKey, copier);
		}

		return copier;
	}

	private static String generateKey(Class cl1, Class cl2) {
		return cl1.getName() + "_" + cl2.getName();
	}

	private BeanCopierUtil() {
	}
}
