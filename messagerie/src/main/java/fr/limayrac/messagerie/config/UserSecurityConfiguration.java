package fr.limayrac.messagerie.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import fr.limayrac.messagerie.service.UtilisateurService;

@Configuration
@EnableWebSecurity
public class UserSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	/*
	 * @Autowired DataSource dataSource;
	 * 
	 * //Enable jdbc authentication
	 * 
	 * @Autowired public void configAuthentication(AuthenticationManagerBuilder
	 * auth) throws Exception { auth.jdbcAuthentication().dataSource(dataSource); }
	 * 
	 * @Override public void configure(WebSecurity web) throws Exception {
	 * web.ignoring().antMatchers("/resources/**"); }
	 */
	
	
	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService customUserDetailsService;
	
	public class PasswordEnconderTest implements PasswordEncoder {
	    public String encode(CharSequence charSequence) {
	        return charSequence.toString();
	    }

	    public boolean matches(CharSequence charSequence, String s) {
	        return charSequence.toString().equals(s);
	    }
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
	    return new PasswordEnconderTest();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.csrf().disable()
		.authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/inscription").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/connexion").defaultSuccessUrl("/welcome").failureUrl("/connexion?error=true").permitAll()
		.and().logout().deleteCookies("JSESSIONID").logoutUrl("/deconnexion").logoutSuccessUrl("/connexion"); 
	}
	
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder
	 * authManagerBuilder) throws Exception {
	 * authManagerBuilder.userDetailsService(customUserDetailsService).
	 * passwordEncoder(bCryptPasswordEncoder()); }
	 * 
	 * @Bean public BCryptPasswordEncoder bCryptPasswordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
	//@Autowired
	//public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
	//	authenticationMgr.inMemoryAuthentication().withUser("admin").password("admin").authorities("ROLE_USER").and()
	//			.withUser("javainuse").password("javainuse").authorities("ROLE_USER", "ROLE_ADMIN");
	//}


}
