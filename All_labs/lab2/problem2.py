def palindrome(stringInput):
    listInput = list(stringInput)
    listIterator = len(listInput)-1
    backWardsList = []

    for char in listInput:
        backWardsList.append(listInput[listIterator])
        listIterator-=1
    backWardsString = "".join(backWardsList)

    if stringInput == backWardsString:
        print("Original: ", stringInput, " reversed: ", backWardsString, "this is a palindrome.")
    else:
        print("Original: ", stringInput, " reversed: ", backWardsString, "this is not a palindrome.")
