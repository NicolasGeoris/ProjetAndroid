package com.example.projetandroid.ui.roles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projetandroid.ui.jouer.Joueur

class JouerViewModel : ViewModel() {

    private val _liste = MutableLiveData<MutableList<Joueur>>().apply {
        value = mutableListOf()
    }
    val liste: MutableLiveData<MutableList<Joueur>> = _liste
}