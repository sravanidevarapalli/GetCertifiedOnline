package com.GetCertifiedOnline.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.GetCertifiedOnline.Entity.AdminLogin;

@EnableJpaRepositories 
@Component 
@Repository 

public interface AdminLoginRepository extends JpaRepository<AdminLogin, String> {



	
}
