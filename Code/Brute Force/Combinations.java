import java.io.*;
import java.util.*;

public class Combinations{
    
    File actorFile;
    File movieFile;
    File actorMovieFile;
    int numberOfActors = 0;
    ArrayList<Screening> possibleScreenings = new ArrayList<Screening>();
    ST<Integer, ArrayList<Movie> > actorMoviesMap = new ST<Integer, ArrayList<Movie> >();  
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
        try{BufferedReader reader = new BufferedReader(new FileReader(actorFile));
            while ((reader.readLine()) != null)
                numberOfActors++;
            reader.close();   
        }
        catch (Exception e){
            System.err.format("Exception occurred trying to read '%s'.", actorFile);
            e.printStackTrace();  
        }
        actors = new String[numberOfActors];
        int counter = 0;
        try{BufferedReader reader = new BufferedReader(new FileReader(actorFile));
            String line;
            while ((line = reader.readLine()) != null)
                actors[counter++]= line;
            reader.close();
        }catch (Exception e){
            System.err.format("Exception occurred trying to read '%s'.", actorFile);
            e.printStackTrace();
        }
        
        int numberOfMovies=0;
        
        //just counting number of lines = numberOfMovies
        try{BufferedReader reader = new BufferedReader(new FileReader(movieFile));
            while ((reader.readLine()) != null)
                numberOfMovies++;
            reader.close();
        }
        catch (Exception e){
            System.err.format("Exception occurred trying to read '%s'.", movieFile);
            e.printStackTrace();  
        }
                
        Movie[] allMovies = new Movie[numberOfMovies];
        counter = 0; 
        try{BufferedReader reader = new BufferedReader(new FileReader(movieFile));
            String line;
            while ((line = reader.readLine()) != null){
                Movie thisMovie = new Movie();
                String[] parts = line.split(",");
                thisMovie.movieID = Integer.parseInt(parts[0]);
                thisMovie.rating = Double.parseDouble(parts[2]);
                allMovies[counter++] = thisMovie;
            }
            reader.close();
        }catch (Exception e){
            System.err.format("Exception occurred trying to read '%s'.", movieFile);
            e.printStackTrace();
        }
      
        try{BufferedReader reader = new BufferedReader(new FileReader(actorMovieFile));
            String line;
            while ((line = reader.readLine()) != null){               
                Movie thisMovie = new Movie();    
                String[] parts = line.split(",");
                int actorID = Integer.parseInt(parts[1]);
                thisMovie.actor = Integer.parseInt(parts[1]);
                thisMovie.movieID = Integer.parseInt(parts[2]);
                thisMovie.rating = allMovies[thisMovie.movieID].rating;   
                if (actorMoviesMap.contains(actorID)){
                    //get all the movieSet and add new movieRel
                    ArrayList<Movie> thisActorsRating = actorMoviesMap.get(actorID);
                    thisActorsRating.add(thisMovie);
                    actorMoviesMap.put(actorID, thisActorsRating);
                }else{
                    //add actor and movieSet                   
                    ArrayList<Movie> set = new ArrayList<Movie>();
                    set.add(thisMovie);
                    actorMoviesMap.put(actorID, set);
                }
            }
            reader.close();
        }catch (Exception e){
            System.err.format("Exception occurred trying to read '%s'.", actorMovieFile);
            e.printStackTrace();
        }
    }
    
    public ArrayList<Screening> findScreenings(){
        for (int actor : actorMoviesMap.keys()){
            Integer[] screening = new Integer[m];
            screenings(0, 0, actorMoviesMap.get(actor), screening, 0.0, m);
        }
        return possibleScreenings;
    }
    
    public void print(){
        System.out.println(possibleScreenings.size());
        for(int i = 0; i < possibleScreenings.size(); i++){
            System.out.println(possibleScreenings.get(i).toString());  
        }
    }
    
    private void screenings(int g, int index, ArrayList<Movie> movies, Integer[] temp, double rating, int m){
        for(int i = index; i < movies.size(); i++){
            temp[g] = movies.get(i).movieID;           
            if (g < m-1)
                screenings(g + 1, i + 1, movies, temp, rating + movies.get(i).rating, m);
            else
                possibleScreenings.add(new Screening(movies.get(0).actor, temp, rating + movies.get(i).rating));  
        }        
    }
    
    public void bestCombinations(){
        Check c = new Check(m);
        ArrayList<ArrayList<Screening>> screenings = c.getPossibleCombinations(possibleScreenings);
        double bestRating = -1;
        int bestCombination = -1;
        double tempRating = -1.0;
        
        for(int i = 0; i < screenings.size(); i++){
            tempRating = 0.0;
            for(int g = 0; g < screenings.get(i).size(); g++)
                tempRating += screenings.get(i).get(g).getRating();
            if(tempRating > bestRating){
                bestRating = tempRating;
                bestCombination = i;
            }
        }

        System.out.printf("Rating: %.2f \n", bestRating);
        System.out.println("Screenings: ");
        for(int g = 0; g < screenings.get(bestCombination).size(); g++)
            System.out.println(screenings.get(bestCombination).get(g).toString());
    } 
}