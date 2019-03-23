package niebieskaorka.boradgames.data.remote

import niebieskaorka.boradgames.data.model.Game

object Storage {
    //    val sensors = Connection().getSensors()
    val games = ArrayList(Connection().getAllGames())
}