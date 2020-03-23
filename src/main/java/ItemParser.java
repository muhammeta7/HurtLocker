import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {

    private int exceptionCount;
    private Pattern namePattern;
    private Pattern pricePattern;
    private Pattern typePattern;
    private Pattern expirationPattern;


    public ItemParser() {
        this.exceptionCount = 0;
        this.namePattern = Pattern.compile("[Nn][Aa][Mm][Ee]:([a-zA-Z])*;");
        this.pricePattern = Pattern.compile("[Pp][Rr][Ii][Cc][Ee]:(\\d+\\.\\d+)*;");
        typePattern = Pattern.compile("type[@|^|*|:|%]([A-Za-z]+)[;|/^|/!|%|*|@]");
        expirationPattern = Pattern.compile("expiration[@|^|*|:|%](\\\\d+/\\\\d+/\\\\d{4})");
    }

    public Item parseEachItem(String item) throws ItemParseException{
        return new Item(findItemField(item, namePattern),
                new Double(findItemField(item, pricePattern)),
                findItemField(item, typePattern),
                findItemField(item, expirationPattern));
    }

    public List<Item> parseList(String value){
        List<Item>  items = new ArrayList<>();
        for(String s : value.split("##")){
            try{
                items.add(parseEachItem(s));
            } catch (ItemParseException e) {
                System.out.println("Invalid item");
                exceptionCount++;
            }
        }
        return items;
    }

    public Matcher getMatcher(String item, Pattern pattern){
        return pattern.matcher(item);
    }

    public String findItemField(String item, Pattern pattern) throws ItemParseException {
        Matcher matcher = getMatcher(item, pattern);
        if(matcher.find()){
            return matcher.group(0).toLowerCase();
        }
        throw new ItemParseException();
    }

    public int getExceptionCount() {
        return exceptionCount;
    }

}

