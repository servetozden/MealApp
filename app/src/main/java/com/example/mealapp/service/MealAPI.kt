package com.example.mealapp.service

import com.example.mealapp.model.categoryDetail.CategoryDetailModel
import com.example.mealapp.model.categoryList.MealModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealAPI {


    @GET(APIUrl.MEAL_CATEGORY)
    suspend fun getAllCategory() : Response<MealModel>

    @GET(APIUrl.MEAL_SELECT_CATEGORY_DETAIL)
    suspend fun getSelectCategoryDetail(@Query("s") selectCategory: String) : Response<CategoryDetailModel>
}