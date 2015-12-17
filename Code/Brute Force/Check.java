import java.util.*;

public class Check{
    
    int m;
    
    public Check(int m){
        this.m = m;
    }
    
    public ArrayList<ArrayList<Screening>> getPossibleCombinations(ArrayList<Screening> allScreenings){
        ArrayList<Screening> possibleCombi;
        PowerSet ps = new PowerSet(allScreenings.size());
        ArrayList<Set <Integer>> allCombinations = ps.powerSet();
        
        ArrayList<ArrayList<Screening>> result = new ArrayList<ArrayList<Screening>>();
           
        for(int i = 0; i < allCombinations.size(); i++){
            possibleCombi = new ArrayList<Screening>();
            for(Integer element : allCombinations.get(i))
                possibleCombi.add(allScreenings.get(element));
                        
            if(checkCombination(possibleCombi))
                result.add(possibleCombi);
        }
        return result;
    }
    
    public boolean checkCombination(ArrayList<Screening> combination){
        Hashtable<Integer, Integer> movies = new Hashtable<Integer, Integer>();
        Screening s = null;
        Integer movie;
        for(int i = 0; i < combination.size(); i++){
            s = combination.get(i);
            for(int g = 0; g < m; g++){
                movie = s.getMovie(g);
                if(movies.containsKey(movie))
                    return false;
                else
                    movies.put(movie, 1);
            }
        }
        return true;
    }  
}