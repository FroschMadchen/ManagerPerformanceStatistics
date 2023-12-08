package com.example.managerperformancestatistics.presentation.screen.Menu.BottomNavigationFrasments.concrete

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.managerperformancestatistics.databinding.ItemConcreteProjectBinding
import com.example.managerperformancestatistics.model.dataClasses.ProjectTitle
import com.example.managerperformancestatistics.presentation.screen.Menu.BottomNavigationFrasments.metal.ActionListener

interface ActionListener {
    fun openProject(id: Int)
}

class ProjectConcreteAdapter(
    private val actionListener: ActionListener,
    private val listOfLists: MutableList<ProjectTitle>
) : RecyclerView.Adapter<ProjectConcreteAdapter.ProjectItemViewHolder>(), View.OnClickListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectItemViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemConcreteProjectBinding = ItemConcreteProjectBinding.inflate(
            inflater,
            parent,
            false
        )

        binding.root.setOnClickListener(this)

        return ProjectItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProjectItemViewHolder, position: Int) {
        val projectList = listOfLists[position]
        with(holder.binding) {
            holder.itemView.tag = projectList.id
            nameProject.text = projectList.nameProject
            nameManagerWork.text = projectList.nameManagerWork
            imageView
        }
    }

    override fun getItemCount(): Int {
        return listOfLists.size
    }

    class ProjectItemViewHolder(val binding: ItemConcreteProjectBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onClick(view: View?) {
        val id = view?.tag as Int

        // Обработка клика на элементе списка
        actionListener.openProject(id) //id

    }
}
