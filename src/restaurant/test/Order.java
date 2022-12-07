/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




package restaurant.test;

import restaurant.test.DBmanager;


public class Order {
    //dbmanager=databasemanager
    private DBmanager dbManager = DBmanager.createInstance();

    public double[] getCard() {
        return card;
    }

    public void setCard(double[] card) {
        this.card = card;
    }

    public static int getItem() {
        return item;
    }

    public static void setItem(int item) {
        Order.item = item;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
    private double card[]= new double [10];
    private String reciept[][]= new String [10][2];
    static int item=0;

    public String[][] getReciept() {
        return reciept;
    }
    private double sum;
    public void addToCard(String itemName , int amount )
    {  
        //double total_price = 0.0;
        try{
        //int x ; // get price from db
         //   x = Integer.parseInt(dbManager.getItemPrice(itemName));
       // sum = amount * x;
       // total_price += sum; 
       // card[item]=total_price;
        reciept[item][0]=itemName; // get item name from db
        reciept[item][1]=String.valueOf(amount);
        item++;
       // r.addTrans(itemCode, total_price);
        }
        catch(NumberFormatException e)
        {
            System.out.print("Number format exception");
        }
        }  
    
    public void GetTotalPrice(String itemName , int amount){
      double total_price = 0.0;
        try{
        int x ; // get price from db
            x = Integer.parseInt(dbManager.getItemPrice(itemName));
        sum = amount * x;
        total_price += sum;
        card[item]=total_price;
        }
        
         catch(NumberFormatException e)
        {
            System.out.print("Number format exception");
        }
    
    }
    
    
    
    public double Item_Amount(Order o)
    {  
       double total_items = 0;
       double []card= o.getCard();
       for (int i=0;i<card.length;i++)
       {
           total_items+=card[i];
       }
       return total_items;
    }
   
}
