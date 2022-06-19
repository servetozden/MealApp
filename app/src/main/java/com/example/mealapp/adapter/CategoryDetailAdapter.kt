package com.example.mealapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mealapp.R
import com.example.mealapp.listener.MealCategoryListener
import com.example.mealapp.model.categoryDetail.CategoryDetailModel
import com.example.mealapp.model.categoryDetail.CategorySelectDetailModel
import com.example.mealapp.model.categoryList.MealCategoryModel

class CategoryDetailAdapter(private var dataCategoryDetailNetModel: ArrayList<CategorySelectDetailModel>) : RecyclerView.Adapter<CategoryDetailAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryDetailAdapter.ViewHolder {

        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category_detail, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryDetailAdapter.ViewHolder, position: Int) {

        var categoryDetail = dataCategoryDetailNetModel[position]

        holder.textViewMealCategoryDetailDescription.text = categoryDetail.strInstructions
        holder.textViewMealCategoryDetailName.text = categoryDetail.strMeal
        holder.textViewMealCountry.text = categoryDetail.strArea
        var uri : String = categoryDetail.strMealThumb
        Glide.with(holder.itemView.context).load(uri).into(holder.imageViewMealLogo)
    }

    override fun getItemCount(): Int {

        return dataCategoryDetailNetModel.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val textViewMealCategoryDetailName: TextView
        val textViewMealCategoryDetailDescription: TextView
        val textViewMealCountry: TextView

        val imageViewMealLogo: ImageView
        val constraintLayout : ConstraintLayout


        init {
            textViewMealCategoryDetailName = mView.findViewById<View>(R.id.textViewMealCategoryDetailName) as TextView
            textViewMealCategoryDetailDescription= mView.findViewById(R.id.textViewMealCategoryDetailDescription)
            textViewMealCountry= mView.findViewById(R.id.textViewMealCountry)
            imageViewMealLogo = mView.findViewById(R.id.imageViewMealLogo)
            constraintLayout = mView.findViewById(R.id.constraintLayoutBackground)



        }
    }
}