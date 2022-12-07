package restaurant.test;

public class item {
    private int item_id;
    private String item_name;
    private String item_price;

    public item(){};

    public item(int item_id, String item_name, String item_price){
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_price = item_price;
    }

    item(String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //item(String string, String string0) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  //  }

    public int getId() {
        return item_id;
    }

    public String getName() {
        return item_name;
    }

    public String getPrice() {
        return item_price;
    }

    public void setId(int item_id) {
        this.item_id = item_id;
    }

    public void setName(String item_name) {
        this.item_name = item_name;
    }

    public void setPrice(String item_price) {
        this.item_price = item_price;
    }
}
