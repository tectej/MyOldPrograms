import java.util.ArrayList;
import java.util.List;

//Write down program for following scenario.
//Use java coding standard. You have array list with some words in it..
//we will call it as dictionary….and you have a arbitrary string containing 
//some chars in it. You have to go through each word of dictionary 
//and find out if that word can be constructed with the 
//help of chars from arbitrary string given. 
//If you find the word print it else print none

public class DictionaryWord {
	public static void main(String args[]) {

		List<String> dictionary = new ArrayList<String>();
		dictionary.add("Red");
		dictionary.add("Blue");
		dictionary.add("Pink");
		dictionary.add("Yello");

		String letters = "iknP";

		boolean isNone = true;
		for (String word : dictionary) {
			boolean flag = true;
			for (Character c : word.toCharArray()) {
				if (!letters.contains(c.toString())) {
					flag = false;
					break;
				}
			}
			if (flag) {
				isNone = false;
				System.out.println(word);
			}
		}
		if (isNone)
			System.out.println("none");

	}

}