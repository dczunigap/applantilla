package mx.com.plantilla.config.security;

import mx.com.plantilla.security.JwtAutorizationFilter;
import mx.com.plantilla.security.JwtAuthenticationLoginFilter;
import mx.com.plantilla.security.JwtAuthenticationEntryPoint;
import mx.com.plantilla.security.JwtUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by dzuniga on 03/05/2017.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public JwtAuthenticationEntryPoint getUnauthorizedHandler(){
        return new JwtAuthenticationEntryPoint();
    }

    @Bean
    public JwtUserDetailService getUserDetailsService(){
        return new JwtUserDetailService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAutorizationFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAutorizationFilter(authenticationManager());
    }

    @Bean
    public JwtAuthenticationLoginFilter loginFilterBean() throws Exception {
        return new JwtAuthenticationLoginFilter(authenticationManager(), getApplicationContext());
    }

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(getUserDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .exceptionHandling().authenticationEntryPoint(getUnauthorizedHandler()).and()
                //don't create session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                // allow anonymous resource requests
                .antMatchers(HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js").permitAll()
                .antMatchers(HttpMethod.POST, "/login/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/user/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(loginFilterBean(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class)

                //disable page caching
                .headers().cacheControl();
    }
}
