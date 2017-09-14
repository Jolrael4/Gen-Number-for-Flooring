public class FloorPatternLim {
  public static void main(String[] args) {
    int a[]= new int[12];
    int i = 1;
    a[0] = 4;                                   //set starting number
    
    recursive(a, i);
  }
  private static void recursive(int[] a, int i){
    for(int k = 1; k <= 4; k++){
      if((i >= 1 && a[i-1] == k) ||             //check for 11
         (i >= 2 && a[i-2] == k) ||             //check for 121
         (i >= 3 && (((a[i-1] == k-1) && (a[i-2] == k-2) && (a[i-3] == k-3))||   //check for 1234 
                     ((a[i-1] == k+1) && (a[i-2] == k+2) && (a[i-3] == k+3))))){ //or 4321
        continue;    }                          //bad case; for increments
      a[i] = k;
      if(i == 11){                              //have all digits
        if(CheckQuad(a) && CheckWrap(a) && CheckRepeat(a) && CheckWrapRep(a)){ 
          for(int m = 0;m < a.length; m++){
            System.out.print(a[m]);}
          System.out.println("");
        }
        continue;                               //solution; for increments
      }
      else{
        recursive(a, (i+1));                    //partial solution; go to the next digit
        continue;
      }
    }
    return;
  }
  
  private static boolean CheckQuad(int[] a){
    int one = 0,two = 0,three = 0,four = 0;     //with 12 digits there should be 3 of each number
    for(int m = 0;m < a.length; m++){
      if(a[m]==1){
        one++;
      }else if(a[m]==2){
        two++;
      }else if(a[m]==3){
        three++;
      }else{
        four++;
      }
    }
    if(one!=3||two!=3||three!=3||four!=3){
      return false;
    }
    return true;
  }
  
  private static boolean CheckWrap(int[] a){
    if((a[0] != a[11] && a[0] != a[10] && a[1] != a[11])|| //check for wrapped 11 or 121
        (a[9]== (a[0]-3)&& a[10]== (a[0]-2) && a[11]== (a[0]-1))|| //check for wrapped 1234 
        (a[9]== (a[0]+3)&& a[10]== (a[0]+2) && a[11]== (a[0]+1))){ //or 4321
      return true;
    }
    return false;
  }
  
  private static boolean CheckRepeat(int[] a){
    for(int m = 0;m <= 9;m++){                  //check for 123123
      for(int n = 0;n <= 9;n++){
        if(m != n && (a[m] == a[n] && a[m+1] == a[n+1] && a[m+2] == a[n+2])){
          return false;
        }
      }
    }
    return true;
  }
  
  private static boolean CheckWrapRep(int[] a){
    for(int m = 0; m < 9; m++){                 //check for a repeat wrapped around the end
      if(m!=10 && ((a[10] == a[m] && a[11] == a[m+1] && a[0] == a[m+2]) ||
                   (a[11] == a[m] && a[0] == a[m+1] && a[1] == a[m+2])))
        return false;
    }
    return true;
  }
}