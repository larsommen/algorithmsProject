public class Run{
    
    public static void main(String[] args){
        
        Combinations c = new Combinations("1.csv", "2.csv", "3.csv", 3);
        c.run();
        c.findScreenings();
        c.sortScreenings();
        c.greedySelect();
    }    
}

    