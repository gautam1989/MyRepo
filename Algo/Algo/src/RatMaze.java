
public class RatMaze {

	static final int ROW = 4, COL = 4;



	static boolean  isSafe(int M[][], int row, int col,
			boolean visited[][])
	{
		return (row >= 0) && (row < ROW) &&
				(col >= 0) && (col < COL) &&
				(M[row][col]==1 && !visited[row][col]);
	}

	public static void DFS(int M[][],boolean visited[][],int row,int col){

		int rowNbr[] = new int[] {1,0};
		int colNbr[] = new int[] {0,1};

		visited[row][col]=true;
		
		if(visited[ROW-1][COL-1]){
			return;
		}
			

		for(int k=0;k<2;k++){
			if(isSafe(M, row+rowNbr[k], col+colNbr[k], visited)){
				DFS(M, visited, row+rowNbr[k], col+colNbr[k]);
			}
		}

	}

	public static void runRat(int M[][]){

		boolean [][]visited = new boolean[ROW][COL];

		for(int i=0;i<ROW;i++){
			for(int j=0;j<COL;j++){
				if(!visited[i][j] && M[i][j]==1 ){
					DFS(M,visited,i,j);
				}
			}
		}
		
		if(visited[ROW-1][COL-1]){
			System.out.println("RAT IS ALIVE");
			return;
		}
			

	}

	public static void main (String[] args) throws java.lang.Exception
	{
		int M[][]=  new int[][] {{1, 0, 0, 0},
			{1, 1, 0, 1},
			{0, 1, 0, 0},
			{1, 1, 1, 0},
		};
		RatMaze rm = new RatMaze();
		rm.runRat(M);
		
		

	}
}
