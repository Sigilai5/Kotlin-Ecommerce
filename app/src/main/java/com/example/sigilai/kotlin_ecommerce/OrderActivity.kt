package com.example.sigilai.kotlin_ecommerce

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        var url= "http://192.168.0.42/Kotlin-Eccomerce/get_temp.php?mobile=" +UserInfo.mobile
        var list=ArrayList<String>()
        var rq: RequestQueue = Volley.newRequestQueue(this)
        var jar= JsonArrayRequest(Request.Method.GET,url,null, Response.Listener { response ->

            for (x in 0..response.length()-1)
                list.add("Name : "+ response.getJSONObject(x).getString("name") + "\n"
                        + "Price : "+ response.getJSONObject(x).getString("price") + "\n"
                        + "Quantity : "+ response.getJSONObject(x).getString("quantity"))

            var adp= ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
            order_list.adapter=adp

        }, Response.ErrorListener { error ->
            Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
        })
        rq.add(jar)


    }
}
