package za.ac.cput.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("faculty-user")
               .password(bCryptPasswordEncoder.encode("721087c4-0ede-407e-8c1f-ac57e531f292"))
               .roles("USER")
               .build()
        );

        manager.createUser(User.withUsername("faculty-admin")
               .password(bCryptPasswordEncoder.encode("721087c4-0ede-407e-8c1f-ac57e531f293"))
               .roles("USER", "FACULTY-ADMIN")
               .build()
        );
        
        manager.createUser(User.withUsername("student-user")
               .password(bCryptPasswordEncoder.encode("721087c4-0ede-407e-8c1f-ac57e531f292"))
               .roles("USER")
   
            .build()
        );

        manager.createUser(User.withUsername("student-admin")
               .password(bCryptPasswordEncoder.encode("721087c4-0ede-407e-8c1f-ac57e531f293"))
               .roles("USER", "STUDENT-ADMIN")
               .build()
        );

        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.httpBasic()
            .and().csrf().disable().formLogin().disable()
            //URL Path Matchers for the Faculty Domain.
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/**/faculty/save").hasRole("FACULTY-ADMIN")
            .antMatchers(HttpMethod.DELETE, "/**/faculty/delete").hasRole("FACULTY-ADMIN")
            .antMatchers(HttpMethod.DELETE, "/**/faculty/delete/{facultyId}").hasRole("FACULTY-ADMIN")
            .antMatchers(HttpMethod.GET, "/**/faculty/read").hasAnyRole("USER", "FACULTY-ADMIN")
            .antMatchers(HttpMethod.GET, "/**/faculty/find-all").hasAnyRole("USER", "FACULTY-ADMIN")
            //Add your Path Matchers for your domains here and put a comment in place to signal
            //to other team members that your code begins here.

             //URl Path Matchers for the Student Domain endPoint
                .antMatchers(HttpMethod.POST, "/**/student/save").hasAnyRole("STUDENT-ADMIN")
                .antMatchers(HttpMethod.DELETE, "/**/student/delete/{id}").hasAnyRole("STUDENT-ADMIN")
                .antMatchers(HttpMethod.GET, "/**/student/read").hasAnyRole("USER", "STUDENT-ADMIN")
                .antMatchers(HttpMethod.GET, "/**/student/find-all").hasAnyRole("USER", "STUDENT-ADMIN")

            .and()
            .cors()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }
}

