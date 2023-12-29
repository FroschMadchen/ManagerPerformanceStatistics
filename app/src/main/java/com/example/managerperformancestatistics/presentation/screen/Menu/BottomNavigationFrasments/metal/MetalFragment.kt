package com.example.managerperformancestatistics.presentation.screen.Menu.BottomNavigationFrasments.metal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.managerperformancestatistics.APP_ACTIVITY
import com.example.managerperformancestatistics.R
import com.example.managerperformancestatistics.databinding.FragmentMetalBinding
import com.example.managerperformancestatistics.model.dataClasses.ProjectTitle


class MetalFragment : Fragment() {
    private var _binding: FragmentMetalBinding? = null
    private lateinit var mController: NavController
    private lateinit var adapter:ProjectMetalAdapter
    private var listTitleProject = mutableListOf<ProjectTitle>()
    private val viewModel: MetalViewModel by viewModels()
    private var arraySpinner:Array<String> = arrayOf("Все проекты менеджера","Только проекты в процессе","По компании - заказчик")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMetalBinding.inflate(inflater).also { _binding = it }.root

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mController = findNavController()



        listTitleProject.add(ProjectTitle(11,"ООО 'ЧестныйСтрой'","Василькова В.В."))
        listTitleProject.add(ProjectTitle(34,"ООО 'НашеДело'","Жидова Ю.В."))
      /*  listTitleProject.add(ProjectTitle("ОAО 'Казанский Дом Культуры и творчества'","Самаритян У.Е."))
        listTitleProject.add(ProjectTitle("ООО 'Костакин'","Кошка Н.В."))
        listTitleProject.add(ProjectTitle("ООО 'Два Брата'","Зубин О.З."))
        listTitleProject.add(ProjectTitle("OOO 'Бахчианджи'","Ларенс О.В."))
        listTitleProject.add(ProjectTitle("ООО 'ХорошиеЛюди'","Бичурин  М.В."))
        listTitleProject.add(ProjectTitle("Металлическая конструкция №1","Василькова В.В."))
        listTitleProject.add(ProjectTitle("Металлическая лея","Жидова Ю.В."))
        listTitleProject.add(ProjectTitle("Металлический каркас мансарда","Самаритян У.Е."))
        listTitleProject.add(ProjectTitle("Металлическа бляшка","Кошка Н.В."))
        listTitleProject.add(ProjectTitle("Металлические ставни, многоэтажка","Зубин О.З."))
        listTitleProject.add(ProjectTitle("Металлические ограждения, гос","Ларенс О.В."))
        listTitleProject.add(ProjectTitle("Металлическая клетка, цирк ебанный","Бичурин  М.В."))
*/
        val listProject = getAllProject()

        adapter = ProjectMetalAdapter(object :ActionListener{
            override fun openProject(id: Int) {
                TODO("We open the project in the following fragment")
                getInfoProjectID()
            }
        },listProject)

        _binding?.apply {
            recyclerViewMetal.layoutManager = LinearLayoutManager(APP_ACTIVITY)
            recyclerViewMetal.adapter = adapter

            btnAddProjectMetal.setOnClickListener {
                findNavController().navigate(R.id.action_menuFragment_to_createProjectFragment)
            }

           val adapter:ArrayAdapter<String> = ArrayAdapter(APP_ACTIVITY,android.R.layout.simple_spinner_item,arraySpinner)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    private fun getInfoProjectID() {
        TODO("get Info Project by ID")
    }

    private fun getAllProject():List<ProjectTitle> = viewModel.get()
}