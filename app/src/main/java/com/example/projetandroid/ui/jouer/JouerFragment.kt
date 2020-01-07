package com.example.projetandroid.ui.jouer

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetandroid.R
import com.example.projetandroid.ui.roles.JouerViewModel
import kotlinx.android.synthetic.main.fragment_jouer.*

class JouerFragment : Fragment() {

    private lateinit var jouerViewModel : JouerViewModel

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

        new_player.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            //builder.setView(inflater.inflate(R.layout.new_button, null))
            val layout = LinearLayout(context)
            val layoutParams = LinearLayout.LayoutParams(resources.getDimension(R.dimen.popup_width).toInt(), LinearLayout.LayoutParams.WRAP_CONTENT)
            val editText = EditText(context)
            editText.layoutParams = layoutParams
            editText.hint = resources.getString(R.string.nom)
            val spinner = Spinner(context)
            spinner.layoutParams = layoutParams

            val arrayAdapter = ArrayAdapter(context!!, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.roles))
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = arrayAdapter

            layout.addView(editText)
            layout.addView(spinner)
            builder.setView(layout)
            //builder.setView(input_role)
            builder.create()
            builder.setPositiveButton(
                R.string.fire
            ) { dialog, id ->
                jouerViewModel.liste.value?.add(Joueur(editText.text.toString(), spinner.selectedItem.toString()))
                (recyclerView.adapter as AdapterRoleJouer).notifyDataSetChanged()
            }
            builder.setNegativeButton(R.string.cancel) { _, _ -> }
            builder.show()
        }
    }
}