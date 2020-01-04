package com.deloitte.ecommerce.entities;



public class AppUser {

    public AppUser() {

    }

    public AppUser(String mobileno, String password, double balance, String name) {
        this.mobileno = mobileno;
        this.password = password;
        this.balance = balance;
        this.name=name;
    }

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private String mobileno;

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof AppUser)) {
            return false;
        }
        AppUser user = (AppUser) obj;
        return user.mobileno.equals(this.mobileno);
    }

    @Override
    public int hashCode() {
        return mobileno.hashCode();
    }
}
