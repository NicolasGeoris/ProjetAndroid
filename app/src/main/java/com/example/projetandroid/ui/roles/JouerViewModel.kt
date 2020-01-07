package com.example.projetandroid.ui.roles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projetandroid.ui.jouer.Joueur

class JouerViewModel : ViewModel() {

    private val _liste = MutableLiveData<MutableList<Joueur>>().apply {
        value = mutableListOf(Joueur("test", "test"))
    }
    val liste: MutableLiveData<MutableList<Joueur>> = _liste
}