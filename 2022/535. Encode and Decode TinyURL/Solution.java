public class Codec {
    
    private static String CODE = "0123456789abcedfghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Map<String, String> map = new HashMap<>();
    Random random = new Random();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = randomString(6);
        while (map.containsKey(key)) {
            key = randomString(6);
        }
        map.put(key, longUrl);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (map.containsKey(shortUrl)) {
            return map.get(shortUrl);
        }
        return "";
    }
    
    public String randomString(int digit) {
        StringBuilder sb = new StringBuilder();
        while (digit-- > 0) {
            sb.append(CODE.charAt(random.nextInt(62)));
        }
        return sb.toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));