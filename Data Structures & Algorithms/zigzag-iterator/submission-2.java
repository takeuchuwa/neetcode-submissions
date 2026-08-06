class ZigzagIterator {

    Iterator<Integer> v1;
    Iterator<Integer> v2;
    int pointer;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1.iterator();
        this.v2 = v2.iterator();
        this.pointer = this.v1.hasNext() ? 0 : 1;
    }

    public int next() {
        if (pointer == 0) {
            pointer = v2.hasNext() ? 1 : 0;
            return v1.next();
        }

        if (pointer == 1) {
            pointer = v1.hasNext() ? 0 : 1;
            return v2.next();
        }
        
        return -1;
    }

    public boolean hasNext() {
        return v1.hasNext() || v2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
