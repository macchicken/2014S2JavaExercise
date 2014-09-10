package tutorial;

import java.util.ArrayList;

public class Text {

	private ArrayList<String> text;

	public Text(int capacity) {
		this.text = new ArrayList<String>(capacity);
	}

	public ArrayList<String> getText() {
		return text;
	}
	
	public boolean addWord(String word){
		return text.add(word);
	}
	
	public void search(String word){
		int i=0;
		for (String str:text){
			if (str.equals(word)){System.out.println(word+" occurs at positon "+(i+1));}
			i++;
		}
	}

	public void searchByIndex(int[] index){
		for (int i:index){
			try {
				System.out.println(text.get(i));
			} catch (IndexOutOfBoundsException e) {
				System.out.println("no word at this positon "+i);
			}
		}
	}
}
