import java.util.HashSet;
import java.util.Iterator;

public class idManager {
    private static final int ID_LENGTH = 4;
    private static final HashSet<String> idSet = new HashSet<>();

    public String generateRandomId() {
        String newId = "";
        
        for (int i = 0; i < ID_LENGTH; i++) {
            char ch = (char) ((Math.random() * 26) + 97); // a~z 까지의 랜덤 문자 생성
            newId += ch;
        }
        
        boolean initSuccess = validateId(newId);

        if (initSuccess) {
            idSet.add(newId);
            return newId;
        }
        return generateRandomId();
    }

    public boolean validateId(String newId) {
        if (idSet.contains(newId)) {
            return false;
        }

        return true;
    }
}
