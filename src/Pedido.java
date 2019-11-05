import java.util.List;
public class Pedido {
    List <Product> productList;
    int cost=0;
    String name;

    public Pedido(List<Product> productList, String name) {
        this.productList = productList;
        this.name=name;
        this.cost = this.count(productList);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public int getCost() {
        return cost;
    }

    public int count(List <Product> productList)
    {
        return 1;
    }
}
