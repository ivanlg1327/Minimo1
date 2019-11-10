import java.util.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Order {
    List <Product> productList;
    int cost=0;
    String name;
    Date date;
    User user;

    public Order(List<Product> productList, String name , Date date, User user) {
        this.productList = productList;
        this.name=name;
        this.cost = this.count(productList);
        this.date=date;
        this.user=user;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public int getCost() {
        return cost;
    }

    public int count(List <Product> productList)
    {
        return 1;
    }
    public String getUser(){
        return this.name;
    }
    public void addUSer(String id){

    }

    public void addLP(int num, String name){

    }
}
