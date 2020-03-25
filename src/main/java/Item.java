import java.util.HashMap;
import java.util.Map;

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

    public void incrementPrice(Double key){
        if(prices.containsKey(key)){
            prices.replace(key, prices.get(key)+1);
        } else {
            prices.put(key, 1);
        }
    }

    public Integer numberOfOccurances(){
        int total = 0;
        for(Map.Entry<Double, Integer> entry : prices.entrySet()){
            total += entry.getValue();
        }
        return total;
    }

    public String printTimeOrTimes(Integer num){
        return num > 1 ? "times" : "time";
    }

    @Override
    public String toString(){
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("name:%8s\t\t seen: %d %s\n",getName(), numberOfOccurances(), printTimeOrTimes(numberOfOccurances())));
        sb.append("============= \t \t =============\n");
        for (Map.Entry<Double,Integer> e:prices.entrySet()) {
            sb.append(String.format("Price:%7.2f\t\t seen: %d %s\n",e.getKey(), e.getValue(), printTimeOrTimes(e.getValue())));
            if(counter == 0)
                sb.append("-------------     \t -------------\n");

            counter++;
        }
        return sb.toString();
    }


}
