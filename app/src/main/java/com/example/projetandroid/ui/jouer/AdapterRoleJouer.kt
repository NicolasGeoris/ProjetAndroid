package com.example.projetandroid.ui.jouer

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetandroid.R
import com.example.projetandroid.Role

class AdapterRoleJouer(private var myDataset: MutableList<Joueur>) :
    RecyclerView.Adapter<AdapterRoleJouer.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(val cardView: CardView) : RecyclerView.ViewHolder(cardView) {
    }


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): AdapterRoleJouer.MyViewHolder {
        // create a new view
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.element_role_jouer, parent, false) as CardView
        // set the view's size, margins, paddings and layout parameters
        return MyViewHolder(cardView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val nom = holder.cardView.findViewById<TextView>(R.id.texte_nom)
        nom.text = myDataset[position].nom
        val bouton_role = holder.cardView.findViewById<Button>(R.id.bouton_role)
        bouton_role.setOnClickListener {
            val builder = AlertDialog.Builder(holder.cardView.context)
            val aEcrire = myDataset[position].nom + " a le rôle de : " + myDataset[position].role
            builder.setMessage(aEcrire)
            builder.create()
            builder.show()
        }
        val bouton_tuer = holder.cardView.findViewById<Button>(R.id.bouton_tuer)
        bouton_tuer.setOnClickListener {
            myDataset.removeAt(position)
            notifyDataSetChanged()
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}