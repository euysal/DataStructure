package homeworks;

/**
 * File Name: Maze.java 
 * 
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2017
 * 
 * To compile you require: IntUtil.java RandomInt.java Maze.java
 */

public class Maze {
  
  //ADD ONLY PRIVATE VARIABLES THAY YOU REQUIRE for the class
  private static IntUtil u = new IntUtil() ;
  private String[][] maze;
  private int[] position; // for [r,c]
  
  //WRITE CODE BELOW
  public Maze(int x, int y) {
	this.maze = new String[x][y];
	for(int i=0; i< x; i++){
		for(int j=0; j < y; j++){
			this.maze[i][j] = ".";
		}
	}
	this.position = new int[2];
	this.position[0] = 0;
	this.position[1] = 0;	
  }
  public void setWall(int p, int q){
	  this.maze[p][q] = "*";
  }
  
  public void draw(){
	  int x = this.maze.length;
	  int y = this.maze[0].length;
	  
	  System.out.print("  ");
	  for(int j=0; j< y; j++){
		  System.out.print(j);
	  }
	  System.out.println();
	  for(int i=x-1; i>= 0; i--){
		  System.out.print(i+" ");
		  for(int j=0; j < y; j++){
			System.out.print(this.maze[i][j]);
		  }
		  System.out.println();
		} 
	  System.out.print("  ");
	  for(int j=0; j< y; j++){
		  System.out.print(j);
	  }
	  System.out.println();
  }
  
  public boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    // only got here if we didn't return false
	    return true;
	}
  
  public boolean traversablePath(String s, int[] from, int[] to){
	  this.position[0] = from[0];
	  this.position[1] = from[1];
	  String[] path = s.split("");
	  int index=0;
	  while(index < path.length){
		  String direction = path[index];
		  index++;
		  String secondChar = path[index];
		  index++;
		  int steps = 0;
		  if(!isInteger(secondChar)){
			  direction += secondChar;
			  steps = Integer.parseInt(path[index]);
			  index++;
		  }
		  else{
			  steps = Integer.parseInt(secondChar);
		  }
		  
		  int[] currentPosition = this.position;
		  
		  for(int x=0; x < steps; x++){
			  switch(direction.toUpperCase()){
			  	case "N":
			  		this.position[0] += 1;
			  		break;
			  	case "S":
			  		this.position[0] -= 1;
			  		break;
			  	case "E":
			  		this.position[1] += 1;
			  		break;
				case "W":
					this.position[1] -= 1;
			  		break;
				case "NE":
					this.position[0] += 1;
					this.position[1] += 1;
			  		break;
				case "SE":
					this.position[0] -= 1;
					this.position[1] += 1;
			  		break;
			  	case "NW":
			  		this.position[0] += 1;
			  		this.position[1] -= 1;
			  		break;
				case "SW":
					this.position[0] -= 1;
					this.position[1] -= 1;
			  		break;
			  		
			  }

			  if(this.position[0] == -1 || this.position[1] == -1 
					  || this.position[0] >= this.maze.length || this.position[1] >= this.maze[0].length){
				  //out of bounds
				  return false;
			  }
			  if( this.maze[this.position[0]][this.position[1]] == "*"){
				  return false;
			  }
		  }
		  System.out.println("move "+ steps +" steps "+ direction +"   {"+ currentPosition[0]+","+currentPosition[1]+"} -> {"+ this.position[0]+","+this.position[1]+"}");
	  }
	  
	 
	  return true;
  }
  
  //CANNOT CHANGE ANYTHING BELOW
  //MUST WORK AS IS
  //ALL ASSERTIONS MUST PASS
  private boolean test1(int[] from, int[] to, String s) {
    boolean p = traversablePath(s,from,to) ;
    if (p == true) {
      System.out.println("{" + from[0] + "," + from[1] + "} " +   s + " move to " + "{" + to[0] + "," + to[1] + "} ");
    }else {
      System.out.println("move " + s + " not possible") ;
    } 
    return p ;
  }

  private static void test1() {
    Maze m = new Maze(3,4) ;
    m.setWall(2,3);
    m.setWall(1,1);
    m.setWall(0,1);
    m.draw();
    {
      int[] from = {0,0} ;
      int[] to = {-1,-1};
      String s = "N2e1E1n0s2e1" ;
      boolean p = m.test1(from,to,s) ;
      u.myassert(p == true);
    }
    {
      int[] from = {0,0} ;
      int[] to = {-1,-1};
      String s = "N2e3" ;
      boolean p = m.test1(from,to,s) ;
      //u.myassert(p == false);
    }

    {
      int[] from = {0,0} ;
      int[] to = {-1,-1};
      String s = "W1" ;
      boolean p = m.test1(from,to,s) ;
      //u.myassert(p == false);
    }

    {
      int[] from = {0,0} ;
      int[] to = {-1,-1};
      String s = "N3" ;
      boolean p = m.test1(from,to,s) ;  
      //u.myassert(p == false);
    }
  }

  private static void test2() {
    Maze m = new Maze(5,9) ;
    m.setWall(1,2);
    m.setWall(3,6);
    m.setWall(0,6);
    m.draw();
    {
      int[] from = {2,0} ;
      int[] to = {-1,-1};
      String s = "N2e1E1n0s2e1" ;
      boolean p = m.test1(from,to,s) ;
      u.myassert(p == true);
    }

  }

  private static void testBench() {
    test1() ;
    test2() ;

  }

  public static void main(String[] args) {
    System.out.println("Maze.java");
    testBench();
    System.out.println("DONE with Maze");
  }
}

/*

m.draw() MUST PRODUCE THIS OUTPUT
      0123
    2 ...*
    1 .*..
    0 .*..
      0123
      
 A POSSIBLE MOVE MUST PRODUCE OUTPUT LIKE THIS
 
move 2 steps N    {0,0} -> 2,0} 
move 1 steps e    {2,0} -> 2,1} 
move 1 steps E    {2,1} -> 2,2} 
move 0 steps n    {2,2} -> 2,2} 
move 2 steps s    {2,2} -> 0,2} 
move 1 steps e    {0,2} -> 0,3} 
{0,0} N2e1E1n0s2e1 move to {0,3} 

AN POSSIBLE MOVE MUST PRODUCE OUTPUT LIKE THIS
move 2 steps N    {0,0} -> 2,0} 
move 3 steps e    {2,0} -> 2,3} 
move N2e3 not possible


*/
