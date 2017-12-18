package homeworks;

/**
 * File Name: TruthTable.java 
 * Print 'n' input truth table
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */

class TruthTable{
  private int n ;
  TruthTable(int n) {
    this.n = n ;
    printTruthTable() ;
  }
  
  
  private void printTruthTable() {
    //WRITE CODE HERE. 
    //Show truth table for n < 8
    //along with a line at the end as follows
    //For 7 inputs, table size is 128

    //For n > 8 just print tablesize
    //For 25 inputs, table size is 33554432
    //but internally it should build truth table like n < 8
	    long lines = (long) Math.pow(2, this.n);
	      
	    for(int i=0; i< lines  ; i++){
	      int x = i;
	      for(int j=this.n-1; j >= 0  ; j--){
	        int y = i % (int)Math.pow(2, j);
	        if( this.n < 8){
	        	if ( x == y)
	  	        	System.out.print(" 0");
	  	        else
	  	          System.out.print(" 1");
	        }
	        x = y;
	      }
	      if( this.n < 8){
	    	  System.out.println();
	      }
	    }
	    System.out.println("Number of lines in the Truth table "+lines+"\n\n");
	     
  }
  
  private static void testBench() { 
    //CANNOT CHANGE BELOW
    for (int i = 1 ; i < 40; ++i) {
      System.out.println("------------Truth table of " + i + " inputs function --------------");
      TruthTable t = new TruthTable(i) ;
    }
  }

  public static void main(String[] args) {
    //CANNOT CHANGE BELOW
    System.out.println("TruthTable.java");
    testBench();
    System.out.println("Done");
  }
}
