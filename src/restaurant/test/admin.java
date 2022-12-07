/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.test;

public class admin  extends customer {
   
     private DBmanager dbManager = DBmanager.createInstance();
     private static admin instance;
     
     public static admin getInstance(){
     if(instance==null){
     instance= new admin();
     }
         return instance;
     
     }
     
   //  @Override
     public boolean update_profile(String customer_username, String customer_password, String customer_email, String customer_phone_no, String customer_gender, int customer_age){
    
    System.out.println(this.getCustomerID());
  boolean done=dbManager.update_cst_profile(customer_username,customer_password,customer_email,customer_phone_no,customer_gender,customer_age,this.getCustomerID());
    
    
     return done;
    }
      
      public boolean update_menu(String item_name,String item_price,String  item_id){   //  <<<<<
    
    
      return dbManager.update_item(item_name, item_price, item_id); //  <<<<<
    
    
    }
      
      public boolean add_item(String item_name , String item_price){  //  <<<<<
      
      
     return dbManager.add_item(item_name, item_price);//  <<<<<
      
      
      
      }
      
      public boolean delete_item(String item_name){//  <<<<<
      
      
      return dbManager.del_item(item_name);//  <<<<<
      
      }
    
    
}
