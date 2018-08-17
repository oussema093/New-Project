package tn.esprit.spring.controller.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.controller.impl.RegisterForm;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.interfaces.AccountService;

@RestController
public class AccountRestController {
	@Autowired 
	private AccountService accountService;
	
	@PostMapping("/register")
	public User register(@RequestBody RegisterForm userForm) {
		if(!userForm.getPassword().equals(userForm.getRepassword()))
		{
			throw new RuntimeException("you must confirm your password");
		}
		User u=accountService.findUserbyUserName(userForm.getUsername());
		if(u!=null)
		{
			throw new RuntimeException("this user already exist. Try with an another username");

		}
		User user=new User();
		user.setUserName(userForm.getUsername());
		user.setPassword(userForm.getPassword());
		 accountService.saveUser(user);
			accountService.addRoleToUser("USER", userForm.getUsername());
return user;
	}
}
