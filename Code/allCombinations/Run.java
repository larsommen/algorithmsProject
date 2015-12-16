public class Run{
    
    public static void main(String[] args){
        
        Combinations c = new Combinations("1.csv", "2.csv", "3.csv");
        c.run();
        c.findCombinations(3);
        c.print();
    }    
}