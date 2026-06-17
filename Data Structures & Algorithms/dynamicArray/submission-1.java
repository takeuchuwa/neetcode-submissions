class DynamicArray {
    private int[] array;
    private int size;

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
        if (array.length == size) {
            resize();
        }
        array[size++] = n;
    }

    public int popback() {
        return array[--size];
    }

    private void resize() {
        int[] nArray = new int[size * 2];
        for (int i = 0; i < size; i++) {
            nArray[i] = array[i];
        }

        array = nArray;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return array.length;
    }
}
