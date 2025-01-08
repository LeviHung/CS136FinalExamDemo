import java.lang.Comparable;

/**
 * Student Class
 */
public class Student implements Comparable<Student>
{
  private int id;
  private String fname;
  private String lname;
  private String address;
  private String city;
  private String state;
  private String zip;

  /**
   * Constructor
   * @param i The student ID.
   * @param f The student first name.
   * @param l The student last name.
   * @param a The address.
   * @param c The city.
   * @param s The state.
   * @param z The zip code.
   */
  Student(int i, String f, String l, String a, String c, String s, String z)
  {
    id      = i;
    fname   = f;
    lname   = l;
    address = a;
    city    = c;
    state   = s;
    zip     = z;
  }

  /**
   * The getId method returns student ID.
   * @return The value in the id field.
   */
  public int getId()
  {
    return id;
  }

  /**
   * The getFName method returns student first name.
   * @return The value in the fname field.
   */
  public String getFName()
  {
    return fname;
  }

  /**
   * The getLName method returns student last name.
   * @return The value in the lname field.
   */
  public String getLName()
  {
    return lname;
  }

  /**
   * The getAddress method returns address.
   * @return The value in the address field.
   */
  public String getAddress()
  {
    return address;
  }

  /**
   * The getCity method returns city.
   * @return The value in the city field.
   */
  public String getCity()
  {
    return city;
  }

  /**
   * The getState method returns state.
   * @return The value in the state field.
   */	
  public String getState()
  {
    return state;
  }

  /**
   * The getZip method returns zip code.
   * @return The value in the zip field.
   */	
  public String getZip()
  {
    return zip;
  }

  /**
   * The setId method sets the id field.
   * @param i The student ID.
   */
  public void setId(int i)
  {
    id = i;
  }

  /**
   * The setFName method sets the fname field.
   * @param n The student first name.
   */
  public void setFName(String f)
  {
    fname = f;
  }

  /**
   * The setLName method sets the lname field.
   * @param n The student last name.
   */
  public void setLName(String l)
  {
    lname = l;
  }

  /**
   * The setAddress method sets the address field.
   * @param a The address.
   */
  public void setAddress(String a)
  {
    address = a;
  }

  /**
   * The setCity method sets the city field.
   * @param c The city.
   */
  public void setCity(String c)
  {
    city = c;
  }

  /**
   * The setState method sets the state field.
   * @param s The state.
   */
  public void setState(String s)
  {
    state = s;
  }

  /**
   * The setZip method sets the zip field.
   * @param z The zip code.
   */
  public void setZip(String z)
  {
    zip = z;
  }
  
  @Override
  public int compareTo(Student o) 
  {
    return fname.compareTo(o.fname);
    
    /*
  	if (id > o.id) {
  		return 1;
  	} else if (id < o.id) {
  		return -1;
  	} else {
      return 0;  		
  	}
  	*/
  }
  
	@Override
	public String toString()
	{
	   String str;
	
	   str = "Student Name: " + fname + " " + lname +
 	  		   "\nStudent Address: " + address;
	   return str;
	}
}