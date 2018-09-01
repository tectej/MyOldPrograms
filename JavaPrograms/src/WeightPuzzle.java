//Problem statement: Family Patel is moving from Mumbai to Delhi. They have 20 boxes to move. The insurance cost is calculated by multiplying weight of each box by 2 and by multiplying weight of the heaviest box by 3. The weights of boxes are (20,10,5,40,20,41,41,2,6,7,3,4,5,6,23,34,7,8,9,2). Calculate and print insurance cost.

//Constraints: 
//Use only single for loop. 
//No inbuilt methods like Arrays.sort() , Collections.sort() or TreeSet() or anything alike. Just use single for loop.

import java.util.HashMap;
import java.util.Map;

public class WeightPuzzle {
public static void main(String[] args) {
System.out.println(insuranceCalculator());
}

public static int insuranceCalculator() {

int[] weights = new int[] { 20, 10, 5, 40, 20, 41, 41, 2, 6, 7, 3, 4,
5, 6, 23, 34, 7, 8, 9, 2 };
int temp = weights[0];
int insurance = 0;

Map<Integer,Integer> map = new HashMap<Integer,Integer>();

for (int i = 0; i < weights.length; i++) {
int next = i + 1;
if (next < weights.length) { 
temp = (temp > weights[next] ? temp : weights[next]);
}
Integer old = 0;
if((old=map.put(weights[i], 1))!=null){
map.put(weights[i], ++old);
}
insurance += weights[i] * 2 ;
}
return insurance + temp*map.get(temp);
}
}