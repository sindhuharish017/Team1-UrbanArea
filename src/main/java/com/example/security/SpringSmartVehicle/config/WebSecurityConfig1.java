package com.example.security.SpringSmartVehicle.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled=true,securedEnabled=true,prePostEnabled=true)
public class WebSecurityConfig1 {

	@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http)  throws Exception{  

	 	http.csrf().disable();
	 	
		http.headers().frameOptions().disable();
		http.authorizeRequests()
		.antMatchers("/userlogin").hasAnyRole("USER")
		.antMatchers("/admin").hasAnyRole("ADMIN")	
		.antMatchers("/createdl").authenticated()
		.antMatchers("/updatedl/**").authenticated()
		.antMatchers("/updateddllist").authenticated()
		.antMatchers("/GenerateOTP").authenticated()
		.antMatchers("/dllist/**").authenticated()
		.antMatchers("/police/**").authenticated()
		.antMatchers("/accessDenied").authenticated()
		.antMatchers("/allowAccess/**").authenticated()
		.antMatchers("/vehicleType/**").authenticated()
		.antMatchers("/register").authenticated()
		.anyRequest().permitAll()
         .and()
      .formLogin()
      .loginPage("/admin")
      .usernameParameter("username")
      .passwordParameter("pass")
        .defaultSuccessUrl("/createdl").failureUrl("/admin?error=true")
        .permitAll()
        .and()
        .httpBasic(); 
	
     http.logout() 
       .permitAll()
       
       .and()
       .exceptionHandling().accessDeniedPage("/403");
//     .httpBasic(); 
		return http.build();
 }
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder) {
		
		InMemoryUserDetailsManager udm =new InMemoryUserDetailsManager();
	
		

		udm.createUser(User.withUsername("admin").password(passwordEncoder.encode("admin@123")).roles("ADMIN","USER").build());

		return udm;
		
	}
	
}

