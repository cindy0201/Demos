package xiaoting.htc.com.furnitureadministration.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import static android.content.ContentValues.TAG;
import static android.content.Context.MODE_PRIVATE;

/**
 * Created by cindy on 16-11-8.
 */

public class LoginInfo {
    private String loginName;
    private String loginPassword;
    private Context mContext;

    public LoginInfo(Context context, String name, String pwd) {
        loginName = name;
        loginPassword = pwd;
        mContext = context;
    }

    public boolean registerUser(String fileName) {
        Log.i(TAG,"registerUser...");
        SharedPreferences share = mContext.getSharedPreferences(fileName, MODE_PRIVATE);
        if (share.contains(loginName)) {
            Log.i(TAG,"user repeated!");
            return false;
        }
        SharedPreferences.Editor editor = share.edit();
        editor.putString(loginName, loginPassword);
        editor.apply();
        return true;
    }
}
