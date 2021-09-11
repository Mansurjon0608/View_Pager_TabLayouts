package com.example.homework194

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw19_2.Adapters.MyPagerAdapter
import com.example.hw19_2.Animation.MyAnim
import com.example.hw_19.Utils.Data
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.item_tab.view.*


class HomeFragment : Fragment() {



    private lateinit var root: View
    private val tabList= arrayListOf("All", "News", "Action","Animals", "House")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        root =  inflater.inflate(R.layout.fragment_home, container, false)

        load()

        root.view_pager.adapter = MyPagerAdapter(tabList)

        root.view_pager.setPageTransformer(true, MyAnim())

        root.tab_layout.setupWithViewPager(root.view_pager)

        root.tab_layout.tabMode = TabLayout.MODE_SCROLLABLE

        setTab()

        root.tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.customView?.item_txt_tab?.setTextColor(Color.WHITE)
                tab?.customView?.indicator_tab?.visibility = View.VISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.customView?.item_txt_tab?.setTextColor(Color.parseColor("#FF808A93"))
                tab?.customView?.indicator_tab?.visibility = View.INVISIBLE
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

        return root
    }

    @SuppressLint("InflateParams")
    private fun setTab() {
        val tabCount = root.tab_layout.tabCount

        for (i in 0 until tabCount){
            val view = LayoutInflater.from(context).inflate(R.layout.item_tab, null, false)
            val tab = root.tab_layout.getTabAt(i)
            tab?.customView = view

            view.item_txt_tab.text = tabList[i]

            if (i == 0){
                view.item_txt_tab.setTextColor(Color.WHITE)
                view.indicator_tab.visibility = View.VISIBLE
            }else{
                view.item_txt_tab.setTextColor(Color.parseColor("#FF808A93"))
                view.indicator_tab.visibility = View.INVISIBLE
            }
        }
    }

    private fun load(){
        Data.list = ArrayList()

        for (i in 0..10) {
            Data.list.add(R.drawable.img1)
            Data.list.add(R.drawable.img2)
            Data.list.add(R.drawable.img3)
            Data.list.add(R.drawable.img4)
            Data.list.add(R.drawable.img5)
            Data.list.add(R.drawable.img6)
            Data.list.add(R.drawable.img7)
            Data.list.add(R.drawable.img9)
            Data.list.add(R.drawable.img10)
            Data.list.add(R.drawable.img11)
            Data.list.add(R.drawable.img12)

        }
    }


}