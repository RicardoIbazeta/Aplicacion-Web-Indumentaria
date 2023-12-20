
package ProyectoIndumentaria;

import ProyectoIndumentaria.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SeguridadWeb extends WebSecurityConfigurerAdapter {

    @Autowired
    public ClienteServicio clienteServicio;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(clienteServicio) // Autentica el usuario
                .passwordEncoder(new BCryptPasswordEncoder()); // Una vez autenticado, se encripta la contraseña
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                            .antMatchers("/css/*", "/js/*", "/img/*", "/**")
                            .permitAll()
                .and().formLogin()
                            .loginPage("/login")
                            .loginProcessingUrl("/logincheck")
                            .usernameParameter("email")
                            .passwordParameter("password")
                            .defaultSuccessUrl("/inicio")
                            .permitAll()
                .and().logout()
                            .logoutUrl("/logout")
                            .logoutSuccessUrl("/")
                            .permitAll()
                .and().csrf()
                            .disable();
    }

}