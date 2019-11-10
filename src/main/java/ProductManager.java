import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public interface ProductManager {
    public List<Product> listPrices();//Listado de productos ordenado (ascendentemente) por precio
    public void ped(Order order);//Realizar un pedido (que puede estar formado por diferentes productos y en diferentes cantidades) por parte de un usuario identificado
    public Order listActive();//Servir un pedido. Los servicios se realizan en orden de llegadas
    public List<Order> listUser(String idUser);// Listado de pedidos de un usuario que ya hayan sido realizados
    public List<Product> listSales();// Listado de productos ordenado (descendentemente) por número de ventas
}
