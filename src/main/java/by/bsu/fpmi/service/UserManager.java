package by.bsu.fpmi.service;

import java.util.HashMap;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import by.bsu.fpmi.domain.User;

@Service
public class UserManager {

	private HashMap<String, User> users = new HashMap<String, User>();
	
	//тут еще нужно прикрутить базу данных
	
	public User getUser(String username) throws UsernameNotFoundException {
		if( !users.containsKey( username ) ){
			throw new UsernameNotFoundException( username + " not found" );
		}
		
		return users.get( username );	
	}
	
}
