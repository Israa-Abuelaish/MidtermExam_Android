
package com.example.midtermexam_israa_abuelaish;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    // Declare variables
    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;

    // Store the previous back press time
    private long backPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Connect Java with XML
        setContentView(R.layout.activity_main);

        // Initialize components
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // Create TextWatcher
        TextWatcher watcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(
                    CharSequence s,
                    int start,
                    int count,
                    int after) {
            }

            @Override
            public void onTextChanged(
                    CharSequence s,
                    int start,
                    int before,
                    int count) {

                validateInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };

        // Add TextWatcher to both EditTexts
        etEmail.addTextChangedListener(watcher);
        etPassword.addTextChangedListener(watcher);

        // Login Button
        btnLogin.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    ModeActivity.class
            );

            startActivity(intent);

        });

        // Handle Back Button
        getOnBackPressedDispatcher().addCallback(
                this,
                new OnBackPressedCallback(true) {

                    @Override
                    public void handleOnBackPressed() {

                        long currentTime =
                                System.currentTimeMillis();

                        if (currentTime - backPressedTime < 2000) {

                            finish();

                        } else {

                            backPressedTime = currentTime;

                            Snackbar.make(
                                    findViewById(R.id.rootLayout),
                                    getString(R.string.exit_message),
                                    Snackbar.LENGTH_SHORT
                            ).show();

                        }
                    }
                }
        );
    }

    // Validate Email and Password
    private void validateInputs() {

        String email =
                etEmail.getText().toString().trim();

        String password =
                etPassword.getText().toString();

        // Check Email
        boolean validEmail =
                Patterns.EMAIL_ADDRESS
                        .matcher(email)
                        .matches();

        // Check Password
        boolean validPassword =
                password.length() >= 6;

        // Enable Login only if both conditions are true
        btnLogin.setEnabled(
                validEmail && validPassword
        );
    }
}
