package self.unity.web.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yangguoqing
 */
@Data
@ConfigurationProperties("unified.web")
public class UnifiedWebProperty {

	/**
	 * 是否启用cros
	 */
	@Value("${cros-enable:false}")
	private boolean crosEnable;

	/**
	 * 设置允许origin
	 */
	@Value("${cros-allowed-origin:*}")
	private String crosAllowedOrigin;

	/**
	 * 设置允许header
	 */
	@Value("${cros-allowed-header:*}")
	private String crosAllowedHeader;

	/**
	 * 设置允许method
	 */
	@Value("${cros-allowed-method:*}")
	private String crosAllowedMethod;

	/**
	 * 设置允许path
	 */
	@Value("${cros-path:/**}")
	private String crosPath;

}
