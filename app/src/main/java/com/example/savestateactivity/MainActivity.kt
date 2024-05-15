package com.example.savestateactivity

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.savestateactivity.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var listView: ListView? = null
    private var adapter: AnswerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = AnswerAdapter()
        binding.rvTask.layoutManager= LinearLayoutManager(this)
        binding.rvTask.adapter = this.adapter
    }
/*
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("answerPosition", adapter?.answerPosition ?: 0)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        adapter?.answerPosition = savedInstanceState.getInt("answerPosition")
    }*/

}

