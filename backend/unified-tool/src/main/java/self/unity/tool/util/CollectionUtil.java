package self.unity.tool.util;

import self.unity.response.exception.UnifiedInteractiveException;
import self.unity.response.inter.UnifiedResponseInter;

import java.util.Collection;

/**
 * @author yangguoqing
 */
public class CollectionUtil {

	public static boolean collectionIsNotEmpty(Collection collection) {
		return collectionIsNotEmpty(collection, null);
	}

	public static boolean collectionIsNotEmpty(Collection collection, UnifiedResponseInter unifiedResponseInter) {
		boolean check = null == collection || collection.isEmpty();

		if (check && null != unifiedResponseInter) {
			throw new UnifiedInteractiveException(unifiedResponseInter);
		}

		return check;
	}
}
