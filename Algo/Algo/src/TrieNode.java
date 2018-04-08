import java.util.HashMap;
import java.util.Map;

class TrieN2{
	Map<Character,TrieN2> charmap = new HashMap<>();
	boolean isLast;
	
	
}




public class TrieNode {

	static TrieN2 root = new TrieN2();
	static TrieN2 currentNode;

	static void insert(String word){

		//int i=0;
//		for(char c:word.toCharArray()){
//			i++;
//			insert(c,currentNode,word.length(),i);
//		}
		
		TrieN2 current = root;
		for(int i=0;i<word.length();i++){
			
			if(!current.charmap.containsKey(word.charAt(i))){
				TrieN2 tr = new TrieN2();
				current.charmap.put(word.charAt(i),tr);
				current = tr;
			}else{
				current = current.charmap.get(word.charAt(i));
			}
			
			
		}
		
		current.isLast = true;
		

	}


	static void insert(char c,TrieN2 node, int length, int curr){

		if(node == null){
			root = new TrieN2();
			root.charmap.put(c, root);
			node = root;
		}else{
		
			if(!node.charmap.containsKey(c)){
				TrieN2 newNode = new TrieN2();newNode.charmap.put(c, newNode);
				node.charmap.put(c, newNode);
			}else{
				currentNode=node.charmap.get(c);
				insert(c,currentNode,length,curr);
			}
			
		}
		
		if(length==curr){
			node.isLast=true;
		}
		currentNode=node;
		
		
	}


	public static void main(String[] args) {
			insert("abc");
	}




}
