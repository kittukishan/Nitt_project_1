package site.demo.formula;

public class Idgen {
 
	private String value;
	
	
	public String generate(String max,String idtype){
	
		String s1=max.substring(2);
		System.out.println("first"+s1);
		String s2=max.substring(0,2);
		System.out.println("second"+s2);
		int i1=Integer.parseInt(s1);
		i1=i1+1;
		System.out.println("integer first"+i1);
		 value=s2+i1;
		System.out.println(value);
		
		return value;	
	}
	
}
