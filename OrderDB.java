import java.util.*;

public class OrderDB {
    public static Map<String, List<String>> userOrders = new HashMap<>();

    public static void addOrder(String username, String orderSummary) {
        userOrders.computeIfAbsent(username, k -> new ArrayList<>()).add(orderSummary);
    }

    public static List<String> getOrders(String username) {
        return userOrders.getOrDefault(username, new ArrayList<>());
    }
}