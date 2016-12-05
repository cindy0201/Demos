package xiaoting.htc.com.furnitureadministration;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import xiaoting.htc.com.furnitureadministration.model.LoginInfo;

public class MainActivity extends Activity {
    //private static String TAG = "xiaoting-MainActivity";

    private EditText userName_edit;
    private EditText password_edit;
    private Button login;
    private Button register;
    private ProgressDialog mLoginingDlg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        setListener();
    }

    private void initView() {
        userName_edit = (EditText)findViewById(R.id.login_edtId);
        password_edit = (EditText)findViewById(R.id.login_edtPwd);
        login = (Button)findViewById(R.id.login_btnLogin);
        register = (Button) findViewById(R.id.login_btnReg);
    }

    private void setListener() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    private void login() {
        showLoginDlg();
        String name = userName_edit.getText().toString();
        String password = password_edit.getText().toString();
        if(name.equals("") || password.equals("")) {
            Toast.makeText(this,"名字或密码不能为空",Toast.LENGTH_SHORT).show();
        }else {
            LoginInfo user = new LoginInfo(getApplicationContext(),name,password);
            int checkResult = user.loginCheck();
            closeLoginDlg();
            switch (checkResult) {
                case 0:
                    Intent mIntent = new Intent(this,HomeActivity.class);
                    startActivity(mIntent);
                    break;
                case 1:
                    Toast.makeText(this,"用户名不存在",Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(this,"密码错误",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    private void register() {
        Intent mIntent = new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(mIntent);
    }

    private void showLoginDlg() {
        String message = "正在登录...";
        if(mLoginingDlg == null) {
            mLoginingDlg = new ProgressDialog(this);
            mLoginingDlg.setMessage(message);
            mLoginingDlg.show();
        }
    }

    private void closeLoginDlg() {
        if (mLoginingDlg != null && mLoginingDlg.isShowing())
            mLoginingDlg.dismiss();
    }


}
