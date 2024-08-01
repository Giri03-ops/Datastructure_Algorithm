import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class TwoSums {

    public int[] twoSum(int[] nums, int target) {
        
        int[] copyOfnums = new int[nums.length];
        System.arraycopy(nums, 0, copyOfnums, 0, nums.length);

        LinkedHashMap<Integer, Integer> NumsDictionary = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            NumsDictionary.put(i, nums[i]);
        }

        // Function to calculate passes
        var Passes = CalculatePasses(nums);
        var PassIndex = 1;
        
        var ArrayLength = nums.length;
        var Arraychunk = 1;
        var ArrayIndex = 0;

        while (PassIndex <= Passes){

            while (ArrayIndex <= ArrayLength) {
                var ArrayIndex2 = ArrayIndex + Arraychunk;
    
                if(ArrayIndex2 > ArrayLength) {
                    break; 
                }
    
                int[] TempArray1 = Arrays.copyOfRange(copyOfnums, ArrayIndex, ArrayIndex2);
                
                int[] TempArray2 = Arrays.copyOfRange(copyOfnums, ArrayIndex2, Math.min(ArrayIndex2 + Arraychunk ,ArrayLength) );
    
                // MergeSort Function 
                copyOfnums = MergeSort(nums, TempArray1, TempArray2, TempArray1.length, TempArray2.length,ArrayIndex);
    
                System.out.print(Arrays.toString(copyOfnums)); // Fix printing to use Arrays.toString
    
                ArrayIndex = ArrayIndex + 2*Arraychunk; // Update ArrayIndex to prevent infinite loop
            }

            Arraychunk = 2 * Arraychunk ;
            PassIndex += 1;
            ArrayIndex = 0;
        }

        ArrayList<Integer> IndicesArray = new ArrayList<Integer>();
        
        IndicesArray = GetIndicesArrayList(IndicesArray, NumsDictionary, copyOfnums,target);

        int [] Indices = convertToIntArray(IndicesArray);

        return Indices;
    }

    public static boolean boolOf(int value) {
        return value != 0;
    }

    public static int CalculatePasses(int[] NumberArray) {
        var NaturalLogPasses = Math.log(NumberArray.length) / Math.log(2);
        // This helps round off to the next integer
        var Passes = (int) Math.ceil(NaturalLogPasses);
        return Passes;
    }


    public static int[] convertToIntArray(ArrayList<Integer> list) {
       
        int[] array = new int[list.size()];

        
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }
    
    public static ArrayList<Integer> convertArrayToArrayList(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num : array) {
            arrayList.add(num); 
        }
        return arrayList;
    }
    
    public int[] MergeSort(int[] NumberArray, int[] Array1, int[] Array2, int ArrayLength1, int ArrayLength2, int CopyToIndex) {
        var Array1Index = 0;
        var Array2Index = 0;

        int[] SortedArray = new int[ArrayLength1 + ArrayLength2];
        var SortedArrayIndex = 0;

        // Merge while both arrays have elements
        while (Array1Index < ArrayLength1 && Array2Index < ArrayLength2) {
            if (Array1[Array1Index] < Array2[Array2Index]) {
                SortedArray[SortedArrayIndex] = Array1[Array1Index];
                Array1Index++;
            } else {
                SortedArray[SortedArrayIndex] = Array2[Array2Index];
                Array2Index++;
            }
            SortedArrayIndex++;
        }

        // Copy remaining elements from Array1
        while (Array1Index < ArrayLength1) {
            SortedArray[SortedArrayIndex] = Array1[Array1Index];
            Array1Index++;
            SortedArrayIndex++;
        }

        // Copy remaining elements from Array2
        while (Array2Index < ArrayLength2) {
            SortedArray[SortedArrayIndex] = Array2[Array2Index];
            Array2Index++;
            SortedArrayIndex++;
        }

        // Copy sorted array back to NumberArray
        for (int i = 0; i < SortedArray.length; i++) {
            NumberArray[CopyToIndex] = SortedArray[i];
            CopyToIndex++;
        }

        return NumberArray;
    }

    public  ArrayList<Integer> GetIndicesArrayList(ArrayList<Integer> IndicesArray, LinkedHashMap<Integer, Integer> NumsDictionary, int [] copyOfnums,int target) {

        for (int i = 0; i < copyOfnums.length; i++){

            int SecondNumber;

            int FirstNumberOriginalIndex = getOriginalIndex(NumsDictionary,copyOfnums[i]);
            
            SecondNumber = target - copyOfnums[i];

            int[] slicedArray = Arrays.copyOfRange(copyOfnums, i+1, copyOfnums.length);

            ArrayList<Integer> SecondNumberInfoList = BinarySearch(NumsDictionary,slicedArray, slicedArray.length, SecondNumber);

            if (boolOf(SecondNumberInfoList.get(0))){

                IndicesArray.add(FirstNumberOriginalIndex);
                IndicesArray.add(SecondNumberInfoList.get(2)); 

                return IndicesArray;

            }
            
        }

        return IndicesArray;

    }

    public ArrayList<Integer> BinarySearch (LinkedHashMap<Integer, Integer> NumsDictionary,int[] Array, int Arraylength, int target){

        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);

        int LowIndex = 0;
        int HighIndex = Arraylength-1;



        while(LowIndex <= HighIndex){

            int MidIndex = (LowIndex + HighIndex)/2;

            if (Array[MidIndex] == target){

                result.set(0,1);
                result.add(MidIndex);
                result.add(getOriginalIndex(NumsDictionary,Array[MidIndex]));
                return result;

            }
            
            if (Array[MidIndex] < target){
                LowIndex = MidIndex + 1;

            }
            else{
                HighIndex = MidIndex - 1;
            }
        }

            return result;
    }


    public static <K, V> Integer getOriginalIndex(Map<K, V> map, V value) {
        int index = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                K key = entry.getKey();
                map.put(key, null); 
                return index; // Return the index
            }
            index++;
        }
        return null; // Return null if the value is not found
    }

    public static void main(String[] args) {
        TwoSums solution = new TwoSums();

        int[] nums = {0,4,3,0};
        int target = 0;

        // Call the twoSum method
        int[] result = solution.twoSum(nums, target);

        // Print the result
        System.out.println("Indices of the numbers that add up to " + target + ": " + Arrays.toString(result));
    }
}
