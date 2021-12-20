import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static ArrayList<User> users = new ArrayList<>();

    static int ERRORS_COUNT = 0;
    static int PROCESSED_LINES = 0;

    public static void main(String[] args) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("users.csv"));
            String line = bufferedReader.readLine();
            int i = 1;

            System.out.println("Comenzando lectura del archivo users.csv");
            while(line != null) {
                if(isLineValid(line)) {
                    String parts[] = line.split(",");
                    if(!mailExists(parts[0], i) && Utils.isEmailValid(parts[0])) {
                        User newUser = new User(parts[0], parts[1], parts[2]);
                        users.add(newUser);
                        PROCESSED_LINES++;
                    }
                } else {
                    ERRORS_COUNT++;
                    System.err.println("La línea " + i + " está mal formada y no ha sido procesada");
                }

                line = bufferedReader.readLine();
                i++;
                if(line == null)
                    System.out.println("Lectura del archivo finalizada.\nLíneas procesadas: " + PROCESSED_LINES + "\nErrores: " + ERRORS_COUNT);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File users.csv not found");
        } catch (IOException e) {
            System.err.println("Error while reading users.csv: " + e.getMessage());
        }
    }

    static boolean isLineValid(String line) {
        if(!line.contains(","))
            return false;
        if(line.split(",").length != 3)
            return false;
        return true;
    }

    static boolean mailExists(String mail, int line) {
        for(User user : users) {
            if(user.getEmail().equals(mail)) {
                ERRORS_COUNT++;
                if(line != 0)
                    System.err.println("El correo electrónico " + mail + " (línea " + line + ") ya existe en la base de datos");
                else
                    System.err.println("El correo electrónico " + mail + " ya existe en la base de datos");
                return true;
            }
        }
        return false;
    }
}
