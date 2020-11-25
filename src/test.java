import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class test {
    public static void main(String[] args) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String bCryptedPassword = bCryptPasswordEncoder.encode("password");
        boolean passwordIsValid = bCryptPasswordEncoder.matches("password", bCryptedPassword);
        System.out.println(bCryptedPassword);
        System.out.println(passwordIsValid);

    }
}