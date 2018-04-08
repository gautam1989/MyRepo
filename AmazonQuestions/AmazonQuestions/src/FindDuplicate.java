
public class FindDuplicate {
	void printRepeating(int arr[], int size)
    {
        int i;  
        System.out.println("The repeating elements are : ");
    
        for (i = 0; i < size; i++)
        {
            if (arr[Math.abs(arr[i])] >= 0)
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else
                System.out.print(Math.abs(arr[i]) + " ");
        }         
    } 
 
    /* Driver program to test the above function */
    public static void main(String[] args) 
    {
        FindDuplicate duplicate = new FindDuplicate();
        int arr[] = {1,2,3,2,1};
        int arr_size = arr.length;
        duplicate.printRepeating(arr, arr_size);
    }
    
    void print(int a[]){
    	for(int g:a)
    		System.out.print(g+" ");
    		
    	System.out.println();
    }
}
