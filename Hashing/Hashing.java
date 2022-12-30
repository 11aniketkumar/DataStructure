import java.util.*;

public class Hashing {
    public static void main(String[] args) {
        //Create
        HashMap<String, Integer> hm = new HashMap<>();

        //Insert - O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Paris", 7);
        hm.put("Nepal", 5);

        System.out.println(hm);
        System.out.println("========================================");


        //Get - O(1)
        int population = hm.get("India");
        System.out.println(population);
        System.out.println(hm.get("Indonesia")); //null
        System.out.println("========================================");

        //ContainsKey - O(1)
        System.out.println(hm.containsKey("India"));        //true
        System.out.println(hm.containsKey("Indonesia"));    //false
        System.out.println("========================================");

        //Remove - O(1)
        System.out.println(hm.remove("Indonesia"));
        // System.out.println(hm.remove("China")); //valid case
        System.out.println(hm);
        System.out.println("========================================");

        //size
        System.out.println(hm.size());
        //Is Empty
        System.out.println(hm.isEmpty());

        //clear the hashMap
        // hm.clear();
        // System.out.println(hm.isEmpty());
        System.out.println("========================================");


        //Iterate
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for(String k: keys) {
            System.out.println(k + " \t " + hm.get(k));
        }

        // System.out.println(hm.entrySet());
    }
}