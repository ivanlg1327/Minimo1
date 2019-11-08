public class Product implements Comparable<Product>{
    String name;
    double price;
    int count;
    String description;

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


    public Product(String name, double price, int count, String description) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.description = description;
    }

    @Override
    public int compareTo(Product e2) {
        return this.name.compareTo(e2.name);
    }
}
