package ohtu;

public class TennisGame {

    private int p1_score = 0;
    private int p2_score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            p1_score += 1;
        } else {
            p2_score += 1;
        }
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;

        if (p1_score == p2_score) {
            score = evenScoreCase(p1_score);

        } else if (p1_score >= 4 || p2_score >= 4) {
            score = scoreOverFour();

        } else {
            score += scoreCase(p1_score) + "-" + scoreCase(p2_score);
        }      
        
        return score;
    }

    public String scoreCase(int tempScore) {
        String score = "";
        switch (tempScore) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
        }
        return score;
    }

    public String evenScoreCase(int p1_score) {
        String score = "";
        switch (p1_score) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }

    public String scoreOverFour() {
        String score;
        int minusResult = p1_score - p2_score;
        if (minusResult == 1) {
            score = "Advantage player1";
        } else if (minusResult == -1) {
            score = "Advantage player2";
        } else if (minusResult >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
        return score;
    }
}
