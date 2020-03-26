import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        ItemParser items = new ItemParser();
        List<String> parsed = items.seperateItems(output);
        Map<String, Item> map= items.createItemMap(parsed);
        for (Map.Entry<String, Item> entry : map.entrySet()){
            System.out.println(entry.getValue());
        }
        System.out.println("Errors               seen: "+ items.getExceptionCount() +" times");
    }
}
