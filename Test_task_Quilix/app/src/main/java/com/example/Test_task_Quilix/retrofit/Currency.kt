package com.example.Test_task_Quilix.retrofit

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Currency")
class Currency {
    @Element(name = "CharCode")
    lateinit var charCode:  String
    @Element(name = "Name")
    lateinit var name:  String
    @Element(name = "Rate")
    lateinit var rate:  String
}