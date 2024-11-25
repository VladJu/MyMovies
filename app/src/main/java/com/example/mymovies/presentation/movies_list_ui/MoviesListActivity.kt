package com.example.mymovies.presentation.movies_list_ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.mymovies.R

class MoviesListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MoviesListActivity", "onCreate")
        setContentView(R.layout.activity_movies_list)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.movies_list_container, MoviesListFragment.newInstance())
                .commit()
        }

    }



    override fun onStart() {
        super.onStart()
        Log.d("MoviesListActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MoviesListActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MoviesListActivity", "onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d("MoviesListActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MoviesListActivity", "onDestroy")
    }
}