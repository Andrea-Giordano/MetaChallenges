class Main {  

  boolean areTheyEqual(int[] array_a, int[] array_b) {

    Map<Integer, Integer> map = new HashMap<>();
    
    for(int el : array_a) {
      map.merge(el, 1, Integer::sum);
    }
    
    for(int el : array_b) {
      if(map.containsKey(el)) {
        map.merge(el, -1, Integer::sum);
        map.remove(el, 0);
      } else {
        return false;
      }
    }
    return true;
  }
}