import java.lang.Comparable;

/**
 * Course Enrollment
 */
public class Enrollment implements Comparable<Enrollment>
{
  private int eid;
  private int sid;
  private int cid;
  private int year;
  private String semester;
  private String grade;

  /**
   * Constructor
   * @param e The enrollment ID.
   * @param s The student ID.
   * @param c The Course ID.
   * @param y The semester.
   * @param sem The year.
   * @param i The instructor.
   * @param g The grade.
   */	

  Enrollment(int e, int s, int c, int y, String sem, String g)
  {
    eid      = e;
    sid      = s;
    cid      = c;
    year     = y;
    semester = sem;
    grade    = g;
  }

  /**
   * The getEid method returns enrollment ID.
   * @return The value in the eid field.
   */
  public int getEid()
  {
    return eid;
  }

  /**
   * The getSid method returns student ID.
   * @return The value in the sid field.
   */
  public int getSid()
  {
    return sid;
  }

  /**
   * The getCid method returns Course ID.
   * @return The value in the cid field.
   */
  public int getCid()
  {
    return cid;
  }

  /**
   * The getYear method returns year.
   * @return The value in the year field.
   */
  public int getYear()
  {
    return year;
  }

  /**
   * The getSemester method returns semester.
   * @return The value in the semester field.
   */
  public String getSemester()
  {
    return semester;
  }

  /**
   * The getGrade method returns grade.
   * @return The value in the grade field.
   */
  public String getGrade()
  {
    return grade;
  }

  /**
   * The setEId method sets the eid field.
   * @param e The enrollment ID.
   */
  public void setEid(int e)
  {
    eid = e;
  }

  /**
   * The setSId method sets the sid field.
   * @param s The student ID.
   */
  public void setSid(int s)
  {
    sid = s;
  }

  /**
   * The setCId method sets the cid field.
   * @param c The course ID.
   */
  public void setCid(int c)
  {
    cid = c;
  }

  /**
   * The setYear method sets the year field.
   * @param y The year.
   */
  public void setYear(int y)
  {
    year = y;
  }

  /**
   * The setSemester method sets the semester field.
   * @param sem The semester.
   */
  public void setSemester(String sem)
  {
    semester = sem;
  }

  /**
   * The setGrade method sets the grade field.
   * @param g The grade.
   */
  public void setGrade(String g)
  {
    grade = g;
  }
  
  @Override
  public int compareTo(Enrollment o) 
  {
  	if (sid > o.sid) {
  		return 1;

  	} else if (eid < o.eid) {
  		return -1;

  	} else {
      return 0;  		
  	}
  }

  @Override
  public String toString()
  {
    String str;
	
	str = "Student ID: " + sid +
 	  	  "\nCourse ID: " + cid;
	return str;
  }
}