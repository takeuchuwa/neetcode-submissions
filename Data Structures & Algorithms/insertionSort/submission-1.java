// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        
        List<List<Pair>> output = new ArrayList<>();
        if (!pairs.isEmpty()) {
            output.add(new ArrayList<>(pairs));
        }
        for (int i = 1; i < pairs.size(); i++) {
            int j = i - 1;
            while (j >= 0 && pairs.get(j).key > pairs.get(j + 1).key) {
                Pair tmp = pairs.get(j + 1);
                pairs.set(j + 1, pairs.get(j));
                pairs.set(j, tmp);
                j--;
            }
            output.add(new ArrayList<>(pairs));
        }

        return output;
    }
}
