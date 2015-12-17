import java.util.*;

public class PowerSet{
    
    int w;
    ArrayList<Set <Integer>> ps;
    Set<Integer> set;
    
    public PowerSet(int w){
        this.w = w;
        ps = new ArrayList<Set <Integer>>();
        set = new HashSet<Integer>();
        addElementes();
    }
    
    private void addElementes(){
        for(int i = 0; i < w; i++){
            set.add(i);
        }
    }
    
    public void print(){
        ps = getPowerSet(set);
        
        for(Set<Integer> combi : ps){
            System.out.println(combi);
        }
        
    }
    
    public void print2(ArrayList<Set <Integer>> pss){
        //ps = getPowerSet(set);
        
        for(Set<Integer> combi : pss){
            System.out.println(combi);
        }
        
    }
    
    public ArrayList<Set <Integer>> powerSet(){
        ps = getPowerSet(set);
        return ps;
    }
    
    public ArrayList<Set <Integer>> getPowerSet(Set<Integer> s){
        ArrayList<Set<Integer>> result = new ArrayList<Set<Integer>>();
        for (Integer element : s) {
            int size = result.size();
            for(int i = 0; i < size; i++){
                Set<Integer> temp = new HashSet<Integer>(result.get(i));
                temp.add(element);
                result.add(temp);
            }
            
            Set<Integer> e = new HashSet<Integer>();
            e.add(element);
            result.add(e);       
        }
        
        return result;
    }
    
}

