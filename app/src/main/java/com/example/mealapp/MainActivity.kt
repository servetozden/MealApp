package com.example.mealapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.mealapp.adapter.MealCategoryAdapter
import com.example.mealapp.databinding.ActivityMainBinding
import com.example.mealapp.fragment.CategoryDetailFragment
import com.example.mealapp.fragment.MealCategoryFragment
import com.example.mealapp.listener.MealCategoryListener
import com.example.mealapp.model.categoryList.MealCategoryModel
import com.example.mealapp.viewmodel.MainViewModel
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity(), MealCategoryListener {

    lateinit var binding: ActivityMainBinding
    private lateinit var viewmodel: MainViewModel
    private lateinit var adapter: MealCategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
//
        viewmodel = ViewModelProviders.of(this).get(MainViewModel::class.java)
      //  viewmodel.refresh()
        //viewmodel.refreshCategory("Beef")
//        observeViewModel()


        supportFragmentManager.beginTransaction()
            .add(R.id.containerFragment, MealCategoryFragment()).commit()

    }

    override fun onMealCategorySelected(mealCategoryModel: MealCategoryModel?) {
        if (mealCategoryModel !=null){

            //viewmodel.refreshCategory(mealCategoryModel.strCategory)
            val mFragmentManager = supportFragmentManager
            val mFragmentTransaction = mFragmentManager.beginTransaction()
            val mFragment = CategoryDetailFragment()

            val b = Bundle()
            b.putString("CategorySelect",  mealCategoryModel?.strCategory)
            mFragment.arguments = b
            mFragmentTransaction.replace(R.id.containerFragment,mFragment).commit()

        }




    }

}