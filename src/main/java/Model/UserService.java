package Model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserService {

    private static final String SALT = "1:Hashirama_2:Tobirama_3:Hiruzen_4:Minato_5:Tsuande_-:Danzo_6:Kakashi_7:Naruto";

    public static User enrollUser(String username, String password){
        if (username == null || password == null){
            return null;
        }

        User user = new User();

        user.setUsername(username);
        user.setPassword(generateSecurePassword(password));

        return user;
    }

    public static String generateSecurePassword(String password){
        MessageDigest md = null;
        try{
            md = MessageDigest.getInstance("SHA-512");
            md.update(SALT.getBytes());
            byte[] newValue = md.digest(password.getBytes(StandardCharsets.UTF_8));
            return java.util.Base64.getEncoder().encodeToString(newValue);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return password;
    }

}
