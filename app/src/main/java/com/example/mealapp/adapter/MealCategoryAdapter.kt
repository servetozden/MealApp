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
import com.example.mealapp.model.categoryList.MealCategoryModel

class MealCategoryAdapter(private var dataNetModel: ArrayList<MealCategoryModel>, private var onMealCategoryListener: MealCategoryListener) : RecyclerView.Adapter<MealCategoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MealCategoryAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_meal_category, parent, false)
        return ViewHolder(view)
    }

    fun setData(newDataSet: java.util.ArrayList<MealCategoryModel>) {
        dataNetModel = newDataSet
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: MealCategoryAdapter.ViewHolder, position: Int) {

        if (position % 2 == 0){
            holder.constraintLayout.setBackgroundResource(R.color.new_create_pg_account_grey);
        }else{
            holder.constraintLayout.setBackgroundResource(R.color.white);

        }


        var getData = dataNetModel[position]

        holder.txtMealName.text = getData.strCategory
       // holder.txtMealDescription.text = getData.strCategoryDescription
        var uri : String = getData.strCategoryThumb
        Glide.with(holder.itemView.context).load(uri).into(holder.imageViewRate)

        holder.constraintLayout.setOnClickListener {
            onMealCategoryListener.onMealCategorySelected(dataNetModel[position])
        }
    }

    override fun getItemCount(): Int {
       return dataNetModel.size
    }


    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val txtMealName: TextView
        val txtMealDescription: TextView
        val imageViewRate: ImageView
        val constraintLayout : ConstraintLayout


        init {
            txtMealName = mView.findViewById<View>(R.id.textViewMealName) as TextView
            txtMealDescription= mView.findViewById(R.id.textViewMealDescription)
            imageViewRate = mView.findViewById(R.id.imageViewRateLogo)
            constraintLayout = mView.findViewById(R.id.constraintLayoutBackground)



        }
    }
}