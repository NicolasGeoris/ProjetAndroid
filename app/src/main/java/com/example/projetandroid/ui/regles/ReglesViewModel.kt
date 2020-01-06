package com.example.projetandroid.ui.regles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReglesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Le Loup-garou est un jeu de société qui se joue entre plusieurs joueurs (au moins 6 généralement) et qui nécessite un maître de jeu. \n" +
                "Les joueurs se voient attribuer un rôle parmi les vilageois ou les loups-garous, certains avec un rôle spécifique. \n" +
                "\n" +
                "Cette application est un assistant au maître du jeu. Elle permet de remplacer les cartes du jeu.\n" +
                "\n" +
                "BUT DU JEU\n" +
                "Pour les Villageois : éliminer les Loups-garous.\n" +
                "Pour les Loups-garous : éliminer les Villageois.\n" +
                "\n" +
                "LES LOUPS-GAROUS\n" +
                "Chaque nuit, ils égorgent un Villageois.\n" +
                "Le jour ils se font passer pour des Villageois\n" +
                "afin de ne pas être démasqués.\n" +
                "\n" +
                "LES VILLAGEOIS\n" +
                "Chaque nuit, l’un d’entre eux est égorgé par le ou les Loups-Garous.\n" +
                "Ce joueur est éliminé du jeu, et ne peut plus participer aux débats. Les Villageois survivants doivent chaque jour lyncher un des joueur, dans l’espoir qu’il soit Loup-Garou.\n" +
                "\n" +
                "La composition de base minimum d'une partie est 2 loups-garous, une voyante et le nombre suffisant de simples villageois.\n" +
                "\n" +
                "LA NUIT\n" +
                "Tous les joueurs ferment les yeux, et le maître de jeu appelle tour à tour tous les joueurs qui doivent se réveiller, selon leur rôle.\n" +
                "Les loups se réveillent forcément à chaque nuit et décident d'égorger quelqu'un.\n" +
                "La voyante se réveille à chaque nuit (tant qu'elle est vivante) et désigne quelqu'un dont le maître du jeu lui montrera le rôle dans la\n" +
                "partie.\n" +
                "\n" +
                "LE JOUR\n" +
                "Tous les joueurs peuvent rouvrir et prennent part au débat, essayant de chercher les loups-garous parmi eux.\n" +
                "A la fin de la journée ils votent et décident de tuer quelqu'un.\n" +
                "\n" +
                "Un joueur mort ne peut plus parler jusqu'à la fin de la partie.\n"
    }
    val text: LiveData<String> = _text
}