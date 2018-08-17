//package tn.esprit.spring;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//
//import tn.esprit.spring.config.JwtFilter;
//import tn.esprit.spring.entity.User;
//import tn.esprit.spring.repository.UserRepositiory;
//
//
//
//@SpringBootApplication
//public class TestSpringSecurity implements CommandLineRunner {
//	@Autowired
//	UserRepositiory udao;
//	@Bean
//	public org.springframework.boot.web.servlet.FilterRegistrationBean jwtFilter() {
//		final org.springframework.boot.web.servlet.FilterRegistrationBean registrationBean = new org.springframework.boot.web.servlet.FilterRegistrationBean();
//		registrationBean.setFilter(new JwtFilter());
//		registrationBean.addUrlPatterns("/rest/*");
//
//		return registrationBean;
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(TestSpringSecurity.class, args);
//		
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
//		//,df.parse("26/04/1993")
//User u1=new User("Ammar","Oussema","ouss","0000",df.parse("26/04/1993"));	
//User u2=new User("Ammar","ahmed","ahm","0000",df.parse("05/06/2004"));	
//User u3=new User("Ammar","samir","sam","1111",df.parse("17/08/1957"));	
//User u4=new User("Ammar","rim","rim","5555",df.parse("30/11/1994"));	
//User u5=new User("jack","frack","jck","2222",df.parse("30/07/2007"));	
//User u6=new User("ahwel","sam","sam","4444",df.parse("22/08/1988"));	
//
//udao.save(u1);
//udao.save(u2);
//udao.save(u3);
//udao.save(u4);
//udao.save(u5);
//udao.save(u6);		
//	}
//}
