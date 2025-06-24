import java.util.HashMap;
import java.util.Map;

public class UserDB {
    public static Map<String, String> customers = new HashMap<>();
    public static Map<String, String> admins = new HashMap<>();

    static {
        customers.put("user1", "User@123");
        admins.put("admin", "Admin@123");
    }
}