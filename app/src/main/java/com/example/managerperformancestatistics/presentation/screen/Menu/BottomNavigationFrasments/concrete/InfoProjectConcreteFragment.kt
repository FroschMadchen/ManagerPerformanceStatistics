package com.example.managerperformancestatistics.presentation.screen.Menu.BottomNavigationFrasments.concrete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.managerperformancestatistics.R


class InfoProjectConcreteFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info_project_concrete, container, false)
    }
}