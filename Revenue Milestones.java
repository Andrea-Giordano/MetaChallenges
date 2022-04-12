
class Main {

  int[] getMilestoneDays(int[] revenues, int[] milestones) {

    int[] res = new int[milestones.length];
    TreeMap<Integer, Integer> sumRev = new TreeMap<>();
    
    int sum = 0;
    for (int i=0; i<revenues.length; i++) {
      sum += revenues[i];
      sumRev.put(sum, i);
    }
    
    for (int i=0; i<milestones.length; i++) {
      res[i] = sumRev.ceilingEntry(milestones[i]).getValue()+1;
    }
    
    return res;
  }
}