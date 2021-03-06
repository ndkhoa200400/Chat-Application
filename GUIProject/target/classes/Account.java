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

    private static String filepath = "./src/database/accounts.json";
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    private static Gson gson = new Gson();

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.mode = setMode(username);
        this.avatar_img = setAvatarPath(mode);
    }

    public boolean checkPassword(String p) {
        return this.password.equals(p);
    }

    public static String setMode(String name) {
        String mode;
        if (name.startsWith("S")) {
            mode = "Student";
        }
        if (name.startsWith("T")) {
            mode = "Teacher";
        } else {
            mode = "Staff";
        }
        return mode;
    }

    static String setAvatarPath(String mode) {
        String avatar_img;
        if (mode.equals("Student")) {
            avatar_img = "./src/database/user_img/student.png";

        } else if (mode.equals("Teacher")) {
            avatar_img = "./src/database/user_img/teacher.png";

        } else {
            avatar_img = "./src/database/user_img/staff.png";

        }
        return avatar_img;
    }

    static boolean isExisted(String username) {

        try ( FileReader reader = new FileReader(filepath)) {
            // Read JSON file

            JsonArray obj = (JsonArray) gson.fromJson(reader, JsonArray.class);

            // Neu chua co tai khoan nao trong file
            if (obj == null) {             
                return false;
            }
            for (int i = 0; i < obj.size(); i++) {
                if (obj.get(i).getAsJsonObject().get("username").toString().equals("\""+username+"\"")) {            
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
        if (!s.matches("^[a-zA-Z0-9]+$")) {
            return false;
        }
        return true;
    }

    static String checkAccount(String username, String password) throws IOException {
        if (!isValidString(username)) {
            return "Invalid username";
        }
        BufferedReader reader;
        try {

            reader = new BufferedReader(new FileReader(filepath));
            JsonArray obj = (JsonArray) gson.fromJson(reader, JsonArray.class);

            // Neu chua co tai `khoan nao trong file
            if (obj == null) {
                return "Incorrect username or password";
                
            }

            for (int i = 0; i < obj.size(); i++) {
                JsonObject account = obj.get(i).getAsJsonObject();

                if (account.get("username").getAsString().equals(username)
                        && bCryptPasswordEncoder.matches(password, account.get("password").getAsString())) {

                    return "ok";
                }
            }
            reader.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return "Incorrect username or password";
    }

    static void signUp(String username, String password) throws IOException {
        FileWriter writer = null;
        try {

            try ( FileReader reader = new FileReader(filepath)) {
                // Read JSON file

                JsonArray obj = (JsonArray) gson.fromJson(reader, JsonArray.class);
                if (obj == null) {
                    obj = new JsonArray();
                }
                JsonObject temp = new JsonObject();
                temp.addProperty("username", username);
                temp.addProperty("password", bCryptPasswordEncoder.encode(password));
                String mode = setMode(username);
                temp.addProperty("mode", mode);
                temp.addProperty("avatar_img", setAvatarPath(mode));
                obj.add(temp);
                writer = new FileWriter(filepath, false);
                gson.toJson(obj, writer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    String getUserName() {
        return this.username;
    }

    public String getAvatar_img() {
        return avatar_img;
    }

    public String getMode() {
        return mode;
    }

    void changePassword(String newPassword) throws IOException {
        this.password = newPassword;
        FileWriter writer = null;
        try {

            try ( FileReader reader = new FileReader(filepath)) {
                // Read JSON file

                JsonArray obj = (JsonArray) gson.fromJson(reader, JsonArray.class);
                if (obj == null) {
                    obj = new JsonArray();
                }
                for (int i = 0; i < obj.size(); i++) {
                    JsonObject account = (JsonObject) obj.get(i);
                    if (account.get("username").getAsString().equals(this.username)) {
                        account.addProperty("password", bCryptPasswordEncoder.encode(password));
                    }
                }
                // temp.addProperty("username", username);
                // temp.addProperty("password", bCryptPasswordEncoder.encode(password));
                // obj.add(temp);
                writer = new FileWriter(filepath, false);
                gson.toJson(obj, writer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.close();

        }
    }

    void changeAvatar(String filePath) throws IOException {
        file img = new file();
        img.getFileInfo(filePath);
        FileWriter writer = null;

        try {

            try ( FileReader reader = new FileReader("./src/database/accounts.json")) {
                // Read JSON file

                JsonArray obj = (JsonArray) gson.fromJson(reader, JsonArray.class);
                if (obj == null) {
                    obj = new JsonArray();
                }
                for (int i = 0; i < obj.size(); i++) {
                    JsonObject account = (JsonObject) obj.get(i);
                    if (account.get("username").getAsString().equals(this.username)) {
                        account.addProperty("avatar_img", filePath);
                    }
                }
                avatar_img = filePath;
                // temp.addProperty("username", username);
                // temp.addProperty("password", bCryptPasswordEncoder.encode(password));
                // obj.add(temp);
                writer = new FileWriter("./src/database/accounts.json", false);
                gson.toJson(obj, writer);
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            writer.close();
        }
    }
}