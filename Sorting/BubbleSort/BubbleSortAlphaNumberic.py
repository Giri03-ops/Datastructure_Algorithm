import re

def compareStrings (stringOne , stringTwo):

    minimumLength = min (len(stringOne),len(stringTwo))

    for index in minimumLength:

        if stringOne[index] > stringTwo[index] :
            return stringOne
        elif stringOne[index] < stringTwo[index] :
            return stringTwo
    


def alphanumeric_compare(stringOne, stringTwo):
    def split_key(key):
        return [int(text) if text.isdigit() else text for text in re.split('([0-9]+)', key)]

    # Split strings into alphanumeric parts
    partsOne = split_key(stringOne)
    partsTwo = split_key(stringTwo)

    # Compare parts
    for partOne, partTwo in zip(partsOne, partsTwo):
        if partOne < partTwo:
            return stringTwo  # stringOne is smaller
        elif partOne > partTwo:
            return stringOne  # stringTwo is smaller

    # If all parts are equal so far, compare lengths
    if len(partsOne) < len(partsTwo):
        return stringTwo  # stringOne is shorter and hence smaller
    else:
        return stringOne  # stringTwo is shorter and hence smaller





def BubbleSort(UnSortedList) :

    NumberOfPasses = len(UnSortedList) - 1 # Number of Passes = N-1
    
    for NumberOfPassIndex in range(0,NumberOfPasses ) : 

        for listIndex in range(0,NumberOfPasses - NumberOfPassIndex) : #

            if UnSortedList[listIndex] > UnSortedList[listIndex + 1] :

                UnSortedList[listIndex],UnSortedList[listIndex + 1] = UnSortedList[listIndex + 1],UnSortedList[listIndex]
        
        print (f"{NumberOfPassIndex} : {UnSortedList} ")

    return UnSortedList



def main() :

    UnSortedList = ["a1", "b2", "c3", "a2", "b1", "c1"]

    SortedList = BubbleSort(UnSortedList)

    print(SortedList) 



if __name__ == "__main__" :
    main()