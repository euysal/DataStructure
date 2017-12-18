package homeworks;


/**
 * File Name: SlistQuickSort 
 * Sort int slist using Quick Sort
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */

/*
 * To compile you require: IntUtil.java RandomInt.java IntSlist2.java SlistSort.java SlistQuickSort.java
 */

class SlistQuickSort extends SlistSort{
	//You can add any number of private members to this class
	//You can add any number of private functions to this class
	private class Result{
		  node newHead = null;
		  node newTail = null;
		  node pivot = null;
		}

		private node quickSort(node head, node tail){
		    if(head == null || head.next == null || head == tail)
		        return head;
		    
		    Result r = new Result();
		    r = partition(head, tail, r);
		    node pivot = r.pivot;
		    if(r.newHead != null){
		      node firstTail = findTail(r.newHead, pivot);
		      quickSort(r.newHead, firstTail);
		    }
		    quickSort(pivot.next, r.newTail);
		    return r.newHead;
		}

		private Result partition(node head, node tail, Result r){
		    node pivot = tail;
		    node pre = null;
		    node cur = head;
		    while(cur != pivot){
		        if(cur.d < pivot.d){
		            if(r.newHead == null)
		                r.newHead = cur;
		            pre = cur;
		            cur = cur.next;
		        }
		        else{
		            if(pre != null){
		                pre.next = cur.next;
		            }
		            node temp = cur.next;
		            if(r.newTail == null){
		              cur.next = pivot.next;
		                pivot.next = cur;
		            } else{
		              cur.next = r.newTail.next;
		                r.newTail.next = cur;
		            }
		            r.newTail = cur;
		            cur = temp;  
		        }
		    }
		    r.pivot = pivot;
		    return r;
		}

		private static node findTail(node head){
		    node cur = head;
		    while(cur.next != null)
		        cur = cur.next;
		    return cur;
		}

		private static node findTail(node head, node pivot){
		    node cur = head;
		    while(cur.next != pivot)
		        cur = cur.next;
		    return cur;
		}
  @Override
  protected void sort(boolean ascend) { 
    //WRITE CODE HERE
    //YOU CAN CALL ANY OF YOUR PRIVATE FUNCTION
	  if(this.a.first == null)
		  return;
	  node head = this.a.first;
	  node tail = findTail(this.a.first);
	  node result = quickSort(head, tail);
	  
	  System.out.println("----");
  }

  public static void main(String[] args) {
    System.out.println("SlistQuickSort.java");
    SlistQuickSort u = new SlistQuickSort() ;
    u.testBench();
    System.out.println("SlistQuickSort.java done. You are great!");
  }

}