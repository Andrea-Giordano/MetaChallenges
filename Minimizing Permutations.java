class Main {


  void swap(int[] arr, int a, int b) {
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }
  
  void reverseSubPortion(int[] arr, int first, int last) {
    int i = first;
    int j = last;
    while (i < j) {
      swap(arr, i, j);
      i++;
      j--;
    }  
  }

  String obj(int[] arr) {
    return Arrays.toString(arr);
  }
  
  boolean equals(int[] arr1, int[] arr2) {
    for(int i=0; i<arr1.length; i++) {
      if(arr1[i]!=arr2[i]){
        return false;
      }
    }
    return true;
  }
  
  int minOperations(int[] arr) {

    int ops = 0;
    Queue<String> level = new LinkedList<>();
    Set<String> generated = new HashSet<>();
    
    int[] target = new int[arr.length];
    for (int i=0; i<arr.length; i++) {
      target[i] = i;
    }    
    
    if (equals(target, arr)) {
      return 0;
    }
    
    int swap = 0;
    level.add(new Pair(obj(target), swap));

    String el = level.poll();
    while(el) {
      for(int i=0; i<arr.length-1; i++) {
        for (int j=0; j<arr.length; j++) {
          int[] permutation = reverseSubPortion(el, i, j);
          if(generated.add(permutation)){
            if(equals(permutation, arr)) {
              return swap++;
            }
            level.add(new Pair(obj(permutation), swap++));
          }
        }
      }
    }    
    
    return swap;    
  }


class Pair {
  public String s;
  public int steps;

  public Pair(String s, int v) {
    this.s = s;
    this.steps = v;
  }
 }
}