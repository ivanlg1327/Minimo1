import java.util.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Order {
    List <Product> productList;
    int cost=0;
    String name;
    Date date;

    public Order(List<Product> productList, String name , Date date) {
        this.productList = productList;
        this.name=name;
        this.cost = this.count(productList);
        this.date=date;
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
