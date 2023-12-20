package com.example.managerperformancestatistics.presentation.screen.Menu.BottomNavigationFrasments.concrete


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.managerperformancestatistics.APP_ACTIVITY
import com.example.managerperformancestatistics.databinding.FragmentConcreteBinding
import com.example.managerperformancestatistics.databinding.FragmentMetalBinding
import com.example.managerperformancestatistics.model.dataClasses.ProjectTitle
import com.example.managerperformancestatistics.presentation.screen.Menu.BottomNavigationFrasments.metal.ActionListener
import com.google.android.material.navigation.NavigationView
import com.example.managerperformancestatistics.R


class ConcreteFragment : Fragment() {
    private var _binding: FragmentConcreteBinding? = null
    private lateinit var mController: NavController
    private lateinit var adapter: ProjectConcreteAdapter
    private var listTitleProjectCon = mutableListOf<ProjectTitle>()
    private var arraySpinner:Array<String> = arrayOf("Все проекты менеджера","Только проекты в процессе","По компании - заказчик")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentConcreteBinding.inflate(inflater).also { _binding = it }.root


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mController = findNavController()

        listTitleProjectCon.add(ProjectTitle(12,"Бетонные конструкция №1","Василькова В.В."))
        listTitleProjectCon.add(ProjectTitle(11,"Бетонные блоки","Измайлова В.С."))
      /*  listTitleProjectCon.add(ProjectTitle("Бетонный каркас мансарда","Бахчиванджи Ш.Г."))
        listTitleProjectCon.add(ProjectTitle("Бетонная бляшка","Михалюк Д.Е."))
        listTitleProjectCon.add(ProjectTitle("Бетонные ставни, многоэтажка","Осипов В.Д."))
        listTitleProjectCon.add(ProjectTitle("Бетонные ограждения, гос","Булгариева З.Б."))
        listTitleProjectCon.add(ProjectTitle("Бетонные клетки, цирк ебанный","Лёлкина Е.В."))
        listTitleProjectCon.add(ProjectTitle("Бетонные конструкция №1","Василькова В.В."))
        listTitleProjectCon.add(ProjectTitle("Бетонные блоки","Измайлова В.С."))
        listTitleProjectCon.add(ProjectTitle("Бетонный каркас мансарда","Бахчиванджи Ш.Г."))
        listTitleProjectCon.add(ProjectTitle("Бетонная бляшка","Михалюк Д.Е."))
        listTitleProjectCon.add(ProjectTitle("Бетонные ставни, многоэтажка","Осипов В.Д."))
        listTitleProjectCon.add(ProjectTitle("Бетонные ограждения, гос","Булгариева З.Б."))
        listTitleProjectCon.add(ProjectTitle("Бетонные клетки, цирк ебанный","Лёлкина Е.В."))
*/


        adapter = ProjectConcreteAdapter(object : ActionListener {


            override fun openProject(id: Int) {
                findNavController().navigate(R.id.action_menuFragment_to_infoProjectConcreteFragment)
                //   getInfoProjectConcreteID()
            }
        },listTitleProjectCon)

        _binding?.apply {
            recyclerViewConcrete.layoutManager = LinearLayoutManager(APP_ACTIVITY)
            recyclerViewConcrete.adapter = adapter

            btnAddProjectConcrete.setOnClickListener {
                findNavController().navigate(R.id.action_menuFragment_to_createProjectFragment)
            }




            val adapter: ArrayAdapter<String> = ArrayAdapter(APP_ACTIVITY,
                android.R.layout.simple_spinner_item,arraySpinner)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    private fun getInfoProjectConcreteID() {
        TODO("get Info Project by ID")
    }

}