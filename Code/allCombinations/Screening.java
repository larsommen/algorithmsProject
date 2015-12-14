 public class Screening{

  private int actorId;
  private Integer[] movies;
  private double rating;
  
  public Screening(int actorId, Integer[] temp, double rating){
     movies = new Integer[temp.length];
     for(int i = 0; i < temp.length; i++){
         movies[i] = temp[i];
     }
     this.actorId = actorId;
     this.rating = rating;
  }
  
  public String toString(String[] actors){
      
      String m = ", ";
      m += movies[0] + ", " + movies[1] + " ";
      return actorId + m + rating;
      
  }

 }