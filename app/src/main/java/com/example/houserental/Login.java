package com.example.houserental;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText et1_name,et2_pwd,et3_email;
    ProgressDialog progressDialog;
    FirebaseAuth auth;
    FirebaseUser user;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et1_name=findViewById(R.id.et1_name);
        String name=getIntent().getStringExtra("name");
        et1_name.setText(name);

        et2_pwd=findViewById(R.id.et2_pwd);
        String pwd=getIntent().getStringExtra("pwd");
        et2_pwd.setText(pwd);
        et3_email=findViewById(R.id.et3_email);
        progressDialog=new ProgressDialog(this);
        //ASSIGNING FIREBASE INSTANCES
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
    }


     // FROM LOGIN TO HOME ACTIVITY
     public void logIn_to_home(View view) {
        if (view.getId() == R.id.btn_logIn) {

            String email,pwd;
            email=et3_email.getText().toString();
            pwd=et2_pwd.getText().toString();

            if(email.isEmpty())
                et3_email.setError("Enter your email");
            else if(pwd.isEmpty())
                et2_pwd.setError("Enter your password");
            else
            {
                progressDialog.setMessage("Please Wait While Login...");
                progressDialog.setTitle("Log In");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();

                auth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            progressDialog.dismiss();
                            Toast.makeText(Login.this,"LogIn Successfull",Toast.LENGTH_LONG).show();
                            MyApplication myApplication=new MyApplication();
                            //GO  TO MAINACTIVITY
                            intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            progressDialog.dismiss();
                            Toast.makeText(Login.this,"Email or Password is not Corretct "/*+task.getException()*/,Toast.LENGTH_LONG).show();
                        }
                    }
                });

        }
    }


    }
    // FROM LOGIN TO SIGNUP ACTIVITY
    public void logIn_to_signUp(View view) {
        if(view.getId()==R.id.tv3_newUser)
        {
            Intent intent=new Intent(Login.this,SignUp.class);
            startActivity(intent);
            finish();
        }
    }
}