/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;

/**
 *
 * @author arangholm
 */
public class Run{
    
    public static void main(String[] args){
        String actorFile = "/Users/arangholm/algorithmsProject/Code/greedy/1.csv";
        String movieFile = "/Users/arangholm/algorithmsProject/Code/greedy/2.csv";
        String actorMovieFile = "asr.csv";
        
<<<<<<< HEAD
        Combinations c = new Combinations("../../data/ActorsLarge.csv", "../../data/MoviesLarge.csv", "../../data/30RelLarge.csv", 3);
=======
        Combinations c = new Combinations(actorFile, movieFile, actorMovieFile, 3);
>>>>>>> 0eae80c3c57e2f7c9a6c85241936911162a655f1
        c.run();
        //Phase 1
        c.findCombinations(3);
        //Phase 2
        c.sortScreenings();
        //Phase 3
        c.greedySelect();
    }    
    
}
