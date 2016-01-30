public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for(String s: strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();//must toString()
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> str = new ArrayList<>();
        int i = 0;
        while(i < s.length()) {
            int sharp = s.indexOf('#', i);
            int l = Integer.parseInt(s.substring(i, sharp));//method Integer.parseInt
            str.add(s.substring(sharp + 1, sharp + l + 1));//add method in ArrayList
            i = sharp + l + 1;
        }
        return str;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
