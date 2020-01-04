package com.deloitte.ecommerce.dao;

import com.deloitte.ecommerce.entities.AppUser;

public interface Dao {
    AppUser getUserByMobileno(String mobileno);

    boolean credentialsCorrect(String mobileno, String password);
}
