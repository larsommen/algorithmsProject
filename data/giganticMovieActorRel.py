import random
from random import randint
noOfMovies=100
noOfActors =10
iD =0
for x in range(0, 40):
	currentMovie = 0
	inNoMovies =100
	for y in range(0, inNoMovies):
		nextMovie = randint(1,noOfMovies/inNoMovies)
		currentMovie = currentMovie+nextMovie
		#print str(iD)+","+str(x)+","+str(currentMovie)	

for x in range(0, 100):
	for y in range(0,100):
		rating = 10*random.random()
		print str(iD)+","+str(x)+","+str(y) 
		iD=iD+1
