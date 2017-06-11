package Day4_normal;

public class Encapsulations {
	
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getagestatus(){
		
		return Agestatus();
	}
	
	
	private String Agestatus(){
		
		String status;
		if(age >18){
			status = "Major";
		}else{
			
			status = "Minor";
		}
		return status;		
		
	}

	
	
	
	
	
	

}
