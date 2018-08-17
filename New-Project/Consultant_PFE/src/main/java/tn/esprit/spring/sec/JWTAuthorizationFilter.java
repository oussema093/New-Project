package tn.esprit.spring.sec;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import tn.esprit.spring.sec.SecurityConstants;

public class JWTAuthorizationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers", 
				"Origin, Accept, X-Requested-With, Content-Type,"
				+ "Access-Control-Request-Method,"
				+ "Access-Control-Request-Headers,"
				+ "Authorization");//autoriser angular d'utiliser des entetes
		response.setHeader("Access-Control-Allow-Methods", "POST, GET,DELETE, PUT, HEAD, OPTIONS");
		response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, " + 
				"Access-Control-Allow-Credentials, "
				+ "Authorization");//permet a app frontend de lire ces entetes
		String jwt = request.getHeader(SecurityConstants.HEADER_STRING);
		System.out.println(jwt);
		if (request.getMethod().equals("OPTIONS")) {
			response.setStatus(HttpServletResponse.SC_OK);
			//ce n est pas la peine d'utiliser les regles de securité
		} 
		
		else {
		
		
		
		
		if (jwt == null || !jwt.startsWith(SecurityConstants.TOKEN_PREFIX)) {
			filterChain.doFilter(request, response);
			return;
		}
		Claims claims = Jwts.parser().setSigningKey(SecurityConstants.SECRET)
				.parseClaimsJws(jwt.replace(SecurityConstants.TOKEN_PREFIX, "")).getBody();
		//supprimer prefix remplacer par chaine vide
		String username = claims.getSubject();
		//subject contient username
		//apres j'ai besoin de recuperer les roles 
		ArrayList<Map<String, String>> roles = (ArrayList<Map<String, String>>) claims.get("roles");
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		roles.forEach(r -> {
			authorities.add(new SimpleGrantedAuthority(r.get("authority")));
			//"authority" nom de la clé
		});
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
				null, authorities); // mot de passe null car le jwt qu'o recoit suppose que le user est deja
									// authentifié =>maintenant jute verifier que le token envoyé est valide ou pas
		// le token ne contient pas le mot de passe
		//charge le context de securité de spring
		//accede a la securité de spring avec la classe securitycontextholder
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		//l'utilisateur qui est authentifié voila son id tu le charges
		filterChain.doFilter(request, response);
	}
	}
}

