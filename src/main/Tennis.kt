package main

class Tennis(player1Name: String, player2Name : String) : TennisInt {
    var player1Point = 0;
    var player2Point = 0;

    private val player1Name = player1Name
    private val player2Name = player2Name



    override fun getScore(): String {
        if(isPlayerPointEqualsTo(player1Point, player2Point)) return scoreWhenPointsAreEquals(player1Point)

        if(isPlayerPointHigherThan(player1Point, 0)){
            if(isPlayerPointHigherOrEqualsThan(player1Point, 4) && isPlayerPointHigherOrEqualsThan(player2Point, 0) && isPlayerPointHigherOrEqualsThan(player1Point-player2Point, 2)){
                return "Win for player1"
            }
            if(isPlayerPointEqualsTo(player2Point, 0)){
                return concatScores(parseScore(player1Point), parseScore(player2Point))
            }
        }

        if(isPlayerPointHigherThan(player2Point, 0)){
            if(isPlayerPointHigherOrEqualsThan(player2Point, 4) && isPlayerPointHigherOrEqualsThan(player1Point, 0) && isPlayerPointHigherOrEqualsThan(player2Point-player1Point, 2)){
                return "Win for player2"
            }
            if(isPlayerPointEqualsTo(player1Point, 0)){
                return concatScores(parseScore(player1Point), parseScore(player2Point))
            }
        }

        if(isPlayerPointHigherThan(player1Point, player2Point) && isPlayerPointMinorThan(player1Point, 4)){
            return concatScores(parseScore(player1Point), parseScore(player2Point))
        }

        if(isPlayerPointHigherThan(player2Point, player1Point) && isPlayerPointMinorThan(player2Point, 4)){
            return concatScores(parseScore(player1Point), parseScore(player2Point))
        }

        return if(isAnAdvantageSituation(player1Point, player2Point)) "Advantage player1" else "Advantage player2"
    }

    override fun wonPoint(player: String) {
        if(player == "player1") P1Score() else P2Score()
    }

    private fun isAnAdvantageSituation(player1Point: Int, player2Point: Int) : Boolean {
        return isPlayerPointHigherThan(player1Point, player2Point) && isPlayerPointHigherOrEqualsThan(player2Point, 3)
    }

    private fun isPlayerPointHigherOrEqualsThan(playerPoint: Int, point: Int): Boolean {
        return playerPoint >= point
    }

    private fun concatScores(str1: String, str2: String): String {
        return "$str1-$str2"
    }

    private fun isPlayerPointMinorThan(playerPoint: Int, point: Int): Boolean {
        return playerPoint < point
    }

    private fun isPlayerPointHigherThan(playerPoint: Int, point: Int): Boolean {
        return playerPoint > point
    }

    private fun isPlayerPointEqualsTo(playerPoint: Int, point: Int): Boolean {
        return playerPoint == point
    }

    private fun scoreWhenPointsAreEquals(playerPointToCompare: Int): String {
        var score = ""
        if(isPlayerPointMinorThan(playerPointToCompare,4)){
            score = parseScore(playerPointToCompare)
            score += "-All"
        }
        if(isPlayerPointHigherOrEqualsThan(playerPointToCompare,3)){
            score = "Deuce"
        }
        return score
    }

    fun P1Score() {
        player1Point++
    }

    fun P2Score() {
        player2Point++
    }

    fun parseScore(point: Int): String {
        when(point){
            0 -> return "Love"
            1 -> return "Fifteen"
            2 -> return "Thirty"
            3 -> return "Forty"
            else -> return "Deuce"
        }
    }
}