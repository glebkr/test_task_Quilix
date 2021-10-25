package com.example.Test_task_Quilix

import android.content.Intent
import android.database.CursorIndexOutOfBoundsException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Test_task_Quilix.retrofit.Common
import com.example.Test_task_Quilix.retrofit.Currency
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.currency_item.*
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    lateinit var curTodList: MutableList<Currency>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mService = Common.apiDataInterface

        val calendar = Calendar.getInstance()
        val today = calendar.time
        calendar.add(Calendar.DAY_OF_YEAR, 1)
        val tomorrow = calendar.time
        calendar.add(Calendar.DAY_OF_YEAR, -2)
        val yesterday = calendar.time
        val dateFormat = SimpleDateFormat("dd.MM.yyyy")
        val formatTod = dateFormat.format(today)
        val formatTom = dateFormat.format(tomorrow)
        val formatYest = dateFormat.format(yesterday)
        date1.text = formatTod

        rateRV.layoutManager = LinearLayoutManager(this)
        mService.getRateListToday().enqueue(object: retrofit2.Callback<MutableList<Currency>> {
            override fun onResponse(call: Call<MutableList<Currency>>, response: Response<MutableList<Currency>>) {
                if (response!!.isSuccessful) {
                    curTodList = response.body()!!
                    /*
                    val adapter = curTodList?.let { RateListAdapter(it) }
                    rateRV.adapter = adapter
                    adapter!!.notifyDataSetChanged()
                    Toast.makeText(applicationContext, "success", Toast.LENGTH_LONG).show()

                     */
                } else {
                    Toast.makeText(applicationContext, "unsuccessful", Toast.LENGTH_LONG).show()
                }

            }

            override fun onFailure(call: Call<MutableList<Currency>>, t: Throwable) {
                Toast.makeText(applicationContext,"fail",Toast.LENGTH_LONG).show()
            }


        })

        mService.getRateListTomorrow().enqueue(object : retrofit2.Callback<MutableList<Currency>> {
            override fun onResponse(
                call: Call<MutableList<Currency>>,
                response: Response<MutableList<Currency>>
            ) {
                val curTomList = response.body()
                if (curTomList!!.size == 0) {
                    mService.getRateListYesterday().enqueue(object : retrofit2.Callback<MutableList<Currency>> {
                        override fun onResponse(
                            call: Call<MutableList<Currency>>,
                            response: Response<MutableList<Currency>>
                        ) {
                            date2.text = formatYest
                            val curYestList = response.body()
                            val adapter = curYestList?.let { RateListAdapter(curTodList, curYestList) }
                            rateRV.adapter = adapter
                            adapter!!.notifyDataSetChanged()

                        }

                        override fun onFailure(call: Call<MutableList<Currency>>, t: Throwable) {
                            Toast.makeText(applicationContext,"fail",Toast.LENGTH_LONG).show()
                        }

                    })
                } else {
                    date2.text = formatTom
                    val adapter = curTomList?.let { RateListAdapter(curTodList, curTomList) }
                    rateRV.adapter = adapter
                    adapter!!.notifyDataSetChanged()
                    Toast.makeText(applicationContext, "success", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<MutableList<Currency>>, t: Throwable) {
                        Toast.makeText(applicationContext,"fail",Toast.LENGTH_LONG).show()

            }

        } )


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