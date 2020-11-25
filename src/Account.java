import java.io.BufferedReader;
import java.io.DataOutputStream; 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class Account {
    @SerializedName(value = "username")
    private String username;

    @SerializedName(value = "password")
    private String password;

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    private static Gson gson = new Gson();

    Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // static boolean isExisted(String username)
    // {
    // @SuppressWarnings("unchecked")
    // BufferedReader reader;
    // try {
    // // reader = new BufferedReader(new FileReader("accounts.txt"));
    // reader = new BufferedReader(new FileReader("./database/accounts.json"));
    // String line = reader.readLine();
    // while (line != null) {
    // if (line.equals(username)) {
    // reader.close();
    // return true;
    // }
    // // read next line
    // line = reader.readLine();
    // line = reader.readLine();
    // }
    // reader.close();

    // } catch (Exception e) {
    // //TODO: handle exception
    // System.err.println("ERROR when checking existing accounts");
    // }
    // return false;
    // }
    static boolean isExisted(String username) {

        try (FileReader reader = new FileReader("./database/accounts.json")) {
            // Read JSON file

            JsonArray obj = (JsonArray) gson.fromJson(reader, JsonArray.class);

            // Neu chua co tai khoan nao trong file
            if (obj == null) return false;
            for (int i = 0; i < obj.size(); i++) {
                if (obj.get(i).getAsJsonObject().get("username").equals(username)) {
                    return true;
                }
            }

        } catch (Exception e) {
           
            e.printStackTrace();
        } 
       
        return false;
    }

    static boolean isValidString(String s) {

        if (Character.isDigit(s.charAt(0))) {
            return false;
        }
        // Only alphabets and alphanumeric characters
        if (!s.matches("^[a-zA-Z0-9]+$"))
            return false;
        return true;
    }

    static boolean checkAccount(String username, String password) throws IOException {
        if (!isValidString(username))
            return false;
        BufferedReader reader;
        try {

            reader = new BufferedReader(new FileReader("./database/accounts.json"));
            JsonArray obj = (JsonArray) gson.fromJson(reader, JsonArray.class);
          
            // Neu chua co tai `khoan nao trong file
            if (obj == null) return false;
            System.out.println(obj);
            for (int i = 0; i < obj.size(); i++) {
                JsonObject account = obj.get(i).getAsJsonObject();
                System.out.println(account);
                if (account.get("username").equals(username) &&
                    bCryptPasswordEncoder.matches(password, account.get("password").toString())){
                    return true;
                }
            }
            reader.close();

        } catch (Exception e) {
            // TODO: handle exception

        }
     
        return false;
    }

    // static void signUp(String username, String password)
    // {
    // BufferedWriter writer = null;
    // try {
    // writer = new BufferedWriter(new FileWriter("./database/accounts.json",
    // true));
    // writer.write(username +"\n" + password + "\n");
    // writer.close();
    // } catch (IOException e) {
    // System.out.println("Exception occurred:");
    // e.printStackTrace();
    // }
    // }

    static void signUp(String username, String password) throws IOException {

        Account newA = new Account(username, password);
        FileWriter writer = null;
        try{
           
            try (FileReader reader = new FileReader("./database/accounts.json")) {
                // Read JSON file

                JsonArray obj = (JsonArray) gson.fromJson(reader, JsonArray.class);
                if (obj == null) obj = new JsonArray();
                JsonObject temp = new JsonObject();
                temp.addProperty("username", username);
                temp.addProperty("password", bCryptPasswordEncoder.encode(password));
                obj.add(temp);
                writer = new FileWriter("./database/accounts.json", false);
                gson.toJson(obj, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }}catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            writer.close();
        }
    }

    String getUserName() {
        return this.username;
    }
}
