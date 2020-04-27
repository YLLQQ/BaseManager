package self.unity.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import self.unity.web.advice.UnifiedExceptionAdvice;
import self.unity.web.advice.UnifiedResponseBodyAdvice;
import self.unity.web.property.UnifiedWebProperty;

/**
 * @author yangguoqing
 */
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(UnifiedWebProperty.class)
public class StarterAutoConfigure {

	private UnifiedWebProperty unifiedWebProperty;

	@Autowired
	public void setUnifiedWebProperty(UnifiedWebProperty unifiedWebProperty) {
		this.unifiedWebProperty = unifiedWebProperty;
	}

	@Bean
	public UnifiedResponseBodyAdvice UnifiedResponseBodyAdvice() {
		return new UnifiedResponseBodyAdvice();
	}

	@Bean
	public UnifiedExceptionAdvice unifiedExceptionAdvice() {
		return new UnifiedExceptionAdvice();
	}

	@Bean
	@Order(0)
	@ConditionalOnMissingBean
	@ConditionalOnProperty(prefix = "unified.web", value = "cros-enable", havingValue = "true")
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();

		config.setAllowCredentials(true);
		config.addAllowedOrigin(unifiedWebProperty.getCrosAllowedOrigin());
		config.addAllowedHeader(unifiedWebProperty.getCrosAllowedHeader());
		config.addAllowedMethod(unifiedWebProperty.getCrosAllowedMethod());

		source.registerCorsConfiguration(unifiedWebProperty.getCrosPath(), config);

		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));

		bean.setOrder(0);

		return bean;
	}
}
