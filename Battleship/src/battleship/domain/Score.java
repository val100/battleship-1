/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.domain;

/**
 * This class is used to represent the scores on the scoreboard.
 *
 * @author larg
 */
public class Score implements Comparable<Score> {

    private int score;
    private String name;

    public Score(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Score o) {
        return o.getScore() - this.getScore();
    }
}
