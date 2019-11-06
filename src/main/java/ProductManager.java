import java.util.List;

public interface ProductManager {
    public List<Product> listPrices();//Listado de productos ordenado (ascendentemente) por precio
    public void ped(Pedido pedido);//Realizar un pedido (que puede estar formado por diferentes productos y en diferentes cantidades) por parte de un usuario identificado
    public Pedido listActive();//Servir un pedido. Los servicios se realizan en orden de llegadas
    public List<Pedido> listUsuario(String idUser);// Listado de pedidos de un usuario que ya hayan sido realizados
    public List<Product> listSales();// Listado de productos ordenado (descendentemente) por número de ventas
}
