class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int sandwichPointer = 0;
        int studentPointer = 0;
        int n = students.length;
        int endOfQueue = n - 1;
        boolean noOneTakesTopSandwich = false;
        while (!noOneTakesTopSandwich && studentPointer < n && sandwichPointer < n) {
            if (students[studentPointer] ==  sandwiches[sandwichPointer]) {
                students[studentPointer] = -1;
                sandwichPointer++;
                endOfQueue = studentPointer;
            } else if (studentPointer == endOfQueue) {
                noOneTakesTopSandwich = true;
            }

            if (++studentPointer == n) {
                studentPointer = 0;
            }

        }
        return n - sandwichPointer;
    }
}