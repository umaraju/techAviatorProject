package Day3_AccessModifier;

public class insidepackage {
	
	
	public static void main(String[] args) {
	Accessmodifiers ac = new Accessmodifiers();
//	variable	
		System.out.println(ac.pub);
//		System.out.println(ac.pri);
		System.out.println(ac.def);
		System.out.println(ac.pro);
		
//		methods
		ac.pubmethod();
//		ac.primethod();
		ac.defmethod();
		ac.promethod();
		
		
		
	}

}
