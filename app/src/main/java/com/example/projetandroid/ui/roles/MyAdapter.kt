package com.example.projetandroid.ui.roles

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetandroid.R
import com.example.projetandroid.Role

class MyAdapter(private val myDataset: List<Role>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(val cardView: CardView) : RecyclerView.ViewHolder(cardView) {
    }


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyAdapter.MyViewHolder {
        // create a new view
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.element_text_view, parent, false) as CardView
        // set the view's size, margins, paddings and layout parameters
        return MyViewHolder(cardView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val nom = holder.cardView.findViewById<TextView>(R.id.nom_role)
        val description = holder.cardView.findViewById<TextView>(R.id.description_role)
        val image = holder.cardView.findViewById<ImageView>(R.id.image_role)
        nom.text = myDataset[position].nom
        description.text = myDataset[position].description
        when (myDataset[position].nom) {
            "Simple Villageois" -> image.setImageResource(R.mipmap.ic_villageois_foreground)
            "Loup-Garou" -> image.setImageResource(R.mipmap.ic_loup_foreground)
            "Voyante" -> image.setImageResource(R.mipmap.ic_voyante_foreground)
            "Petite Fille" -> image.setImageResource(R.mipmap.ic_petite_fille_foreground)
            "Chasseur" -> image.setImageResource(R.mipmap.ic_chasseur_foreground)
            "Cupidon" -> image.setImageResource(R.mipmap.ic_cupidon_foreground)
            "Sorcière" -> image.setImageResource(R.mipmap.ic_sorciere_foreground)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}