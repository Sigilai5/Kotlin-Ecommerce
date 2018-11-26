package com.example.sigilai.kotlin_ecommerce


import android.os.Bundle

import android.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup




class QuantityFragment : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quantity, container, false)
    }


}
