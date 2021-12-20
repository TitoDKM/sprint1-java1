import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class Utils {
    static final Pattern EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean isEmailValid(String mail) {
        Boolean valid = EMAIL_REGEX.matcher(mail).find();
        if(!valid) {
            System.err.println("El correo electrónico " + mail + " tiene un formato incorrecto");
        }
        return valid;
    }
}
