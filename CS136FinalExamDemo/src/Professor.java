import java.lang.Comparable;

/**
 * Professor Class
 */
public class Professor implements Comparable<Professor>
{
  private int id;
  private String name;
  private int did;      // department ID

  /**
   * Constructor
   * @param i The professor's ID.
   * @param n The professor's name.
   * @param d The professor's department ID.
   */
  Professor(int i, String n, int d)
  {
    id      = i;
    name    = n;
    did     = d;
  }

  /**
   * The getId method returns professor's ID.
   * @return The value in the id field.
   */
  public int getId()
  {
    return id;
  }

  /**
   * The getName method returns professor's name.
   * @return The value in the name field.
   */
  public String getName()
  {
    return name;
  }

  /**
   * The getDepartment method returns professor's department ID.
   * @return The ID in the department field.
   */
  public int getDepartmentId()
  {
    return did;
  }

  /**
   * The setId method sets the id field.
   * @param i The professor's ID.
   */
  public void setId(int i)
  {
    id = i;
  }

  /**
   * The setName method sets the name field.
   * @param n The professor's name.
   */
  public void setName(String f)
  {
    name = f;
  }

  /**
   * The setDepartment method sets the department field.
   * @param n The professor's department object.
   */
  public void setDepartmentId(int d)
  {
    did = d;
  }
  
  @Override
  public int compareTo(Professor o) 
  {
    return name.compareTo(o.name);
    /*
    if (o.id > o.id) {
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
    
    str = "Professor ID: " + id +
          "Professor Name: " + name +
          "\nDepartment ID: " + did;
    return str;
  }
}