def mostCommonCharacter(stringInput):
    alphabetCount = [0]*28
    alphabet = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
    stringInput = list(stringInput)
    charCount = 0
    letterCount = 0

    for character in stringInput:
        for letter in alphabet:
            if stringInput[charCount] == alphabet[letterCount]:
                alphabetCount[letterCount]+=1
            letterCount+=1
        letterCount = 0
        charCount+=1
    maxIndex = alphabetCount.index(max(alphabetCount))
    print("The most common character is" ,alphabet[maxIndex], ": ",alphabetCount[maxIndex] )
