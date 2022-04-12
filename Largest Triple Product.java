class Main {
  
  void replaceOnMinIfGreater(int[] arr, int val) {
    int minIdx = 0;
    int min = arr[minIdx];
    
    for(int i=0; i<arr.length; i++) {
      if (arr[i]<min) {
        min = arr[i];
        minIdx = i;
      }
    }
    
    if (val > arr[minIdx]) {
      arr[minIdx] = val;
    }
  }
  

  int[] findMaxProduct(int[] arr) {

    int[] res = new int[arr.length];
    int[] maxElems = new int[3];

    for (int i=0; i<arr.length; i++) {
      if (i==0 || i==1) {
        res[i] = -1;
        maxElems[i] = arr[i];
      } else {
        if (i==2) {
          maxElems[i] = arr[i];
        } else {
          replaceOnMinIfGreater(maxElems, arr[i]);
        }
        res[i] = maxElems[0] * maxElems[1] * maxElems[2]; 
      }
    }
    
    return res;
  }
}