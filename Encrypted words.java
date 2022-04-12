
class Main {


  String encrypt(String s) {
    if (s.length()==1) {
      return s;
    }
    
    int halfIdx = s.length()%2 == 0 ? s.length()/2 -1 : s.length()/2;
    
    String newS = String.valueOf(s.charAt(halfIdx));
    
    if (halfIdx == 0) {
      return newS.concat(encrypt(s.substring(halfIdx+1)));
    }
    
    return newS
      .concat(encrypt(s.substring(0, halfIdx)))
      .concat(encrypt(s.substring(halfIdx+1)));
    
  }
  

  String findEncryptedWord(String s) {
    return encrypt(s);
  }

}