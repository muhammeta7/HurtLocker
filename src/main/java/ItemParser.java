import com.sun.javafx.collections.MappingChange;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {

    int exceptionCount = 0;
    private Map<String, Item> itemMap;

    public ItemParser(){
        this.itemMap = new HashMap<>();
    }

    // Return Lists of Strings seperated by ##
    public List<String> seperateItems(String text){
        List<String> items = new ArrayList<>();
        Pattern pattern = Pattern.compile("(.*?)##");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            items.add(matcher.group(0));
        }
        return items;
    }

    // Map String to Items
    public Map<String, Item> createItemMap(List<String> itemsList){
        Map<String, Item> itemMap = new LinkedHashMap<>();
        for(String s : itemsList){
            Pattern pattern = Pattern.compile("^(?i)name:(.*?);((?i)price:(.*?);)");
            Matcher matcher = pattern.matcher(s);
            while(matcher.find()){
                String name;
                double price;
                try {
                    name = formatName(convertZeroToO(matcher.group(1).toLowerCase()));
                    price = Double.parseDouble(matcher.group(3));
                    if(name.equals("")){
                        throw new Exception();
                    }
                }catch (Exception e){
                    exceptionCount++;
                    continue;
                }

                if(!itemMap.containsKey(name)){
                    itemMap.put(name, new Item(name));
                }

                itemMap.get(name).incrementPrice(price);
            }
        }

        return itemMap;
    }

    public static String formatName(String string) {
        char[] charArray = string.toCharArray();

        for (int i = 1; i<string.length(); i++) {
            if (charArray[i] >= 65 && charArray[i] <= 90) {
                charArray[i] += 32;
            }
        }

        if (charArray[0] >= 97 && charArray[0] <= 122) {
            charArray[0] -= 32;
        }
        return new String(charArray);

    }

    public String convertZeroToO(String name){
        Pattern pattern = Pattern.compile("0");
        return pattern.matcher(name).replaceAll("o");
    }

    public int getExceptionCount() {
        return exceptionCount;
    }
}

