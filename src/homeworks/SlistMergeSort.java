package homeworks;

/**
 * File Name: SlistMergeSort.java 
 * Sort int slist using Merge Sort
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */

/*
 * To compile you require: IntUtil.java RandomInt.java IntSlist2.java SlistSort.java SlistMergeSort.java
 */

class SlistMergeSort extends SlistSort{
  //You can add any number of private members to this class
  //You can add any number of private functions to this class
  // merge sort
  private node mergeSort(node head, boolean ascend){
	  if (head == null || head.next == null)
			return head; 
	  
	  int count = 0;
	  node n = head;
	  while (n != null) {
		count++;
		n = n.next;
	  }
		
	  int middle = count/2;
	  
	  node l = head, r= null;
	  node n2 = head;
	  int countHalf = 0;
	  while(n2 != null){
		countHalf++;
		node next = n2.next;
		if (countHalf == middle) {
			n2.next = null;
			r = next;
		}
		n2 = next;
	  }
	  
	  node h1 = mergeSort(l, ascend);
	  node h2 = mergeSort(r, ascend);
	  node merged = merge(h1, h2, ascend);
	  return merged;
  }
  private node merge(node l, node r, boolean ascend){
	  node p1 = l;
	  node p2 = r;

	  node fakeHead = new node(-1, -1);
	  node pNew = fakeHead;
	  while (p1 != null || p2 != null) {
		  if (p1 == null) {
				pNew.next = new node(p2.d, p2.t);
				p2 = p2.next;
				pNew = pNew.next;
			} else if (p2 == null) {
				pNew.next = new node(p1.d, p1.t);
				p1 = p1.next;
				pNew = pNew.next;
				} else {
					if (p1.d <= p2.d) {
						// if(fakeHead)
						pNew.next = new node(p1.d, p1.t);
						p1 = p1.next;
						pNew = pNew.next;
						}  else {
								pNew.next = new node(p2.d, p2.t);
								p2 = p2.next;
								pNew = pNew.next;
								}
					}
		  }

	// printList(fakeHead.next);
	return fakeHead.next;
  }

  @Override
  protected void sort(boolean ascend) {
    //WRITE CODE HERE
    //YOU CAN CALL ANY OF YOUR PRIVATE FUNCTION
	int len = this.a.size();
	if(len == 0)
		return;
	node n = mergeSort(this.a.first, ascend);
	this.a.first = n;
	
  }
  
  public static void main(String[] args) {
    System.out.println("SlistMergeSort.java");
    SlistMergeSort u = new SlistMergeSort() ;
    u.testBench();
    System.out.println("SlistMergeSort.java Done. You are genius");
  }
}


