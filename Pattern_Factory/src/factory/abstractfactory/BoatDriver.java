package factory.abstractfactory;

public class BoatDriver {
	
	public Boat drive(String boatName) throws Exception{
		if( boatName.equals("Steamer") ){
			return new Steamer();
		}else if( boatName.equals("Caique") ){
			return new Caique();
		}else{
			throw new Exception("没有这样的船.");
		}
	}

}
