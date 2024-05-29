package gr.hepheastus.hepheastusclass.config

import gr.hepheastus.hepheastusclass.services.UserDetailService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(val userDetailService: UserDetailService) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeRequests()
            .requestMatchers("/api/**").permitAll()
            .requestMatchers("/error/**").permitAll()
            .requestMatchers("/log-in/**").permitAll()
            .requestMatchers("/css/**").permitAll()
            .requestMatchers("/images/**").permitAll()
            .requestMatchers("/favicon.ico").permitAll()
            .requestMatchers("/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER", "ROLE_MODERATOR")
            .and()
            .csrf { it.disable() }
            .formLogin{
                it.loginPage("/log-in")
                it.defaultSuccessUrl("/")
            }.logout {
                it.logoutSuccessUrl("/log-in")
            }
        return http.build()
    }
}