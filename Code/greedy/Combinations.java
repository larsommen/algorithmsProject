/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.Scanner;
import java.util.*;


public class Combinations{
    
    File actorFile;
    File movieFile;
    File actorMovieFile;
    int numberOfActors = 0;
    ArrayList<Screening> possibleScreenings = new ArrayList<Screening>();
    ST<Integer, ArrayList<MovieRatings> > ratingsMap = new ST();  
    String[] actors;
    int m;
    
    public Combinations(String f1, String f2, String f3, int m){
        actorFile = new File(f1);
        movieFile = new File(f2);
        actorMovieFile = new File(f3);
        this.m = m;
    }
    
    public void run(){
        //just counting number of lines = numberOfActors
        try
        {BufferedReader reader = new BufferedReader(new FileReader(actorFile));
            String line;
            while ((line = reader.readLine()) != null)
            {
                numberOfActors++;
            }
            reader.close();
            
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", actorFile);
            e.printStackTrace();  
        }
        
        //System.out.println("Number of actors are: "+ numberOfActors );
        
        actors = new String[numberOfActors];
        
        int counter = 0;
        
        try
        {BufferedReader reader = new BufferedReader(new FileReader(actorFile));
            String line;
            while ((line = reader.readLine()) != null)
            {
                //System.out.println(line);
                actors[counter]= line;
                counter++;
            }
            reader.close();
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", actorFile);
            e.printStackTrace();
        }
        
        int numberOfMovies=0;
        
        //just counting number of lines = numberOfMovies
        try
        {BufferedReader reader = new BufferedReader(new FileReader(movieFile));
            String line;
            while ((line = reader.readLine()) != null)
            {
                numberOfMovies++;
            }
            reader.close();
            
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", movieFile);
            e.printStackTrace();  
        }
        
        //System.out.println("Number of movies are: "+ numberOfMovies );
        
        MovieRatings [] allMovies = new MovieRatings[numberOfMovies];
        
        counter = 0;
        
        try
        {BufferedReader reader = new BufferedReader(new FileReader(movieFile));
            String line;
            while ((line = reader.readLine()) != null)
            {
                MovieRatings thisRating = new MovieRatings();
                //          System.out.println(line);
                String[] parts = line.split(",");
                thisRating.movieID = Integer.parseInt(parts[0]);
                thisRating.movieTitle = parts[1];
                thisRating.rating = Double.parseDouble(parts[2]);
                allMovies[counter]= thisRating;
                counter++;
            }
            reader.close();
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", movieFile);
            e.printStackTrace();
        }
        
        int numberOfActorsInMovies=0;
        
        
        //just counting number of lines = numberOfActorsInMovies
        try
        {BufferedReader reader = new BufferedReader(new FileReader(actorMovieFile));
            String line;
            while ((line = reader.readLine()) != null)
            {
                numberOfActorsInMovies++;
            }
            reader.close();
            
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", actorMovieFile);
            e.printStackTrace();  
        }
        
        
        counter = 0;
        
        try
        {BufferedReader reader = new BufferedReader(new FileReader(actorMovieFile));
            String line;
            
            while ((line = reader.readLine()) != null)
            {
                //System.out.println(line);
                
                MovieRatings thisMovieRating = new MovieRatings();
                
                String[] parts = line.split(",");
                int actorID = Integer.parseInt(parts[1]);
                thisMovieRating.actor = Integer.parseInt(parts[1]);
                thisMovieRating.movieID = Integer.parseInt(parts[2]);
                thisMovieRating.rating = allMovies[thisMovieRating.movieID].rating;
                
                if (ratingsMap.contains(actorID)){
                    //get the movieSet and add new movieRel
                    ArrayList<MovieRatings> thisActorsRating = ratingsMap.get(actorID);
                    thisActorsRating.add(thisMovieRating);
                    ratingsMap.put(actorID, thisActorsRating);
                }else{
                    //add actor and movieSet
                    
                    //Set set = new HashSet();
                    
                    ArrayList<MovieRatings> set = new ArrayList<MovieRatings>();
                    
                    set.add(thisMovieRating);
                    
                    ratingsMap.put(actorID, set);
                    
                }
                
//            actorMovieRel[counter]= thisMovieRating;
                
                counter++;
            }
            reader.close();
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", actorMovieFile);
            e.printStackTrace();
        }
        
    }
    
    public ArrayList<Screening> findCombinations(int m){
        for (int s : ratingsMap.keys()){
            
            Integer[] screen = new Integer[m];
            combinations(0, 0, ratingsMap.get(s), screen, 0.0, m);
        }
	System.out.println("Posible Screenings: "+ possibleScreenings.size());        
        return possibleScreenings;
    }
    
    public void print(){
        for(int i = 0; i < possibleScreenings.size(); i++){
            System.out.println(possibleScreenings.get(i).toString());
            
        }
        
    }
    
    
    private void combinations(int g, int index, ArrayList<MovieRatings> movies, Integer[] temp, double rating, int m){
        for(int i = index; i < movies.size(); i++){
            temp[g] = movies.get(i).movieID;           
            if (g < m-1)
                combinations(g + 1, i + 1, movies, temp, rating + movies.get(i).rating, m);
            else
                possibleScreenings.add(new Screening(movies.get(0).actor, temp, rating + movies.get(i).rating));  
        }        
    }
    
    public void bestCombinations(){
        Check c = new Check(m);
        
        ArrayList<ArrayList<Screening>> screenings = c.getPossibleScreenings(possibleScreenings);
        String line = "";
        double bestRating = -1;
        int best = -1;
        double tempRating = -1.0;
        
        for(int i = 0; i < screenings.size(); i++){
            tempRating = 0.0;
            line = "";
            //ArrayList <Screening> as = ;
            for(int g = 0; g < screenings.get(i).size(); g++){
                tempRating += screenings.get(i).get(g).getRating();
                line += screenings.get(i).get(g).toString() + ": ";
            }
            //System.out.println(line);
            if(tempRating > bestRating){
                bestRating = tempRating;
                best = i;
            }
            
        }
        
        line = "";
        System.out.println("Rating:" + bestRating);
        for(int g = 0; g < screenings.get(best).size(); g++){
            line += screenings.get(best).get(g).toString() + ": ";
        }
       // System.out.println(line);
    }
    public void sortScreenings() {
//        System.out.println("Before Sorting:");
//     for(Screening scr: possibleScreenings){
//          System.out.println(scr.getRating());
//           }
//           
        Collections.sort(possibleScreenings, ScreeningRatingComparator);
        
//        System.out.println("\nArrayList in descending order:");
       for(Screening scr: possibleScreenings){
 //           System.out.println(scr.getRating());
        }
    }
    public static Comparator<Screening> ScreeningRatingComparator 
                          = new Comparator<Screening>() {

        public int compare(Screening screening1, Screening screening2) {
            
          double screeningRating1 = screening1.getRating();
          double screeningRating2 = screening2.getRating();
          
          //ascending order
//        return screeningRating1.compareTo(screeningRating2);
          
          //descending order
          return Double.compare(screeningRating2,screeningRating1);
        }
    };
    
    public void greedySelect() {
        Check checker = new Check(m);
        ArrayList<Screening> selectedSets = new ArrayList<Screening>();
        selectedSets = checker.checkGreedy(possibleScreenings); 
        
        System.out.println("Solution:");
                for(int j = 0; j < selectedSets.size(); j++){
                System.out.println(selectedSets.get(j).toString());
                }
    }
    
}
