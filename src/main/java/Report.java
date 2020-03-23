import org.apache.commons.io.IOUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Report {

    private ItemParser items;
    private Map<Item, Integer> inventory;

    public Report() {
        this.items = new ItemParser();
        this.inventory = new HashMap<>();
    }

}
