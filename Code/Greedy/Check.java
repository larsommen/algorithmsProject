import java.util.*;

public class Check{
    
    int m;
    
    public Check(int m){
        this.m = m;
    }
    
    public ArrayList<Screening> checkGreedy(ArrayList<Screening> screenings){
        ArrayList<Screening> result = new ArrayList<Screening>();
        Hashtable<Integer, Integer> movies = new Hashtable<Integer, Integer>();
        Screening s = null;
        boolean moviesNotSelected = true;
        
        for(int i = 0; i < screenings.size(); i++){
            s = screenings.get(i);
            moviesNotSelected = true;
            for(int g = 0; g < m; g++){
                if(movies.containsKey(s.getMovie(g))){
                    moviesNotSelected = false;
                    break;
                }                    
            } 
            if(moviesNotSelected){
                result.add(s);
                for(int g = 0; g < m; g++){
                    movies.put(s.getMovie(g), 1); 
                }
            }
        }
        return result;
    } 
}