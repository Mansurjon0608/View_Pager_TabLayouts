package com.example.homework194

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_view.view.*


class ViewFragment : Fragment() {



    private lateinit var root: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        root = inflater.inflate(R.layout.fragment_view, container, false)

        root.image_view_fragment.setImageResource(arguments?.getInt("image")!!)

        return root
    }
}