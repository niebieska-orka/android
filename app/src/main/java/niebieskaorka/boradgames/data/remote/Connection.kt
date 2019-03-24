package niebieskaorka.boradgames.data.remote

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import niebieskaorka.boradgames.data.model.Game
import niebieskaorka.boradgames.data.model.Result
import java.net.HttpURLConnection
import java.net.URL

class Connection {

    fun getGame(game_ID: String): Game? {
        val connection = URL("http://10.20.170.49:8000/game/$game_ID").openConnection() as HttpURLConnection
        println(connection.responseCode)
        try {
            println("a???")
            val data = connection.inputStream.bufferedReader().readText()
            println("!!!")
            println(data)
            return Gson().fromJson<Game>(data, Game::class.java)
        } catch (e: Exception) {
            println("Service unavailable " + e.message)
        } finally {
            connection.disconnect()
        }
        return null
    }

    fun getAllGames(): List<Game> {
        val connection = URL("http://10.20.170.49:8000/games/").openConnection() as HttpURLConnection
//        println(connection.responseCode)
        try {
            println("???")
            val data = connection.inputStream.bufferedReader().readText()
            println("!!!")
            println(data)
            val listType = object : TypeToken<Result>() {}.type
            return Gson().fromJson<Result>(data, listType).results
        } catch (e: Exception) {
            println("Service unavailable " + e.message)
//            Log.d(Connection.TAG, "Service unavailvable: " + e.message)
        } finally {
            connection.disconnect()
        }
        return emptyList()
    }
}