public class Run{
    
    public static void main(String[] args){
        
        Combinations c = new Combinations("../../data/ActorsLarge.csv", "../../data/MoviesLarge.csv", "../../data/20Rel.csv", 3);
        c.run();
        c.findCombinations(3);
        //c.print();
        c.bestCombinations();
        //c.print();
        
        //PowerSet ps = new PowerSet(5);
        //ps.print();
        
    }    
}

    
