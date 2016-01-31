public List<String> generatePossibleNextMoves(String s) {
    List list = new ArrayList();
    for (int i=-1; (i = s.indexOf("++", i+1)) >= 0; )
        list.add(s.substring(0, i) + "--" + s.substring(i+2));
    return list;
}

public List<String> generatePossibleNextMoves(String s) {

    List<String> list = new ArrayList<String>();

    for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
            list.add(s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length()));
        }
    }

    return list;

}
