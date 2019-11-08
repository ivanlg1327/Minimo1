import java.util.*;

public class User {
    String name;
    List<Order> historical;

    public User(String name, List<Order> historical) {
        this.name = name;
        this.historical = historical;
    }
}
