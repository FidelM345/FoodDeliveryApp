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

package com.example.parallaxscroll.repo

import com.example.parallaxscroll.model.FoodModel

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class FoodlistRepository {

  private val foods = mutableListOf<FoodModel>()


    fun addToCart(movieId: Long): Observable<FoodModel> {
        return Observable.fromCallable {
            val movie = foods.first { movie -> movie.id == movieId }
            movie.copy(isSelected = true)
        }
    }



    fun removeFromCart(movieId: Long): Observable<FoodModel> {
        return Observable.fromCallable {
            val movie = foods.first { movie -> movie.id == movieId }
            movie.copy(isSelected = false)
        }
    }





    fun getAllpizzas(): Observable<List<FoodModel>> = Observable.fromCallable<List<FoodModel>> {
    Thread.sleep(3000)
    foods.addAll(listOf(
        FoodModel(
            1,
            "Margherita",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet dictum sit amet justo donec enim",
            "150 grams, 4pcs",
            "https://images.pexels.com/photos/2762942/pexels-photo-2762942.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=500&w=500",
            false,
            50

        ),
        FoodModel(
            1235,
            "Double Cheese",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet dictum sit amet justo donec enim",
            "180 grams, 4pcs",
            "https://images.pexels.com/photos/2147491/pexels-photo-2147491.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
            false,
            40
        ),
        FoodModel(
            1236,
            "Farm House.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet dictum sit amet justo donec enim",
            "150 grams, 4pcs",
            "https://images.pexels.com/photos/4109111/pexels-photo-4109111.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260",
            false,
            30
        ),
        FoodModel(
            1237,
            "Peppy Paneer",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet dictum sit amet justo donec enim",
            "150 grams, 5pcs",
            "https://images.pexels.com/photos/3762075/pexels-photo-3762075.jpeg?auto=compress&cs=tinysrgb&h=650&w=940",
            false,
            65
        ),
        FoodModel(
            1238,
            "Mexican Green",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet dictum sit amet justo donec enim",
            "120 grams, 4pcs",
            "https://images.pexels.com/photos/3944308/pexels-photo-3944308.jpeg?auto=compress&cs=tinysrgb&h=650&w=940",
            false,
            55
        ),
        FoodModel(
            1239,
            "Deluxe Veggie.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sit amet dictum sit amet justo donec enim",
            "150 grams, 4pcs",
            "https://images.pexels.com/photos/825661/pexels-photo-825661.jpeg?auto=compress&cs=tinysrgb&h=650&w=940",
            false,
        42
        )

    ))
    foods

  }.subscribeOn(Schedulers.io())


  // add method to watchlist a movie

  // add method to remove a movie from watchlist

}