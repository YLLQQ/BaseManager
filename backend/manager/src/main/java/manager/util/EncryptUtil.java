package manager.util;

import com.google.common.hash.Hashing;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

/**
 * @author yangguoqing
 */
public class EncryptUtil {

	public static void main(String[] args) throws Exception {
		String str = "{\"authCardName\":\"张波\",\"authCardType\":2,\"terminalLocation\":\"321\"," +
				"\"companyName\":\"zyzx\",\"authCardId\":\"360***********2317\",\"healthCodeMessage\":\"绿码\"," +
				"\"terminalId\":\"1111\",\"authTime\":\"2020-04-02 15:41:30\",\"useFaceAuth\":false}";


		String key = "88a49ef474a611ea9a440242ac120003";

		String encrypt = encrypt(str, key);

//		System.out.println(encrypt);

		encrypt = "ZZiNBshdazXIqLhHngI0KhnkR+0EGJAY+yBo8d8fh+e4axa" +
				"/R4LwaxIme8kxJCsSIBQBpMjz2xB2kRv8wvFcvYvg7SsCbmmFGZY31sZNriWuM3yWM21KqqWdztei5sMiPftAiDmrHc6l+t0184tT1Bs5yPWnDGLtCp9eYEUYaspS9McXjIAF+bI76wibuAn8efggScIF/DZW1nJS5WFpgbvrP5K5IZFWet8pTgx7J1c4TjkZDP5ZmEkVsfSPfH7Qvfw5MJbmrbaZuEMVM2yL7MM0unVln5zLwzL2scLCRXppSfpI2gjqQigAm6vvCOF7oSjAhI66+uGtdWL9aQIMRKo0Xe3+Boj5+OAJ81EgnZm6Sqg+uG5FyXKsyUXNg3QocFV9+bMfjmu6c0tCYXosJQ==";

		System.out.println(encrypt);

		String decrypt = decrypt(encrypt, key);

		System.out.println(decrypt);


	}

	public static String encrypt(String str, String password) {
		try {
			str = Base64Utils.encodeToString(str.getBytes());
			final byte[] datasource = str.getBytes();
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(password.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey secretKey = keyFactory.generateSecret(desKey);
			Cipher cipher = Cipher.getInstance("DES");

			cipher.init(Cipher.ENCRYPT_MODE, secretKey, random);

			byte[] result = cipher.doFinal(datasource);

			return Base64Utils.encodeToString(result);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String decrypt(String str, String password) {
		try {
			byte[] strBytes = Base64Utils.decodeFromString(str);
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(password.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey secretKey = keyFactory.generateSecret(desKey);
			Cipher cipher = Cipher.getInstance("DES");

			cipher.init(Cipher.DECRYPT_MODE, secretKey, random);

			byte[] resultBytes = cipher.doFinal(strBytes);
			byte[] resultDecode = Base64Utils.decode(resultBytes);

			return new String(resultDecode, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}


	/**
	 * DES加密
	 *
	 * @param plainText
	 * @param decKey
	 *
	 * @return
	 *
	 * @throws Exception
	 */
	private static byte[] encryptWithDES(String plainText, String decKey) throws Exception {
		// 初始化向量
		IvParameterSpec ips = new IvParameterSpec("01234567".getBytes());
		// 创建一个DESKeySpec对象
		DESedeKeySpec desKey = new DESedeKeySpec(decKey.getBytes());
		// 创建一个密匙工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		// 将DESKeySpec对象转换成SecretKey对象
		SecretKey secureKey = keyFactory.generateSecret(desKey);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		// 用密匙初始化Cipher对象
		cipher.init(cipher.ENCRYPT_MODE, secureKey, ips);
		// 真正开始加密操作
		return cipher.doFinal(plainText.getBytes("UTF-8"));
	}

	/**
	 * DES解密
	 *
	 * @param plainText
	 * @param decKey
	 *
	 * @return
	 *
	 * @throws Exception
	 */
	public static String encryptWithDESCodecEncode(String plainText, String decKey) {
		//先按decKey加密 再使用org.apache.tomcat.util.codec.binary.Base64;
		try {
			return org.apache.tomcat.util.codec.binary.Base64.encodeBase64String(encryptWithDES(plainText, decKey));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * md5加密
	 *
	 * @param string 待加密字符串
	 *
	 * @return
	 */
	public static String md5(String string) {
		return Hashing.md5().hashBytes(string.getBytes()).toString();
	}
}
