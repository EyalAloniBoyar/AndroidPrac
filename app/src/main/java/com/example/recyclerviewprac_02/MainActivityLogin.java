package com.example.recyclerviewprac_02;

import static android.app.ProgressDialog.show;
import static com.example.recyclerviewprac_02.FirebaseRef.refAuth;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

public class MainActivityLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button signUpButton = findViewById(R.id.signUpButton);
        Button loginButton = findViewById(R.id.loginButton);

        signUpButton.setOnClickListener(v -> {

            TextView email = findViewById(R.id.email_su);
            TextView password = findViewById(R.id.password_su);
            TextView remember = findViewById(R.id.remember_su);

            refAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override

                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        FirebaseUser user = refAuth.getCurrentUser();
                        Toast.makeText(MainActivityLogin.this, user.getUid(), Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(MainActivityLogin.this, "Error. Please try again later.", Toast.LENGTH_LONG).show();
                    }
                }
            });

            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("strEmail", email.toString());
            intent.putExtra("strPassword", password.toString());

            SharedPreferences sharedPreferences = getSharedPreferences("MainActivityLogin", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(email.getText().toString(), remember.getText().toString());
            editor.apply();

            startActivity(intent);
        });

        loginButton.setOnClickListener(v -> {

            TextView email = findViewById(R.id.email_lg);
            TextView password = findViewById(R.id.password_lg);
            TextView remember = findViewById(R.id.remember_lg);

            refAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override

                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        FirebaseUser user = refAuth.getCurrentUser();
                        Toast.makeText(MainActivityLogin.this, user.getUid(), Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(MainActivityLogin.this, "Error. Please try again later.", Toast.LENGTH_LONG).show();
                    }
                }
            });
        });
    }
}