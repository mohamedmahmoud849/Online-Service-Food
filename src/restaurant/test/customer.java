/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.test;


import java.util.ArrayList;
import java.util.List;
import restaurant.test.DBmanager;

/**
 *
 * @author DELL
 */
public class customer {
    
     private String customer_username;
    private String customer_password;
    private String customer_email;
    private String customer_phone_no;
    private String customer_gender;
    private int customer_age;
    private int customer_ID;
    
    public  customer(){}
    
     private DBmanager dbManager = DBmanager.createInstance();
     private static customer instance;
     
     public static customer getInstance(){
     if(instance==null){
     instance= new customer();     //design pattern //
     }
         return instance;
     
     }

    public String getUsername() {
        return customer_username;
    }

    public String getPassword() {
        return customer_password;
    }

    public String getEmail() {
        return customer_email;
    }

    public String getPhone_no() {
        return customer_phone_no;
    }

    public String getGender() {
        return customer_gender;
    }

    public int getAge() {
        return customer_age;
    }

    public int getCustomerID() {
        return customer_ID;
    }
//dbmanager==databasemanager
    public DBmanager getDbManager() {
        return dbManager;       
    }

    
 public String register(String customer_username, String customer_password, String customer_email, String customer_phone_no, String customer_gender, int customer_age){
        String validation = checkValidatetion(customer_username,customer_password,customer_email,customer_phone_no);

            
        if(!validation.equals("validate"))
            return validation;

        this.customer_username = customer_username;
        this.customer_password = customer_password;
        this.customer_email = customer_email;
        this.customer_phone_no = customer_phone_no;
        this.customer_gender = customer_gender;
        this.customer_age = customer_age;

        if(dbManager.addCustomer(this)) {
            this.customer_ID = dbManager.getCSTID(customer_email,customer_password);
            return "true";
        }
        else
            return "false";
    }
    //customer login//
    public boolean logIn(String customer_email, String customer_password){
        int id = dbManager.getCSTID(customer_email,customer_password);
        if(id != 0){
            ArrayList<String> object = dbManager.findCST(id);
            this.customer_username = object.get(0);
            this.customer_password = object.get(1);
            this.customer_gender = object.get(2);
            this.customer_age = Integer.parseInt(object.get(3));
            this.customer_email = object.get(4);
            this.customer_phone_no = object.get(5);
            this.customer_ID= id;

            return true;
        }
        return false;
    }
    
     private String checkValidatetion(String customer_username, String customer_password, String customer_email, String customer_phone_no){
        String passwordvalidation = passwordValidation(customer_username,customer_password);

        if (dbManager.checkEmail(customer_email)){
            return "Email is exsit before, please use another email ";
        }

        if(!passwordvalidation.equals("Password is valid.")){
            return passwordvalidation;
        }


        if (customer_phone_no.length() != 11) {
            return "Please enter validate phone number";
        }

        return "validate";
    }
    private String passwordValidation(String customer_userName, String customer_password)
    {
        if (customer_password.length() < 8) {
            return "Password should be more than 8 characters in length.";
        }
        if (customer_password.indexOf(customer_userName) > -1) {
            return "Password Should not be same as user name";
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!customer_password.matches(upperCaseChars )) {
            return "Password should contain atleast one upper case alphabet";
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!customer_password.matches(lowerCaseChars )) {
            return "Password should contain atleast one lower case alphabet";
        }
        String numbers = "(.*[0-9].*)";
        if (!customer_password.matches(numbers )) {
            return "Password should contain atleast one number.";
        }
        String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
        if (!customer_password.matches(specialChars )) {
            return "Password should contain atleast one special character";
        }

        this.customer_password = customer_password;
        return "Password is valid.";
    }
   // public boolean update_profile(String customer_username, String customer_password, String customer_email, String customer_phone_no, String customer_gender, int customer_age){
    
   // System.out.println(this.getCustomerID());
 // boolean done=dbManager.update_cst_profile(customer_username,customer_password,customer_email,customer_phone_no,customer_gender,customer_age,this.getCustomerID());
    
    
   //  return done;
//    }

    
}


    
    
    

