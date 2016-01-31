
//backtracking inspired by Flip Game I
public boolean canWin(String s) {
    List<String> list = new ArrayList<>();
    for(int i = 0; i < s.length() - 1; i++){
        if(s.charAt(i) == '+' && s.charAt(i + 1) == '+')
            list.add(s.substring(0, i) + "--" + s.substring(i + 2, s.length()));         // generate all possible sequence after every attempt
    }

    for(String str : list){
        if(!canWin(str))             // if there is any one way the next player can't win, take it and you'll win
            return true;
    }
    return false;      
}

//another backtracking
public boolean canWin(String s) {
  if (s == null || s.length() < 2) {
    return false;
  }

  for (int i = 0; i < s.length() - 1; i++) {
    if (s.startsWith("++", i)) {
      String t = s.substring(0, i) + "--" + s.substring(i + 2);

      if (!canWin(t)) {
        return true;
      }
    }
  }

  return false;
}


//use HashMap to memorize both win string & lose string
public boolean canWin(String s) {
    if(s == null || s.length() < 2) return false;
    Map<String, Boolean> map = new HashMap<>();
    return canWin(s, map);
}

public boolean canWin(String s, Map<String, Boolean> map){
    if(map.containsKey(s)) return map.get(s);
    for(int i = 0; i < s.length() - 1; i++) {
        if(s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
            String opponent = s.substring(0, i) + "--" + s.substring(i + 2);
            if(!canWin(opponent, map)) {
                map.put(s, true);
                return true;
            }
        }
    }
    map.put(s, false);
    return false;
}
