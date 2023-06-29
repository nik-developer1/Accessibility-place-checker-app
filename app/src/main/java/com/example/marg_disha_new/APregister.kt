package com.example.marg_disha_new

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class APregister : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apregister)

        val db = Firebase.firestore


        val submit = findViewById<Button>(R.id.submit)

        submit.setOnClickListener {
            // Add a new document with a generated ID

            val palace = findViewById<EditText>(R.id.placenaame)
            val place = palace.text.toString()

            val category = findViewById<EditText>(R.id.category)
            val cat = category.text.toString()

            val latitude = findViewById<EditText>(R.id.latitude1)
            val lat = latitude.text.toString()

            val longitude = findViewById<EditText>(R.id.longitude1)
            val lon = longitude.text.toString()


            var isCheckedw = false

            val checkwheel: CheckBox = findViewById(R.id.checkWheelchair)

            if (checkwheel.isChecked) {
                isCheckedw = true
            }


            var isCheckedh = false
            val checkhand: CheckBox = findViewById(R.id.checkHandrails)

            if (checkhand.isChecked) {
                isCheckedh = true
            }


            var isCheckedr = false

            val checkrails: CheckBox = findViewById(R.id.checkRamps)

            if (checkrails.isChecked) {
                isCheckedr = true
            }


            var isCheckedli = false

            val checklifts: CheckBox = findViewById(R.id.checkLifts)

            if (checklifts.isChecked) {
                isCheckedli = true
            }

            val accessibleplace = hashMapOf(
                "name_of_place" to place,
                "category" to cat,
                "lat" to lat,
                "lon" to lon,
                "checkboxwheelchair" to isCheckedw,
                "checkboxhandrails" to isCheckedh,
                "checkboxramps" to isCheckedr,
                "checkboxlifts" to isCheckedli
            )


            db.collection("Places")
                .add(accessibleplace)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }

            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)

        }


    }

}