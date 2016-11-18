package xiaoting.htc.com.furnitureadministration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    private EditText regUserName;
    private EditText regPassword;
    private Button regEnsure;

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

            }
        });
    }
}
