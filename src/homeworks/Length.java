package homeworks;

import java.util.Random;

/**
 * File Name: Length.java 
 *
 * DO NOT POST ON GITHUB.
 * @author Jagadeesh Vasudevamurthy
 * @year 2017
 */

class Length {
	private static final IntUtil u = new IntUtil();
	//YOU CANNOT ADD ANY VARIABLE HERE

	private static int length_easy(int [] s, int x) {
		//CANNOT CHANGE BELOW
		int l = 0 ;
		int gx = x ;
		while (true) {
			if (s[x] == gx) {
				return l ;
			}
			x = s[x] ;
			++l ;
		}  
	}

	/*
	   YOU CANNOT USE ANY static variable in this function
	   YOU can use as many local variables as you need
	   Cannot use any loop statements like  for, while, do, while, go to
	   Can use if. 
	   ONLY AFTER THE execution of this routine array s MUST have the same content as you got it.
	   YOU cannot call any subroutine inside this function except length itself (NOT length_easy)
	 */
	private static int length(int [] s, int x) { 
		//WRITE CODE HERE 
		int numberAtx = s[x];
		int lengthTillNow = 0; 
		if(s[x] == x) {
		  return 0; // exit condition where s[x] = x (no need to process more)
		}
		if(s[numberAtx] == x) {
		  return 1; // exit condition where s[s[x]] = x (only one process)
		}
		s[x] = s[numberAtx]; 
		lengthTillNow = length(s, x); // Recursive length call 
		s[x] = numberAtx; 
		return lengthTillNow + 1; // +1 process 

	}

	//NOTHING CAN BE CHANGED BELOW
	public static void testbed() {
		//CANNOT CHANGE BELOW
		int s[] = {5,1,0,4,2,3} ;
		int y = length_easy(s,3) ;
		System.out.println("length_easy y = " + y);
		u.myassert(y == 4) ;
		int b[] = {5,1,0,4,2,3} ;
		int x = length(s,3) ;
		System.out.println("length x = " + x);
		u.myassert(x == y) ;
		for (int i = 0; i < s.length; ++i) {
			u.myassert(s[i] == b[i]);
		}
		System.out.println("Assert passed");
	}

	public static void testbed1() {
		//CANNOT CHANGE BELOW
		int s[] = {5,1,0,4,2,3} ;
		int b[] = {5,1,0,4,2,3} ;
		int l = s.length ;
		for (int j = 0; j < l ; ++j) {
			System.out.println("---------------------j = " + j + " ------------------");
			int y = length_easy(s,j) ;
			System.out.println("length_easy y = " + y);
			int x = length(s,j) ;
			System.out.println("length x = " + x);
			u.myassert(x == y) ;
			for (int i = 0; i < s.length; ++i) {
				u.myassert(s[i] == b[i]);
			}
			System.out.println("---------------------Assert passed--------------------");
		}
	}

	public static void testbed2() {
		int n = 5000 ;	
		System.out.println("Testing on " + n + " numbers");
		int[] a = u.generateNumberInIncreasingOrder(n, 1);
		//shuffle a
		Random r = new Random() ;
		for (int i = 0; i < n; ++i) {
			int p = RandomInt.getRandomInt(r,0,n); //This gives number between 0 to n-1
			int q = RandomInt.getRandomInt(r,0,n);
			u.swap(a,p,q);
		}
		//Keep a in b to compare
		int[] b = new int[n] ;
		for (int i = 0; i < n; ++i) {
			b[i] = a[i] ;
		}
		for (int j = 0 ; j < n; ++j) {
			int y = length_easy(a,j) ;
			int x = length(a,j) ;
			u.myassert(x == y) ;
			for (int i = 0; i < a.length; ++i) {
				u.myassert(a[i] == b[i]);
			}
		}
		System.out.println("All " + n + " cases passed. You are great");
	}


	public static void main(String[] args) {
		System.out.println("Length.java");
		testbed() ;
		testbed1() ;
		testbed2() ;
		System.out.println("Length.java DONE");
	}
}
