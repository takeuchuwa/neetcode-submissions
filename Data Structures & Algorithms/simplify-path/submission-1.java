class Solution {
    public String simplifyPath(String path) {
        if (!path.startsWith("/")) {
            return null;
        }
        Deque<String> directories = new ArrayDeque<>();
        StringBuilder directoryBuilder = new StringBuilder();
        for (char c: path.toCharArray()) {
            if (c == '/') {
                processDirChange(directories, directoryBuilder);
            } else {
                directoryBuilder.append(c);
            }
        }
        processDirChange(directories, directoryBuilder);

        directoryBuilder.setLength(0);
        Iterator<String> iterator = directories.descendingIterator();
        while (iterator.hasNext()) {
            directoryBuilder.append('/');
            directoryBuilder.append(iterator.next());
            
        }

        return directoryBuilder.length() > 0 ? directoryBuilder.toString() : "/";
    }

    private void processDirChange(Deque<String> directories, StringBuilder directoryBuilder) {
        if (directoryBuilder.length() > 0) {
            String curr = directoryBuilder.toString();
            if ("..".equals(curr)) {
                directories.poll();
            } else if (!".".equals(curr)) {
                directories.push(curr);
            }
            directoryBuilder.setLength(0);
        }
    }
}