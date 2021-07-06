package com.GetCertifiedOnline.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.GetCertifiedOnline.Entity.User;




@Repository("userrepo")
public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * This method for checking whether userId present in database or not
	 */
	@Query("SELECT user FROM User user WHERE user.username= :username AND user.password= :password")
	public List<User> loginUser(@Param("username") String username, @Param("password") String password);
	
}
