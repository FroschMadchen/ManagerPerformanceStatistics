package com.example.managerperformancestatistics.presentation.screen.ActionProgect.createProject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.managerperformancestatistics.R
import com.example.managerperformancestatistics.databinding.FragmentCreateProjectBinding


class CreateProjectFragment : Fragment() {
    private var _binding: FragmentCreateProjectBinding? = null
    private lateinit var mController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCreateProjectBinding.inflate(inflater).also { _binding = it }.root

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mController = findNavController()

    }
}