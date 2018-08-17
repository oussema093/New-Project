package tn.esprit.spring.sec;
import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.sec.SecurityConstants;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	
	private AuthenticationManager authenticationManager;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}
@Override
public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
		throws AuthenticationException {
	User user = null;
//	//lorsque les données sont envoyées au format  www url encoded
//	String username = request.getParameter("username");
//	String password = request.getParameter("password");
	
	//on fait cela au format JSON
	try {
		//object mapper permet de prendre les données en forme json et les stocker
		//dans un objet java
		//request.getInputStream() filtre recoit la requete
		//deserialiser dans un objet de type User
		user = new ObjectMapper().readValue(request.getInputStream(), User.class);
	} catch (JsonParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		throw new RuntimeException(e);
	}	
	System.out.println("****************");
	System.out.println("username :"+user.getUserName());
	System.out.println("password :"+user.getPassword());
	return authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));}
@Override
protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
		Authentication authResult) throws IOException, ServletException {
	// dans cette methode on va generer le token
	//recuperer l'objet User avec la methode getprincipal qui contient les informations de
	//l'utilisateur qui est authentifié
	org.springframework.security.core.userdetails.User springUser=(org.springframework.security.core.userdetails.User)authResult.getPrincipal();
	String jwt = Jwts.builder()
			.setSubject(springUser.getUsername())
			.setExpiration(new
					Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
			.signWith(SignatureAlgorithm.HS256, SecurityConstants.SECRET)
			.claim("roles", springUser.getAuthorities())
			.compact();
//	token généré = >le mettre dans response 	
	response.addHeader(SecurityConstants.HEADER_STRING, 
			SecurityConstants.TOKEN_PREFIX + jwt);
	
	
}
}

