package xiaoting.htc.com.furnitureadministration.model;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import xiaoting.htc.com.furnitureadministration.control.Utils;

import static android.content.ContentValues.TAG;
import static android.content.Context.MODE_PRIVATE;

/**
 * Created by cindy on 16-11-8.
 */

public class LoginInfo {
    private String loginName;
    private String loginPassword;
    private Context mContext;
    private static final String PREF_NAME = "User";
    private static final String DEFAULT_VALUE = "";

    private static final String TAG = "xiaoting-LoginInfo";

    public LoginInfo(Context context, String name, String pwd) {
        loginName = name;
        loginPassword = pwd;
        mContext = context;
    }

    public boolean registerUser() {
        Log.i(TAG,"registerUser...");
        SharedPreferences share = mContext.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        if (share.contains(loginName)) {
            Log.i(TAG,"user repeated!");
            return false;
        }
        String encryptedPsw = Utils.MD5Encrypt(loginPassword);
        if(encryptedPsw != null) {
            SharedPreferences.Editor editor = share.edit();
            editor.putString(loginName, encryptedPsw);
            editor.commit();
            return true;
        }else {
            return false;
        }
    }

    public int loginCheck() {
        SharedPreferences share = mContext.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
        if(share.contains(loginName)) {
            Log.i(TAG,"loginName input is " + loginName);
            String sPassword = share.getString(loginName,DEFAULT_VALUE);
            Log.i(TAG,"password from SharedPreference is " + sPassword);
            if(sPassword.equals(Utils.MD5Encrypt(loginPassword))) {
                //the loginPassword input by user is matched.
                return 0;
            }else {
                //the loginPassword input by user is wrong.
                return 2;
            }
        }else {
            //the loginName input by user doesn't exist.
            Log.i(TAG,"user name doesn't exist.");
            return 1;
        }
    }
}
