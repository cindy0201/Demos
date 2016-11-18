package xiaoting.htc.com.furnitureadministration.model;

import org.json.JSONObject;

/**
 * Created by cindy on 16-11-8.
 */

public class LoginInfo {
    private String loginName;
    private String loginPassword;
    private static final String JSON_NAME = "name";
    private static final String JSON_PASSWORD = "password";

    LoginInfo(String name, String pwd) {
        loginName = name;
        loginPassword = pwd;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }

    public JSONObject newJson() {

    }


}
