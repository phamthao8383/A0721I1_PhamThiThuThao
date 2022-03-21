package fresher.Team3.Confs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()

                .antMatchers("/Admin/**", "/Home/UserInfor/**").authenticated().antMatchers("/Admin/**")
                .hasAuthority(
                        "admin").and().exceptionHandling().accessDeniedPage("/403")

                .and()

                // cấu hình trang đăng nhập
                // /login là 1 action
                .formLogin().loginPage("/login").loginProcessingUrl("/perform_login").usernameParameter("email")
                .passwordParameter("password")
                /* .defaultSuccessUrl("/index", true) */.successHandler(myAuthenticationSuccessHandler())
                .failureUrl("/login?login_error=true").permitAll()

                .and()

                // cấu hình cho phần logout
                .logout().logoutUrl("/logout").logoutSuccessUrl("/index").invalidateHttpSession(true)
                .deleteCookies("JSESSIONID").permitAll();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
     * cau hinh chuyen huong dang nhap theo role
     */
    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
        return new MySimpleUrlAuthenticationSuccessHandler();
    }

}
