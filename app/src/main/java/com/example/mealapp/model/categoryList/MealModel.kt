package com.example.mealapp.model.categoryList

import com.example.mealapp.model.categoryList.MealCategoryModel
import com.google.gson.annotations.SerializedName

data class MealModel(

    @SerializedName("categories")
    var categories: List<MealCategoryModel>,

    )
