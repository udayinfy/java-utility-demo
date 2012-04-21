package common.hibernate;



public class UUIDUtil {
	
	public static void main(String[] args) {
		int generateUUID = generateUUID();
		System.out.println(generateUUID);
	}
	
	
	public static int generateUUID(){
		return (int) (Math.random() * Integer.MAX_VALUE );
	}

}
