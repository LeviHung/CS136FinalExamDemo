import java.sql.*;

/**
 * EnrollmentDBManager Class
 */
public class EnrollmentDBManager
{
  private Statement stmt;
  /**
   * Constructor
   * @param conn The Connection.
   */
  EnrollmentDBManager(Connection conn) throws Exception
  {
    this.stmt = conn.createStatement();
  }

  /**
   * addEnrollment
   * @param sid The student ID.
   * @param cid The Course ID.
   * @param year The year.
   * @param semester The semester.
   * @param grade The grade.
   */
  public void addEnrollment(int sid, int cid, int year, 
                            String semester, String grade) throws Exception
  {
    if (sid < 0) {
      throw new InvalidEnrollmentInfo("Student ID");
    }

    if (cid < 0) {
      throw new InvalidEnrollmentInfo("Course ID");
    }

    if (year <= 0) {
      throw new InvalidEnrollmentInfo("Year");
  	}

    if (semester.length() == 0)
    {
      throw new InvalidEnrollmentInfo("Semester");
    }

    if (findEnrollment(sid, cid, year, semester) == false) {
      
      String sqlStatement = 
          "INSERT INTO enrollment (StudentID, CourseID, Year, Semester, Grade) " + 
          "VALUE (" + 
          sid + ", " + 
          cid + ", " + 
          year + ", '" + 
          semester + "', '" + 
          grade + "')";
       
       // Send the statement to the DBMS
       int rows = stmt.executeUpdate(sqlStatement);
       
       // Display the results
       System.out.println(rows + " row(s) added to the enrollment table");  
      
    } else {
      // If the enrollment with id exist, throw an InvalidEnrollIDExist exception.
      throw new InvalidEnrollmentIDExist();  
    }		
  }


  /**
   * updateEnrollment method
   * Calls GetEnrollment method with id to check to see if the enrollment with 
   * that id exist in the enrollment MyGenericList.
   * If found, updates the objects in the MyGenericList for that enrollment id.
   * Writes the whole MyGenericList back to the file and returns true.
   * If not found, displays error message and returns false.
   * @param eid The enrollment ID.
   * @param sid The student ID.
   * @param cid The Course ID.
   * @param year The year.
   * @param semester The semester.
   * @param grade The grade.
   * @return result
   */
  public void updateEnrollment(int eid, int sid, int cid, int year, 
                               String semester, String grade) throws Exception
  {
    if (eid < 0) {
      throw new InvalidEnrollmentInfo("Emrollment ID");
    }

    if (sid < 0) {
      throw new InvalidEnrollmentInfo("Student ID");
    }

    if (cid < 0) {
      throw new InvalidEnrollmentInfo("Course ID");
    }

    if (year <= 0) {
      throw new InvalidEnrollmentInfo("Year");
    }

    if (semester.length() == 0) {
      throw new InvalidEnrollmentInfo("Semester");
    }

    if (findEnrollment(eid)) {
      
      Enrollment enrollmentInfo = getEnrollmentInfo(eid);
      
      // If the user want to edit grade only. 
      if (sid == enrollmentInfo.getSid() &&
          cid == enrollmentInfo.getCid() &&
          year == enrollmentInfo.getYear() &&
          semester.equals(enrollmentInfo.getSemester())) {
        String sqlStatement = "UPDATE enrollment " + 
            "SET Grade = '" + grade +
            "' WHERE EnrollmentID = " + eid;

        // Send the UPDATE statement to the DBMS
        int rows = stmt.executeUpdate(sqlStatement);
      
        // Display the results
        System.out.println(rows + " row(s) updated.");

      } else {
        
        if (findEnrollment(sid, cid, year, semester) == false) {
          String sqlStatement = "UPDATE enrollment " + 
              "SET StudentID = " + sid + 
              ", CourseID = " + cid + 
              ", Year = " + year + 
              ", Semester = '" + semester +
              "', Grade = '" + grade +
              "' WHERE EnrollmentID = " + eid;           
           // Send the statement to the DBMS
           int rows = stmt.executeUpdate(sqlStatement);
           
           // Display the results
           System.out.println(rows + " row(s) updated.");
          
        } else {
          // If the enrollment with id exist, throw an InvalidEnrollIDExist exception.
          throw new InvalidEnrollmentIDExist();  
        }        
      } 
        
    } else {
      // If not found, throw an InvalidEnrollmentID exception.
      throw new InvalidEnrollmentID(eid);
    }       
  }

  /**
   * deleteEnrollment method
   * @param id The enrollment ID.
   */
  public void deleteEnrollment(int id) throws Exception
  {
    if (findEnrollment(id)) {
      String sqlStatement = "DELETE FROM enrollment WHERE EnrollmentID = '" + id +"'";
      
      // Send the UPDATE statement to the DBMS
      int rows = stmt.executeUpdate(sqlStatement);
      
      // Display the results
      System.out.println(rows + " row(s) deleted.");
          
    } else {
      // If not found, throw an InvalidStudentID exception.
      throw new InvalidEnrollmentID(id);
    }  
  }
  
  private boolean findEnrollment(int id) throws SQLException
  {
    boolean enrollmentFound; 
    
    //String sqlStatement = "SELECT * FROM enrollment WHERE EnrollmentID = " + id;
    String sqlStatement = "CALL FindEnrollmentID(" + id + ")";
    
    // Send the SELECT statement to the DBMS.
    ResultSet result = stmt.executeQuery(sqlStatement);
    
    // Display the contents of the result set
    if (result.next()) {
      enrollmentFound = true; 
  
    } else {
      enrollmentFound = false;
    }

    return enrollmentFound; 
  }

  private boolean findEnrollment(int sid, int cid, int year, 
                                       String semester) throws SQLException
  {
    boolean enrollmentFound; 
    String sqlStatement =
          "SELECT * FROM enrollment WHERE StudentID = " + sid + 
          " AND CourseID = " + cid + 
          " AND Year = " + year + 
          " AND Semester = '" + semester + "'";
  
    // Send the SELECT statement to the DBMS.
    ResultSet result = stmt.executeQuery(sqlStatement);
    
    // Display the contents of the result set
    if (result.next()) {
      enrollmentFound = true; 
  
    } else {
      enrollmentFound = false;
    }

    return enrollmentFound; 
  }

  /**
   * getEnrollmentNewId method
   * @return id
   */
  public int getEnrollmentNewId() throws Exception
  {
    //String sqlStatement = "SELECT MAX(EnrollmentID) AS id FROM enrollment";

    /*
    String sqlStatement = "SELECT `AUTO_INCREMENT` AS id " +
                          "FROM  INFORMATION_SCHEMA.TABLES " +
                          "WHERE TABLE_SCHEMA = 'cs136'" +
                          "AND   TABLE_NAME   = 'enrollment'";
    */
    String sqlStatement = "CALL GetNextEnrollmentID();";
    
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
  public Enrollment getEnrollmentInfo(int id) throws Exception
  {
    if (findEnrollment(id)) {
      String sqlStatement = "SELECT StudentID, CourseID, Year, " + 
                            "Semester, Grade FROM enrollment " + 
                            "WHERE EnrollmentID = " + id;
      
      ResultSet result = stmt.executeQuery(sqlStatement);
      
      if (result.next()) {
        Enrollment enrollmentInfo = new Enrollment(id,
                                       result.getInt("StudentID"),
                                       result.getInt("CourseID"),
                                       result.getInt("Year"),
                                       result.getString("Semester"),
                                       result.getString("Grade"));

        return enrollmentInfo;        

      } else {
        throw new InvalidEnrollmentID(id);
      }

    } else {
      throw new InvalidEnrollmentID(id);
    }
  }
  
  /**
   * getEnrollmentByStudentId method
   * Checks to see if the Emrollment with the sid exist in the MyGenericList.
   * If yes, then read the emrollment id into resultID array and returns it.
   * If the Student with ID does not exist, throw an InvalidEnrollment exception.
   * @param sid The Student ID.
   * @return
   */
  public int[] getEnrollmentByStudentId(int sid) throws Exception
  {
    String sqlStatement = "SELECT COUNT(*) AS num FROM enrollment WHERE StudentID = " + sid;

    ResultSet result = stmt.executeQuery(sqlStatement);

    int num = 0;
    if (result.next()) {
      num = result.getInt("num");
    }
    
    int[] resultEid = new int[num];

    sqlStatement = "SELECT EnrollmentID FROM enrollment WHERE StudentID = " + sid;
    
    result = stmt.executeQuery(sqlStatement);


    int index = 0;
    while (result.next()) {
      resultEid[index++] = result.getInt("EnrollmentID");
    }
    
    return resultEid;
  }
  
  /**
   * getEnrollmentByCourseId method
   * Checks to see if the Emrollment with the cid exist in the MyGenericList.
   * If yes, then read the emrollment id into resultID array and returns it.
   * If the Course with ID does not exist, throw an InvalidEnrollment exception.
   * @param cid The Course ID.
   * @return
   */
  public int[] getEnrollmentByCourseId(int cid) throws Exception
  {
    
    String sqlStatement = "SELECT COUNT(*) AS num FROM enrollment WHERE CourseID = " + cid;

    ResultSet result = stmt.executeQuery(sqlStatement);

    int num = 0;
    if (result.next()) {
      num = result.getInt("num");
    }
    
    int[] resultEid = new int[num];

    sqlStatement = "SELECT EnrollmentID FROM enrollment WHERE CourseID = " + cid;
    
    result = stmt.executeQuery(sqlStatement);


    int index = 0;
    while (result.next()) {
      resultEid[index++] = result.getInt("EnrollmentID");
    }
    
    return resultEid;
  }
  
  /**
   * getEnrollmentNumber method
   * Checks to see if the Emrollment with the cid exist in the MyGenericList.
   * If yes, then read the emrollment number with the course id returns it.
   * If the enrollment does not exist, throw an InvalidEnrollment exception. 
   * @param cid The Course ID.
   * @return
   */
  public int getEnrollmentNumber(int cid, String semester, int year) throws Exception
  {
    int resultNumber = 0;       
    
    String sqlStatement =
          "SELECT COUNT(*) AS num FROM enrollment WHERE " + 
          " CourseID = " + cid + 
          " AND Year = " + year + 
          " AND Semester = '" + semester + "'";
    
    ResultSet result = stmt.executeQuery(sqlStatement);

    if (result.next()) {
      resultNumber = result.getInt("num");
    }

    return resultNumber;
  }
  
  public String[] searchEnrollList(int field, boolean isDesc) throws Exception
  {
    String sqlStatement = "SELECT COUNT(*) AS num FROM enrollment";

    ResultSet result = stmt.executeQuery(sqlStatement);

    int num = 0;
    if (result.next()) {
      num = result.getInt("num");
    }
    
    String[] enrollmentlist = new String[num];
    sqlStatement = "SELECT EnrollmentID, StudentID, CourseID, Year, " + 
                   "Semester, Grade FROM enrollment ";

    if (field == 0) {           // Enrollment ID
      if (isDesc == false) {    // Order by ASC
        sqlStatement += "ORDER BY EnrollmentID ASC";

      } else {                  // Order by DESC
        sqlStatement += "ORDER BY EnrollmentID DESC";
        
      }
    } else {                    // Student ID
      if (isDesc == false) {    // Order by ASC
        sqlStatement += "ORDER BY StudentID ASC";

      } else {                  // Order by DESC
        sqlStatement += "ORDER BY StudentID DESC";
        
      }      
    }
    
    result = stmt.executeQuery(sqlStatement);

    int index = 0;
    while (result.next()) {
      int eid           = result.getInt("EnrollmentID");
      int sid           = result.getInt("StudentID");
      int cid           = result.getInt("CourseID");
      int year          = result.getInt("Year");
      String semester   = result.getString("Semester");
      String grade      = result.getString("Grade");
      enrollmentlist[index++] = String.format("%10d\t%d\t%d\t%d\t%s\t%s\n", 
                              eid, sid, cid, year, semester, grade);
      
    }
    
    return enrollmentlist;
  }
  
  public void closeStatement()  throws Exception
  {
    this.stmt.close();
  }
}
