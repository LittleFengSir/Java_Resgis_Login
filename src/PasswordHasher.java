import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordHasher {

    // 生成随机的盐值
    public static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    // 使用SHA-256哈希函数对密码和盐值进行加密
    public static String hashPassword(String password, byte[] salt) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(salt);
            byte[] hashedPassword = messageDigest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 验证密码是否匹配
    public static boolean verifyPassword(String inputPassword, byte[] salt, String storedPassword) {
        String hashedInputPassword = hashPassword(inputPassword, salt);
        return hashedInputPassword != null && hashedInputPassword.equals(storedPassword);
    }
}
