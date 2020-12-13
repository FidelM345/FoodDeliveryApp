package com.example.parallaxscroll.state

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.example.parallaxscroll.model.FoodModel



/*You give it an initial type of Uninitialized since
it won’t have any data when the user opens the app.*/


data class WatchListState(
        val food: Async<List<FoodModel>> = Uninitialized
) : MvRxState
