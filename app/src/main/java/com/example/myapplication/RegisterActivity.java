package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityLoginBinding;
import com.example.myapplication.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;
    private TextView Name, UserName, Email, Password1, Password2, Contact;
    private ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Name = binding.Name;
        UserName = binding.Username;
        Email = binding.email;
        Password1 = binding.password1;
        Password2 = binding.password2;
        Contact = binding.contact;

        viewModel = new ViewModelProvider(this).get(ViewModel.class);
    }

    public void loadLogin(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    public void Registered(View view) {
        String name = Name.getText().toString();
        String username = UserName.getText().toString();
        String password1 = Password1.getText().toString();
        String password2 = Password2.getText().toString();
        String email = Email.getText().toString();
        String contact = Contact.getText().toString();

        if (username.equalsIgnoreCase("")) {
            Toast.makeText(this, "Empty Username", Toast.LENGTH_LONG).show();
            return;
        }
        if (password1.equalsIgnoreCase("")) {
            Toast.makeText(this, "Empty password", Toast.LENGTH_LONG).show();
            return;
        }
        if (password2.equalsIgnoreCase("")) {
            Toast.makeText(this, "Empty password", Toast.LENGTH_LONG).show();
            return;
        }
        if (name.equalsIgnoreCase("")) {
            Toast.makeText(this, "Empty name", Toast.LENGTH_LONG).show();
            return;
        }
        if (email.equalsIgnoreCase("")) {
            Toast.makeText(this, "Empty email", Toast.LENGTH_LONG).show();
            return;
        }
        if (contact.equalsIgnoreCase("")) {
            Toast.makeText(this, "Empty contact", Toast.LENGTH_LONG).show();
            return;
        }
        if (!password1.equals(password2)) {
            Toast.makeText(this, "The passwords don't match", Toast.LENGTH_LONG).show();
            return;
        }

        Usuario user = viewModel.UsuarioProducto(username);
       // Usuario user2 = viewModel.UsuarioEmail(email);

        if(user.getUserName().toString().equals(username)){
            Toast.makeText(this, "Another account exists with the same username", Toast.LENGTH_LONG).show();
            return;
        }  else {
            //Save userID using shared preference to be access from anywhere in the app
            viewModel.agregarUsuario(new Usuario(username, password1, email, contact));
            System.out.println(username.toString());
            System.out.println(password1.toString());
            System.out.println(email.toString());
            System.out.println(contact.toString());
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);



        }





    };
}