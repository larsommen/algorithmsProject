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
        String actorFile = "ActorsLarge.csv";
        String movieFile = "MoviesLarge.csv";
        String actorMovieFile = "1000RelLarge.csv";
        
        Combinations c = new Combinations(actorFile, movieFile, actorMovieFile, 3);
        c.run();
        //Phase 1
        c.findCombinations(3);
        //Phase 2
        c.sortScreenings();
        //Phase 3
        c.greedySelect();
    }    
    
}