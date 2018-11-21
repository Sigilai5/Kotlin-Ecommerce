package com.example.sigilai.kotlin_ecommerce

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        var cat:String =intent.getStringExtra("cat")
        var url="http://192.168.0.42/Kotlin-Eccomerce/get_items.php?category="+cat

    }
}
