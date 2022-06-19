package com.example.mealapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mealapp.model.categoryDetail.CategoryDetailModel
import com.example.mealapp.model.categoryList.MealCategoryModel
import com.example.mealapp.model.categoryList.MealModel
import com.example.mealapp.service.MealService
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {


    val mealService = MealService()
    var job: Job? = null

    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        onError("Exception: ${throwable.localizedMessage}")
    }
    val mealModel = MutableLiveData<MealModel>()

    val mealCategoryDetailModel = MutableLiveData<CategoryDetailModel>()
    val exchangeLoadError = MutableLiveData<String?>()

    fun refresh() {
        fetchMeal()
    }

    fun refreshCategory(selectCategory : String) {
        fetchMealCategoryDetail(selectCategory)
    }


    private fun fetchMeal() {

        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = mealService.mealCategory()
            withContext(Dispatchers.Main) {
                if(response.isSuccessful) {
                    mealModel.value = response.body()


                } else {
                    onError("Error: ${response.message()}")
                }
            }
        }
    }

    private fun fetchMealCategoryDetail(selectCategory : String) {

        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = mealService.mealCategoryDetail(selectCategory)
            withContext(Dispatchers.Main) {
                if(response.isSuccessful) {
                    mealCategoryDetailModel.value = response.body()


                } else {
                    onError("Error: ${response.message()}")
                }
            }
        }
    }

    private fun onError(message: String) {
        exchangeLoadError.value = message

    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }


}