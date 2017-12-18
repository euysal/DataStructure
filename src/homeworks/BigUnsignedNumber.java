
package homeworks;

import java.awt.image.SampleModel;

/**
 * File Name: BigUnsignedNumber.java 
 * Infinite capacity Unsigned Number
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2017
 */
/*
 * To compile you require: CharArray.java, IntUtil.java RandomInt.java Cstring.java  BigUnsignedNumber.java
 */

class BigUnsignedNumber {
  private Cstring d; //data
  static IntUtil u = new IntUtil();
  //YOU CANNOT add any data members
  //YOU CAN add any public or private function so that all the tests will pass
  
  //WRITE ALL THE REQUIRED PROCEDURE REQUIRED TO COMPILE AND RUN BigUnsignedNumberTester.java 
  //NOTHING CAN BE CHANGED IN BigUnsignedNumberTester.java

	public BigUnsignedNumber(char num) {
		d = new Cstring(num);
	}

	public BigUnsignedNumber(String num) {
		d = new Cstring(num);
	}
	
	public BigUnsignedNumber(int num) {
		d = new Cstring(num + "");
	}

	public BigUnsignedNumber(Cstring cs) {
		this.d = cs;
	}

	public BigUnsignedNumber() {
		//default constructor. used when nothing about the number is known.
	}

	public void pLn(String s) {
		d.pLn(s);
	}

	public BigUnsignedNumber clone() {
		Cstring clone = d.clone();
		return new BigUnsignedNumber(clone);
	}

	public BigUnsignedNumber add(BigUnsignedNumber num) {
		Cstring num1 = d;
		Cstring num2 = num.d;
		Cstring result = new Cstring();
		for (int n1 = num1.size() - 1, n2 = num2.size() - 1, carry = 0; n1 >= 0 || n2 >= 0 || carry != 0; n1--, n2--) {
			int digit1 = n1 < 0 ? 0 : num1.get(n1) - '0';
			int digit2 = n2 < 0 ? 0 : num2.get(n2) - '0';

			int digit = digit1 + digit2 + carry;
			if (digit > 9) {
				carry = 1;
				digit -= 10;
			} else {
				carry = 0;
			}
			char c = (char) (digit + '0');
			result.append(new Cstring(c));
		}
		result.reverse();
		return new BigUnsignedNumber(result);
	}

	public BigUnsignedNumber mult(BigUnsignedNumber num) {
		Cstring num1 = d.clone();
		num1.reverse();
		Cstring num2 = num.d.clone();
		num2.reverse();

		// initialize product array with size num1.size() + num2.size() + 1 and fill all indexes with '\0'
		// maximum size of product array is num1.size() + num2.size(), the extra 1 space is for trailing '\0'
		Cstring result = new Cstring(num1.size() + num2.size() + 1, '\0');

		for (int i = 0; i < num1.size(); i++) {
			for (int j = 0; j < num2.size(); j++) {

				int prod = (num1.get(i) - '0') * (num2.get(j) - '0');
				Cstring prodCstring = new Cstring(prod + "");
				prodCstring.reverse();

				//loop runs at most one or two times
				for (int k = 0; k < prodCstring.size(); k++) {
					int val = (result.get(i + j + k) == '\0') ? prodCstring.get(k) - '0' : (result.get(i + j + k) - '0') + (prodCstring.get(k) - '0');
					result.set(i + j + k, (char) (val + '0'));

					// carry case
					int currentVal = (result.get(i + j + k) == '\0') ? 0 : result.get(i + j + k) - '0';
					if (currentVal > 9) {
						result.set(i + j + k, (char) (0 + '0'));
						Cstring curValCstring = new Cstring(currentVal + "");
						curValCstring.reverse();
						for (int l = 0; l < curValCstring.size(); l++) {
							int n = (result.get(i + j + k + l) == '\0') ? curValCstring.get(l) - '0' :  (result.get(i + j + k + l) - '0') + (curValCstring.get(l) - '0');
							result.set(i + j + k + l, (char) (n + '0'));
						}
					}
				}
			}
		}
		result.reverse();
		return new BigUnsignedNumber(result);
	}

	public static BigUnsignedNumber factorial(int num) {
		BigUnsignedNumber result = new BigUnsignedNumber();
		result.d = new Cstring();
		// by default set result as 1 (because 0! = 1)
		result.d.set(0, (char) (1 + '0'));
		result.d.set(1, '\0');

		for (int i = 2; i <= num; i++)
			result = result.mult(new BigUnsignedNumber(i));

		return result;
	}

	public boolean isEqual(BigUnsignedNumber num) {
		return d.isEqual(num.d);
	}

	public boolean isEqual(String s) {
		return d.isEqual(new Cstring(s));
	}

	public boolean isEqual(int num) {
		return isEqual(num + "");
	}

	public int size() {
		return d.size();
	}

public static void main(String[] args) {
	System.out.println('0');
	int x =0;
	System.out.println((char)x);
    System.out.println("BigUnsignedNumber.java");
    
    System.out.println("BigUnsignedNumber.java Done");
  }
}
