package com.example.managerperformancestatistics.presentation.screen.Menu.BottomNavigationFrasments.concrete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.managerperformancestatistics.R

import com.example.managerperformancestatistics.databinding.FragmentInfoProjectConcreteBinding


class InfoProjectConcreteFragment : Fragment() {
    private var _binding: FragmentInfoProjectConcreteBinding? = null
    private lateinit var mController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentInfoProjectConcreteBinding.inflate(inflater).also { _binding = it }.root


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mController = findNavController()


    }
}