import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Item {

    private String name;
    private Map<Double, Integer> prices;

    public Item(String name) {
        this.name = name;
        this.prices = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<Double, Integer> getPrices() {
        return prices;
    }

}
