package com.example.projetandroid.ui.roles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projetandroid.ui.jouer.Joueur

class JouerViewModel : ViewModel() {

    private val _liste = MutableLiveData<List<Joueur>>().apply {
        value = listOf(Joueur("test", "test"))
    }
    val liste: MutableLiveData<List<Joueur>> = _liste
}