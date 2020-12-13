package com.example.parallaxscroll.adapters

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.parallaxscroll.views.fragments.AllFoodFragment
import com.example.parallaxscroll.views.fragments.CartFragment
import com.example.parallaxscroll.views.fragments.DrinksFragment
import com.example.parallaxscroll.views.fragments.SushiFragment

/*The first is a reference to the Activity which hosts the adapter,
and the second is an Int that tells the adapter
the number of items it’ll show. The Activity reference is passed to the super constructor.*/

class PagerAdapter(activity: AppCompatActivity, val itemsCount: Int) : FragmentStateAdapter(activity) {

    //    which is an abstract method that returns the total number of items in the adapter.
    override fun getItemCount(): Int {
        return itemsCount
    }

//    which is again an abstract method and returns a Fragment instance
//    for the given position. DoppelgangerFragment.getInstance(position) creates instances
//    of DoppelgangerFragment with a different doppelganger picture for different values of position.

    override fun createFragment(position: Int): Fragment {

     //   return AllFoodFragment.getInstance(position)



        when (position) {
            0 ->
                return  AllFoodFragment();
            1->
                return SushiFragment();
            2 ->
                return DrinksFragment();
        }
        return    return AllFoodFragment()


    }
}

