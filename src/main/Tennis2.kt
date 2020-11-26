package main

import kotlin.math.min

class Tennis2(player1Name: String, player2Name : String) : TennisInt {
    var player1Point = 0;
    var player2Point = 0;

    private val player1Name = player1Name
    private val player2Name = player2Name

    override fun getScore(): String {
        var score = ""
        var tempScore = 0

        if(player1Point == player2Point){
            when(player1Point){
                0 -> score = "Love-All"
                1 -> score = "Fifteen-All"
                2 -> score = "Thirty-All"
                else -> score = "Deuce"
            }
        } else if (player1Point >= 4 || player2Point >= 4) {
            var minusResult = player1Point - player2Point
            if(minusResult == 1) score = "Advantage player1"
            else if (minusResult == -1) score = "Advantage player2"
            else if (minusResult >= 2) score = "Win for player1"
            else score = "Win for player2"
        } else {
            for(i in 1..3){
                if(i==1) tempScore = player1Point
                else {
                    score += "-"
                    tempScore = player2Point
                }
                when(tempScore) {
                    0 -> score += "Love"
                    1 -> score += "Fifteen"
                    2 -> score += "Thirty"
                    3 -> score += "Forty"
                }
            }
        }
        return score
    }

    override fun wonPoint(playerName: String) {
        if (playerName == "player1") player1Point+=1 else player2Point+=1
    }

}