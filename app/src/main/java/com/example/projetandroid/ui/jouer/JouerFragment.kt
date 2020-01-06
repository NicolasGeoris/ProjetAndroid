package com.example.projetandroid.ui.jouer

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projetandroid.R
import kotlinx.android.synthetic.main.fragment_jouer.*
import kotlinx.android.synthetic.main.fragment_jouer.view.*

class JouerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_jouer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        new_player.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setMessage(R.string.dialog_fire_missiles)
                .setPositiveButton(R.string.fire
                ) { dialog, id ->
                    // FIRE ZE MISSILES!
                }
                .setNegativeButton(R.string.cancel
                ) { dialog, id ->
                    // User cancelled the dialog
                }
            // Create the AlertDialog object and return it
            builder.create()
            builder.show()
        }
    }
}