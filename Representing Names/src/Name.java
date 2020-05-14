// **************************************************************
// Conner Calhoun
// 
// Name.java
// Class file to be used by TestNames.java
// **************************************************************
public class Name

{
	// Instance variables
    String firstName;
	String middleName;
    String lastName;

//----------------------------------------------------------------
// Constructor - sets up a full name given the first, middle, and
// last names.   
//----------------------------------------------------------------
    
	public Name (String first, String middle, String last)
	{
	firstName = first;
	middleName = middle;
	lastName = last;
    }

   
//----------------------------------------------------------------
// Returns the first name.    
//----------------------------------------------------------------
    
	public String getFirst()    
	{
	return firstName;
    }    
	
//----------------------------------------------------------------    
// Returns the middle name.   
//----------------------------------------------------------------   
	public String getMiddle()   
	{
	return middleName;
    }
    
//----------------------------------------------------------------   
// Returns the last name.    
//----------------------------------------------------------------
	public String getLast()
	{
	return lastName;
    }

//----------------------------------------------------------------    
// Returns the full name in order.    
//----------------------------------------------------------------    
	public String firstMiddleLast()  
	{
	return firstName + " " + middleName + " " + lastName;
    }

//----------------------------------------------------------------    
// Returns the full name in the order last, first middle    
//----------------------------------------------------------------  
	public String lastFirstMiddle()  
	{
	return lastName + " " + firstName + " " + middleName;
    }

//----------------------------------------------------------------    
// Returns true if this name is the same as otherName.
//----------------------------------------------------------------
	public boolean equals (Name otherName)
	{
	return (this.firstMiddleLast()).equalsIgnoreCase(otherName.firstMiddleLast());
    }

//-----------------------------------------------------------------    
// Returns the person's initials.
//-----------------------------------------------------------------
	public String initials()
	{
	String firstLetters;
	
		firstLetters = firstName.substring(0,1) + middleName.substring(0,1) +
	
		    lastName.substring(0,1);
	
		return firstLetters.toUpperCase();
    
	}
	
//------------------------------------------------------------------   
// Returns the number of characters in the full name (not including   
// spaces).    
//------------------------------------------------------------------ 
	public int length()
	{
	return firstName.length() + middleName.length() + lastName.length();
    }
}

