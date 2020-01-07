package com.example.projetandroid.ui.jouer

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetandroid.R
import com.example.projetandroid.ui.roles.JouerViewModel
import com.example.projetandroid.ui.roles.MyAdapter
import kotlinx.android.synthetic.main.fragment_jouer.*

class JouerFragment : Fragment() {

    private lateinit var jouerViewModel : JouerViewModel
    var nom_joueur = ""
    var role_joueur = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        jouerViewModel =
            ViewModelProviders.of(this).get(JouerViewModel::class.java)
        var root = inflater.inflate(R.layout.fragment_jouer, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.recycler_joueurs)
        recyclerView?.layoutManager = LinearLayoutManager(root.context)
        jouerViewModel.liste.observe(this, Observer {
            recyclerView.adapter = AdapterRoleJouer(it)
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        jouerViewModel =
            ViewModelProviders.of(this).get(JouerViewModel::class.java)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_joueurs)

        val inflater = requireActivity().layoutInflater
        new_player.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            //builder.setView(inflater.inflate(R.layout.new_button, null))
            var input_nom = EditText(context)
            input_nom.setBackgroundColor(255)
            var input_role = Spinner(context)
            builder.setView(input_nom)
            //builder.setView(input_role)
            builder.create()
            builder.setPositiveButton(
                R.string.fire
            ) { dialog, id ->
                jouerViewModel.liste.value = jouerViewModel.liste.value?.plus(Joueur(input_nom.text.toString(), "chacalito"))
                (recyclerView.adapter as AdapterRoleJouer).notifyDataSetChanged()
            }
            builder.setNegativeButton(R.string.cancel) { _, _ -> }
            builder.show()
        }
    }
}