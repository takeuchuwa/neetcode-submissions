// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        return mergeSort(pairs, 0, pairs.size());
    }

    public List<Pair> mergeSort(List<Pair> pairs, int startIndex, int endIndex) {
        if (endIndex - startIndex <= 1) {
            return pairs.subList(startIndex, endIndex);
        }

        int middleIndex = (startIndex + endIndex) / 2;
        List<Pair> firstHalf = mergeSort(pairs, startIndex, middleIndex);
        List<Pair> secondHalf = mergeSort(pairs, middleIndex, endIndex);

        int firstPointer = 0;
        int secondPointer = 0;

        List<Pair> sortedArray = new ArrayList<>(endIndex - startIndex);
        while (firstPointer < firstHalf.size() && secondPointer < secondHalf.size()) {
            Pair first = firstHalf.get(firstPointer);
            Pair second = secondHalf.get(secondPointer);
            if (first.key <= second.key) {
                sortedArray.add(first);
                firstPointer++;
            } else {
                sortedArray.add(second);
                secondPointer++;
            }

        }

        if (firstPointer < firstHalf.size()) {
            sortedArray.addAll(firstHalf.subList(firstPointer, firstHalf.size()));
        }

        if (secondPointer < secondHalf.size()) {
            sortedArray.addAll(secondHalf.subList(secondPointer, secondHalf.size()));
        }

        return sortedArray;
    }
}
