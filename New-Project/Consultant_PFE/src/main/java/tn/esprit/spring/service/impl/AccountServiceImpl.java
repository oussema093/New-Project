package tn.esprit.spring.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.repository.UserRepositiory;

import tn.esprit.spring.service.interfaces.AccountService;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepositiory userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public User saveUser(User u) {
		String hashPW=bCryptPasswordEncoder.encode(u.getPassword());
		u.setPassword(hashPW);
		// TODO Auto-generated method stub
		return userRepository.save(u);
	}

	@Override
	public Role saveRole(Role r) {
		return roleRepository.save(r);
	}

	@Override
	public void addRoleToUser(String roleName, String username) {

		Role r=roleRepository.findByRoleName(roleName);
		User u=userRepository.findByUserName(username);
		
		u.getRoles().add(r);
	}

	@Override
	public User findUserbyUserName(String username) {
		User u=new User();
		u.setUserName("a");
		return userRepository.findByUserName(username);
	}

	@Override
	public Role findRolebyRoleName(String roleName) {
		return roleRepository.findByRoleName(roleName);
	}

}
