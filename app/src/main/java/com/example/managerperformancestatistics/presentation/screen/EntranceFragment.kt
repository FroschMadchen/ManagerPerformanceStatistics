package com.example.managerperformancestatistics.presentation.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.managerperformancestatistics.R

class EntranceFragment : Fragment() {
    companion object{
        fun newInstance()= EntranceFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_entrance, container, false)
    }
}