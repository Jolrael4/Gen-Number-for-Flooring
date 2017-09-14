public class FloorPattern {
  public static void main(String[] args) {
    int a[]= new int[12];
    int i = 0;
    
    recursive(a, i);
  }
  private static void recursive(int[] a, int i){
    for(int k = 1; k <= 4; k++){
      if((i >= 1 && a[i-1] == k) ||             //check for 11
         (i >= 2 && a[i-2] == k) ||             //check for 121
         (i >= 3 && (((a[i-1] == k-1) && (a[i-2] == k-2) && (a[i-3] == k-3))|| //check for 1234 or 4321
                     ((a[i-1] == k+1) && (a[i-2] == k+2) && (a[i-3] == k+3))))){
        continue;    }                          //bad case; for increments
      a[i] = k;
      if(i == 11){
        for(int m = 0;m < a.length; m++){
          System.out.print(a[m]);}
        System.out.println("");
        continue;                              //solution; for increments
      } 
      else{
        recursive(a, (i+1));                     //partial solution; go to the next digit
        continue;
      }
    }
    return;
  }
}