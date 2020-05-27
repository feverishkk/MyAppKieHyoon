package com.example.myappkiehyoon.Fragment.MarketInfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import com.example.myappkiehyoon.MainActivity
import com.example.myappkiehyoon.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_write.*

class WriteActivity : AppCompatActivity() {

    private lateinit var rating_num : String

    private lateinit var nickname: String

    private lateinit var auth : FirebaseAuth

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        auth = FirebaseAuth.getInstance()

        rating_area.setOnRatingBarChangeListener { ratingBar, fl, b ->
            rating_num = fl.toString()

        }

        val docRef = db.collection("users").document(auth.currentUser?.uid.toString())

        docRef.get().addOnSuccessListener { documentSnapshot ->

            nickname = documentSnapshot.get("nickname") as String
        }

        writing_button.setOnClickListener {

            val form = hashMapOf(

                "test" to text_input_area.text.toString(),
                "writing" to nickname,
                "rating" to rating_num
            )

            db.collection("reviews")
                .add(form)
                .addOnSuccessListener {
                    Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                    finish()
                }
                .addOnFailureListener { Toast.makeText(this, "Failure", Toast.LENGTH_LONG).show() }
        }
    }
}
