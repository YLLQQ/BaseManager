package self.unity.tool.util;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * com.mobile.auth.service.util.MainUtil
 *
 * @author eleven
 * @date 2019/09/12
 */
public class MainUtil {

	public static boolean insertOrUpdateSuccess(int row) {
		return row > 0;
	}

	/**
	 * 输入流转换为字符串
	 *
	 * @param inputStream
	 *
	 * @return
	 */
	public static String inputStreamToString(InputStream inputStream) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		String str;
		StringBuilder stringBuilder = new StringBuilder();

		try {
			while (!StringUtils.isEmpty(str = reader.readLine())) {
				stringBuilder.append(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return stringBuilder.toString();
	}
}
