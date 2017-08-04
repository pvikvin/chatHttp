package com.gemicle.chat.manager;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gemicle.chat.pojo.User;

public class UserManager {
	
	private static List<User> users = new ArrayList<User>();
	
	public static void add(User user){
		users.add(user);
	}
	
	public static void delete(int index){
		users.remove(index);
	}
	
	public static List<User> getUsers(){
		return users;
	}

}
