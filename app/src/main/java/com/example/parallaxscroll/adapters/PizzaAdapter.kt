/*
 * Copyright (c) 2020 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.example.parallaxscroll.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parallaxscroll.R
import com.example.parallaxscroll.model.FoodModel


class PizzaAdapter(private val wathclistListener: WatchlistListener) :
    RecyclerView.Adapter<PizzaAdapter.MovieViewHolder>() {

  private val foods = mutableListOf<FoodModel>()

  var context: Context?=null;

  fun setfoods(foods: List<FoodModel>) {
    this.foods.clear()
    this.foods.addAll(foods)
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
    context=parent.context;
    val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.food_viewholder_layout, parent, false)
    return MovieViewHolder(view)
  }

  override fun getItemCount() = foods.size

  override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
    val food = foods[position]

    Glide
        .with(holder.itemView)
        .load(food.imageUrl)
        .centerCrop()
        .into(holder.posterImageView)

    holder.foodTitleTextView.text = food.title
    holder.foodDesc.text = food.desc
    holder.foodWeight.text = food.weight

    if (food.isSelected) {
      holder.watchlistButton.setBackgroundColor(Color.GREEN)
      holder.watchlistButton.text="REMOVE"

      }else{
      holder.watchlistButton.setBackgroundColor(Color.BLUE)
      holder.watchlistButton.text=" $ ${food.price} "
    }




    holder.watchlistButton.setOnClickListener {
      Toast.makeText(context, "Item aadded to cart", Toast.LENGTH_SHORT).show()
      if (food.isSelected) {
        wathclistListener.removeFromWatchlist(food.id)
      } else {
        wathclistListener.addToWatchlist(food.id)
      }
    }
  }


  inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val posterImageView: ImageView = itemView.findViewById(R.id.movie_poster_imageview)
    val foodTitleTextView: TextView = itemView.findViewById(R.id.header)
    val foodDesc: TextView = itemView.findViewById(R.id.description)
    val foodWeight: TextView = itemView.findViewById(R.id.weight)

    val watchlistButton: Button = itemView.findViewById(R.id.watchlist_button)
  }

  interface WatchlistListener {

    fun addToWatchlist(movieId: Long)

    fun removeFromWatchlist(movieId: Long)
  }

}