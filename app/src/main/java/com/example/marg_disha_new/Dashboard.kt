package com.example.marg_disha_new

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import com.google.api.AnnotationsProto.http
import java.io.File

class Dashboard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }

    fun regform(view: View) {
        val intent = Intent(this, APregister::class.java)
        startActivity(intent)
    }

    fun complaints(view: View) {
        val url = "http://www.ccdisabilities.nic.in/Complaints/learn-how-register-complaint"
        var intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    fun pdf(view: View) {
        val url = "https://drive.google.com/file/d/1GsBhDvA0d0LIyEAjR_DWSbjLji8KCBoC/view?pli=1"
        var intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    fun pchecker(view: View) {
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }
}
