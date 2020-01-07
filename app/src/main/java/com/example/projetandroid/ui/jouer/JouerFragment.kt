package com.example.projetandroid.ui.jouer

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.projetandroid.R
import kotlinx.android.synthetic.main.fragment_jouer.*

class JouerFragment : Fragment() {

    var joueurs: List<Joueur> = emptyList()
    var nom_joueur = ""
    var role_joueur = ""

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
                nom_joueur = input_nom.text.toString()
                //role_joueur = input_role.selectedItem.toString()
            }
            builder.setNegativeButton(R.string.cancel) { _, _ -> }
            builder.show()
            joueurs + Joueur(nom_joueur, role_joueur)
        }
    }
}