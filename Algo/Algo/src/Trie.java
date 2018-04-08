import java.util.LinkedList;
import java.util.List;

class TrieN{
	TrieN [] charindex=new TrieN[26];
	List<Integer> indexlist= new LinkedList<>();
	boolean isEnd;
}

public class Trie {

	TrieN root = new TrieN();
	static int ori_index=0;
	public void insert(String word){
		TrieN node = root;
		for(int i=0;i<word.length();i++){
			
				int index =  Math.abs(word.charAt(i) - 'a');
				if(node.charindex[index]==null){
					node.charindex[index]=new TrieN();
					node.indexlist.add(ori_index++);
					node = node.charindex[index]; 
				}else{
					node.indexlist.add(ori_index++);
					node = node.charindex[index];
					
				}
		
		}
		node.isEnd = true;
	}


	public boolean search(String word){
		TrieN node = root;
		for(int i=0;i<word.length();i++){
			int index = Math.abs(word.charAt(i) - 'a');
			if(node.charindex[index]!=null){
				System.out.println(word.charAt(i)+" "+node.indexlist);
				node = node.charindex[index];
			}else if(node.charindex[index]==null){
				return false;
			}
		}
		if(node.isEnd == true){
			return true;
		}
		return false;
	}


	public void delete(TrieN node,String word,int i){


		if(node.isEnd == true){
			return;
		}

		if( i < word.length()-1){
			int index = Math.abs(word.charAt(i) - 'a');
			if(node.charindex[index]!=null){
				delete( node.charindex[index],word,i+1);

				if(false == findChildrenIndexs(node,index)){
					node.charindex[index] = null;
				}

			}else if(node.charindex[index]==null){
				System.out.println("Word not found"); 
				System.exit(1);
			}
		}


	}







	public boolean findChildrenIndexs(TrieN node,int index){
		boolean ret = false;
		for(int i=0;i<26;i++){
			if(i!=index){
				if(node.charindex[i] !=null){
					ret = true;
					return ret;
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {

		/*System.out.println('a'-'a');
		System.out.println('z'-'a');

		System.out.println('A'-'A');
		System.out.println('Z'-'A');*/


		Trie t = new Trie();
		String s[] = "geeks for geeks".split(" ");
		for(int i=0;i<s.length;i++){
			t.insert(s[i]);
			ori_index++;
		}
		

		System.out.println(t.search("geeks"));
		//t.insert("verma");

		/*System.out.println(t.search("gautam"));
		System.out.println(t.search("gautams"));
		TrieN node = t.root;
		t.delete(node, "gautam", 0);
		System.out.println("After delete");
		System.out.println(t.search("gautam"));
		System.out.println(t.search("gautams"));*/


	}



}
