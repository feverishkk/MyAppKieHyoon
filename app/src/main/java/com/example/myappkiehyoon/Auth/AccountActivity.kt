package com.example.myappkiehyoon.Auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myappkiehyoon.MainActivity
import com.example.myappkiehyoon.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_account.*

class AccountActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)


        auth = FirebaseAuth.getInstance()

        val docRef = db.collection("users").document(auth.currentUser?.uid.toString())


        docRef.get().addOnSuccessListener { documentSnapshot ->

            nickname_area.setText(documentSnapshot.get("nickname").toString())

        }

        logout_button.setOnClickListener{

            auth.signOut()

            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

    }
}
