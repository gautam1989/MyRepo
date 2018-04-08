import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class VideoShots {
	
	
	
	
	public static void main(String[] args) {

		List<String> shotlist = new ArrayList<>();
		String l="o,a,b,a,b,c,b,a,c,a,d,e,f,e,g,d,e,h,i,j,h,k,l,i,j";
		for(String sp:l.split(","))
			shotlist.add(sp);
		
		Integer[] shots = shots(shotlist);
		for(int g:shots)
			System.out.println(g);
		
	}
	
	
	
	
	public static Integer[] shots(List<String> shotlist){
		
		Map<String,Integer[]> minmaxMap = new LinkedHashMap();
		for(int i =0;i<shotlist.size();i++){
			if(minmaxMap.containsKey(shotlist.get(i))){
				Integer[] cn = minmaxMap.get(shotlist.get(i));
				cn[1]=i;
				minmaxMap.put(shotlist.get(i), cn);
			}else{
				Integer[] cn = new Integer[2];
				cn[0]=i;
				cn[1]=i;
				minmaxMap.put(shotlist.get(i), cn);
			}
		}
		
		
		//merging the intervals
		List<Integer> shotspartitioned = new ArrayList<>();
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		Iterator it = minmaxMap.entrySet().iterator();
		int i=0;
		while(it.hasNext()){
			Map.Entry<String, Integer[]> ent = (Entry<String, Integer[]>) it.next();
			if(i==0){
				min = ent.getValue()[0];
				max = ent.getValue()[1];
				i++;
				continue;
			}
			
			
			if(ent.getValue()[0] > min && ent.getValue()[1] == -1){
				continue;
			}else if(ent.getValue()[0] > max && ent.getValue()[1] == -1){
				min = ent.getValue()[0];
				max = Integer.MIN_VALUE;
			}
			else if(ent.getValue()[0] > min && ent.getValue()[1] < max){
				continue;
			}
			else if(ent.getValue()[0]>max){
				shotspartitioned.add((max-min)+1);
				min =ent.getValue()[0];
				max=ent.getValue()[1];
			}else if(ent.getValue()[0] > min && ent.getValue()[1] > max){
				max =  ent.getValue()[1];
			}
			
			
			
			
			
		}
		
		int appendTolist = shotspartitioned.stream().mapToInt(f->f).sum();
		shotspartitioned.add(shotlist.size()-appendTolist);
		
		
		return  shotspartitioned.stream().toArray(Integer[]::new);
		
	}
	
	
}
