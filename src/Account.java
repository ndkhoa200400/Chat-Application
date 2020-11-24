import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
 
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class Account {
    @SerializedName(value ="username")
    private String username;

    @SerializedName(value = "password")
    private String password;
    
    DataOutputStream fout;

    private static Gson gson;

    Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // static boolean isExisted(String username)
    // {
    //     @SuppressWarnings("unchecked")
    //     BufferedReader reader; 
    //     try { 
    //         // reader = new BufferedReader(new FileReader("accounts.txt"));
    //         reader = new BufferedReader(new FileReader("./database/accounts.json"));
	// 		String line = reader.readLine();
	// 		while (line != null) {
    //             if (line.equals(username)) {
    //                 reader.close();
    //                 return true;      
    //             }       
    //             // read next line
    //             line = reader.readLine();
    //             line = reader.readLine();
    //         }     
    //         reader.close();

    //     } catch (Exception e) {
    //         //TODO: handle exception
    //        System.err.println("ERROR when checking existing accounts");
    //     }
    //     return false;
    // }
    static boolean isExisted(String username){
        @SuppressWarnings("unchecked")
         //JSON parser object to parse read file
         JSONParser jsonParser = new JSONParser();

         try (FileReader reader = new FileReader("./database/accounts.json"))
         {
             //Read JSON file
             Object obj = jsonParser.parse(reader);
  
             JSONArray accountsList = (JSONArray) obj;
             
              
             //Iterate over employee array
             accountsList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
  
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         } catch (ParseException e) {
             e.printStackTrace();
         }
    }

    static boolean isValidString(String s)
    {

        if (Character.isDigit(s.charAt(0)))
        {
            return false;
        }
        // Only alphabets and alphanumeric characters
        if (!s.matches("^[a-zA-Z0-9]+$")) return false;
        return true;
    }

    static boolean checkAccount(String username, String password) throws IOException
    {
        if (!isValidString(username)) return false;
        BufferedReader reader; 
        try {
            
            reader = new BufferedReader(new FileReader("./database/accounts.json"));
            ArrayList<String> lines = new ArrayList<String>();
			String line = reader.readLine();
			while (line != null) {
                lines.add(line);                       
                // read next line
                line = reader.readLine();
            }
      
            for (int i = 0; i < lines.size(); i+=2) {
                if (lines.get(i).equals(username))
                {
                    if (lines.get(i+1).equals(password))
                    {
                        reader.close();
                        return true;
                    }
                }
            }
            
            reader.close();

        } catch (Exception e) {
            //TODO: handle exception
           
        }
        return false;
    }

    // static void signUp(String username, String password)
    // {
    //     BufferedWriter writer = null;
    //     try {
    //         writer = new BufferedWriter(new FileWriter("./database/accounts.json", true));
    //         writer.write(username +"\n" + password + "\n");
    //         writer.close();
    //     } catch (IOException  e) {
    //         System.out.println("Exception occurred:");
    // 	    e.printStackTrace();
    //     }
    // }

    static void signUp(String username, String password){
        gson = new Gson();
        Account newA = new Account(username,password);
        try (FileWriter writer = new FileWriter("D:/data.json")) {
            gson.toJson(newA);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    String getUserName()
    {
        return this.username;
    }
}
