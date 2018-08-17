package tn.esprit.spring.sec;

public class SecurityConstants {
	
	public static final String SECRET = "oussema@ammar.net";
	public static final long EXPIRATION_TIME = 864_000_000; //10 jours
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	//le nom de header danslequel je vais mettre le tokken

}
