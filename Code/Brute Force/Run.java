public class Run{
    
    public static void main(String[] args){
        
<<<<<<< HEAD
        Combinations c = new Combinations("1.csv", "2.csv", "asr.csv", 3);
=======
        Combinations c = new Combinations("../../data/ActorsLarge.csv", "../../data/MoviesLarge.csv", "../../data/20Rel.csv", 3);
>>>>>>> bab05076bde257f3c1c6fdae5cb41a1957ce5cfa
        c.run();
        c.findCombinations(3);
        //c.print();
        c.bestCombinations();
        //c.print();
        
        //PowerSet ps = new PowerSet(5);
        //ps.print();
        
    }    
}

    
