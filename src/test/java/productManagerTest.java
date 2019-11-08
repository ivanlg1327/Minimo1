import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class productManagerTest {
    ProductManagerImp pm = null;
    List<Product> productList;
    List<User> userList;
    Queue<Order> orderQueue = new LinkedList<>();

    @Before
    public void setUp() {
        pm = new ProductManagerImp(productList, userList, orderQueue);
        pm.addUser("11111", "Toni");
        pm.addUser("22222", "Ivan");
        pm.addProduct("COCA-ZERO", "coca cola cero",4.5,productList);//mirar si tal como est montado nos rellena la lista
        pm.addProduct("BOCATA", "Bocata jampn",2,productList);
        Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        Order p = new Order(productList, "Ivan", date);//aqui toca poner otra product list para que haga lo que toca
        p.addLP(2, "COCA-ZERO");
        p.addLP(1, "BOCATA");
        p.addUSer("11111");//diferente este para decir que es para este usuario
        pm.ped(p);

    }

    @Test
    public void testing() {
       // pm.listPrices();
    }


    @Test
    public void anotarPedido() {
        Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        Order p = new Order(productList, "Toni", date);
        p.addLP(1, "COCA-ZERO");
        p.addLP(3, "BOCATA");
        p.addUSer("22222");
        pm.ped(p);
    }

    @Test
    public void servirPedido() {
        Order p1 = pm.listActive();
       // Assert.assertEquals("ServirPEdido", "Toni", p1.getUser());

    }
}
