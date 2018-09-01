/*Array List Vs Linked List

We know that Both ArrayList and Linked List implements List interface. 
Both are ordered and unsorted Collection. Both can be accessed using an index.Both have add and get method for adding and Retrieving elements. Mostly they are similar so why two collections when they are mostly similar in function?? The change is how elements are stored in the two collection classes.

class Node : Prev -- Item--Next


ArrayList uses Object array in background to store elements and Linked List uses similar structure which we have used in c , c++ languages like a node containing previous address and Next nodes address and the value of data stored in that node.

ArrayList is faster for retrieving elements as element can be fetched directly from array.
But For Linked List starting from root node , every element will be checked till it reaches to the element at specified index.

Linked List is faster when removing an element because , when you remove an element from Linked List simply , the next node field of previous node will store address of next node and previous node field of next node will store address of previous node so just addresses will be adjusted but when you delete an element from an Array List indexes of all the elements will be subtracted wil value 1 .So suppose if an ArrayList contain 50000 elements , and you delete an element at position 2000 , All the indexes of below elements will be subtracted with value 1 ( will be moved one position up in Array) so this takes significant amount of time when compared to time taken by Linked List.

So Array List should be used when you want to do frequent access of elements and Less removal or insertion of elements and Linked List should be used when you want to perform frequent Insertion or Deletion operation than accessing the elements. To get clear understanding of this you can study output of below program where time for removal and access for both ArrayList and Linked List is printed.
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedList {

public static void main(String[] args) throws Exception {
List<Integer> ar = new ArrayList<>();
List<Integer> ll = new LinkedList<>();


int i=0;

System.out.println("// Time to Insert elements - Almost equal for Both ArrayList and Linked List");
System.out.println();
long beforeInsertTimeAL = System.nanoTime();

for (i = 0; i < 127440; i++) {
ar.add(i);
}

long timeAfterAddingAL = System.nanoTime();

long timeToAddInAL = timeAfterAddingAL - beforeInsertTimeAL;

System.gc();

long beforeInsertTimeLL = System.nanoTime();

for (i = 0; i < 127441; i++) {
ll.add(i);
}

long timeAfterAddingLL = System.nanoTime();

long timeToAddInLL = timeAfterAddingLL - beforeInsertTimeLL;

System.out.println("Array List Insert Time "+timeToAddInAL);
System.out.println("Linked List Insert Time :"+timeToAddInLL);

System.out.println();
System.out.println("// Time to Remove an element - ArrayList takes more time");

System.out.println();

long beforeRemoveTimeAL = System.nanoTime();

for(int j=55;j<555;j++)
ar.remove(j);

long timeAfterRemoveAL = System.nanoTime();


System.out.println("Time to remove an element in ArrayList: "+(timeAfterRemoveAL-beforeRemoveTimeAL));

long beforeRemoveTimeLL = System.nanoTime();

for(int j=55;j<555;j++)
ll.remove(j);

long timeAfterRemoveLL = System.nanoTime();

System.out.println("Time to remove an element in LinkedList: "+(timeAfterRemoveLL-beforeRemoveTimeLL));

System.out.println();
System.out.println("// Access Time - Linked List takes more time");
long beforeAccessTimeAL = System.nanoTime();

for(int j=556;j<1056;j++)
ar.get(j);

long timeAfterAccessAL = System.nanoTime();

System.out.println("Time to access an element in ArrayList: "+(timeAfterAccessAL-beforeAccessTimeAL));


long beforeAccessTimeLL = System.nanoTime();

for(int j=556;j<1056;j++)
ll.get(j);

long timeAfterAccessLL = System.nanoTime();

System.out.println("Time to Access an element in LinkedList: "+(timeAfterAccessLL-beforeAccessTimeLL));

}
}