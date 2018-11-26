package com.example.sigilai.kotlin_ecommerce


import android.os.Bundle

import android.app.DialogFragment
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


class QuantityFragment : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_quantity, container, false)

        var et =v.findViewById<EditText>(R.id.et_quantity)
        var btn=v.findViewById<Button>(R.id.btn_quantity)

        btn.setOnClickListener {

            var url = "http://192.168.0.42/Kotlin-Eccomerce/add_temp.php?mobile=" + UserInfo.mobile + "&item_id="+ UserInfo.itemId +"&quantity=" + et.text.toString()

            var rq:RequestQueue=Volley.newRequestQueue(activity)
            var sr = StringRequest(Request.Method.GET,url,Response.Listener { response ->

                var i = Intent(activity,OrderActivity::class.java)
                startActivity(i)

            },Response.ErrorListener { error ->
                Toast.makeText(activity,error.message,Toast.LENGTH_LONG).show()

            })

            rq.add(sr)

        }

        return v

    }


}
