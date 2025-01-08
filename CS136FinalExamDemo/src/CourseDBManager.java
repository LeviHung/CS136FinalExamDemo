import java.sql.*;

/**
 * CourseDBManager Class
 */
public class CourseDBManager
{
  private Statement stmt;
  
  /**
   * Constructor
   * @param filename The file name.
   */
  CourseDBManager(Connection conn) throws Exception
  {
    this.stmt = conn.createStatement();
  }

  /**
   * addCourse
   * @param name The Course name.
   * @param desc The Course description.
   * @param number The Course number.
   * @param departmentId The Course department ID.
   * @param professorId The Course professor ID.
   */
  public void addCourse(String name, String desc, 
                        int number, 
                        int departmentId, int professorId) 
                        throws Exception
  {
    if (name.isEmpty()) {
      throw new InvalidCourseInfo("Name");
   	}

  	if (desc.isEmpty()) {
      throw new InvalidCourseInfo("Description");
   	}

  	if (number <= 0) {
      throw new InvalidCourseInfo("Number");
  	}

    if (departmentId <= 0) {
      throw new InvalidCourseInfo("Department");
    }  
      
   	if (professorId <= 0) {
      throw new InvalidCourseInfo("Professor");
  	}
   	  
    String sqlStatement = 
        "INSERT INTO course (CourseName, CourseDescription, CourseNumber, " + 
        "DepartmentID, ProfessorID)" +
        "VALUE ('" + 
        name + "', '" + 
        desc + "', " + 
        number + ", " + 
        departmentId + ", " + 
        professorId + ")";
       
    // Send the statement to the DBMS
    int rows = stmt.executeUpdate(sqlStatement);
       
    // Display the results
    System.out.println(rows + " row(s) added to the course table");
  }

  /**
   * updateCourse method
   * @param id The Course ID.
   * @param name The Course name.
   * @param desc The Course description.
   * @param number The Course number.
   * @param departmentId The Course department's ID.
   * @param professorId The Course professor's ID.
   */
  public void updateCourse(int id, String name, 
                           String desc, int number, 
                           int departmentId, int professorId)  
                           throws Exception
  {
    if (id < 0) {
      throw new InvalidCourseInfo("Course ID");
    }

    if (name.isEmpty()) {
      throw new InvalidCourseInfo("Name");
    }

    if (desc.isEmpty()) {
       throw new InvalidCourseInfo("Description");
    }

    if (number <= 0) {
      throw new InvalidCourseInfo("Number");    
    }

    if (departmentId <= 0) {
      throw new InvalidCourseInfo("Department");
    }  
    
    if (professorId <= 0) {
      throw new InvalidCourseInfo("Professor");
    }
 	  
    if (findCourse(id)) {
      // Create an UPDATE statement to update the info for the specified student ID
      String sqlStatement = "UPDATE course " + 
          "SET CourseName = '" + name + 
          "', CourseDescription = '" + desc + 
          "', CourseNumber = " + number + 
          ", DepartmentID = " + departmentId +
          ", ProfessorID = " + professorId +
          " WHERE CourseID = " + id;
    
      // Send the UPDATE statement to the DBMS
      int rows = stmt.executeUpdate(sqlStatement);
    
      // Display the results
      System.out.println(rows + " row(s) updated.");
        
    } else {
      // If not found, throw an InvalidCourseID exception.
      throw new InvalidCourseID(id);
    }		

  }


  private boolean findCourse(int id) throws SQLException
  {
    boolean courseFound; // Flag
    
    // Create a SELECT statement to get the specified row from the student table.
    // String sqlStatement = "SELECT * FROM course WHERE CourseID = " + id;
    String sqlStatement = "CALL FindCourseID(" + id + ")";
    
    // Send the SELECT statement to the DBMS.
    ResultSet result = stmt.executeQuery(sqlStatement);
    
    // Display the contents of the result set
    if (result.next()) {
      courseFound = true; 
  
    } else {
      courseFound = false;
    }

    return courseFound; 
  }

  /**
   * deleteCourse method
   * @param id The course ID.
   */
  public void deleteCourse(int id) throws Exception
  {
    if (findCourse(id)) {
      String sqlStatement = "DELETE FROM course WHERE CourseID = '" + id +"'";
      
      // Send the UPDATE statement to the DBMS
      int rows = stmt.executeUpdate(sqlStatement);
      
      // Display the results
      System.out.println(rows + " row(s) deleted.");
          
    } else {
      // If not found, throw an InvalidStudentID exception.
      throw new InvalidCourseID(id);
    }  
  }
  
  /**
   * getCourseNewId method
   * @return id
   */
  public int getCourseNewId() throws Exception
  {
    // String sqlStatement = "SELECT MAX(CourseID) AS id FROM course";
    /*
    String sqlStatement = "SELECT `AUTO_INCREMENT` AS id " +
                          "FROM  INFORMATION_SCHEMA.TABLES " +
                          "WHERE TABLE_SCHEMA = 'cs136'" +
                          "AND   TABLE_NAME   = 'course'";
    */
    String sqlStatement = "CALL GetNextCourseID();";
    
    ResultSet result = stmt.executeQuery(sqlStatement);
    
    int id = 0;
    if (result.next()) {
      id = result.getInt("id");
    }
    
    return id;
  }
  
  /**
   * getCourseInfo method
   * @param id
   * @return
   */
  public Course getCourseInfo(int id) throws Exception
  {
    if (findCourse(id)) {
      String sqlStatement = "SELECT CourseName, CourseDescription, CourseNumber, " + 
                            "DepartmentID, ProfessorID FROM course " + 
                            "WHERE CourseID = " + id;
      
      ResultSet result = stmt.executeQuery(sqlStatement);
      
      if (result.next()) {
        Course courseInfo = new Course(id,
                                       result.getString("CourseName"),
                                       result.getString("CourseDescription"),
                                       result.getInt("CourseNumber"),
                                       result.getInt("DepartmentID"),
                                       result.getInt("ProfessorID"));

        return courseInfo;        

      } else {
        throw new InvalidCourseID(id);
      }

    } else {
      throw new InvalidCourseID(id);
    }
  }
  
  public String[] searchCourseList() throws Exception
  {

    String sqlStatement = "SELECT COUNT(*) AS num FROM course";

    ResultSet result = stmt.executeQuery(sqlStatement);

    int num = 0;
    if (result.next()) {
      num = result.getInt("num");
    }
    
    String[] courselist = new String[num];

    sqlStatement = "SELECT CourseID FROM course";

    result = stmt.executeQuery(sqlStatement);

    int index = 0;
    while (result.next()) {
      courselist[index++] = Integer.toString(result.getInt("CourseID"));
    }
    
    return courselist;
  }
  
  public String[] searchCourseIDNameList() throws Exception
  {
    String sqlStatement = "SELECT COUNT(*) AS num FROM course";

    ResultSet result = stmt.executeQuery(sqlStatement);

    int num = 0;
    if (result.next()) {
      num = result.getInt("num");
    }
    
    String[] courselist = new String[num];

    sqlStatement = "SELECT CourseID, CourseName FROM course";

    result = stmt.executeQuery(sqlStatement);

    int index = 0;
    while (result.next()) {
      courselist[index++] = Integer.toString(result.getInt("CourseID")) + " " +
                            result.getString("CourseName");
    }
    
    return courselist;
  }

  public String[] searchCourseList(int field, boolean isDesc) throws Exception
  {
    String sqlStatement = "SELECT COUNT(*) AS num FROM course";

    ResultSet result = stmt.executeQuery(sqlStatement);

    int num = 0;
    if (result.next()) {
      num = result.getInt("num");
    }
    
    String[] courselist = new String[num];
    sqlStatement = "SELECT CourseID, CourseName, CourseDescription, CourseNumber, " + 
                   "DepartmentID, ProfessorID FROM course ";

    if (field == 0) {           // Student ID
      if (isDesc == false) {    // Order by ASC
        sqlStatement += "ORDER BY CourseID ASC";

      } else {                  // Order by DESC
        sqlStatement += "ORDER BY CourseID DESC";        
      }

    } else {                    // LastName
      if (isDesc == false) {    // Order by ASC
        sqlStatement += "ORDER BY CourseName ASC";

      } else {                  // Order by DESC
        sqlStatement += "ORDER BY CourseName DESC";        
      }      
    }
    
    result = stmt.executeQuery(sqlStatement);

    int index = 0;
    while (result.next()) {
      int cid       = result.getInt("CourseID");
      String name   = result.getString("CourseName");
      String desc   = result.getString("CourseDescription");
      int number    = result.getInt("CourseNumber");
      int did       = result.getInt("DepartmentID");
      int pid       = result.getInt("ProfessorID");
      
      courselist[index++] = String.format("%10d\t%s\t%s\t%6d\t%d\t%d\n", 
          cid, name, desc, number, did, pid);
      
    }
    
    return courselist;
  }
  
  public void closeStatement()  throws Exception
  {
    this.stmt.close();
  }
}