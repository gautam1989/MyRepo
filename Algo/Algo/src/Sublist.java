import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Sublist {
	public static void main(String[] args) {

		List<String> targetList =new ArrayList<>();
		targetList.add("in");
		targetList.add("the");
		targetList.add("spain");

		List<String> avbList =new ArrayList<>();
		avbList.add("made");
		avbList.add("the");
		avbList.add("spain");
		avbList.add("that");
		avbList.add("in");
		
		avbList.add("the");
		avbList.add("rain");
		avbList.add("in");
		avbList.add("spain");
		avbList.add("stays");
		avbList.add("forecast");
		avbList.add("in");
		avbList.add("the");
		avbList.add("stays");

		;
		
		for(int g:subSequenceTags2(targetList, avbList)){
			System.out.print(g);
		}
	}


	static List<Integer>  subSequenceTags2(List<String> targetList,List<String> availableList){
		
		if(availableList.isEmpty()){
			List<Integer> newl = new ArrayList<>();
			newl.add(0);
			return newl;
		}

		Map<Integer,String> tempmap = new HashMap();	
		Queue<String> runQ = new ArrayDeque<>();
		List<Integer[]> indexlist = new ArrayList<>();
		int i=0;
		for(String s:availableList){

			if(!add(s, runQ,targetList,i)){
				i++;
				continue;
			}

			if( runQ.size()>1 && runQ.peek().split("-")[0].equals(s.split("-")[0])){
				tempmap.remove(Integer.parseInt(runQ.peek().split("-")[1]));
				runQ.poll();
			}

			tempmap.put(i, s);

			if(allitemspresent(tempmap,targetList)){
				Integer[] minmax = findmaxminindex(tempmap,targetList);
				indexlist.add(minmax);
			}

			i++;

		}


		Integer[] finalList = removeUnnecassary(indexlist,targetList,availableList);

		


		List<Integer> newl = new ArrayList<>();

		if(null!=finalList && finalList.length>=1){
			newl.add(finalList[0]);newl.add(finalList[finalList.length-1]);
		}
		else{
			newl.add(0);
		}
		return newl;



	}



	private static boolean add(String s,Queue<String> runQ, List<String> targetList,int i){
		if(targetList.contains(s)){
			runQ.add(s+"-"+i);
			return true;
		}
		return false;

	}

	private static Integer[] removeUnnecassary(List<Integer[]> indexlist, List<String> targetList,
			List<String> availableList) {
		Map<Integer,List<Integer[]>> indexMap = new HashMap<>();

		for(int i=0;i<indexlist.size();i++){
			Integer[] val = indexlist.get(i);
			int value = val[val.length-1]-val[0];
			if(indexMap.containsKey(value)){
				indexMap.get(value).add(val);
			}else{
				List<Integer[]> newList= new ArrayList<>();
				newList.add(val);
				indexMap.put(value,newList);
			}
		}
		
		if(indexMap.size()==0){
			return null;
		}

		int minindexmap=indexMap.keySet().stream().mapToInt(f->f).min().getAsInt();
		Integer[] finalList = indexMap.get(minindexmap).get(0);
		return finalList;

	}


	private static Integer[] findmaxminindex(Map<Integer, String> tempmap, List<String> targetList) {

		Map<String,String> ttmap = new HashMap<>();
		int count=targetList.size();
		int max=-1;
		int min=-1;
		ArrayList<Integer> keys = new ArrayList<Integer>(tempmap.keySet());
		for(int i=keys.size()-1; i>=0;i--){

			if(targetList.contains(tempmap.get(keys.get(i)))){

				if(ttmap.containsKey(tempmap.get(keys.get(i))) ){
				
				}else{
					ttmap.put(tempmap.get(keys.get(i)), tempmap.get(keys.get(i)));
					if(max==-1)
						max = keys.get(i);
					count--;
				}

				if(count==0){
					min = keys.get(i);
					break;
				}
			}

		}

		return new Integer[]{min,max};
	}


	private static boolean allitemspresent(Map<Integer, String> tempmap, List<String> targetList) {




		for(String s:targetList){
			if(!tempmap.containsValue(s))
				return false;
		}


		return true;
	}



	public static void print(int[][]a,int r,int c){
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}


}
