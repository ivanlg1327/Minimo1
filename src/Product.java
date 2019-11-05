public class Product {
    String name;
    double price;
    int count;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }


    public Product(String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }
}
