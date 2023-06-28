package com.example.houserental;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
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
import com.google.firebase.ktx.Firebase;

public class SignUp extends AppCompatActivity {

    EditText et1_name,et2_email,et3_setpwd,et4_cfmpwd;
    Intent signUp_intent;
    ProgressDialog progressDialog;
    FirebaseAuth auth;//FIREBASE INSTANCES
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        et1_name=findViewById(R.id.et1_name);
        et2_email=findViewById(R.id.et2_email);
        et3_setpwd=findViewById(R.id.et3_setpwd);
        et4_cfmpwd=findViewById(R.id.et4_cfmpwd);
        progressDialog=new ProgressDialog(this);
        //ASSIGNING FIREBASE INSTANCES
        auth= FirebaseAuth.getInstance();
        user=auth.getCurrentUser();

    }

    public void signUp_to_logIn(View view) {
        if(view.getId() == R.id.btn_signUp) {
            performAuthentication();

        }
    }

    private void performAuthentication()
    {
        String email,setpwd,cfmpwd;
        email=et2_email.getText().toString();
        setpwd=et3_setpwd.getText().toString();
        cfmpwd=et4_cfmpwd.getText().toString();

        if(email.isEmpty())
            et2_email.setError("Enter your email");
        else if(setpwd.length()<6)
            et3_setpwd.setError("password length should more than 6 character");
        else if(!setpwd.equals(cfmpwd))
            et4_cfmpwd.setError("Password is not matched");
        else
        {
            progressDialog.setMessage("Please Wait While Registering...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            auth.createUserWithEmailAndPassword(email,cfmpwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        Toast.makeText(SignUp.this,"Registration Successfull",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(SignUp.this," "+task.getException(),Toast.LENGTH_LONG).show();
                    }
                }
            });
            //GOTO LOGIN PAGE
            signUp_intent = new Intent(this, Login.class);
            signUp_intent.putExtra("name",et1_name.getText().toString());
            signUp_intent.putExtra("pwd",et4_cfmpwd.getText().toString());
            startActivity(signUp_intent);
        }
    }
}