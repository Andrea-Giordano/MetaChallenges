class Main {

  int numberOfWays(int[] arr, int k) {
    
    int ways = 0;

    Map<Integer, Integer> map = new HashMap<>();

    for(int v : arr) {
      if(map.containsKey(k-v)){
        ways += map.get(k-v);
      } 
      map.merge(v, 1, Integer::sum);
    }

    return ways;
  }
}