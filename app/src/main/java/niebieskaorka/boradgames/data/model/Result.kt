package niebieskaorka.boradgames.data.model

import com.google.gson.annotations.SerializedName

data class Result(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<Game>
)

data class Game(
    val title: String,
    val description: String,
    val picture_url: String,
    val publisher: String,
    val score: Float,
    val playing_time: Float,
    val min_age: Int,
    val min_players: Int,
    val max_players: Int
)