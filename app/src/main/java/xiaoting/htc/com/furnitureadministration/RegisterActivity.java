package xiaoting.htc.com.furnitureadministration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import xiaoting.htc.com.furnitureadministration.model.LoginInfo;

public class RegisterActivity extends AppCompatActivity {
    private EditText regUserName;
    private EditText regPassword;
    private Button regEnsure;
    private static final String TAG = "xiaoting-RegisterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regUserName = (EditText)findViewById(R.id.reg_name);
        regPassword = (EditText)findViewById(R.id.reg_password);
        regEnsure = (Button)findViewById(R.id.reg_ensure_btn);
        regEnsure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = regUserName.getText().toString();
                String password = regPassword.getText().toString();
                Log.i(TAG,"user name is "+name);
                Log.i(TAG,"password is "+password);
                if(name.equals("") || password.equals("")) {
                    Toast.makeText(RegisterActivity.this,"名字或密码不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    LoginInfo user = new LoginInfo(getApplicationContext(),name,password);
                    if(user.registerUser()) {
                        Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(RegisterActivity.this,"此用户已经存在",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
