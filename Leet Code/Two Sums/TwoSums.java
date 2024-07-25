import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums=[2,7,11,15], int target) {

        //Funtion to calculate passes
        var Passes = CalculatePasses(nums);
        var ArrayLength = nums.length;
        var Arraychunk = 1;
        var ArrayIndex = 0 ;

        while (ArrayIndex <= ArrayLength) {
            
            var ArrayIndex2 = ArrayIndex + Arraychunk;

            int [] TempArray1 = Arrays.copyOfRange(nums,ArrayIndex, ArrayIndex2);

            int [] TempArray2 = Arrays.copyOfRange(nums,ArrayIndex2, ArrayIndex2 + Arraychunk);
            
            //MergeSort Function
            nums = MergeSort(nums,TempArray1, TempArray2, TempArray1.length, TempArray2.length ) ;

            System.out.print(nums);            


        }
        return nums;
    }

    public static int CalculatePasses (int[] NumberArray){

        var NaturalLogPasses = Math.log(NumberArray.length)/Math.log(2);
        //this helps roundoff to the next integer
        var Passes = (int) Math.ceil(NaturalLogPasses);

        return Passes;

    }

    public int[] MergeSort(int[] NumberArray,int[] Array1, int[] Array2, int ArrayLength1, int ArrayLength2){

        var Array1Index = 0;
        var Array2Index = 0;

        int [] SortedArray = new int[ArrayLength1 + ArrayLength2] ;

        var SortedArrayIndex = 0;

        //while loop till shortest array among the two array
        while (Array1Index <= ArrayLength1 && Array2Index <= ArrayLength2){

            if (Array1[Array1Index] < Array2[Array2Index])
            {
                
                SortedArray[SortedArrayIndex] = Array1[Array1Index];

                Array1Index += 1 ;
                SortedArrayIndex += 1;

            }
            else
            {

                SortedArray[SortedArrayIndex] = Array2[Array2Index];
                Array2Index += 1 ;
                SortedArrayIndex += 1;

            }

        }


        if (Array1Index!= ArrayLength1 )
        {

            for(int i=Array1Index ; i < ArrayLength1 ; i++)
            {
                SortedArray[SortedArrayIndex] = Array1[Array1Index];
                SortedArrayIndex += 1;
                
            }
        }
        else if(Array2Index!= ArrayLength2)
        {
            for(int i= Array2Index ; i < ArrayLength2 ; i++)
            {
                SortedArray[SortedArrayIndex] = Array2[Array2Index];
                SortedArrayIndex += 1;
                
            }
        }

        
    for (int i = 0; i < SortedArray.length; i++) {
        NumberArray[i] = SortedArray[i];
    }

    return NumberArray;
    }

}