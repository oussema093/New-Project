package tn.esprit.spring.controller.impl;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import tn.esprit.spring.entity.Consultant;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepositiory;

@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*",maxAge=3600)
@RestController
@RequestMapping("/user")
public class UserController {


	@Autowired
	private UserRepositiory urep;

	
	
	 @GetMapping(value = "/auth")
	    public User authentification(@RequestParam(name="login") String login,@RequestParam(name="pwd")String pwd) 
	 {

		 return urep.auth(login, pwd);
	 }
	 @GetMapping(value = "/userlogin")
	    public User getUserbyLogin(@RequestParam(name="login") String login) 
	 {

		 return urep.findByUserName(login);
	 }
}
