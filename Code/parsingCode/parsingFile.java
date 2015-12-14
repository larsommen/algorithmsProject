import java.io.*;
import java.util.Scanner;
import java.util.*;


public class parsingFile{
	




	public static void main(String[] args) throws FileNotFoundException {

		//read number of actor movie relations

		//String actorsFileName=args[0];

		File actorfile = new File(args[0]);

		File movieFile= new File(args[1]);

		File actorMovieFile = new File(args[2]);

		int numberOfActors = 0;



		//just counting number of lines = numberOfActors
		try
  				{BufferedReader reader = new BufferedReader(new FileReader(actorfile));
   					 String line;
    				while ((line = reader.readLine()) != null)
   						{
 						     numberOfActors++;
   						}
  						  reader.close();

						  }
						  catch (Exception e)
						  {
						    System.err.format("Exception occurred trying to read '%s'.", actorfile);
						    e.printStackTrace();  
						  }

		System.out.println("Number of actors are: "+ numberOfActors );

		String [] actors = new String[numberOfActors];

		int counter = 0;

		try
  				{BufferedReader reader = new BufferedReader(new FileReader(actorfile));
   					 String line;
    				while ((line = reader.readLine()) != null)
   						{
 						     System.out.println(line);
 						     actors[counter]= line;
 						     counter++;
   						}
  						  reader.close();
						  }
						  catch (Exception e)
						  {
						    System.err.format("Exception occurred trying to read '%s'.", actorfile);
						    e.printStackTrace();
						  }
		
		int numberOfMovies=0;

	//just counting number of lines = numberOfMovies
		try
  				{BufferedReader reader = new BufferedReader(new FileReader(movieFile));
   					 String line;
    				while ((line = reader.readLine()) != null)
   						{
 						     numberOfMovies++;
   						}
  						  reader.close();

						  }
						  catch (Exception e)
						  {
						    System.err.format("Exception occurred trying to read '%s'.", movieFile);
						    e.printStackTrace();  
						  }

		System.out.println("Number of movies are: "+ numberOfMovies );

		MovieRatings [] allMovies = new MovieRatings[numberOfMovies];

		counter = 0;

		try
  				{BufferedReader reader = new BufferedReader(new FileReader(movieFile));
   					 String line;
    				while ((line = reader.readLine()) != null)
   						{
 						     MovieRatings thisRating = new MovieRatings();
 						     System.out.println(line);
 						     String[] parts = line.split(",");
 						     thisRating.movieID = Integer.parseInt(parts[0]);
 						     thisRating.movieTitle = parts[1];
 						     thisRating.rating = Double.parseDouble(parts[2]);
 						     allMovies[counter]= thisRating;
 						     counter++;
   						}
  						  reader.close();
						  }
						  catch (Exception e)
						  {
						    System.err.format("Exception occurred trying to read '%s'.", movieFile);
						    e.printStackTrace();
						  }
		
		int numberOfActorsInMovies=0;



//		Set<MovieRatings> [] setOfMovieRatings = new HashSet[numberOfActors]<MovieRatings>();

	//just counting number of lines = numberOfActorsInMovies
		try
  				{BufferedReader reader = new BufferedReader(new FileReader(actorMovieFile));
   					 String line;
    				while ((line = reader.readLine()) != null)
   						{
 						     numberOfActorsInMovies++;
   						}
  						  reader.close();

						  }
						  catch (Exception e)
						  {
						    System.err.format("Exception occurred trying to read '%s'.", actorMovieFile);
						    e.printStackTrace();  
						  }

		System.out.println("Number of actor movie relations are: "+ numberOfActorsInMovies );

		MovieRatings [] actorMovieRel = new MovieRatings[numberOfActorsInMovies];

	//	Set<MovieRatings> movieSet = new HashSet<MovieRatings>();

		ST<Integer, Set<MovieRatings> > ratingsMap = [];

		counter = 0;

		try
  				{BufferedReader reader = new BufferedReader(new FileReader(actorMovieFile));
   					 String line;



    				while ((line = reader.readLine()) != null)
   						{
 						     System.out.println(line);

 						     MovieRatings thisMovieRating = new MovieRatings();

 						     String[] parts = line.split(",");
 						     int actorID = Integer.parseInt(parts[1]);
 						     thisMovieRating.actor = Integer.parseInt(parts[1]);
 						     thisMovieRating.movieID = Integer.parseInt(parts[2]);
 						     thisMovieRating.rating = allMovies[thisMovieRating.movieID].rating;

 						     if (ratingsMap.contains(actorID)){
 						     	//get the movieSet and add new movieRel
 						     	Set<MovieRatings> thisActorsRating = ratingsMap.get(actorID);
 						     	thisActorsRating.add(thisMovieRating);
 						     	ratingsMap.put(actorID, thisActorsRating);
 						     }else{
 						     	//add actor and movieSet

 						     	Set set = new HashSet();

 						     	set.add(thisMovieRating);

 						     	ratingsMap.put(actorID, set);

 						     }


// 						     actorMovieRel[counter]= thisMovieRating;

 						     counter++;
   						}
  						  reader.close();
						  }
						  catch (Exception e)
						  {
						    System.err.format("Exception occurred trying to read '%s'.", actorMovieFile);
						    e.printStackTrace();
						  }
		








		for (int i=0;i<numberOfActors ;i++ ) {


			System.out.println(actors[i]);			
		}


		
		Movie [] allCombinationsActorMovie = new Movie[10];



		System.out.println(actorfile);

		System.out.println(movieFile);

		System.out.println(actorMovieFile);		

	}




}