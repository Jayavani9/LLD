import java.util.*;

public class URLShortener {

    static String characters = "bcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    static HashMap<String, String> longToShort = new HashMap<>();
    static HashMap<String, String> shortToLong = new HashMap<>();
    static int keyLen = 6;
    static HashSet<String> set = new HashSet<>();
    static Random random = new Random();
    static String base = "http://short.url/";

    public static String generateKey() {
        String key = "";
        for (int i = 0; i < keyLen; i++) {
            int rand = random.nextInt(characters.length());
            key += characters.charAt(random.nextInt(rand));
        }
        return key;
    }

    public static String generateUniqueKey() {
        String key = generateKey();

        if (set.contains(key)) {
            key = generateKey();
        }

        set.add(key);
        return key;
    }

    public static String shorten(String LongURL) {

        if (longToShort.containsKey(LongURL)) {
            return base + longToShort.get(LongURL);
        }

        String key = generateUniqueKey();
        longToShort.put(LongURL, key);
        shortToLong.put(key, LongURL);

        return base + key;
    }

    public static String expand(String shortURL) {

        String key = shortURL.replace(base, "");
        return shortToLong.get(key);

    }

    public static void main(String[] args) {

        String LongURL = "https://example.com/some/very/long/url";

        String shortURL = shorten(LongURL);
        System.out.println(shortURL);

        String longURL = expand(shortURL);
        System.out.println(longURL);

    }

}
