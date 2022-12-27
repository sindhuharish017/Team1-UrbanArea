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
public SecurityFilterChain securityFilterChain(HttpSecurity http)  throws Exception{  // (2)

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

        .defaultSuccessUrl("/createdl").failureUrl("/login?error=true")// (5)
        .permitAll()
        .and()
        .httpBasic(); 
     http.logout() // (6)
       .permitAll()
       .and()
     .httpBasic(); // (7)
		return http.build();
 }
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder) {
		
		InMemoryUserDetailsManager udm =new InMemoryUserDetailsManager();
	
		
//		udm.createUser(User.withUsername("scott").password(passwordEncoder.encode("tiger")).roles("USER").build());
		udm.createUser(User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("ADMIN","USER").build());

		return udm;
		
	}
	
}

