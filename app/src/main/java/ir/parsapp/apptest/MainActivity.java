package ir.parsapp.apptest;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(FLAG_FULLSCREEN,FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(policy);


        TextView btnLogin = findViewById(R.id.btn_login);
        final EditText txtUsername=findViewById(R.id.txt_username);
        final EditText txtPassword=findViewById(R.id.txt_password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username =  txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

                if(username.equals("admin") && password.equals("admin")){
                    //login success
                    Intent i=new Intent(MainActivity.this,MainPageActivity.class);
                    startActivity(i);
                    MainActivity.this.finish();
                }else{

                }
            }
        });


    }

}
