package mspring4.S_5_1;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"mspring4.S_5_1"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION,
                        value = EnableWebMvc.class
                )
        })
public class RootConfig {
}
