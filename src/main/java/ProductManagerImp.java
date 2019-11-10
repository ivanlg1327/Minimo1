import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class ProductManagerImp implements ProductManager{
    private Logger log = LogManager.getLogger(ProductManagerImp.class);
    List<Product> productList;
    List<User> userList;
    Queue<Order> orderQueue = new LinkedList<>();
    public ProductManagerImp(List<Product> productList,List<User> userList,Queue<Order> orderQueue) {
        this.productList = productList;
        this.userList = userList;
        this.orderQueue= orderQueue;
    }
    HashMap<String, User> users = new HashMap<String, User>();

    public void addUser(String id, String name){    //se podria hacer más simple
       //List<Pedido> empty=null;

        /*Predicate condition = new Predicate() {
            boolean evaluate(Object sample) {
                return ((Sample)sample).value3.equals("three");
            }
        };*/
        List <User> empty=new ArrayList<User>() ;;
        List<User> result = userList.stream().filter(item -> item.name.equals(name)).collect(Collectors.toList());
        log.info(result);
        if (result!=empty)
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

    }

    @Override
    public Order listActive() {
        return null;
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
