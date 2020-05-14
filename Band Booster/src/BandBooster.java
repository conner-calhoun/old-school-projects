//**********************************************************************
// Conner Calhoun
// 
// Lab 4 BandBooster.java
//
// Methods used in BandSales.
//**********************************************************************

public class BandBooster
{
	private String name; // name of student
	int boxesSold; // number of boxes of candy sold
	
	public BandBooster (String newName)
	{
		name = newName;
		boxesSold = 0;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int updateSales(int boxes)
	{
		boxesSold = boxesSold + boxes;
		return boxesSold;
	}
	
	public String toString()
	{
		return name + ": " + boxesSold;
		
	}
	
}
