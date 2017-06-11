package Day6;

public class Staticmandv {
	
	static int a =10;
	int b = 40;
	int c = 60;
	
	Staticmandv(){
		
		a++;
		System.out.println("a: " + a);
		b++;
		System.out.println("b: " + b);
		c++;
		System.out.println("c: " + c);
		
		
	}
	
	
	public static void add(){
		System.out.println(a+10);
	}
	
	

}
