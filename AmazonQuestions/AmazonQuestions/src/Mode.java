
public class Mode {
public static void main(String[] args) {
	
	 int val=0;
	 int count=1;
	int a[]={1,2,3,4,5,6,6,0};
	MergeSort ms=new MergeSort();
	ms.start(a);
	print(a);
	returnMode(a);
	
	
}


static void returnMode(int a[]){
	int currhighest=1;
	int lasthighest=1,count=1,val=0;
	for(int i=0;i<a.length;i++){
		int p=i-1;
		if(p >=0){
			if(a[i]==a[p]){
				currhighest++;
				if(currhighest > lasthighest){
					lasthighest = currhighest;
					val=a[i];
				}
			}else{
				if(currhighest > lasthighest){
					lasthighest = currhighest;
					val=a[i];
				}
				currhighest=1;
				
			}
		}
	}
	count =lasthighest;
	System.out.println(lasthighest+":"+val);
}
static void print(int a[]){
	for(int b:a)
		System.out.println(b);
}

}
