package com.hyx.dao;

import com.hyx.enity.User;

public interface UserDao {
        
	User register(String name,String pwd);
	
	User login(String name,String pwd);
}
