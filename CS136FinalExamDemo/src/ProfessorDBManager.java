import java.sql.*;
/**
* ProfessorDBManager Class
*/
public class ProfessorDBManager
{
  private Statement stmt;

 /**
  * Constructor
  * @param filename
  */
  ProfessorDBManager(Connection conn) throws Exception
  {
    this.stmt = conn.createStatement();
  }

  /**
   * addProfessor method
   * @param name The instructor name.
   * @param did The department ID.
   */
  public void addProfessor(String name, int did)
                           throws Exception
  {
   
    if (name.isEmpty()) {
      throw new InvalidProfessorInfo("Name");
    }

    if (did <= 0) {
      throw new InvalidProfessorInfo("Department");
    }
    
    String sqlStatement = 
           "INSERT INTO professor (ProfessorName, DepartmentID)" +
           "VALUE ('" + 
           name + "', '" + 
           did + "')";
   
    // Send the statement to the DBMS
    int rows = stmt.executeUpdate(sqlStatement);
     
    // Display the results
    System.out.println(rows + " row(s) added to the professor table");
  }

  /**
   * updateProfessor method
   * @param id The instructor ID.
   * @param name The instructor name.
   * @param did The department ID.
   */
  public void updateProfessor(int id, String name, int did) throws Exception
  {
    // If the instructor information is empty, 
    // it throws an InvalidInstructorInfo exception.
    if (id < 0) {
      throw new InvalidProfessorInfo("Professor ID");
    }
    if (name.isEmpty()) {
      throw new InvalidProfessorInfo("Name");
    }
    if (did <= 0) {
      throw new InvalidProfessorInfo("Department");
    }

    if (findProfessor(id)) {
      String sqlStatement = "UPDATE professor " + 
         "SET ProfessorName = '" + name + 
         "', DepartmentID = '" + did +
         "' WHERE ProfessorID = '" + id +"'";
     
      // Send the UPDATE statement to the DBMS
      int rows = stmt.executeUpdate(sqlStatement);
     
      // Display the results
      System.out.println(rows + " row(s) updated.");
         
    } else {
      // If not found, throw an InvalidProfessorID exception.
      throw new InvalidProfessorID(id);
    }    
  }

  private boolean findProfessor(int id) throws SQLException
  {
    boolean professorFound; // Flag
   
    //String sqlStatement = "SELECT * FROM professor WHERE ProfessorID = " + id;
    String sqlStatement = "CALL FindProfessorID(" + id + ")";
    
    // Send the SELECT statement to the DBMS.
    ResultSet result = stmt.executeQuery(sqlStatement);
   
    // Display the contents of the result set
    if (result.next()) {
      professorFound = true; 

    } else {
      professorFound = false;
    }

    return professorFound; 
  }
 
  /**
   * getStudentFName method
   * @param id
   * @return
   */
  public Professor getProfessorInfo(int id) throws Exception
  {
    if (findProfessor(id)) {
      String sqlStatement = "SELECT ProfessorName, DepartmentID FROM professor " + 
                            "WHERE ProfessorID = " + id;
      
      ResultSet result = stmt.executeQuery(sqlStatement);
      
      if (result.next()) {
        Professor profInfo = new Professor(id,
                                           result.getString("ProfessorName"),
                                           result.getInt("DepartmentID"));

        return profInfo;        

      } else {
        throw new InvalidProfessorID(id);
      }

    } else {
      throw new InvalidProfessorID(id);
    }
  }

  /**
   * deleteProfessor method
   * @param id The professor ID.
   */
  public void deleteProfessor(int id) throws Exception
  {
    if (findProfessor(id)) {
      String sqlStatement = "DELETE FROM professor WHERE ProfessorID = '" + id +"'";
      
      // Send the UPDATE statement to the DBMS
      int rows = stmt.executeUpdate(sqlStatement);
      
      // Display the results
      System.out.println(rows + " row(s) deleted.");
          
    } else {
      // If not found, throw an InvalidStudentID exception.
      throw new InvalidProfessorID(id);
    }  
  }

  /**
   * getProfessorNewId method
   * @return id
   */
  public int getProfessorNewId() throws Exception
  {
    /*
    String sqlStatement = "SELECT `AUTO_INCREMENT` AS id " +
                          "FROM  INFORMATION_SCHEMA.TABLES " +
                          "WHERE TABLE_SCHEMA = 'cs136'" +
                          "AND   TABLE_NAME   = 'professor'";
    */
    String sqlStatement = "CALL GetNextProfessorID();";
    
    ResultSet result = stmt.executeQuery(sqlStatement);
    
    int id = 0;
    if (result.next()) {
      id = result.getInt("id");
    }
    return id;
  }
  
  public String[] searchProfessorList(int did) throws Exception
  {
   
    String sqlStatement = "SELECT COUNT(*) AS num FROM professor " + 
                          "WHERE DepartmentID = " + did;

    ResultSet result = stmt.executeQuery(sqlStatement);

    int num = 0;
    if (result.next()) {
      num = result.getInt("num");
    }
   
    String[] professorlist = new String[num];

    sqlStatement = "SELECT ProfessorName FROM professor " + 
                   "WHERE DepartmentID = " + did;

    result = stmt.executeQuery(sqlStatement);

    int index = 0;
    while (result.next()) {
      professorlist[index++] = result.getString("ProfessorName");
    }

    return professorlist;
  }
 
  /**
   * searchProfessorId method
   * @param name
   * @param did
   * @return professor id
   */
  public int searchProfessorId(String name, int did) throws Exception
  {
    String sqlStatement = "SELECT ProfessorID FROM professor " + 
                          "WHERE DepartmentID = " + did + 
                          " AND ProfessorName = '" + name + "'";

    ResultSet result = stmt.executeQuery(sqlStatement);
   
    int id = 0; 
    if (result.next()) {
      id = result.getInt("ProfessorID");
    }
    
    return id;
  }
 
  public String[] searchProfessorList(int field, boolean isDesc) throws Exception
  {
    
    String sqlStatement = "SELECT COUNT(*) AS num FROM professor";

    ResultSet result = stmt.executeQuery(sqlStatement);

    int num = 0;
    if (result.next()) {
      num = result.getInt("num");
    }
    
    String[] professorlist = new String[num];
    sqlStatement = "SELECT ProfessorID, ProfessorName, DepartmentID FROM professor ";

    if (field == 0) {           // Professor ID
      if (isDesc == false) {    // Order by ASC
        sqlStatement += "ORDER BY ProfessorID ASC";

      } else {                  // Order by DESC
        sqlStatement += "ORDER BY ProfessorID DESC";
      }

    } else {                    // Professor Name
      if (isDesc == false) {    // Order by ASC
        sqlStatement += "ORDER BY ProfessorName ASC";

      } else {                  // Order by DESC
        sqlStatement += "ORDER BY ProfessorName DESC";    
      }      
    }
    
    result = stmt.executeQuery(sqlStatement);

    int index = 0;
    while (result.next()) {
      int pid        = result.getInt("ProfessorID");
      String name    = result.getString("ProfessorName");
      int did        = result.getInt("DepartmentID");
      professorlist[index++] = String.format("%10d\t%s\t%d\n", pid, name, did);
    }
    
    return professorlist;
  }
  

  public String[] getColumnNames() throws Exception
  {
   
    String sqlStatement = "SELECT ProfessorID as 'Professor ID', " + 
                          "ProfessorName as 'Name', " + 
                          "DepartmentID as 'Department ID' FROM professor";

    ResultSet result = stmt.executeQuery(sqlStatement);
    // Get a metadata object for the result set.
    ResultSetMetaData meta = result.getMetaData();

    // Create an array of Strings for the column names.
    String[] colNames = new String[meta.getColumnCount()];
    
    // Store the column names in the colNames array.
    for (int i = 0; i < meta.getColumnCount(); i++) {
       // Get a column name.
       colNames[i] = meta.getColumnLabel(i+1);
    }

    return colNames;
  }

  public String[][] getData() throws Exception
  {
    String sqlStatement = "SELECT COUNT(*) AS num FROM professor";

    ResultSet result = stmt.executeQuery(sqlStatement);

    int num = 0;
    if (result.next()) {
      num = result.getInt("num");
    }
    String[][] data = new String[num][3];
    
    sqlStatement = "SELECT * FROM professor";

    result = stmt.executeQuery(sqlStatement);


    int index = 0;
    while (result.next()) {
      int pid       = result.getInt("ProfessorID");
      String name   = result.getString("ProfessorName");
      int did       = result.getInt("DepartmentID");
      data[index][0] = Integer.toString(pid);
      data[index][1] = name;
      data[index][2] = Integer.toString(did);;
      index++;
    }

    return data;
  }
  
  public void closeStatement()  throws Exception
  {
    this.stmt.close();
  }
}