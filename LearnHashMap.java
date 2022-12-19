import java.util.HashMap;

public class LearnHashMap
{
	public static void main(String[] args) {
	    HashMap<String, Integer> map = new HashMap<>();
	    
	    map.put("India", 120);
	    map.put("China", 150);
	    map.put("US", 30);
	    
	    System.out.println(map);
	    
	    map.put("US", 25);
	    System.out.println(map);
	    
	    if(map.containsKey("China")) {
	        System.out.println("Key is present in the map");
	    } else {
	        System.out.println("Key is  not present in the map");
	    }
	    
	    System.out.println(map.get("China"));
	    System.out.println(map.get("Indonesia"));
	    
	}
}