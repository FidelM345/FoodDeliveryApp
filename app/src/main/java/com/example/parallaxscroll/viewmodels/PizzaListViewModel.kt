package com.example.parallaxscroll.viewmodels

import androidx.lifecycle.MutableLiveData
import com.airbnb.mvrx.*
import com.example.parallaxscroll.repo.FoodlistRepository
import com.example.parallaxscroll.state.WatchListState
import com.example.parallaxscroll.utility.WatchlistApp


class PizzaListViewModel(
    initialState: WatchListState,
    private val foodlistRepository: FoodlistRepository
) : BaseMvRxViewModel<WatchListState>(initialState, debugMode = true) {

    val errorMessage = MutableLiveData<String>()


    /* To modify the state, use setState(). In this case, you’re using copy() to make a copy of the current state and change the type of
     the movies property to Loading to reflect that an operation is underway.
     Then, you start fetching the list of movies from the repository. When it finishes, use the
     obtained movie list to set the new state. MvRX provides execute() as a method to convert a RxJava observable to an Async type.
 */

    init {
        // 1
        setState {
            copy(food = Loading())
        }


        // 2
        foodlistRepository.getAllpizzas()
                .execute {
                    copy(food = it)
                }

        val errorMessage = MutableLiveData<String>()

    }



    fun addToCart(movieId: Long) {
        withState { state ->
            if (state.food is Success) {
                val index = state.food.invoke().indexOfFirst {
                    it.id == movieId
                }
                // 1
                foodlistRepository.addToCart(movieId)
                        .execute {
                            // 2
                            if (it is Success) {
                                copy(
                                        food = Success(
                                                state.food.invoke().toMutableList().apply {
                                                    set(index, it.invoke())
                                                }
                                        )
                                )
                                // 3
                            } else if (it is Fail){
                                errorMessage.postValue("Failed to add movie to watchlist")
                                copy()
                            } else {
                                copy()
                            }
                        }
            }
        }
    }






    fun removeFromCart(movieId: Long) {
        withState { state ->
            if (state.food is Success) {
                val index = state.food.invoke().indexOfFirst {
                    it.id == movieId
                }
                foodlistRepository.removeFromCart(movieId)
                        .execute {
                            if (it is Success) {
                                copy(
                                    food = Success(
                                                state.food.invoke().toMutableList().apply {
                                                    set(index, it.invoke())
                                                }
                                        )
                                )
                            } else if (it is Fail) {
                                errorMessage.postValue("Failed to remove movie from watchlist")
                                copy()
                            } else {
                                copy()
                            }
                        }
            }
        }
    }







    /*  Finally, the companion object MvRxViewModelFactory follows the
    ViewModelProvider Factory pattern to
    get an instance of FoodlistRepository and uses it to create an
    instance of WatchlistViewModel.*/
    companion object : MvRxViewModelFactory<PizzaListViewModel, WatchListState> {

        override fun create(viewModelContext: ViewModelContext,
                            state: WatchListState): PizzaListViewModel? {
            val foodlistRepository =
                    viewModelContext.app<WatchlistApp>().foodlistRepository
            return PizzaListViewModel(state, foodlistRepository)
        }
    }




}
