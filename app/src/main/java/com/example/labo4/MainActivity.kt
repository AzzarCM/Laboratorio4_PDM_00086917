package com.example.labo4

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var movieAdapter: MovieAdapter;
    private lateinit var viewManager: RecyclerView.LayoutManager;

    private var movieList: ArrayList<Movie> = ArrayList();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun initRecyclerView() {
        viewManager = LinearLayoutManager(this)
        movie_list_rv.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            //adapter

            adapter = movieAdapter


        }
    }

    private inner class FetchMovie : AsyncTask<String, Void, String>(){
        override fun doInBackground(vararg params: String?): String? {
            if (params.isNullOrEmpty()) return ""

            val movieName = params[0]
            val movieUrl = NetworkUtility().buildSearchUrl(movieName)

            return try{
                NetworkUtility().getResponseFromHttpUrl(movieUrl)

            }catch (e: IOException){
                ""
            }

        }

    }
    override fun onPostExecute

}
