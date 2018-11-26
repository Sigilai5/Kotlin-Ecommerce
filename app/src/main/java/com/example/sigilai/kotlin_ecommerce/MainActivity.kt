package com.example.sigilai.kotlin_ecommerce

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.activity_registration.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_btn.setOnClickListener {



        var url = "http://192.168.0.42/Kotlin-Eccomerce/login.php?mobile=" + login_mobile.text.toString() + "&password=" + login_password.text.toString()

        var rq: RequestQueue = Volley.newRequestQueue(this)
        var sr= StringRequest(Request.Method.GET,url, Response.Listener { response ->

            //check validation
            if(TextUtils.isEmpty(login_mobile.text.toString()) and  TextUtils.isEmpty(login_password.text.toString()) ){
                Toast.makeText(this, "Input both fields", Toast.LENGTH_LONG).show()
            }

            else if(response.equals("0")) {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_LONG).show()
            }

            else {
                Toast.makeText(this, "Login Successfull!", Toast.LENGTH_LONG).show()

                UserInfo.mobile = login_mobile.text.toString()
                var intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }, Response.ErrorListener { error ->
            Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()

        })

        rq.add(sr)
        }

                        /**WHEN SIGN UP BUTTON IS PRESSED**/
        signup_btn.setOnClickListener {

            var intent = Intent(this,RegistrationActivity::class.java)
            startActivity(intent)

        }

    }
}
