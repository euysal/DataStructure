package homeworks;
/**
 * File Name: Cstring.java 
 * Implements C String
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */
/*
 * To compile you require: CharArray.java, IntUtil.java RandomInt.java Cstring.java
 */

class Cstring {
  private CharArray d; //Infinite array of char
  static IntUtil u = new IntUtil();
  //YOU CANNOT add any data members
  //YOU CAN add any public or private function so that all the tests will pass
  
  public Cstring() {
	d = new CharArray();
	d.set(0, '\0');
  }
  public Cstring(String str) {
	  d=new CharArray();
	  char[] str_chars = str.toCharArray();
	  int i;
	  for(i =0; i< str.length(); i++){
		  d.set(i, str_chars[i]);  
	  }
	  d.set(i, '\0');
  }
  public Cstring(char chr) {
		d=new CharArray();
		d.set(0,chr);
		d.set(1, '\0');
	}
  public int length(){
	  int i=0;
	  while(this.d.get(i) != '\0'){
			 i++;
		 }
	  return i;
  }

  public Cstring(int size, char c) {
		d = new CharArray(size);
		for (int i = 0; i < size; ++i) {
			d.set(i, c);
		}
	}

  public void pLn(String printStr){
	 int i=0;
	 char chr =  d.get(i);
	 System.out.print(printStr);
	 while(chr != '\0'){
		 System.out.print(chr);
		 i++;
		 chr = d.get(i);
	 }
	 System.out.println();
  }
  public Cstring clone(){
	  Cstring clone = new Cstring();
	  clone.d = this.d;
	  return clone;
  }
  public void reverse(){
	  int head=0;
	  int tail= this.length()-1;
	  while(head < tail){
		  char temp;
		  temp = d.get(tail);
		  d.set(tail, d.get(head));
		  d.set(head, temp);
		  head++;
		  tail--;
	  }
  }
  public Cstring add(Cstring secondCstring){
	  Cstring concatString = new Cstring();
	  int len = this.length();
	  int pointer;
	  for( pointer=0; pointer< len; pointer++){
		  concatString.d.set(pointer, this.d.get(pointer));
	  }
	  
	  int i=0;
	  char chr;
	  do{
		  chr = secondCstring.d.get(i);
		  concatString.d.set(pointer,chr);
		  i++;
		  pointer++;
		 }while(chr != '\0');
	  return concatString;
  }
  public Cstring add(String secondString){
	  Cstring concatString = new Cstring();
	  int len = this.length();
	  int pointer;
	  for( pointer=0; pointer< len; pointer++){
		  concatString.d.set(pointer, this.d.get(pointer));
	  }
	  
	  char[] str_chars = secondString.toCharArray();
	  int i;
	  for (i=0; i< str_chars.length; i++){
		  concatString.d.set(pointer,str_chars[i]);
		  pointer++;
	  }
	  concatString.d.set(pointer+1,'\0');
	  return concatString;
  }
  public void append(Cstring secondCstring){
	  int pointer = this.length();
	  
	  int i=0;
	  char chr;
	  do{
		  chr = secondCstring.d.get(i);
		  this.d.set(pointer,chr);
		  i++;
		  pointer++;
		 }while(chr != '\0');
  }
  public void append(String secondString){
	  int pointer = this.length();
	  char[] str_chars = secondString.toCharArray();
	  int i;
	  for (i=0; i< str_chars.length; i++){
		  this.d.set(pointer,str_chars[i]);
		  pointer++;
	  }
	  this.d.set(pointer+1,'\0');
  }
  public boolean isEqual(Cstring secondCstring){
	  int len1 = this.length();
	  int len2 = secondCstring.length();
	  if(len1 != len2){
		  return false;
	  }
	  for(int i=0; i< len1; i++){
		  if(this.d.get(i) != secondCstring.d.get(i)){
			  return false;
		  }
	  }
	  
	  return true;
	  
  }
  
  public char get(int index){
	return this.d.get(index);  
  }
  public void set(int pos, char val) {
		this.d.set(pos, val);
  }
  
    
  
 
 //NOTHING CAN BE CHANGED BELOW. EVERYTHING MUST WORK AS IS
  private static void testBasic() {
    Cstring a = new Cstring('b') ;
    a.pLn("a = ") ;
    Cstring b = new Cstring('7') ;
    b.pLn("b = ") ;
    Cstring c = new Cstring("123456789012345678901234567890123456789012345678901234567890") ;
    c.pLn("c = ") ;
    Cstring d = c.clone() ;
    d.pLn("d = ") ;
    Cstring e = new Cstring("A quick brown fox junped over a lazy dog") ;
    e.pLn("e = ") ;
    Cstring f = new Cstring("Gateman sees name garageman sees nametag") ;
    f.pLn("f =  ") ;
    f.reverse() ;
    f.pLn("f' = ") ;
  }
  
  private static void testAdd() {
    Cstring a = new Cstring("UCSC") ;
    Cstring b = new Cstring("Extension") ;
    Cstring c = a.add(b) ;
    a.pLn("a = ") ;
    b.pLn("b = ") ;
    c.pLn("c = ") ;
    Cstring d = c.add("USA") ;
    d.pLn("d = ") ;
    a.append(b) ;
    a.pLn("a+b = ") ;
    a.append("World") ;
    a.pLn("a+b+World = ") ;
  }
  
  private static void testEqual() {
    Cstring a = new Cstring("123456789012345678901234567890123456789012345678901234567890") ;
    a.pLn("a = ") ;
    Cstring b = new Cstring("123456789012345678901234567890123456789012345678901234567890") ;
    b.pLn("b = ") ;
    u.myassert(a.isEqual(b)) ;
    Cstring c = new Cstring("12345678901234567890123456789012345678901234567890123456789") ;
    c.pLn("c = ") ;
    u.myassert(a.isEqual(c) == false) ;
  }
  
  private static void testBench() {
    System.out.println("-----------Basic----------------");
    testBasic() ;
    System.out.println("-----------Addition----------------");
    testAdd() ;
    System.out.println("-----------Equal----------------");
    testEqual() ;
  }
  
  public static void main(String[] args) {
    System.out.println("Cstring.java");
    testBench();
    System.out.println("Cstring.java Done");
  }
  public int size() {
		return this.length();
	}
  
}