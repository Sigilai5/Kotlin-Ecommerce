package com.example.sigilai.kotlin_ecommerce

import android.content.Intent
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

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

                        /**LOAD DATA TO LIST VIEW**/

        var url = "http://192.168.0.42/Kotlin-Eccomerce/get_category.php"
        var list=ArrayList<String>()
        var rq:RequestQueue=Volley.newRequestQueue(this)
        var jar=JsonArrayRequest(Request.Method.GET,url,null,Response.Listener { response ->

            for (x in 0..response.length()-1)
                list.add(response.getJSONObject(x).getString("category"))

            var adp=ArrayAdapter(this,R.layout.my_textview,list)
            list_category.adapter=adp

        },Response.ErrorListener { error ->
            Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
        })
        rq.add(jar)

                        /**WHEN A CAREGORY IS CLICKED IN LIST VIEW**/

        list_category.setOnItemClickListener { parent, view, position, id ->

            var cat:String=list[position]
            var obj=Intent

        }


    }
}
