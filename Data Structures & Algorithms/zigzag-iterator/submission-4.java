class ZigzagIterator {

    Queue<Iterator<Integer>> iterators;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iterators = new ArrayDeque<>();
        Iterator<Integer> v1Iterator = v1.iterator();
        if (v1Iterator.hasNext()) {
            iterators.offer(v1Iterator);
        }
        Iterator<Integer> v2Iterator = v2.iterator();
        if (v2Iterator.hasNext()) {
            iterators.offer(v2Iterator);
        }
    }

    public int next() {
        Iterator<Integer> curr = iterators.poll();
        int elem = curr.next();
        if(curr.hasNext()) {
            iterators.offer(curr);
        }

        return elem;
    }

    public boolean hasNext() {
        return !iterators.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
