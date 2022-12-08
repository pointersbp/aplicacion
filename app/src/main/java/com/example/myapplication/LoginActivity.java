package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.myapplication.databinding.ActivityLoginBinding;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private @NonNull ActivityLoginBinding binding;
    private TextView usernameTV, passwordTV;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        usernameTV = binding.emailLogin;
        passwordTV = binding.passLogin;


    }

    public void goLogin(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void loadRegister(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void logIn(View view) {
        String username = usernameTV.getText().toString();
        String password = passwordTV.getText().toString();

        if (username.equalsIgnoreCase("")) {
            Toast.makeText(this, "Empty Username", Toast.LENGTH_LONG).show();
            return;
        }
        if (password.equalsIgnoreCase("")) {
            Toast.makeText(this, "Empty password", Toast.LENGTH_LONG).show();
            return;
        }

        Usuario user = Usuariodao.authenticate(username, password);

        if(user == null){
            Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_LONG).show();
            return;
        }else {
            //Save userID using shared preference to be access from anywhere in the app
            SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
            SharedPreferences.Editor myEdit = sharedPreferences.edit();
            myEdit.putInt("userID", user.getId());
            myEdit.putString("userName", user.getUserName());
            myEdit.apply();

            goLogin();
        }
    }
}