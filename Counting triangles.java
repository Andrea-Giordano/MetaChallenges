class Main {

  class Sides{
    int a;
    int b;
    int c;
    
    Sides(int a,int b,int c){
      this.a = a;
      this.b = b;
      this.c = c; 
    }
    
    void sort() {
      int[] arr = {a,b,c};
      Arrays.sort(arr);
      this.a = arr[0];
      this.b = arr[1];
      this.c = arr[2];
    }
    
    @Override
    public boolean equals(Object obj) {
      if(obj == this) {
        return true;
      } else if(!(obj instanceof Sides)) {
        return false;
      }
      
      Sides o = (Sides) obj;
      
      return this.a == o.a && this.b == o.b && this.c == o.c;
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(a, b, c);
    }
  }
  
  // Add any helper functions you may need here
  
  
  int countDistinctTriangles(ArrayList<Sides> arr) {

    int duplicates = 0;
    Set<Sides> set = new HashSet<>();
    
    for(Sides el : arr) {      
      el.sort();
      if(!set.add(el)){
        duplicates++;
      }
    }
    
    return arr.size()-duplicates;
  }
}