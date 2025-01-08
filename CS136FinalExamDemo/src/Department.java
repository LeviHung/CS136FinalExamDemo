import java.lang.Comparable;

/**
 * Department Class
 */
public class Department implements Comparable<Department>
{
  private int id;
  private String name;

  /**
   * Constructor
   * @param i The department's ID.
   * @param n The department's name.
   */
  Department(int i, String n)
  {
    id      = i;
    name    = n;
  }

  /**
   * The getId method returns department's ID.
   * @return The value in the id field.
   */
  public int getId()
  {
    return id;
  }

  /**
   * The getName method returns department's name.
   * @return The value in the name field.
   */
  public String getName()
  {
    return name;
  }

  /**
   * The setId method sets the id field.
   * @param i The instructor's ID.
   */
  public void setId(int i)
  {
    id = i;
  }

  /**
   * The setName method sets the name field.
   * @param n The department's name.
   */
  public void setName(String f)
  {
    name = f;
  }
  
  @Override
  public int compareTo(Department o) 
  {
    return name.compareTo(o.name);
  }
  
  @Override
  public String toString()
  {
     String str;
    
     str = "Department ID: " + id + 
           "\nDepartment Name: " + name;
     return str;
  }
}