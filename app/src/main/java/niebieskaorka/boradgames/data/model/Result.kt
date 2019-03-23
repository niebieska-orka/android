package niebieskaorka.boradgames.data.model

import com.google.gson.annotations.SerializedName

data class Result(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<Game>
)

data class Game(
    val title: String
)