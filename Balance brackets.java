class Main {
  
  boolean areOpposite(char a, char b) {
    if( (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}')) {
      return true;
    }
    return false;
  }

  boolean isBalanced(String s) {
    ArrayDeque<Character> stack = new ArrayDeque<Character>();    
    
    for (char c : s.toCharArray()) {
      if (c == '{' || c == '[' || c == '(') {
        stack.push(Character.valueOf(c));
      } else {
        if (!areOpposite(stack.poll(), c)) {
          return false;
        }
      }
    }
          
    return stack.isEmpty() ? true : false;
  }
}