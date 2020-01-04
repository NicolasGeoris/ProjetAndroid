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
            Role("Simple Villageois", "Un simple villageois qui ne se réveille pas la nuit"),
            Role("Loup-Garou", "Villageois le jour, se réveille pour égorger les autres villageois la nuit"),
            Role("Voyante", "Villageois qui se réveille chaque nuit pour observer le rôle de quelqu'un"),
            Role("Petite Fille", "Villageois qui peut discrètement observer les loups pendant la nuit"),
            Role("Chasseur", "Villageois qui tue quelqu'un à sa mort"),
            Role("Sorcière", "Villageois qui possède une potion de mort et une potion de résurrection et qui se réveille la nuit pour les utiliser, chacune une fois par partie"),
            Role("Cupidon", "Villageois qui lie deux personnes la première nuit. Si l'un des amoureux meurt, l'autre meurt aussi"),
            Role("    ", "mdr sava"))

        val adapter = MyAdapter(roles)
        recyclerView?.adapter = adapter


    }
}