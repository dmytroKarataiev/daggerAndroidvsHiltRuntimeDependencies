package com.example.dagger2vshilt

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.dagger2vshilt.di.Analytics
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class BlankFragment : Fragment() {

    @Inject
    lateinit var analytics: Analytics

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = "Instance: ${analytics.trackScreen()}, $analytics"
        view.findViewById<TextView>(R.id.hello).text = text
    }

}