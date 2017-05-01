package pl.motyka.mateusz;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = { "pl.motyka.mateusz" }, excludeFilters = {
		@Filter(type = FilterType.REGEX, pattern = "pl\\.motyka\\.mateusz\\.web\\..*") })
// @ImportResource({"classpath:/applicationContext.xml"})//,"classpath:/database-config.xml"})
public class SpringBusinessConfig {

	/*
	 * @Autowired DataSource dataSource;
	 * 
	 * @Bean public JdbcTemplate getJdbcTemplate() { return new
	 * JdbcTemplate(dataSource); }
	 */
}
