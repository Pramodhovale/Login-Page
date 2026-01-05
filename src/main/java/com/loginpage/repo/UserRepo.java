package com.loginpage.repo;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.loginpage.model.User;

public interface UserRepo extends JpaRepository<User,Serializable>{
	User findByUsernameAndPassword(String username, String password);
}
