package holyape.com.mvp;

import android.app.ProgressDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MVPActivity extends AppCompatActivity  implements IMainActivity{


    Toolbar toolbar;
    EditText editTextName;
    EditText editTextPassword;
    Button btnLogin;
    LinearLayout main_container;
    private ILoginPresenter loginPresenter;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        toolbar = (Toolbar)findViewById(R.id.main_toolbar);
        editTextName = (EditText)findViewById(R.id.main_etName);
        editTextPassword = (EditText)findViewById(R.id.main_etPassword);
        btnLogin = (Button)findViewById(R.id.main_btnLogin);
        main_container = (LinearLayout)findViewById(R.id.activity_main);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                loginPresenter.attempLogin(editTextName.getText().toString(),editTextPassword.getText().toString());
            }
        });
        toolbar.setTitle("MVP Demo");
        initProgressDialog();
        loginPresenter = new LoginPresenter(this);
    }

    private void initProgressDialog(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Please Wait...");
    }


    @Override
    public void loginSuccess() {
        progressDialog.dismiss();
        Snackbar.make(main_container,"Login Success",Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void loginFailed() {
        progressDialog.dismiss();
        Snackbar.make(main_container,"Login Failed",Snackbar.LENGTH_LONG).show();
    }
}
