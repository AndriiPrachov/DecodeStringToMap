import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapDecoderImpl implements MapDecoder {
    private final static String EQUALS = "=";
    private final static String AMPERSAND = "&";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        in.close();

        System.out.println(new MapDecoderImpl().decodeStringToMap(str).toString());
    }

    @Override
    public Map<String, String> decodeStringToMap(String str) {
        Map<String, String> result = new HashMap<>();

        if (str == null) {
            return null;
        } else if (!str.contains(EQUALS)) {
            throw new IllegalArgumentException(str);
        } else if (!str.isEmpty()) {
            String[] pairs = str.split(AMPERSAND);
            for (String pair : pairs) {
                String[] keyVal = pair.split(EQUALS);
                result.put(keyVal[0], keyVal.length > 1 ? keyVal[1] : "");
            }
        }

        return result;
    }
}
