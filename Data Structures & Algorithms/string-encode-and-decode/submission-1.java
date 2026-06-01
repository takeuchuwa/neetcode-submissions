class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        encodedString.append(strs.size());
        for (String str : strs) {
            encodedString.append("\u0000");
            encodedString.append(str.length());
            encodedString.append("\u001F");
            for (Character c : str.toCharArray()) {
                int n = encodedString.length();
                encodedString.append(c);
            }
        }
        System.out.println(encodedString);
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        String[] split = str.split("\u0000");
        List<String> strs = new ArrayList<>(Integer.parseInt(split[0]));
        for (int i = 1; i < split.length; i++) {
            String[] metadataAndText = split[i].split("\u001F");
        
            strs.add(metadataAndText.length > 1 ? metadataAndText[1] : "");
        }

        return strs;
    }
}
