package com.example.mealapp.service

import com.example.mealapp.model.categoryDetail.CategoryDetailModel
import com.example.mealapp.model.categoryList.MealModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MealService {

    private val api = Retrofit.Builder()
            .baseUrl(APIUrl.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MealAPI::class.java)

    suspend fun mealCategory() : Response<MealModel> {

        return api.getAllCategory()
    }


    suspend fun mealCategoryDetail(selectCategory : String) : Response<CategoryDetailModel> {

        return api.getSelectCategoryDetail(selectCategory)
    }
}