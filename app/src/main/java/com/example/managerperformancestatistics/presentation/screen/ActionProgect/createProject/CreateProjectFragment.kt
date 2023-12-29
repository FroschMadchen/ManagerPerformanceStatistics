package com.example.managerperformancestatistics.presentation.screen.ActionProgect.createProject

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.managerperformancestatistics.R
import com.example.managerperformancestatistics.databinding.FragmentCreateProjectBinding
import com.example.managerperformancestatistics.model.projects.room.entities.ProjectCreateTuples
import com.example.managerperformancestatistics.presentation.screen.ActionAccount.createAcc.CreateViewModel
import com.example.managerperformancestatistics.presentation.screen.SignIn.ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

var IMAGE by Delegates.notNull<String>()

class CreateProjectFragment : Fragment() {
    private val PICK_IMAGE = 4


    private var _binding: FragmentCreateProjectBinding? = null
    private lateinit var mController: NavController
    private val viewModel: CreateProjectVM by viewModels()
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



        _binding?.apply {


            btnSave.setOnClickListener {
                _binding.apply { val companyBuyer = companyBuyer.text.toString()
                    val status = status.text.toString()
                    val material = material.text.toString()
                    val description = description.text.toString()
                    val nameProject = nameProject.text.toString()
                    Log.i(
                        "createProject1",
                        "${companyBuyer}, ${status},${material},${description},${nameProject}"
                    )
                    val newProject: ProjectCreateTuples = ProjectCreateTuples(
                        access_manager_id = ID.toInt(),
                        name_project = nameProject,
                        description = description,
                        status = status,
                        image_item = 34232443,
                        company_buyer = companyBuyer,
                        material = material
                    )
                    CoroutineScope(Dispatchers.IO).launch {
                        Log.i(
                            "createProject2",
                            "${companyBuyer}, ${status},${material},${description},${nameProject}"
                        )
                        viewModel.createProject(newProject)
                    }
                }

            }
              viewModel.createProjectMutable.observe(
              viewLifecycleOwner
          ) { shouldNavigation ->
                  if (shouldNavigation) {
                      viewModel.onNavigationHandler()
                  findNavController().navigate(R.id.action_createProjectFragment_to_menuFragment)

              }
          }



            addImage.setOnClickListener {
                val getIntent = Intent(Intent.ACTION_OPEN_DOCUMENT)
                getIntent.type = "image/*"
                getIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
                val pickIntent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                pickIntent.type = "image/*"

                val chooserIntent = Intent.createChooser(getIntent, "Select Image")
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(pickIntent))

                startActivityForResult(chooserIntent, PICK_IMAGE)

            }
        }


    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?): Unit {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            // Обработка результата выбора изображения

            val images: MutableList<Uri> = mutableListOf()

            data?.clipData?.let { clipData ->
                for (i in 0 until clipData.itemCount) {
                    val uri = clipData.getItemAt(i).uri
                    images.add(uri)
                }
                if (images.isNotEmpty()) {
                    IMAGE = images[0].toString()
                } else {
                    IMAGE = "232"
                }


                // Log.i("ImageCollection","Number of images: ${images.size}")
                images.forEachIndexed { index, uri ->
                    Log.i("Image", "Image $index: $uri")
                }
            }
            /*   val selectedImageUri = data?.data
               if (selectedImageUri != null) {*/
            _binding?.apply {
                /*  imageView3.setImageURI(selectedImageUri)
                  imageView3.setVisibility(View.VISIBLE)*/

                imageView3.setImageURI(images[0])
                //  imageView3.visibility = View.VISIBLE
                Log.i("Image", "Image ${images[0]}")
                image1.setImageURI(images[1])
                Log.i("Image", "Image ${images[1]}")
                image2.setImageURI(images[2])
                image3.setImageURI(images[3])
            }

        }
    }
}






