inputFile= open("actor-surname", "r")
firstName = "Homer"
lastName = "Simpson"
idnumber =0

print str(idnumber) +", "+firstName + " " + lastName
lastName = lastName.rstrip('\n')
for x in range(0, 10):
	inputFile.readline()
for x in range(0, 10):
	idnumber=idnumber+1
	firstName = lastName
	lastName = inputFile.readline();
	firstName = firstName.rstrip('\n')
	lastName = lastName.rstrip('\n')
	print str(idnumber) + ", "+ firstName + " " + lastName

# Close opend file
inputFile.close()


