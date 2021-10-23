package com.example.Test_task_Quilix.retrofit

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name="DailyExRates", strict = false)
class DailyExRates {
    @ElementList(name="Currency")
    lateinit var currencyList: MutableList<Currency>
}