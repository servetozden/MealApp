package com.example.mealapp.model.categoryList

import com.google.gson.annotations.SerializedName

data class MealCategoryModel(
    @SerializedName("strCategory")
    var strCategory: String,
    @SerializedName("strCategoryThumb")
    var strCategoryThumb : String,
    @SerializedName("strCategoryDescription")
    var strCategoryDescription: String,

)
