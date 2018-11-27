package com.example.sigilai.kotlin_ecommerce

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_total.*

class TotalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_total)


        var url = "http://192.168.0.42/Kotlin-Eccomerce/get_total.php?bill_no="+ intent.getStringExtra("bno")
        var rq: RequestQueue = Volley.newRequestQueue(this)
        var sr = StringRequest(Request.Method.GET,url, Response.Listener { response ->

            total_order.text=response

        }, Response.ErrorListener { error ->
            Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()

        })

        rq.add(sr)

    }
}
