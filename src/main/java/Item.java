import java.util.Objects;

public class Item {

    private String name;
    private Double price;
    private String type;
    private String expiration;

    public Item(String name, Double price, String type, String expiration) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getExpiration() {
        return expiration;
    }

    @Override
    public String toString() {
        return "name:" + name + " price:" + price + " type:" + type  + " expiration:" + expiration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) &&
                Objects.equals(price, item.price) &&
                Objects.equals(type, item.type) &&
                Objects.equals(expiration, item.expiration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, type, expiration);
    }

}
