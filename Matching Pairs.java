class Main {  

  int matchingPairs(String s, String t) {

    Set<Character> matches = new HashSet<>();
    Set<Pair<Character, Character>> noMatches = new HashSet<>();
    Set<Character> missT = new HashSet<>();
    Set<Character> missS = new HashSet<>();
       
    int count = 0;
    int addScore = -2;   
    
    for (int i=0; i<s.length(); i++) {

      if (s.charAt(i) == t.charAt(i)) {
        count++;
        
        if (addScore < 0) {
          if (matches.contains(t.charAt(i))) {
            addScore = 0;
          } else {
            matches.add(t.charAt(i));
          }
        }
       
      } else if (addScore < 2) {
        noMatches.add(new Pair<Character, Character>(t.charAt(i), s.charAt(i)));
        missS.add(s.charAt(i));
        missT.add(t.charAt(i));
        
        if (noMatches.contains(new Pair<Character, Character>(s.charAt(i), t.charAt(i)))) {
          addScore = 2; 
        } else if (missS.contains(t.charAt(i)) || missT.contains(s.charAt(i))) {
          addScore = Math.max(addScore, 1);
        } else {
          addScore = Math.min(addScore+1, 0);
        }
      }
    }
    
    return count + addScore;
  }

  class Pair<K, V> {
    
    private final K k;
    private final V v;
    
    public Pair(K k, V v) {
      this.k = k;
      this.v = v;
    }
    
    @Override
    public boolean equals(Object o) {
      if(o == this)
        return true;
      if (!(o instanceof Pair)) return false;
      Pair<K,V> obj = (Pair<K,V>)o;
      return this.k.equals(obj.k) && this.v.equals(obj.v);
    }
    
    @Override
    public int hashCode(){
      return Objects.hash(k,v);
    }
  }
 }