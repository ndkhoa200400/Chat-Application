import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Account {
    private String username;
    private String password;

    DataOutputStream fout;

    Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    static boolean isExisted(String username)
    {
        BufferedReader reader; 
        try {
            
            reader = new BufferedReader(new FileReader("accounts.txt"));
			String line = reader.readLine();
			while (line != null) {
                if (line.equals(username)) {
                    reader.close();
                    return true;      
                }       
                // read next line
                line = reader.readLine();
                line = reader.readLine();
            }     
            reader.close();

        } catch (Exception e) {
            //TODO: handle exception
           
        }
        return false;
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
            
            reader = new BufferedReader(new FileReader("accounts.txt"));
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

    static void signUp(String username, String password)
    {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("accounts.txt", true));
            writer.write(username +"\n" + password + "\n");
            writer.close();
        } catch (IOException  e) {
            System.out.println("Exception occurred:");
    	    e.printStackTrace();
        }
    }

    String getUserName()
    {
        return this.username;
    }
}
