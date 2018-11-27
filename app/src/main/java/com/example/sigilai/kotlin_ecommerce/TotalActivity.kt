package com.example.sigilai.kotlin_ecommerce

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.paypal.android.sdk.payments.PayPalConfiguration
import com.paypal.android.sdk.payments.PayPalPayment
import com.paypal.android.sdk.payments.PayPalService
import com.paypal.android.sdk.payments.PaymentActivity
import kotlinx.android.synthetic.main.activity_total.*
import java.math.BigDecimal

class TotalActivity : AppCompatActivity() {

    //SET UP PAYPAL CONFIGURATION TO NULL AND AMOUNT TO DOUBLE
    var config:PayPalConfiguration?=null
    var amount:Double=0.0

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

                /*PAYPAL SET UP*/
        config=PayPalConfiguration().environment(PayPalConfiguration.ENVIRONMENT_SANDBOX).clientId(UserInfo.client_id)
        var i = Intent(this,PayPalService::class.java)
        i.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config)
        startService(i)

        paypal_btn.setOnClickListener {

            amount=total_order.toString().toDouble()
            var payment=PayPalPayment(BigDecimal.valueOf(amount),"USD","Kotlin Ecommerce",PayPalPayment.PAYMENT_INTENT_SALE)

            var intent=Intent(this,PaymentActivity::class.java)
            intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config)
            intent.putExtra(PaymentActivity.EXTRA_PAYMENT,payment)
            startActivity(intent,123)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==123)
        {
            if (resultCode==Activity.RESULT_OK)
            {
                var obj=Intent(this)
            }
        }

    }

    override fun onDestroy() {
        stopService(Intent(this,PayPalService::class.java))
        super.onDestroy()
    }

}
