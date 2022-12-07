package restaurant.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//dbmanager=databasemanager//
public  class  DBmanager {
    private  String query;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private static DBmanager instance = null;
    private String datasource_url = "jdbc:mysql://localhost:3306/food delivery" ;


    private DBmanager(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(datasource_url,"root","root");
            statement = connection.createStatement();

        }catch (Exception e){
            System.out.println("Error" + e);
        }
    }

    public static DBmanager createInstance(){
        if(instance == null)
            instance = new DBmanager();

        return instance;
    }

    
    public String getItemPrice(String item_nameٍ){
        String price = null;
        String temp = "'" + item_nameٍ + "'";
        try{
            query = "SELECT item_price FROM items where item_name =" + temp;
            resultSet = statement.executeQuery(query);
            while (resultSet.next())
                price = resultSet.getString("item_price");
                 
        }catch (Exception e) {
            System.out.println(e);
        }
        return price;
    }
 public boolean addCustomer(customer user){
        String name = "'" + user.getUsername() + "'";
        String password = "'" + user.getPassword() + "'";
        String gender = "'" + user.getGender() + "'";
        int age = user.getAge();
        String phone = "'" + user.getPhone_no() + "'";
        String email = "'" + user.getEmail() + "'";

        int Customerid ;

        try {
            query = "INSERT INTO cst(cst_gender,cst_age,cst_email,cst_phone_no,cst_password,cst_username) VALUES(" +
                    gender + "," + age + "," + email + "," + phone + "," + password + "," + name + ")";
            statement.execute(query);
            return true;

        }catch (Exception ex){
            System.out.println(ex);
        }

        return false;
    }
 
 
 public boolean add_item(String name, String price){
    
      String item_name = "'" +name + "'";
        String item_price = "'" + price+ "'";
    
    
    try{
    query = "insert into items(item_name,item_price) values ("+item_name+","+item_price+")";
     statement.execute(query);
   return true;
    
    }
    catch(Exception e){
    System.out.println(e);
    }
    
    return false;
    
  }

      public boolean checkEmail(String Customeremail){
        String temp = "'"+Customeremail+"'";
        try {
            String email = null;
            query = "SELECT cst_email FROM cst WHERE cst_email = " + temp;
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                email = resultSet.getString("cst_email");
                System.out.println(email);
            }

            if (email != null)
                return true;

        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
public String getItemName(int item_code){
        String item_name = null;
        try{
            query = "SELECT item_name FROM items where item_id = " + item_code;
            resultSet = statement.executeQuery(query);
            while (resultSet.next())
                item_name = resultSet.getString("item_name");
        }catch (Exception e) {
            System.out.println(e);
        }
        return item_name;
    }
//CST is customer table
    public int getCSTID(String email, String password){
        String temp_email = "'" + email + "'";
        String temp_pass = "'" + password + "'";
        int id = 0;
        try {
            query = "SELECT cst_id FROM cst WHERE cst_email = " + temp_email  +  "&& cst_password = " + temp_pass;

            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                 id = Integer.parseInt(resultSet.getString("cst_id"));
            }
        }catch (Exception ex) {
            System.out.println(ex);
        }
        return id;
    }

    
    public ArrayList<String> findCST(int Customerid){
        ArrayList<String> customer = new ArrayList<>();
        try{
            query = "SELECT * FROM cst WHERE cst_id  = " + Customerid ;
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String  username = resultSet.getString("cst_username");
                String password = resultSet.getString("cst_password");
                String gender = resultSet.getString("cst_gender");
                String age = resultSet.getString("cst_age");
                String email = resultSet.getString("cst_email");
                String phone_no = resultSet.getString("cst_phone_no");

                customer.add(username);
                customer.add(password);
                customer.add(gender);
                customer.add(age);
                customer.add(email);
                customer.add(phone_no);
            }
        }catch (Exception ex) {
            System.out.println(ex);
        }
        return customer;
    }
   public boolean update_cst_profile(String Customer_username, String Customer_password, String Customer_email, String Customer_phone_no, String Customer_gender, int Customer_age, int Customer_id){
    String name_t = "'" + Customer_username + "'";
        String password_t = "'" + Customer_password + "'";
        String gender_t = "'" + Customer_gender+ "'";
        int age_t = Customer_age;
        String phone_t = "'" + Customer_phone_no + "'";
        String email_t = "'" + Customer_email + "'";
    try{
     query = "UPDATE cst SET cst_gender ="+gender_t+",cst_age="+age_t+",cst_email="+email_t+",cst_phone_no= "+phone_t+",cst_password="+password_t+",cst_username="+name_t+
" WHERE cst_id=" + Customer_id;
     System.out.println(query);
        statement.execute(query);
        return true;
     }catch (Exception e) {
            System.out.println(e);
        }
        return false;   
    
 
   }
   //delete item
    public boolean del_item(String name){
   
   String it_name = "'" +name + "'";
   try{
    query = "delete from items where item_name= "+it_name;
     statement.execute(query);
   return true;
    
    }
    catch(Exception e){
    System.out.println(e);
    }
    
    return false;  
   
   } 
    
    public String getItemId(String nameٍ){
        String id =null ;
        String temp = "'" + nameٍ + "'";
        try{
            query = "SELECT item_price FROM items where item_name =" + temp;
            resultSet = statement.executeQuery(query);
            while (resultSet.next())
                id = resultSet.getString("item_id");
                 
        }catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }
    
   public List<item> getMenu()
  {
     List<item> menu = new ArrayList<>();
   
     try {
        query = "SELECT * FROM items ";
       resultSet = statement.executeQuery(query);
        while (resultSet.next())
        {
             menu.add(new item( resultSet.getString("item_name"),
             resultSet.getString("item_price")));
         }
    }catch (Exception e){
         System.out.println(e);
    }
     System.out.println(menu.size());
       return menu;
    }
    //update item//
     public boolean update_item(String item_name , String item_price, String item_id){
        String it_name = "'" + item_name + "'";
        String it_price = "'" + item_price+ "'";
        String it_id = "'" + item_id + "'";

        
        
    try{
    query = "update items set item_name ="+it_name+", item_price="+it_price+" where item_id ="+ it_id;
     statement.execute(query);
   return true;
    
    }
    catch(Exception e){
    System.out.println(e);
    }
    
    return false;
    
    
    
    
    }
    
    }
    
   
    
    
   
    
    













