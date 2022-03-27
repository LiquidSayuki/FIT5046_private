package com.liquid.tutorial3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.liquid.tutorial3.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mAuth = FirebaseAuth.getInstance();

        binding.textInputEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b){
                    if (!emailValidation(binding.textInputEmail.getText().toString())){
                        binding.inputLayoutEmail.setError(getResources().
                                getString(R.string.error_message_email));
                    }else{
                        binding.inputLayoutEmail.setErrorEnabled(false);
                    }

                }
            }
        });

        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });

    }

    private boolean emailValidation(String email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void signUp(){
        binding.progressbar.setVisibility(View.VISIBLE);
        String email = binding.textInputEmail.getText().toString();
        String password = binding.textInputPassword.getText().toString();
        if (emailValidation(email)){
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                binding.progressbar.setVisibility(View.GONE);
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(RegisterActivity.this, "Sign up successful",
                                        Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(RegisterActivity.this, "Sign up Failed",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
            Toast.makeText(this, "Sign up successfully!", Toast.LENGTH_SHORT).show();
        }

    }
}
