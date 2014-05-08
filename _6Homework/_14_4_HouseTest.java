package _6Homework;

public class _14_4_HouseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_14_4_House house1 = new _14_4_House(1,1750.50);
		try{
			_14_4_House house2 =  (_14_4_House)house1.clone();
			System.out.print("house1 == house2  ");
			System.out.println(house1 == house2);
			System.out.print("house1.whenBuilt == house2.whenBuilt   ");
			System.out.println(house1.getWhenBuilt() == house2.getWhenBuilt());
		}catch(CloneNotSupportedException e){
			System.out.println("Clone Not Supported Exception");
		}
		
	}

}
