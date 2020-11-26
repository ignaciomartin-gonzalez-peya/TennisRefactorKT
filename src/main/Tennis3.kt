package main

class Tennis3(player1Name: String, player2Name : String) : TennisInt {
    var player1Point = 0;
    var player2Point = 0;

    private val player1Name = player1Name
    private val player2Name = player2Name

    override fun getScore(): String {
        var score = ""
        if(player1Point < 4 && player2Point < 4 && !(player1Point + player2Point == 6)) {
            val words = arrayOf("Love", "Fifteen", "Thirty", "Forty")
            score = words[player1Point]
            return if(player1Point == player2Point) score + "-All" else score + "-" + words[player2Point]
        } else {
            if (player1Point == player2Point) return "Deuce"
            score = if(player1Point > player2Point) player1Name else player2Name
            return if((player1Point - player2Point) * (player1Point - player2Point) == 1) "Advantage" + score else "Win for " + score
        }
    }

    override fun wonPoint(playerName: String) {
        if(playerName == "player1") player1Point+=1 else player2Point += 1
    }
}