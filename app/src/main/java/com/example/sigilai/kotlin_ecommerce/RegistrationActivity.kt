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
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        registration_btn.setOnClickListener {

            if(registration_password.text.toString().equals(confirm_password.text.toString())){
                var url = "http://192.168.0.42/Kotlin-Eccomerce/add_user.php?mobile=" + registration_mobile.text.toString() + "&password=" + registration_password.text.toString() + "&name=" + registration_name.text.toString() + "&address=" + registration_address.text.toString()


                var rq:RequestQueue=Volley.newRequestQueue(this)
                var sr=StringRequest(Request.Method.GET,url,Response.Listener { response ->
                    if(response.equals("0"))
                        Toast.makeText(this,"Mobile number already exists",Toast.LENGTH_LONG).show()
                    else

                        startActivity(Intent(this,HomeActivity::class.java))

                        Toast.makeText(this,"User created Successfull!",Toast.LENGTH_LONG).show()


                },Response.ErrorListener { error ->
                    Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()

                })

                rq.add(sr)
            }

            else
                Toast.makeText(this,"Password do not match!",Toast.LENGTH_LONG).show()

        }

    }
}
