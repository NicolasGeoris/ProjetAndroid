package com.example.projetandroid.ui.jouer

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.projetandroid.R
import kotlinx.android.synthetic.main.fragment_jouer.*
import android.widget.EditText
import android.widget.Spinner
import kotlinx.android.synthetic.main.new_button.*

class JouerFragment : Fragment() {

    var joueurs: List<Joueur> = emptyList()
    lateinit var player_input : EditText
    lateinit var role_input : Spinner

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*role_input.setOnItemSelectedListener {
            // Create an ArrayAdapter using a simple spinner layout and languages array
            val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, list_of_items)
            // Set layout to use when the list of choices appear
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Set Adapter to Spinner
            role_input.setAdapter(aa)
        }*/


        return inflater.inflate(R.layout.fragment_jouer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val inflater = requireActivity().layoutInflater
        new_player.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setView(inflater.inflate(R.layout.new_button, null))
            builder.create()
            builder.setPositiveButton(
                R.string.fire
            ) { dialog, id ->
                joueurs + Joueur(player_input.text.toString(), player_role.selectedItem.toString())
            }
            builder.setNegativeButton(R.string.cancel) { _, _ -> }
            builder.show()
        }
    }
}