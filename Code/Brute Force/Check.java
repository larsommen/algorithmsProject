import java.util.*;

public class Check{
    
    int m;

    public Check(int m){
        this.m = m;
    }
    
    
    public ArrayList<ArrayList<Screening>> getPossibleScreenings(ArrayList<Screening> allScreenings){
        ArrayList<Screening> possibleCombi;
        PowerSet ps = new PowerSet(allScreenings.size());
        ArrayList<Set <Integer>> allCombinations = ps.powerSet();
        
        ArrayList<ArrayList<Screening>> result = new ArrayList<ArrayList<Screening>>();
        
        
        for(int i = 0; i < allCombinations.size(); i++){
            possibleCombi = new ArrayList<Screening>();
            for(Integer element : allCombinations.get(i)){
                //System.out.print(element);
                possibleCombi.add(allScreenings.get(element));
            }
            
            if(checkScreenings(possibleCombi)){
                result.add(possibleCombi);
            }
        
        }
        
        
        return result;
        
    }
    
    
    public boolean checkScreenings(ArrayList<Screening> screenings){
        Hashtable movies = new Hashtable();
        Screening s = null;
        Integer movie;
        for(int i = 0; i < screenings.size(); i++){
            for(int g = 0; g < m; g++){
                s = screenings.get(i);
                movie = s.getMovie(g);
                if(movies.contains(movie)){
                    return false;
                }
                else
                    movies.put(movie, 1);
            } 
        }
        return true;
    }
    
    


}