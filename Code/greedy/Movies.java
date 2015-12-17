import java.util.*;

public class Movies {
    
    static String[] M = {"A", "B", "C", "D", "E", "F", "G"};
    static int count = 0;


    public static void main(String[] args) {
        combinations(0, M, "", 3);
        //SdtOut.println("Antal:" + count);

    }
    
    public static void combinations(int index, String[] movies, String temp, int m){
        String newTemp;        
        
        for(int i = index; i < movies.length; i++){

            newTemp = temp + movies[i];
            
            if (newTemp.length() < m)
                combinations(i + 1, movies, newTemp, m);
            else{
               System.out.println(newTemp);
               count++;
            }     
        }        
    }
}
    

   