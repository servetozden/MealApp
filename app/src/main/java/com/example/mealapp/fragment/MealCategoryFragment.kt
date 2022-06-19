package com.example.mealapp.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.mealapp.R
import com.example.mealapp.adapter.MealCategoryAdapter
import com.example.mealapp.databinding.FragmentMealCategoryBinding
import com.example.mealapp.listener.MealCategoryListener
import com.example.mealapp.model.categoryList.MealCategoryModel
import com.example.mealapp.viewmodel.MainViewModel
import java.util.*
import kotlin.collections.ArrayList

class MealCategoryFragment : Fragment() {

    private lateinit var binding : FragmentMealCategoryBinding
    private lateinit var viewmodel: MainViewModel
    private lateinit var adapter: MealCategoryAdapter
    var filterArrayList: ArrayList<MealCategoryModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_meal_category, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewmodel.refresh()
        observeViewModel()
        val fullBankList: java.util.ArrayList<MealCategoryModel> = java.util.ArrayList<MealCategoryModel>()

        binding.etChooseMealSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                val fullList : ArrayList<MealCategoryModel> = viewmodel.mealModel.value?.categories as ArrayList<MealCategoryModel>
                val tempList: java.util.ArrayList<MealCategoryModel> =
                    java.util.ArrayList<MealCategoryModel>()

                for (item in fullList) {
                    if (item.strCategory.toLowerCase(Locale.ENGLISH)
                            .contains(s.toString().toLowerCase(Locale.ENGLISH))
                    ) {

                        tempList.add(item)

                    }
                }

                adapter.setData(tempList)

                }

            override fun afterTextChanged(p0: Editable?) {

            }

            })

    }

    fun observeViewModel() {
        viewmodel.mealModel.observe(viewLifecycleOwner, androidx.lifecycle.Observer { it ->
            it?.let {


                adapter = MealCategoryAdapter(it.categories as ArrayList<MealCategoryModel>, getMainListener()!!)

                val recyclerView: RecyclerView = binding.recyclerView
                recyclerView.adapter = adapter

            }
        })

    }

    private fun getMainListener(): MealCategoryListener? {
        return activity as MealCategoryListener?
    }


}