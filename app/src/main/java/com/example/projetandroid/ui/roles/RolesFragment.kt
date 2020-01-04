package com.example.projetandroid.ui.roles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetandroid.R
import com.example.projetandroid.Role

class RolesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_roles, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_liste_roles)
        recyclerView?.layoutManager = LinearLayoutManager(view.context)

        val roles = listOf(
            Role("Villageois", "Un simple villageois"),
            Role("Loup", "Villageois le jour, mange les autres villageois la nuit"),
            Role("Petite Fille", "Villageois qui peut discrètement observer les loups pendant la nuit"),
            Role("Chasseur", "Villageois qui tue quelqu'un à sa mort"),
            Role("Voyante", "Villageois qui se réveille chaque nuit pour observer le rôle de quelqu'un"))

        val adapter = MyAdapter(roles)
        recyclerView?.adapter = adapter


    }
}