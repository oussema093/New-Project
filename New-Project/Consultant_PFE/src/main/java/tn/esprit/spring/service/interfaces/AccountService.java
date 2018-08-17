package tn.esprit.spring.service.interfaces;

import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;

public interface AccountService {
	public User saveUser(User u);
	public Role saveRole(Role r);
	public void addRoleToUser(String roleName,String username);
	public User findUserbyUserName(String username);
	public Role findRolebyRoleName(String roleName);
}