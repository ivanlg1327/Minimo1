package dsa.utils;

import java.util.*;

import dsa.models.Order;
import dsa.models.Product;
import dsa.models.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class ProductManagerImp implements ProductManager{
    private Logger log = LogManager.getLogger(ProductManagerImp.class);
    private List<Product> productList;
    private Queue<Order> orderQueue ;
    private HashMap<String, User> users;

    private static ProductManagerImp instance = new ProductManagerImp();

    public static ProductManagerImp getInstance() {return instance;}
    public ProductManagerImp() {// List<dsa.models.Product> productList, HashMap<String, dsa.models.User> users,Queue<dsa.models.Order> orderQueue) {
        this.productList = new LinkedList<>();
        this.users = new HashMap<String, User>();
        this.orderQueue= new LinkedList<>();
    }
    @Override
    public int size(){
        int aux=this.productList.size();
        return aux;
    }

    public void addUser(String id, String name){
        User result=users.get(id);
        log.info(result);//debe aparecer vacio si no esta en la lista
        User aux;
        if (result==null)
        {
            aux=new User(name, id);
            users.put(id,aux);
            log.info("The user "+ aux.name+" with id '"+aux.id+ "' has been added to the system");
        }
        else
        {
            log.warn("The user " + name + " already exists" );
        }
    }

    public void addProduct(String name, String description,double price ){
        Product temp = new Product(name, price,0, description);
        this.productList.add(temp);//entra en bucle entre esta linea y el producto
        log.info(this.productList);
    }
    @Override
    public Product updateProduct( Product p){
        Product t = this.getProduct(p.getName());
        if (t!=null) {
            log.info(p+" rebut!!!! ");

            t.setName(p.getName());
            t.setPrice(p.getPrice());

            log.info(t+" updated ");
        }
        else {
            log.warn("not found "+p);
        }

        return t;
    }
    @Override
    public List<Product> listPrices()
    {
        Collections.sort(this.productList, new Comparator<Product>() {
            @Override
            public int compare(Product product, Product t1) {
                return ((int)(product.price-t1.price));
            }
        });
        log.info(productList);
        return productList;
    }

    @Override
    public void ped(Order order) {
        this.orderQueue.add(order);
    }

    @Override
    public Order listActive() {
        Order aux=this.orderQueue.poll();
        log.info(aux);
        User user = users.get(aux.getUser());
        int q;
        String p;
        Product product;
        for (Order.LP lp: aux.lps()) {
            q = lp.q;
            p = lp.product;
            product = this.getProduct(p);
            product.numVendes(q);
        }
        user.addHistorical(aux);

        return aux;
    }

    public Product getProduct(String p) {
        for (Product product : this.productList) {
            if (product.name.equals(p)) return product;
        }

        return null;
    }
    @Override
    public void deleteProduct(String name){
        Product t = this.getProduct(name);
        if (t==null) {
            log.warn("not found " + t);
        }
        else log.info(t+" deleted ");

        this.users.remove(t);
    }

    @Override
    public List<Order> listUser(String idUser) {
        return null;
    }

    @Override
    public List<Product> listSales() {
        return null;
    }

}
