package com.deloitte.ecommerce.service;

import com.deloitte.ecommerce.entities.AppUser;

public interface Service {
   

    boolean credentialsCorrect(String mobileno, String password);

	AppUser getUserByMobileno(String mobileno);

}
