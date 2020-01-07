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

        val role = resources.getStringArray(R.array.roles)
        val role_desc = resources.getStringArray(R.array.roles_desc)

        val roles = mutableListOf<Role>()

        for (i in 0 until 7) {
            roles.add(Role(role[i], role_desc[i]))
        }

        val adapter = MyAdapter(roles)
        recyclerView?.adapter = adapter


    }
}