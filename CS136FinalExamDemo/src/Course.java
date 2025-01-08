import java.lang.Comparable;

/**
 * Course Class
 */
public class Course implements Comparable<Course>
{
  private int cid;
  private String name;
  private String desc;
  private int number;
  private int did;              // department ID
  private int pid;              // professor ID

  /**
   * Constructor
   * @param c The Course ID.
   * @param n The Course name.
   * @param d The Course description.
   * @param num The Course number.
   * @param dep The Course department ID.
   * @param p The Course professor ID.
   */	
  Course(int c, String n, String d, int num, int dep, int p)
  {
    cid    = c;
    name   = n;
    desc   = d;
    number = num;
    did    = dep;
    pid    = p;
  }

  /**
   * The getCId method returns Course ID.
   * @return The value in the cid field.
   */
  public int getCid()
  {
    return cid;
  }

  /**
   * The getCourseName method returns Course name.
   * @return The value in the name field.
   */
  public String getCourseName()
  {
    return name;
  }

  /**
   * The getCourseDesc method returns Course description.
   * @return The value in the desc field.
   */
  public String getCourseDesc()
  {
    return desc;
  }

  /**
   * The getCourseNumber method returns Course number.
   * @return The value in the number field.
   */
  public int getCourseNumber()
  {
    return number;
  }

  /**
   * The getCourseDepartmentId method returns course department ID.
   * @return The value in the did field.
   */
  public int getCourseDepartmentId()
  {
    return did;
  }
  /**
   * The getCourseProfessorId method returns course professor ID.
   * @return The value in the iid field.
   */
  public int getCourseProfessorId()
  {
    return pid;
  }

  /**
   * The setCId method sets the cid field.
   * @param c The course ID.
   */
  public void setCId(int c)
  {
    cid = c;
  }

  /**
   * The setId method sets the name field.
   * @param n The Course name.
   */
  public void setCourseName(String n)
  {
    name = n;
  }

  /**
   * The setId method sets the courseDesc field.
   * @param d The Course description.
   */
  public void setCourseDesc(String d)
  {
    desc = d;
  }

  /**
   * The setCourseName method sets the number field.
   * @param num The course number.
   */
  public void setCourseNumber(int num)
  {
    number = num;
  }

  /**
   * The setCourseDepartmentId method sets the did field.
   * @param i The course instructor ID.
   */
  public void setCourseDepartmentId(int i)
  {
    did = i;
  }

  /**
   * The setCourseProfessorId method sets the iid field.
   * @param p The course professor ID.
   */
  public void setCourseProfessorId(int p)
  {
    pid = p;
  }
  
  @Override
  public int compareTo(Course o) 
  {
    return name.compareTo(o.name);
    /*
  	if (cid > o.cid) {
  		return 1;
  	} else if (cid < o.cid) {
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
	
	  str = "Course Name: " + name +
	        "\nCourse Description: " + desc;
	  return str;
	}
}