import csv

# Step 1: Open samples.csv for reading
with open("samples.csv", "r") as file:

# Step 2: Skip the header row
    rows = csv.reader(file)
    next(rows)

# Step 3: Read each sample and convert the
# mass and volume columns to floats
    print(rows)

    totalSamples = 0
    totalMass = 0.0
    heaviestMass = 0
    samplesOfNaCl = 0
    totalVolume = 0
    maxIndex = 0

    massList = []
    temp = 0
    maxIndex = 0

    for column in rows:
        if(column[1] == "NaCl"):
            samplesOfNaCl += 1
        totalMass += float(column[2])
        totalSamples +=1
        totalVolume += float(column[3])
        massList.append(column[2])

    for i in range(len(massList)):

        if(massList[i] > 0):
            temp = massList[i]
            maxIndex = 0


    print(totalMass)
    print(massList)
# Step 4: Calculate the following:
# - Total number of samples
# - Total mass
# - Average mass
# - Sample with the highest mass
# - Number of NaCl samples
# - Average volume

# Step 5: Display the results
