package com.example.mealapp.listener

import com.example.mealapp.model.categoryList.MealCategoryModel

interface MealCategoryListener {

    fun onMealCategorySelected(mealCategoryModel: MealCategoryModel?)

}