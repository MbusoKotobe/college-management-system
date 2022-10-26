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
    public static BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
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
               .password(bCryptPasswordEncoder.encode("721087c4-0ede-407e-8c1f-ac57e531f294"))
               .roles("USER")
   
            .build()
        );

        manager.createUser(User.withUsername("student-admin")
               .password(bCryptPasswordEncoder.encode("721087c4-0ede-407e-8c1f-ac57e531f295"))
               .roles("USER", "STUDENT-ADMIN")
               .build()
        );

        manager.createUser(User.withUsername("course-user")
                .password(bCryptPasswordEncoder.encode("721087c4-0ede-407e-8c1f-ac57e531f296"))
                .roles("USER")
                .build()
        );

        manager.createUser(User.withUsername("course-admin")
                .password(bCryptPasswordEncoder.encode("721087c4-0ede-407e-8c1f-ac57e531f297"))
                .roles("USER", "COURSE-ADMIN")
                .build()
        );

        manager.createUser(User.withUsername("module-user")
                .password(bCryptPasswordEncoder.encode("721087c4-0ede-407e-8c1f-ac57e531f298"))
                .roles("USER")
                .build()
        );

        manager.createUser(User.withUsername("module-admin")
                .password(bCryptPasswordEncoder.encode("721087c4-0ede-407e-8c1f-ac57e531f299"))
                .roles("USER", "MODULE-ADMIN")
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
            .antMatchers(HttpMethod.DELETE, "/**/faculty/delete/{facultyId}").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "/**/faculty/read").hasAnyRole("USER", "FACULTY-ADMIN")
            .antMatchers(HttpMethod.GET, "/**/faculty/find-all").hasAnyRole("USER", "FACULTY-ADMIN")
            
            //URL Path Matchers for the Lecturer Domain.
            .antMatchers(HttpMethod.POST, "/**/lecturer/save").hasRole("ADMIN")
            .antMatchers(HttpMethod.DELETE, "/**/lecturer/delete").hasRole("ADMIN")
            .antMatchers(HttpMethod.DELETE, "/**/lecturer/delete/{lecturerId}").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "/**/lecturer/read").hasAnyRole("USER", "ADMIN")
            .antMatchers(HttpMethod.GET, "/**/lecturer/find-all").hasAnyRole("USER", "ADMIN")

            .antMatchers(HttpMethod.POST, "/**/faculty/save").hasRole("FACULTY-ADMIN")
            .antMatchers(HttpMethod.DELETE, "/**/faculty/delete").hasRole("FACULTY-ADMIN")
            .antMatchers(HttpMethod.DELETE, "/**/faculty/delete/{facultyId}").hasRole("FACULTY-ADMIN")
            .antMatchers(HttpMethod.GET, "/**/faculty/read").hasAnyRole("USER", "FACULTY-ADMIN")
            .antMatchers(HttpMethod.GET, "/**/faculty/find-all").hasAnyRole("USER", "FACULTY-ADMIN")

            //Add your Path Matchers for your domains here and put a comment in place to signal
            //to other team members that your code begins here.

            //URL Path Matchers for the Login Domain EndPoint
            .antMatchers(HttpMethod.POST, "/**/user/login").anonymous()
            .antMatchers(HttpMethod.POST, "/**/user/signup").anonymous()

             //URL Path Matchers for the Student Domain EndPoint
            .antMatchers(HttpMethod.POST, "/**/student/save").hasAnyRole("STUDENT-ADMIN")
            .antMatchers(HttpMethod.DELETE, "/**/student/delete/{id}").hasAnyRole("STUDENT-ADMIN")
            .antMatchers(HttpMethod.GET, "/**/student/read").hasAnyRole("USER", "STUDENT-ADMIN")
            .antMatchers(HttpMethod.GET, "/**/student/find-all").hasAnyRole("USER", "STUDENT-ADMIN")

             //URL Path Matchers for the Course Domain endPoint
            .antMatchers(HttpMethod.POST, "/**/course/save").hasAnyRole("COURSE-ADMIN")
            .antMatchers(HttpMethod.DELETE, "/**/course/delete/{id}").hasAnyRole("COURSE-ADMIN")
            .antMatchers(HttpMethod.GET, "/**/course/read").hasAnyRole("USER", "COURSE-ADMIN")
            .antMatchers(HttpMethod.GET, "/**/course/find-all").hasAnyRole("USER", "COURSE-ADMIN")

             //URL Path Matchers for the Module Domain endPoint
            .antMatchers(HttpMethod.POST, "/**/module/save").hasAnyRole("MODULE-ADMIN")
            .antMatchers(HttpMethod.DELETE, "/**/module/delete/{id}").hasAnyRole("MODULE-ADMIN")
            .antMatchers(HttpMethod.GET, "/**/module/read").hasAnyRole("USER", "MODULE-ADMIN")
            .antMatchers(HttpMethod.GET, "/**/module/find-all").hasAnyRole("USER", "MODULE-ADMIN")

            .and()
            .cors()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }
}

