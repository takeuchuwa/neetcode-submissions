class DynamicArray {

    private int[] array;
    private int pointer = -1;

    public DynamicArray(int capacity) {
        array = new int[capacity];
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
        
    }

    public void pushback(int n) {
        if (++pointer == array.length) {
            resize();
        }
        array[pointer] = n;
    }

    public int popback() {
        return array[pointer--];
    }

    private void resize() {
        int[] newArray = new int[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    public int getSize() {
        return pointer + 1;
    }

    public int getCapacity() {
        return array.length;
    }
}
