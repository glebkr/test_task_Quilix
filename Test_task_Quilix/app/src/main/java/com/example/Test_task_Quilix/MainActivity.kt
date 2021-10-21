package com.example.Test_task_Quilix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = RateListAdapter()
        rateRV.layoutManager = LinearLayoutManager(this)
        rateRV.adapter = adapter

        val calendar = Calendar.getInstance()
        val today = calendar.time
        calendar.add(Calendar.DAY_OF_YEAR, 1)
        val tomorrow = calendar.time
        val dateFormat = SimpleDateFormat("dd.MM.yyyy")
        date1.text = dateFormat.format(today)
        date2.text = dateFormat.format(tomorrow)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settings_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, Settings::class.java)
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }

}