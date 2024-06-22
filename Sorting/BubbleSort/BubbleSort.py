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