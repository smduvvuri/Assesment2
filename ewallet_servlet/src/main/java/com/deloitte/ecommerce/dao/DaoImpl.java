package com.deloitte.ecommerce.dao;

import java.util.HashMap;
import java.util.Map;

import com.deloitte.ecommerce.entities.AppUser;
import com.deloitte.ecommerce.exceptions.UserNotFoundException;



public class DaoImpl implements Dao{

    private Map<String, AppUser> store = new HashMap<>();

    public DaoImpl() {
        AppUser user1 = new AppUser("9491651710", "1234",2000, "Shree");
        store.put("9491651710", user1);
        AppUser user2 = new AppUser("9848415540", "4321",3000, "Shobha");
        store.put("9848415540", user2);
    }

    @Override
    public boolean credentialsCorrect(String mobileno, String password) {
        AppUser user = store.get(mobileno);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }

    @Override
    public AppUser getUserByMobileno(String mobileno) {
        AppUser user = store.get(mobileno);
        if (user == null) {
			throw new UserNotFoundException("Account not found for mobile no=" + mobileno);
		}
		return user;
	}}

