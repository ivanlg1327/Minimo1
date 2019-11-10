import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class ProductManagerImp implements ProductManager{
    private Logger log = LogManager.getLogger(ProductManagerImp.class);
    private List<Product> productList;
    private Queue<Order> orderQueue = new LinkedList<>();
    private HashMap<String, User> users = new HashMap<String, User>();


    public ProductManagerImp(List<Product> productList, HashMap<String, User> users,Queue<Order> orderQueue) {
        this.productList = productList;
        this.users = users;
        this.orderQueue= orderQueue;
    }

    public void addUser(String id, String name){    //se podria hacer más simple

        User result=users.get(id);
        log.info(result);
        if (result!=null)
        {
            User aux=new User(name, null);
            users.put(id,aux);
        }
        else
        {
            log.warn("The user " + name + " already exists" );
        }
    }

    public void addProduct(String name, String description,double price,List<Product> productList ){
        Product temp = new Product(name, price,0, description);
        productList.add(temp);
        log.info(productList);
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
        orderQueue.add(order);
    }

    @Override
    public Order listActive() {
        Order aux=orderQueue.poll();
        String name=aux.name;
        log.info(aux);
        users.get(name);
        return aux;
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
