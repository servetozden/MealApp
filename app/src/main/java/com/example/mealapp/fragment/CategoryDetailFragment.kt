package com.example.mealapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.mealapp.R
import com.example.mealapp.adapter.CategoryDetailAdapter
import com.example.mealapp.adapter.MealCategoryAdapter
import com.example.mealapp.databinding.FragmentCategoryDetailBinding
import com.example.mealapp.model.categoryDetail.CategorySelectDetailModel
import com.example.mealapp.model.categoryList.MealCategoryModel
import com.example.mealapp.viewmodel.MainViewModel

class CategoryDetailFragment : Fragment() {

    private lateinit var binding: FragmentCategoryDetailBinding

    private var categorySelected : String? = null
    private lateinit var viewmodel: MainViewModel
    private lateinit var adapter: CategoryDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = this.arguments
        categorySelected  = bundle?.getString("CategorySelect")
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(   inflater, R.layout.fragment_category_detail, container, false)
        val bundle = this.arguments
        categorySelected  = bundle?.getString("CategorySelect")
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel = ViewModelProviders.of(this).get(MainViewModel::class.java)


        viewmodel.refreshCategory(categorySelected.toString())
        observeViewModel()



    }

    fun observeViewModel() {
        viewmodel.mealCategoryDetailModel.observe(viewLifecycleOwner, androidx.lifecycle.Observer { it ->
            it?.let {

                adapter = CategoryDetailAdapter(it.meals as ArrayList<CategorySelectDetailModel>)

                val recyclerView: RecyclerView = binding.recyclerView
                recyclerView.adapter = adapter


            }
        })

    }


}