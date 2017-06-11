package Day3_AccessModifier;

public class Accessmodifiers {
	
	public String pub = "public";
	private String pri = "private";
	 String def = "default";
	protected String pro = "protected";
	
	
	public void pubmethod(){
		System.out.println("this is a public method");
	}
	
	
	private void primethod(){
		System.out.println("this is a private method");
	}
	
	
	void defmethod(){
		System.out.println("this is a default method");
	}
	
	
	protected void promethod(){
		System.out.println("this is a protected method");
	}
	
	
	
	
	
//	public static void main(String[] args) {
//	Accessmodifiers ac = new Accessmodifiers();
////	variable	
//		System.out.println(ac.pub);
//		System.out.println(ac.pri);
//		System.out.println(ac.def);
//		System.out.println(ac.pro);
//		
////		methods
//		ac.pubmethod();
//		ac.primethod();
//		ac.defmethod();
//		ac.promethod();
//		
//		
//		
//	}

}










