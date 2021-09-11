package com.example.hw19_2.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.homework194.R
import kotlinx.android.synthetic.main.grid_item.view.*

class RvAdapter(private val list: List<Int>) : RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh(var itemRv: View) : RecyclerView.ViewHolder(itemRv) {
        fun onBind(image: Int) {
            itemRv.image_view_rv.setImageResource(image)

            itemRv.image_view_rv.setOnClickListener { view ->
                view.findNavController().navigate(R.id.viewFragment, bundleOf("image" to image))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(LayoutInflater.from(parent.context).inflate(R.layout.grid_item, parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}