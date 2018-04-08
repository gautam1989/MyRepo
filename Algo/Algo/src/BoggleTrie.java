import java.util.HashMap;
import java.util.Map;

public class BoggleTrie {


	String dict[] = new String[]{"geeks", "for", "quiz", "go"};
	char boggle[][] = new char[][]{{'g','i','z'},
		{'u','o','k'},
		{'q','s','e'}};

		static int ROW = 3,COL=3;
		Map<Character,Character> firstcharmap = new HashMap<>();
		boolean[][] visited = new boolean[3][3];

		public static void main(String[] args) {

			BoggleTrie bt = new BoggleTrie();
			bt.firstcharmap = bt.buildCharMap();
			
			Trie t=new Trie();
			for(String s:bt.dict)
				t.insert(s);
			
			TrieN root =t.root;
			bt.countWords(bt.boggle, bt.visited, t, root);

		}
		
		
		public boolean isSafe(char boggle[][],boolean[][] visited,int i,int j,Trie t,TrieN node){
			
			return ( (i<ROW && i>-1) && (j<COL && j>-1) 
						&& (visited[i][j] ==false)
						&& (isPresentInTrie(boggle,visited,i,j,t,node))) ;
			
		}
		
		public boolean isPresentInTrie(char boggle[][],boolean[][] visited,int i,int j,Trie t,TrieN node){
			
			int index = boggle[i][j]-'a';
				if(node.charindex[index] == null){
					return false;
				}else{
					return true;
				}
			
		}
		
		
		
		public void findWords(char boggle[][],boolean[][] visited,int i,int j,Trie t,TrieN node){
			
			      if(isSafe(boggle, visited, i, j,t,node)){
			    	  System.out.print(boggle[i][j]);
			    	  	visited[i][j] = true;
			    	   
			    	  
			    	   node = node.charindex[boggle[i][j]-'a'];
			    		if(node.isEnd == true){
			    			System.out.println("FOUND") ; 
			    			return;
			    			}
			    	   
			    	   int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
			    	    int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};
			    	   
			    	   for(int k=0;k<8;k++){
			    		   //visited=new boolean[3][3];
			    		   //visited[i][j]=true;
			    			   findWords(boggle, visited, i+rowNbr[k], j+colNbr[k], t, node);
			    	   }
			      }else{
			    	  return;
			      }
			
		}
		
		
		public void countWords(char boggle[][],boolean[][] visited,Trie t,TrieN node){
			
			for(int i=0;i<ROW;i++){
				for(int j=0;j<COL;j++){
					if( firstcharmap.get(boggle[i][j])!=null && visited[i][j]==false )
						visited=new boolean[3][3];
						
						findWords(boggle, visited, i, j,t,node);
				}
			}
			
		}
		
		
		public Map<Character,Character> buildCharMap(){
			Map<Character,Character> firstcharmap = new HashMap<>();
			for(String s:dict){
				firstcharmap.put(s.charAt(0), s.charAt(0));
			}
			return firstcharmap;
		}
}
