import java.util.*;

public class User {
    String name;
    String id;
    List<Order> historical;

    public User(String name, String id) {
        this.name = name;
       this.historical = new LinkedList<>();
        this.id= id;
    }

    public void addHistorical(Order order)
    {
        this.historical.add(order);
    }
    public String toString() {
        return this.name;
    }
}
