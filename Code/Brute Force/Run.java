public class Run{
    
    public static void main(String[] args){
        
        Combinations c = new Combinations("1.csv", "2.csv", "3.csv", 2);

        c.run();
        c.findCombinations(2);
        //c.print();
        c.bestCombinations();
        //c.print();
        
        //PowerSet ps = new PowerSet(5);
        //ps.print();
        
    }    
}

    
