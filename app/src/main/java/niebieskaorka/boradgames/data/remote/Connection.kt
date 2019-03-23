package niebieskaorka.boradgames.data.remote

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import niebieskaorka.boradgames.data.model.Game
import niebieskaorka.boradgames.data.model.Result
import java.net.HttpURLConnection
import java.net.URL

class Connection {

    fun getAllGames(): List<Game> {
        val connection = URL("http://10.20.170.229:8000/games/").openConnection() as HttpURLConnection
        try {
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