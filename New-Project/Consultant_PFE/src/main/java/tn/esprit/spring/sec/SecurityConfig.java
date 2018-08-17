package tn.esprit.spring.sec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import tn.esprit.spring.sec.JWTAuthenticationFilter;
import tn.esprit.spring.sec.JWTAuthorizationFilter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	UserDetailsService userDetailsService;
	//il faut completer la couche service pour gerer les userss et les roles
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	//il faut instancier bcrypt
//demander a spring de demander un service

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//definir la methode pour chercher les users et les roles
//		auth.inMemoryAuthentication().withUser("admin").password("1234").roles("ADMIN","USER").
//		and().withUser("user").password("1234").roles("USER");
		
		/*auth.
		jdbcAuthentication().usersByUsernameQuery("")
			.authoritiesByUsernameQuery("").withUser("admin").password("123").roles("admin").and()
			.withUser("operateur").password("123").roles("operateur");*/
		
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
/*		//definir les droits d'accées
		http.csrf().disable();// desativer synchronise token
		
		//http.formLogin();
		//pour utiliser JSON web token,on doit desactiver l'auth basé sur les sessions 
		//desactiver la session
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		//on va passer d'un systeme d'auth par ref à u sys d'auth par valeurs
		http.authorizeRequests().antMatchers("/login/**","/register/**","/tasks/**").permitAll();
		//http.authorizeRequests().antMatchers(HttpMethod.POST,"/tasks/**").hasAuthority("ADMIN");
		//http.authorizeRequests().antMatchers(HttpMethod.PUT,"/tasks/**").permitAll();
		http.authorizeRequests().anyRequest().authenticated();
		http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
	    http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	*/ // desable csrf pour que le serveur ne bloque pas les requettes en les conciderant des attaques de type CSRF 
		
	 		http.csrf().disable();
	       
	 		//http.formLogin();
	 		
	 		// desactive la session(systeme d'auth par reference) et passer a token (systeme d'auth par valeur) => après on crée les filtres : jwtauthenticationfilter, jwtauthorizationfilter
	 		
	 		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//	 		http.authorizeRequests().antMatchers("/login/**","/register/**").permitAll();
//	 		// Les requettes envoyées ne seront pas autorisées avec des methodes POST que lorsque l'utilisateur à le Role ADMIN
//	 		
//	 		http.authorizeRequests().antMatchers(HttpMethod.POST,"/tasks/**").hasAuthority("ADMIN");
//	 		
//	 		http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/tasks/**").hasAuthority("ADMIN");
//	 		http.authorizeRequests().antMatchers(HttpMethod.PUT,"/tasks/**").hasAuthority("ADMIN");
//	 		
//	 		
//
//	 		// tous les ressources demandés necessites une authentification  
//	 	
//	 		http.authorizeRequests().anyRequest().authenticated();
	 		 
	 		//add filter jwtauthentication 
	 		 
	 		http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
	 		http.addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
	
	}
}
