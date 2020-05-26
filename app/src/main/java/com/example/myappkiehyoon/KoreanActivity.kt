package com.example.myappkiehyoon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.example.myappkiehyoon.Fragment.FragmentAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_korean.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custome_tab.view.*

class KoreanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_korean)


        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        list_viewpager.adapter = fragmentAdapter

        // Tab 이름들..
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("Spicy")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("Noodle")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("Beef")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("Meal")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("Soup")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("Dessert")))

        list_viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

        tab_layout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }
            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }
            override fun onTabSelected(p0: TabLayout.Tab?) {
                if (p0 != null) {
                    list_viewpager.currentItem = p0.position
                }

            }
        })

    }


    private fun createTabView(tabName: String) : View {

        val tabView = LayoutInflater.from(baseContext).inflate(R.layout.custome_tab, null)


        tabView.txt_name.text = tabName

        return tabView
    }
}
