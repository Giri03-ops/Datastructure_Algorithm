import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

class Solution {
    public int[] frequencySort(int[] nums) {

        Map<Integer, Integer> FrequencyNumberMap = new HashMap<>();
        int[] OutputArray = new int[nums.length];

        for (int num : nums) {

            if (!FrequencyNumberMap.containsKey(num)) {

                FrequencyNumberMap.put(num, 1);
            } else {

                int FrequencyCount = FrequencyNumberMap.get(num);
                FrequencyCount += 1;
                FrequencyNumberMap.put(num, FrequencyCount);

            }

        }

        // since hash is unordered we need linkedHashMap to add the sorted map
        // Defining the LinkedHashMap

        Map<Integer, Integer> OrderedFrequencyNumberMap = new LinkedHashMap<>();

        // we will create a list of unOrdered hashmap sort it and then add it to our
        // LinkedHashmap

        List<Map.Entry<Integer, Integer>> ListFrequencyNumberMap = new ArrayList<>(FrequencyNumberMap.entrySet());

        ListFrequencyNumberMap.sort((x, y) -> {
            int valueComparison = x.getValue().compareTo(y.getValue());
            if (valueComparison != 0) {
                return valueComparison;
            } else {
                // If values are the same, compare the keys in reverse order
                return y.getKey().compareTo(x.getKey());
            }
        });

        for (Map.Entry<Integer, Integer> Element : ListFrequencyNumberMap) {
            OrderedFrequencyNumberMap.put(Element.getKey(), Element.getValue());
        }

        System.out.print(OrderedFrequencyNumberMap);

        // now lets add the number to the array
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : ListFrequencyNumberMap) {

            if (index < OutputArray.length) {
                var countValue = entry.getValue();
                while (countValue > 0) {
                    OutputArray[index] = entry.getKey();
                    index++;
                    countValue -= 1;
                }

            }
        }

        return OutputArray;

    }
}