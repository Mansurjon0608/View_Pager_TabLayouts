package com.example.hw19_2.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.homework194.R
import com.example.hw_19.Utils.Data.list
import kotlinx.android.synthetic.main.rv_custom.view.*

class MyPagerAdapter(private val list2:ArrayList<String>):PagerAdapter() {
    override fun getCount(): Int = list2.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflate = LayoutInflater.from(container.context).inflate(R.layout.rv_custom, container, false)

        inflate.my_custom_rv.adapter = RvAdapter(list)

        container.addView(inflate, 0)

        list.shuffle()

        return inflate
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view= `object` as View
        container.removeView(view)
    }
}