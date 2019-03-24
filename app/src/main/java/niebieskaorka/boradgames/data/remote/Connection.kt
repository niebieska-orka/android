package niebieskaorka.boradgames.data.remote

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import niebieskaorka.boradgames.data.model.Game
import niebieskaorka.boradgames.data.model.Result
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class Connection {

    fun addRes(game_ID: String, user_ID: String): Boolean {
        khttp.post(
            url = "http://10.20.170.49:8000/reservation",
            json = mapOf("borrower" to user_ID, "game" to game_ID))

//        println("http://10.20.170.49:8000/reservation/?borrower=$user_ID&game=$game_ID&borrow_date=2019-01-06T12:12")
//        val connection = URL("http://10.20.170.49:8000/reservation/?borrower=$user_ID&game=$game_ID&borrow_date=2019-01-06T12:12").openConnection() as HttpURLConnection
//        println(connection.responseCode)
//        try {
//            println("a???")
//            thread(start = true) {
//                val data = connection.outputStream.bufferedWriter().newLine()
//                println(data)
//            }.join()
//            println("!!!")
//            return true
//        } catch (e: Exception) {
//            println("Service unavailable " + e.message)
//            return false
//        } finally {
//            connection.disconnect()
//        }
        return true
    }

    fun getGame(game_ID: String): Game? {
        var game: Game? = null
        thread(start = true) {
            val connection = URL("http://10.20.170.49:8000/game/$game_ID").openConnection() as HttpURLConnection
            println(connection.responseCode)
            try {
                println("a???")
                val data = connection.inputStream.bufferedReader().readText()
                println("!!!")
                println(data)
                game = Gson().fromJson<Game>(data, Game::class.java)
            } catch (e: Exception) {
                println("Service unavailable " + e.message)
            } finally {
                connection.disconnect()
            }
        }.join()
        return game
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