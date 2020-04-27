package manager.interactive.manager;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;

/**
 * @author yangguoqing
 */
@Data
@Slf4j
public class GetManagerInfoByPasswordRequest {

	@NotBlank
	private String loginName;

	@NotBlank
	private String password;
}
