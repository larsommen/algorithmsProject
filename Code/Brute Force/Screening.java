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
  
  public Integer getMovie(int i){
      return movies[i];
  }
  
  public String toString(){
      String m = ", ";
      for(int i = 0; i < movies.length; i++){
          m += movies[i] + ", ";
      }
      return actorId + m + rating;      
  }

 }