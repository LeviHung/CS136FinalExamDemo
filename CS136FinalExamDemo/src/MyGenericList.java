import java.lang.Comparable;

public class MyGenericList <T extends Comparable<T> >
{
  private class Node<T>
  {
  	T value;
    Node<T>  next;
  }     
     
  private Node<T> first = null;
  int count = 0;
   
  public void add(T element)
  {
    Node<T> newNode = new Node<T>();
    newNode.value = element;
	newNode.next = null;
    if (first == null) {
      first = newNode;

    } else {
      Node<T> lastNode = gotolastnode(first);
      lastNode.next = newNode;
    }
    count++;
  }

  public T get(int pos)
  {
    Node<T> nodePtr = first;
    int hopCount = 0;

    while (hopCount < count && hopCount < pos) {   
      if (nodePtr != null) {
        nodePtr = nodePtr.next;
      }
      hopCount++;
    }

    return nodePtr.value;
  }

  private Node<T> gotolastnode(Node<T> nodePointer)
  {
    if (nodePointer== null) {
      return nodePointer;

    } else {
      if (nodePointer.next == null) {
        return nodePointer;

      } else {
        return gotolastnode(nodePointer.next);
      }
    }
  }
  
  public void set(int pos, T element)
  {
    Node<T> nodePtr = first;
    int hopCount = 0;
    while (hopCount < count && hopCount < pos) {   
      if (nodePtr != null) {
        nodePtr = nodePtr.next;
      }
      hopCount++;
    }
    
    nodePtr.value = element;
  }

  public int size() 
  {
    return count;
  }
  
  public void delete(int pos)
  {
    if (pos < 0 || pos > count - 1) {
      throw new IndexOutOfBoundsException(pos);
	}

  	if (pos == 0) {
  	  if (count == 1) {
  		first = null;
  	  } else {
  		first = first.next;
  	  }

  	} else {
      Node<T> Nodeptr = first;
      for (int i = 0; i < pos - 1; i++) {
        Nodeptr = Nodeptr.next;
      }
							
      Nodeptr.next = Nodeptr.next.next;
  	}
  	
  	count--;
  }

  /*
   * sort method - use BubbleSort algorithm
   * @param isDesc the sorting order(true: descending; false: asecending)
   */
  public void sort(boolean isDesc) 
  {
    // The outer loop positions last at the last element to 
    // compare during each pass through the list.
    // Initially, last is the index of the last element in the list.
    // During each iteration, last is decreased by one.
    // The loop will find the largest numberr of the rest of the numbers.
    for (int last = count - 1; last > 0; last--) {
      Node<T> nodePtr  = first;
      Node<T> prevNode = null;
      // The inner loop steps through the list, 
      // and compares each element with its neighbor.
      // All of the elements from index 0 through last are 
      // involved in the comparsion.
      // If two elements are out of order, they are swapped.
      for (int i = 0; i < last; i++) {
        Node<T> currNode = nodePtr;
		Node<T> nextNode = nodePtr.next;
		boolean isSwap = false;
		
		if (isDesc == false && currNode.value.compareTo(nextNode.value) > 0) {
		  isSwap = true;

		} else if (isDesc == true && currNode.value.compareTo(nextNode.value) < 0) {
		  isSwap = true;
		}

		if (isSwap) {
          // Swap the two elements
          Node<T> tmp   = nextNode.next;
          nextNode.next = currNode;
          currNode.next = tmp;
  
          if (i == 0) {
            first = nextNode;
          } else {
            prevNode.next  = nextNode;
          }

          prevNode = nextNode;

		} else {
		  prevNode = nodePtr;
    	  nodePtr = nodePtr.next;
		}
      }
	}
  }
	
  /**
   * The toString method computes the string representation of the list.
   * @return The string form of the list.
   */
  public String toString()
  {
    StringBuilder strBuilder = new StringBuilder();
	 
    // Use p to walk down the linked list
    Node<T> p = first;
    while (p != null) {
	  strBuilder.append(p.value.toString() + "\n"); 
	  p = p.next;
	}      

    return strBuilder.toString(); 
  }
}

