import random
from random import randint
noOfMovies=50
noOfActors =40
iD =0
for x in range(0, 40):
	currentMovie = 0
	inNoMovies =randint(0,10)
	for y in range(0, inNoMovies):
		nextMovie = randint(0,noOfMovies/inNoMovies)
		currentMovie = currentMovie+nextMovie
		print str(iD)+","+str(x)+","+str(currentMovie)	
