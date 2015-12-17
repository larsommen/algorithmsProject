<<<<<<< HEAD
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
        String actorMovieFile = "detVirker3.csv";
        
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
=======
public class Run{
    
    public static void main(String[] args){
        
        Combinations c = new Combinations("1.csv", "2.csv", "../../data/testABCabdEFC.csv", 3);
        c.run();
        c.findCombinations(3);
        //c.print();
        c.bestCombinations();
        //c.print();
        
        //PowerSet ps = new PowerSet(5);
        //ps.print();
        
    }    
}

    
>>>>>>> bab05076bde257f3c1c6fdae5cb41a1957ce5cfa
