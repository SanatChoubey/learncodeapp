package choubey.sanat.codeyourlife;

import android.app.ActionBar;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {


    TextView textView2;
    ProgressBar progressBar2;
    EditText editText1;EditText editText2;
    FirebaseAuth mAuth;
    Button Sigin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView2 = findViewById(R.id.textView2);
        progressBar2= findViewById(R.id.progressBar24);
        editText1=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        mAuth = FirebaseAuth.getInstance();
        progressBar2.setVisibility(View.INVISIBLE);
Sigin= findViewById(R.id.button);
Sigin.setText("Login");
textView2.setText("OR,Sign up hit me ...");
progressBar2.setVisibility(View.INVISIBLE);

        Sigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar2.setVisibility(View.VISIBLE);
                loginss();

            }});






        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logins = new Intent(login .this,auth.class);
                startActivity(logins);
            }
        });








    }


private void loginss() {
    String email = editText1.getText().toString();
    String password = editText2.getText().toString();


    if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {

        Toast.makeText(login.this, "fill all required attributes",
                Toast.LENGTH_SHORT).show();
        progressBar2.setVisibility(View.INVISIBLE);

    } else {


        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent in = new Intent(login.this, topic.class);
                            startActivity(in);

                        } else {
                            // If sign in fails, display a message to the user.



                        }

                        // ...
                    }
                });

    }


}


















}













