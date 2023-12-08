package com.example.managerperformancestatistics.presentation.screen.Menu.BottomNavigationFrasments.metal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.managerperformancestatistics.databinding.ItemMetalProjectBinding

import com.example.managerperformancestatistics.model.dataClasses.ProjectTitle

interface ActionListener {
    fun openProject(id: Int)
}

class ProjectMetalAdapter(
    private val actionListener: ActionListener,
    private val listOfLists: MutableList<ProjectTitle>
) : RecyclerView.Adapter<ProjectMetalAdapter.ProjectItemViewHolder>(), View.OnClickListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectItemViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemMetalProjectBinding = ItemMetalProjectBinding.inflate(
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
           //holder.itemView.tag = projectList.id
            nameProject.text = projectList.nameProject
            nameManagerWork.text = projectList.nameManagerWork
            imageView
        }
    }

    override fun getItemCount(): Int {
        return listOfLists.size
    }

    class ProjectItemViewHolder(val binding: ItemMetalProjectBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onClick(view: View?) {
        val id = view?.tag as Int
        // Обработка клика на элементе списка
                actionListener.openProject(id)

        }
    }
