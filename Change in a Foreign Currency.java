class Main {  

  boolean canGetExactChange(int targetMoney, int[] denominations) {
    Arrays.sort(denominations);
    
    for(int i=denominations.length-1; i>=0; i--) {
      if(targetMoney % denominations[i] == 0) {
        return true;
      } 
      
      targetMoney = targetMoney % denominations[i];
    }
    
    return false;   
  }
}