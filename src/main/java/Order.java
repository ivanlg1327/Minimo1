import java.util.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Order {
    List <Product> productList;
    double cost=0;
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

    public double getCost() {//creo que ahora mismo no tiene utilidad
        return cost;
    }

    public double count(List <Product> productList)
    {
        double aux=0;
        for (Product temp : this.productList)
            aux=aux+temp.price;
        return aux;
    }
    public String getUser(){
        return this.name;
    }
    public void addUSer(String id){

    }

    public void addLP(int num, String name){

    }
    public String toString() {
        return this.name;
    }
}
