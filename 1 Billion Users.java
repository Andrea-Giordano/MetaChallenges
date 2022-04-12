class Main {


  static int BILLION = 1000000000;
  
  int calculateDayUsers(float[] g, int t) {
    int result = 0;
    for(float el : g) {
        result += Math.pow(el, t);
    }
    return result;
  }
  
  int getBillionUsersDay(float[] g) {

    int t = 1;
    int result = 0;
    while (result < BILLION) { 
      t = t*2;
      result = calculateDayUsers(g, t);
    }
   
    
    int tmax = t;
    int tmin = t/2;
    while (tmin < tmax) {      

      t = (tmax + tmin)/2;
      result = calculateDayUsers(g, t);
      
      if (result < BILLION) {
        tmin = t+1;
      } else{
        tmax = t;
      } 
    } 
    
    return t;
  }

}