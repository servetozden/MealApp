package com.example.mealapp.model.categoryDetail

import com.example.mealapp.model.categoryList.MealCategoryModel
import com.google.gson.annotations.SerializedName

data class CategoryDetailModel(

    @SerializedName("meals")
    var meals: List<CategorySelectDetailModel>,
)
