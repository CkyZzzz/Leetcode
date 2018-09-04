public class Codec {
	//<---------------------------1--------------------------->
	private List<String> list = new ArrayList<>();
	private static final String PREFIX = "http://tinyurl.com/";
	
	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		int index = list.size();
		list.add(longUrl);
		return PREFIX + index;
	}
	
	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		int index = Integer.valueOf(shortUrl.substring(PREFIX.length()));
		return list.get(index);
	}
	
	//<---------------------------2--------------------------->
	Map<Integer, String> map = new HashMap<>();
	String HOST = "http://tinyurl.com/";
	
	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		int key = longUrl.hashCode();
		map.put(key, longUrl);
		return HOST + key;
	}
	
	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		int key = Integer.parseInt(shortUrl.replace(HOST, ""));
		return map.get(key);
	}
}