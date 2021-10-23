package com.example.Test_task_Quilix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Test_task_Quilix.retrofit.Common
import com.example.Test_task_Quilix.retrofit.Currency
import com.example.Test_task_Quilix.retrofit.DailyExRates
import com.example.Test_task_Quilix.retrofit.ViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.xml.sax.InputSource
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import retrofit2.Call
import retrofit2.Response
import java.io.InputStream
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*
import javax.security.auth.callback.Callback
import javax.xml.parsers.DocumentBuilderFactory
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var headLines: ArrayList<String>
    lateinit var rateListAdapter: RateListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mService = Common.apiDataInterface
        //val viewModel = ViewModel()
        //viewModel.start()
        rateRV.layoutManager = LinearLayoutManager(this)
        mService.getRateList().enqueue(object: retrofit2.Callback<DailyExRates> {
            override fun onResponse(call: Call<DailyExRates>?, response: Response<DailyExRates>?) {
                if (response!!.isSuccessful) {
                    val der = response.body()
                    val adapter = RateListAdapter(der.currencyList)
                    rateRV.adapter = adapter
                    Toast.makeText(applicationContext, "success", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(applicationContext, "lulw", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<DailyExRates>?, t: Throwable?) {
                Toast.makeText(applicationContext,"fail",Toast.LENGTH_LONG).show()
            }

        })

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

    /*
    fun getDataFromXml(url: URL) {
        val factory = XmlPullParserFactory.newInstance()
        factory.isNamespaceAware = false
        val xpp = factory.newPullParser()
        xpp.setInput(getInputStream(url), "UTF_8")

        var insideItem = false
        val eventType = xpp.eventType
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (xpp.name.equals("item", ignoreCase = true)) {
                insideItem = true
            } else if (xpp.name.equals("title", ignoreCase = true)) {
                if (insideItem) {
                    headLines.add(xpp.nextText())
                }
            } else if (xpp.name.equals("link")) {
                if (insideItem) {
                    headLines.add(xpp.nextText())
                }
            }
        }


    }

    private fun getInputStream(url: URL): InputStream? {

    }
     */


}