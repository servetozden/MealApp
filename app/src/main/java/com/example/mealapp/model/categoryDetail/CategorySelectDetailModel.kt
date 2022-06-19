package com.example.mealapp.model.categoryDetail

import com.google.gson.annotations.SerializedName

data class CategorySelectDetailModel(

    @SerializedName("strMeal")
    var strMeal: String,
    @SerializedName("strArea")
    var strArea : String,
    @SerializedName("strInstructions")
    var strInstructions: String,
    @SerializedName("strMealThumb")
    var strMealThumb: String,

)
