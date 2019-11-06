import java.util.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.util.List;

public class ProductManagerImp implements ProductManager{
    private Logger log = LogManager.getLogger(ProductManagerImp.class);
    List<Product> productList;



    List<User> userList;
    public ProductManagerImp(List<Product> productList,List<User> userList) {
        this.productList = productList;
        this.userList = userList;
    }


    public void addUser(String id, String name){

    }

    public void addProduct(String name, String description,List<Product> productList ){

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
    public void ped(Pedido pedido) {

    }

    @Override
    public Pedido listActive() {
        return null;
    }

    @Override
    public List<Pedido> listUsuario(String idUser) {
        return null;
    }

    @Override
    public List<Product> listSales() {
        return null;
    }


}
