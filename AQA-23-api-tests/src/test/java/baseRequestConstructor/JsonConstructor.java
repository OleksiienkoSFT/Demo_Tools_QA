package baseRequestConstructor;
import org.json.JSONObject;


public class JsonConstructor {
    public static String getLoginBodyStasUser1() {
        JSONObject loginBody = new JSONObject();
        try
        { loginBody.put("userName", "StasUser1");
            loginBody.put("password","P@ssword1");
        } catch(Exception e ) {
            e.getStackTrace();
        }
        return loginBody.toString();
    }

    public static String getLoginBodyForAccount(String userName, String pass) {
        JSONObject loginBody = new JSONObject();
        try
        {
            loginBody.put("userName", userName);
            loginBody.put("password",pass);
        } catch(Exception e ) {
            e.getStackTrace();
        }
        return loginBody.toString();
    }
}
