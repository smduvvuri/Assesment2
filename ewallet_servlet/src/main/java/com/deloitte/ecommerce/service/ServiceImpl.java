package com.deloitte.ecommerce.service;

import com.deloitte.ecommerce.dao.Dao;
import com.deloitte.ecommerce.exceptions.IncorrectNumberException;
import com.deloitte.ecommerce.entities.AppUser;


public class ServiceImpl implements Service {
    private Dao dao;

    public ServiceImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public AppUser getUserByMobileno(String mobileno) {
       
        
        if (mobileno==null||mobileno.length()!=10 ) {
            throw new IncorrectNumberException("Number is incorrect");
        }
        AppUser user = dao.getUserByMobileno(mobileno);
        return user;
    }

    @Override
    public boolean credentialsCorrect(String mobileno, String password) {
        boolean correct = dao.credentialsCorrect(mobileno, password);
        return correct;
    }
}
