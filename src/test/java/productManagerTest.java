import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class productManagerTest {
    ProductManagerImp pm = null;
    List<Product> productList= new LinkedList<>();;
    List<Product> productsUser=new LinkedList<>();;
    HashMap<String, User> users = new HashMap<String, User>();
    Queue<Order> orderQueue = new LinkedList<>();

    @Before
    public void setUp() {
        pm = new ProductManagerImp(productList, users, orderQueue);
        pm.addUser("11111", "Toni");
        pm.addUser("22222", "Ivan");
        pm.addProduct("COCA-ZERO", "coca cola cero",4.5,productList);
        pm.addProduct("BOCATA", "Bocata jampn",2,productList);
        Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        Order p = new Order(productsUser, "Ivan", date,users.get("22222") );//sobraria el nombre pero deberia funcionar
        p.addLP(2, "COCA-ZERO");
        p.addLP(1, "BOCATA");
        p.addUSer("11111");//innecesario porque cuando creo el pedido ya pongo al usuario como constructor
        pm.ped(p);
    }

    @Test
    public void testing() {
       // pm.listPrices();
    }

    @Test
    public void anotarPedido() {
        Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        Order p = new Order(productList, "Toni", date, users.get("11111"));
        p.addLP(1, "COCA-ZERO");
        p.addLP(3, "BOCATA");
        p.addUSer("22222");
        pm.ped(p);
    }

    @Test
    public void servirPedido() {
        Order p1 = pm.listActive();
      //  Assert.assertEquals("ServirPEdido", "Toni", p1.getUser());

    }
}
