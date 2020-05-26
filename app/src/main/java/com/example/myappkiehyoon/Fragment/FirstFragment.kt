package com.example.myappkiehyoon.Fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myappkiehyoon.ContentsListModel
import com.example.myappkiehyoon.Fragment.MarketInfo.MarketInfoActivity
import com.example.myappkiehyoon.R
import kotlinx.android.synthetic.main.fragment_first.view.*

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view : View = inflater.inflate(R.layout.fragment_first, container, false)

        val list_array = arrayListOf<ContentsListModel>(

            ContentsListModel("s", "a", 1, "d"),
            ContentsListModel("u", "r", 1, "d"),
            ContentsListModel("z", "a", 1, "d"),
            ContentsListModel("y", "n", 1, "d"),
            ContentsListModel("y", "g", 1, "d"),
            ContentsListModel("a", "h", 1, "d"),
            ContentsListModel("s", "a", 1, "d"),
            ContentsListModel("s", "e", 1, "d")
        )

        val list_adapter = FirstFragAdapter(requireContext(), list_array)
        view.listview_first_fragment.adapter = list_adapter

        view.listview_first_fragment.setOnItemClickListener{ adapterView, view, i, l ->

            val intent = Intent(requireContext(), MarketInfoActivity::class.java)
            startActivity(intent)
        }

        return view
    }


}
