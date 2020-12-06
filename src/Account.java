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

    @SerializedName(value = "mode")
    private String mode;

    @SerializedName(value = "avatar_img")
    private String avatar_img;

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    private static Gson gson = new Gson();

    final static String F_STRING ="./testfile/hinh.jpg";

    Account(String username, String password,String mode) {
        this.username = username;
        this.password = password;
        this.mode = mode;
    }

    
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
                String a = "18127250";
                System.out.println("\"" + a + "\"");
                System.out.println(account.get("username"));
                if (account.get("username").equals( "\"" + username + "\"") &&
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


    static void signUp(String username, String password,String mode) throws IOException {

        Account newA = new Account(username, password, mode);
        FileWriter writer = null;
        try{
           
            try (FileReader reader = new FileReader("./database/accounts.json")) {
                // Read JSON file
                JsonArray obj = (JsonArray) gson.fromJson(reader, JsonArray.class);
                if (obj == null) obj = new JsonArray();
                JsonObject temp = new JsonObject();
                file img = new file();
                img.getFileInfo(F_STRING);

                temp.addProperty("username", username);
                temp.addProperty("password", bCryptPasswordEncoder.encode(password));
                temp.addProperty("mode", mode);
                temp.addProperty("avatar_img","./database/user_img/hinh.jpg");
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

    void changePassword(String newPassword) throws IOException
    {
        this.password = newPassword;
        FileWriter writer = null;
        try{
           
            try (FileReader reader = new FileReader("./database/accounts.json")) {
                // Read JSON file

                JsonArray obj = (JsonArray) gson.fromJson(reader, JsonArray.class);
                if (obj == null) obj = new JsonArray();
                for (int i = 0; i < obj.size(); i++) {
                    JsonObject account = (JsonObject) obj.get(i);
                    if (account.get("username").getAsString().equals(this.username))
                        account.addProperty("password", bCryptPasswordEncoder.encode(password));
                }
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

    void changeAvatar(String filePath) throws IOException
    {
        FileWriter writer = null;
        try{
           
            try (FileReader reader = new FileReader("./database/accounts.json")) {
                // Read JSON file

                JsonArray obj = (JsonArray) gson.fromJson(reader, JsonArray.class);
                if (obj == null) obj = new JsonArray();
                for (int i = 0; i < obj.size(); i++) {
                    JsonObject account = (JsonObject) obj.get(i);
                    if (account.get("username").getAsString().equals(this.username))
                        account.addProperty("avatar_img", filePath);
                }
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
}
