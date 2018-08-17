package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.User;


	@Repository
	public interface UserRepositiory extends CrudRepository<User, Long> {
		User save(User user);

		public User findByUserName(String userName);
		@Query("select u from User u where u.userName= :x and u.password= :y")
		public User auth(@Param("x")String username,@Param("y")String password);
		
		@Query("select u from User u where u.userName= :x")
		public User getUserbyLogin(@Param("x")String username);

	}

