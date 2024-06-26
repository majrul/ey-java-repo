package com.ey.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.ey.component") //equivalent to <context:component-scan .. />
public class MySpringConfig {

	//@Bean -- this is equivalent to <bean tag of xml />
}
