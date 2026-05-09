// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        quickSort(pairs, 0, pairs.size());
        return pairs;
    }

    public void quickSort(List<Pair> pairs, int start, int end) {
        if (end - start <= 1) {
            return;
        }

        Pair pivot = pairs.get(end - 1);
        int pointer = start;
        for (int i = start; i < end; i++) {
            if (pairs.get(i).key < pivot.key) {
                Pair temp = pairs.get(pointer);
                pairs.set(pointer, pairs.get(i));
                pairs.set(i, temp);
                pointer++;
            }
        }

        pairs.set(end - 1, pairs.get(pointer));
        pairs.set(pointer, pivot);

        quickSort(pairs, start, pointer);
        quickSort(pairs, pointer + 1, end);
    }
}
