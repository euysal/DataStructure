package homeworks;

/**
 * File Name: AmicablePair.java 
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2017
 */
public class AmicablePair2{
  private static int max ;
  static IntUtil u = new IntUtil() ;
  //You can add any private functions.
  
  AmicablePair2(int n) {
    //CANNOT CHANGE THIS PROCEDURE
    max = n ;
    long startTime = System.nanoTime();
    computeAmicablePairs();
    long endTime = System.nanoTime();
    double d = u.timeInSec(endTime,startTime) ;
    System.out.println("Run time for amicable for n = " + max + " is " + d + " secs");
    //YOUR OUTPUT MUST SHOW ABOVE LINE.
    //I WANT TI KNOW HOW MUCH TIME YOUR PROCEDURE TAKES
  }
  
  private boolean hasPrimeFactor(int n){
	  if(n % 2 == 0 || n%3 == 0 || n%5 == 0 || n% 7 == 0)
		  return false;
	  return true;
  }

  private  void computeAmicablePairs() {
    //WRITE CODE HERE
    //CREATE AS MANY PRIVATE FUNCTIONS YOU WANT
    //DO NOT CRAM ALL IN ONE FUNCTION
    //LEARN HOW TO DECOMPOSE A BIGGER PROBLEM TO SMALLER PROBLEMS
    //YOU CAN STORE ANSWER IN MEMORY TO REDUCE CPU TIMES like prime number algorithm
    //DO NOT USE ANY WEIRD FORMULAS FROM INTERNET
    //WRITE ALL CODE FROM FUNDAMENTALS.
    //DO NOT COPY FROM INTERNET
    int printCount = 0;
	int limit = max*2;
	int[] array = new int[limit];
    int sumFactorsOfOne = 1;
	int sumFactorsOfTwo = 1;

	for(int i = 1; i < limit/2; ++i){
	  if(hasPrimeFactor(i))
		  continue;
	  
	  if(array[i] == 0){
		  int sqrtI = (int)Math.sqrt(i);
		  
		  for(int j = 2; j < sqrtI; ++j){  
			  if(i % j == 0){
				  sumFactorsOfOne += i / j;
				  sumFactorsOfOne += j;
			  }
		  }
		  
		  if(i != sumFactorsOfOne){ // Protection for same numbers
			  
			  int sqrtsumFactorsOfOne = (int)Math.sqrt(sumFactorsOfOne);
			  
			  for(int k = 2; k < sqrtsumFactorsOfOne; ++k){  
				  if(sumFactorsOfOne % k == 0){
					  sumFactorsOfTwo += sumFactorsOfOne / k;
					  sumFactorsOfTwo += k;
				  }
			  }
			  
			  if(sumFactorsOfTwo == i){
				  
				  System.out.println(printCount + ": " + i + " and " + sumFactorsOfOne);
				  array[sumFactorsOfOne] = sumFactorsOfTwo;
				  printCount++;
			  }
		  }
		  
		  sumFactorsOfOne = 1;
		  sumFactorsOfTwo = 1;
	  }
	  
	  
  }
   
  
}
  
  private static void test() {
    //CANNOT CHANGE THIS PROCEDURE
    //int n = 100000000; //First test for 10000 just to see your answers matches with me on page 102
      int n = 10000000 ;
    AmicablePair a = new AmicablePair(n) ;
    //a.computeAmicablePairs();
  }
  
  public static void main(String[] args) {
    System.out.println("AmicablePair.java") ;
    test() ;
    System.out.println("DONE") ;
  }
}

