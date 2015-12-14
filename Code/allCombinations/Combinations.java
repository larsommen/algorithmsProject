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
    
    public Combinations(String f1, String f2, String f3){
        actorFile = new File(f1);
        movieFile = new File(f2);
        actorMovieFile = new File(f3);
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
        
        return possibleScreenings;
    }
    
    public void print(){
        for(int i = 0; i < possibleScreenings.size(); i++){
           System.out.println(possibleScreenings.get(i).toString(actors));
       
        }
        
    }
    
    
    private void combinations(int g, int index, ArrayList<MovieRatings> movies, Integer[] temp, double rating, int m){
        double newRating = 0;
        int newG = 0;       
        
        for(int i = index; i < movies.size(); i++){
            
            newG = g;
            temp[newG] = movies.get(i).movieID;           
            newG = g + 1;
            //newTemp = temp + movies.get(i).movieID + "-";
            //newTemp.add(movies.get(i).movieID + "");
            //System.out.println(movies.get(i).movieID);
            //System.out.println(newTemp.size());
            newRating = rating + movies.get(i).rating;
            
            if (g < m-1){
                //System.out.println(newTemp.size() + ", " + m);
                combinations(newG, i + 1, movies, temp, newRating, m);
            }
            else{
                //System.out.println(newTemp.size()  + ", " + temp.size()); 
                Integer[] finalT = temp;
                
                possibleScreenings.add(new Screening(movies.get(0).actor, finalT, newRating));
                
                System.out.println(movies.get(0).actor + ", " + temp[0] + ", " + temp[1] + ", " + newRating);
                


            }     
        }        
    }
    

}