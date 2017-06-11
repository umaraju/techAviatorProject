package outsidepackage;

import Day3_AccessModifier.Accessmodifiers;

public class Extendclass extends Accessmodifiers {
	public static void main(String[] args) {
		
		
		Extendclass ac = new Extendclass();
//	variable	
		System.out.println(ac.pub);
//		System.out.println(ac.pri);
//		System.out.println(ac.def);
		System.out.println(ac.pro);
		
//		methods
		ac.pubmethod();
//		ac.primethod();
//		ac.defmethod();
		ac.promethod();
		
		
		
	}
	
	
	
	
	
	

}
