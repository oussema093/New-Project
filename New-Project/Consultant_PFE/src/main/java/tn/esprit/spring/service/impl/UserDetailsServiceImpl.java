package tn.esprit.spring.service.impl;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.esprit.spring.service.interfaces.AccountService;
import tn.esprit.spring.entity.User;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private AccountService accountService ;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	    User u=accountService.findUserbyUserName(username);
	    if(u==null) {
	    	throw new UsernameNotFoundException(username);
	    }
	    Collection<GrantedAuthority> authorities = new ArrayList<>();
		u.getRoles().forEach(role->{
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		});
	    
		return new org.springframework.security.core.userdetails.User(u.getUserName(), u.getPassword(), authorities);
	}

}

