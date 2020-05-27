package com.example.myappkiehyoon.Fragment.MarketInfo


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.myappkiehyoon.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_review.view.*

/**
 * A simple [Fragment] subclass.
 */
class ReviewFragment : Fragment() {

    private lateinit var auth : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        auth = FirebaseAuth.getInstance()

        val view : View = inflater.inflate(R.layout.fragment_review, container, false)

        view.write_button.setOnClickListener {

            if(auth.currentUser == null) {

                Toast.makeText(requireContext(),"Please Register or Login", Toast.LENGTH_SHORT).show()

            } else {

                val intent = Intent(requireContext(), WriteActivity::class.java)
                startActivity(intent)
            }



        }

        return view
    }


}
