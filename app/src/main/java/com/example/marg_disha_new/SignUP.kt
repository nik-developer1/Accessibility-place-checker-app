package com.example.marg_disha_new

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.marg_disha_new.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUP : ComponentActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.registerButton.setOnClickListener{
            val email = binding.email1.text.toString()
            val password = binding.password1.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty()){
               firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
                   if(it.isSuccessful){

                       val intent = Intent(this,SignIN::class.java)
                       startActivity(intent)
                   }
                   else{
                       Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                   }
               }
            }
            else{
                Toast.makeText(this, "Empty fields are not allowed", Toast.LENGTH_SHORT).show()
            }
        }


    }
}