class Main {  

  int minLengthSubstring(String s, String t) {

    if(t.length() > s.length()){
      return -1;
    }
    
    Map<Character, Integer> map = new HashMap<>();
    for(char c : t.toCharArray()){
      map.merge(c, 1, Integer::sum);
    }
    
    int first = -1;
    int last = -1;
    int i=0;
    while(!map.isEmpty() && i<s.length()) {
      if (map.size() == t.length() && map.containsKey(s.charAt(i))) {
          map.merge(s.charAt(i), -1, Integer::sum);
          map.remove(s.charAt(i), 0);
          first = i;
      } else if (map.containsKey(s.charAt(i))){
          map.merge(s.charAt(i), -1, Integer::sum);
          map.remove(s.charAt(i), 0);
          last = !map.isEmpty() ? -1 : i;
      }
      i++;
    }

    return last == -1 ? last : last-first+1;
  }
