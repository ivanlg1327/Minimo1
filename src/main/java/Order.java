import java.util.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Order {
    private double cost=0;
    private String name;
    private Date date;
    private List<LP> lps;

    public Order( String name , Date date) {
        this.name=name;
        this.date=date;
        this.lps = new LinkedList<LP>();
    }

    public List<LP> lps() {
        return this.lps;
    }

    public double getCost() {//creo que ahora mismo no tiene utilidad
        return cost;
    }

/*    public double count(List <Product> productList)
    {
        double aux=0;
        for (Product temp : this.productList)
            aux=aux+temp.price;
        return aux;
    } */

    public String getUser(){
        return this.name;
    }
    public void addUSer(String id){

    }

    public void addLP(int num, String name){
        this.lps.add(new LP(num, name));

    }
    public String toString() {
        return this.name;
    }

    protected class LP {
        int q;
        String product;

        public LP(int q, String product) {
            this.q = q;
            this.product =product;
        }
    }
}
