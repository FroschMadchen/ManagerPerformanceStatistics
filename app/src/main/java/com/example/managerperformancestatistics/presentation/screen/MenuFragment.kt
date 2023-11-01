package com.example.managerperformancestatistics.presentation.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.managerperformancestatistics.R
import com.example.managerperformancestatistics.databinding.FragmentMenuBinding
import com.example.managerperformancestatistics.databinding.FragmentRegistrationBinding


class MenuFragment : Fragment() {

    private var binding: FragmentMenuBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMenuBinding.inflate(inflater).also { binding = it }.root

    private fun <T> views(block: FragmentMenuBinding.() -> T): T? = binding?.block()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}
