import dsa.models.Order;
import dsa.utils.ProductManager;
import dsa.utils.ProductManagerImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ProductManagerTest {
    ProductManager pm = null;

    @Before
    public void setUp() {
        pm = new ProductManagerImp(); // ProductManagerImpl.getInstance();
        pm.addUser("11111", "Toni");
        pm.addUser("22222", "Ivan");
        pm.addProduct("COCA-ZERO", "coca cola cero",4.5);
        pm.addProduct("BOCATA", "Bocata jampn",2);
        Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        Order p = new Order( "11111", date);  //sobraria el nombre pero deberia funcionar
        p.addLP(2, "COCA-ZERO");
        p.addLP(1, "BOCATA");
        pm.ped(p);
    }

    @Test
    public void testing() {
        pm.listPrices();//algo falla mirar despues

    }

    @Test
    public void anotarPedido() {
        Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        Order p = new Order("Toni", date); //, users.get("11111"));
        p.addLP(1, "COCA-ZERO");
        p.addLP(3, "BOCATA");
        p.addUSer("22222");
        pm.ped(p);
    }

    @Test
    public void servirPedido() {
        Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        Order p = new Order("22222", date); //, users.get("11111"));
        p.addLP(1, "COCA-ZERO");
        p.addLP(3, "BOCATA");
        pm.ped(p);

        //para asegurar que al empezar esta todo a cero
        Assert.assertEquals("ServirPEdido", 0, pm.getProduct("BOCATA").getCount());
        Assert.assertEquals("ServirPEdido", 0, pm.getProduct("COCA-ZERO").getCount());
        //Assert.assertEquals("ServirPEdido", 2, pm.numOrders());


        Order p1 = pm.listActive();

        Assert.assertEquals("ServirPEdido", "11111", p1.getUser());
        Assert.assertEquals("ServirPEdido", 2, p1.lps().get(0).q);
        Assert.assertEquals("ServirPEdido", "COCA-ZERO", p1.lps().get(0).product);

        Assert.assertEquals("ServirPEdido", 1, p1.lps().get(1).q);
        Assert.assertEquals("ServirPEdido", "BOCATA", p1.lps().get(1).product);

        Assert.assertEquals("ServirPEdido", 1, pm.getProduct("BOCATA").getCount());
        Assert.assertEquals("ServirPEdido", 2, pm.getProduct("COCA-ZERO").getCount());

        //comprobar despues de primera comanda


        p1 = pm.listActive();

        Assert.assertEquals("ServirPEdido", 4, pm.getProduct("BOCATA").getCount());
        Assert.assertEquals("ServirPEdido", 3, pm.getProduct("COCA-ZERO").getCount());
        //comprobar despues de segunda comanda
    }
}
