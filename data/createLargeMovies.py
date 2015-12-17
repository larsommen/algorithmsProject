import random
inputFile= open("movie-characters", "r")
firstName = "Leagal"
lastName = "Weapons"
idnumber =0
rating = 10*random.random()
print str(idnumber) +", "+firstName + " " + lastName + ", "+str(rating)
lastName = lastName.rstrip('\n')
for x in range(0, 10):
	inputFile.readline()
for x in range(0, 50):
	idnumber=idnumber+1
	firstName = lastName
	lastName = inputFile.readline();
	firstName = firstName.rstrip('\n')
	lastName = lastName.rstrip('\n')
	rating = 10*random.random()
	print str(idnumber) + ", "+ firstName + " " + lastName + ", "+str(rating)

# Close opend file
inputFile.close()


