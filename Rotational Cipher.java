class Main {

  String rotationalCipher(String input, int r) {
    
    char[] chars = input.toCharArray();

    for (int i=0; i<chars.length; i++) {
      
      if (chars[i] <= 'Z' && chars[i] >= 'A') {
        int shift = ((chars[i] - 'A' + r ) % 26) + 'A';
        chars[i] = ( (char) shift);
        
      } else if (chars[i] <= 'z' && chars[i] >= 'a') {
        int shift = ((chars[i] - 'a' + r ) % 26) + 'a';
        chars[i] = ( (char) shift);
        
      } else if (chars[i] <= '9' && chars[i] >= '0') {
        int shift = ((chars[i] - '0' + r ) % 10) + '0';
        chars[i] = ( (char) shift);
        
      } 
    }
    return String.valueOf(chars);
  }
}