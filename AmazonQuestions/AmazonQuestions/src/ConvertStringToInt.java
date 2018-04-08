
public class ConvertStringToInt {
	
	static int final_value;
	static int curr_multiplier_value=1;
	
	public static void main(String[] args) {
		
		
		String num_to_convert="121231233";
		convertToInt(num_to_convert, num_to_convert.length());
		System.out.println(final_value);
		
	}
	
	private static  void convertToInt(String num_to_convert,int endindex){
		
		if(num_to_convert.length()<=0)
			return;
		String tempnum = num_to_convert.substring(0, endindex);
		if(tempnum.length()<=0){
			return;
		}
		char lastDigit = tempnum.charAt(tempnum.length()-1);
		int tempVal = curr_multiplier_value * (lastDigit - '0');
		final_value += tempVal;
		curr_multiplier_value = curr_multiplier_value *10;
		convertToInt(num_to_convert,--endindex);
		
	}
	
	private int getMultiplier(String num_to_convert){
		int ret=1;
		for(int i=0;i<num_to_convert.length()-1;i++){
			ret = ret *10;
		}
		return ret;
	}
}
