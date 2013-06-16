/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship.filehandler;

import battleship.domain.Score;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class handles the file actions needed for the scoreboard.
 * 
 * @author larg
 */
public class FileHandler {
    private File scoreBoard;
    private Scanner reader;
    private FileWriter filewriter;
    private ArrayList<Score> scores;
    private String name;
    private int playerScore;

    public FileHandler() {
        this.scoreBoard = new File("scores.txt");
        this.scores = new ArrayList<Score>();               
    }
    
    
    /**
     * Read scores from file to ArrayList of Scores
     * 
     * @return true if read successful, otherwise false 
     */
    public boolean readScore() {
        try {
            this.reader = new Scanner(scoreBoard);
        } catch (Exception e) {
            return false;
        }
        while (reader.hasNextLine()) {
            String row = reader.nextLine();
            String[] tokens = row.split(";");
            playerScore = Integer.parseInt(tokens[0]);
            name = tokens[1];
            Score sc = new Score(playerScore, name);
            scores.add(sc);
        }
        return true;
    }
    
    
    
    /**
     * This method makes a string from the top 10 scores.
     * 
     * @return String of top 10 scores
     */
    public String getScores() {
        readScore();
        String scoreString = "Top-10 scores:\n";
        int position = 1;
        
        for (Score sc : scores) {
            if (position < 11) {
                scoreString += "" + position + ")  " + sc.getName() + " - " + sc.getScore() + "\n";
                position++;
            }
        }
        return scoreString;
    }
    /**
     * Write the score of a completed game to the scoreboard file.
     * 
     * @param name  Name of the user
     * @param score Score of the user
     * @return      true if write succesful, otherwise false
     */
    public boolean writeScore(String name, int score) {
        Score newScore = new Score(score, name);
        scores.add(newScore);
        Collections.sort(scores);  
        try {
            this.filewriter = new FileWriter("scores.txt");
            for (Score sc : scores) {
                filewriter.write(sc.getScore() + ";" + sc.getName() + "\n");
            }
            scores.clear();
            filewriter.close();
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }        
        return true;
    }
}
