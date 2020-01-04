package com.example.projetandroid.ui.regles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.projetandroid.R

class ReglesFragment : Fragment() {

    private lateinit var reglesViewModel: ReglesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        reglesViewModel =
            ViewModelProviders.of(this).get(ReglesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_regles, container, false)
        val textView: TextView = root.findViewById(R.id.texte_regles)
        reglesViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}