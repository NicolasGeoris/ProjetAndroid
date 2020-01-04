package com.example.projetandroid.ui.jouer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetandroid.R

class JouerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_jouer, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.liste_roles)
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        val roles = listOf(
            "Villageois",
            "Loup",
            "Petite Fille",
            "Chasseur",
            "Voyante"
        )

        val adapter = AdapterRoleJouer(roles)
        recyclerView.adapter = adapter

    }
}