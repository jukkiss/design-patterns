import java.util.HashMap;
import java.util.HashSet;

public class AccessControlService {
    private static AccessControlService instance;
    private HashMap<String, HashSet<String>> accessMap = new HashMap<>();

    private AccessControlService() {}

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void grantAccess(String documentId, String username) {
        accessMap.computeIfAbsent(documentId, k -> new HashSet<>()).add(username);
    }

    public boolean isAllowed(String documentId, String username) {
        return accessMap.getOrDefault(documentId, new HashSet<>()).contains(username);
    }
}
