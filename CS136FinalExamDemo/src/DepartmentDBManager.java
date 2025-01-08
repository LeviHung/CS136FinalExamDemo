import java.sql.*;

/**
* DepartmentDBManager Class
*/
public class DepartmentDBManager
{
  private Statement stmt;

 /**
  * Constructor
  * @param filename
  */
  DepartmentDBManager(Connection conn) throws Exception
  {
    this.stmt = conn.createStatement();
  }

  /**
   * addDepartment method
   * @param name The department name.
   */
  public void addDepartment(String name) throws Exception
  {
   
    if (name.isEmpty()) {
      throw new InvalidDepartmentInfo("Name");
    }

    String sqlStatement = 
           "INSERT INTO department (DepartmentName)" +
           "VALUE ('" + 
           name + "')";
      
    // Send the statement to the DBMS
    int rows = stmt.executeUpdate(sqlStatement);
      
    // Display the results
    System.out.println(rows + " row(s) added to the department table");     
  }

  /**
   * UpdateDepartment method
   * @param id The department ID.
   * @param name The department name.
   */
  public void updateDepartment(int id, String name) throws Exception
  {
    // If the department information is empty, 
    // it throws an InvalidDepartmentInfo exception.
    if (id < 0) {
      throw new InvalidDepartmentInfo("Department ID");
    }
    
    if (name.isEmpty()) {
      throw new InvalidDepartmentInfo("Name");
    }

    if (findDepartment(id)) {
      // Create an UPDATE statement to update the info for the specified department ID
      String sqlStatement = "UPDATE department " + 
          "SET DepartmentName = '" + name + 
          "' WHERE DepartmentID = '" + id +"'";
      
      // Send the UPDATE statement to the DBMS
      int rows = stmt.executeUpdate(sqlStatement);
      
      // Display the results
      System.out.println(rows + " row(s) updated.");

    } else {
      // If not found, throw an InvalidDepartmentID exception.
      throw new InvalidDepartmentID(id);
    }    
  }

  private boolean findDepartment(int id) throws SQLException
  {
    boolean departmentFound; // Flag
    
    // Create a SELECT statement to get the specified row from the department table.
    //String sqlStatement = "SELECT * FROM department WHERE DepartmentID = " + id;
    String sqlStatement = "CALL FindDepartmentID(" + id + ")";
    
    // Send the SELECT statement to the DBMS.
    ResultSet result = stmt.executeQuery(sqlStatement);
    
    // Display the contents of the result set
    if (result.next()) {
      departmentFound = true; 

    } else {
      departmentFound = false;
    }
    return departmentFound; 
  }
 
  /**
   * getStudentFName method
   * @param id
   * @return
   */
  public Department getDepartmentInfo(int id) throws Exception
  {
    if (findDepartment(id)) {
      String sqlStatement = "SELECT DepartmentName FROM department " + 
                            "WHERE DepartmentID = " + id;
      
      ResultSet result = stmt.executeQuery(sqlStatement);
      
      if (result.next()) {
        Department departmentInfo = new Department(id,
                                    result.getString("DepartmentName"));

        return departmentInfo;        

      } else {
        throw new InvalidDepartmentID(id);
      }

    } else {
      throw new InvalidDepartmentID(id);
    }
  }

  /**
   * deleteDepartment method
   * @param id The department ID.
   */
  public void deleteDepartment(int id) throws Exception
  {
    if (findDepartment(id)) {
      String sqlStatement = "DELETE FROM department WHERE DepartmentID = '" + id +"'";
      
      // Send the UPDATE statement to the DBMS
      int rows = stmt.executeUpdate(sqlStatement);
      
      // Display the results
      System.out.println(rows + " row(s) deleted.");
          
    } else {
      // If not found, throw an InvalidStudentID exception.
      throw new InvalidDepartmentID(id);
    }  
  }
 
  /**
   * getDepartmentNewId method
   * @return id
   */
  public int getDepartmentNewId() throws Exception
  {
    //String sqlStatement = "SELECT MAX(DepartmentID) AS id FROM department";
    /* 
    String sqlStatement = "SELECT `AUTO_INCREMENT` AS id " +
                          "FROM  INFORMATION_SCHEMA.TABLES " +
                          "WHERE TABLE_SCHEMA = 'cs136'" +
                          "AND   TABLE_NAME   = 'department'";
    */
    String sqlStatement = "CALL GetNextDepartmentID();";
    ResultSet result = stmt.executeQuery(sqlStatement);

    int id = 0;
    if (result.next()) {
      id = result.getInt("id");
    }
    //return num + 1;
    return id;
  }
  
  /**
   * getDepartmentNewId method
   * @return id
   */
  public int getDepartmentIDByName(String name) throws Exception
  {
    String sqlStatement = "SELECT DepartmentID FROM department WHERE DepartmentName = '" + name + "'";
    
    
    ResultSet result = stmt.executeQuery(sqlStatement);

    int id = 0;
    if (result.next()) {
      id = result.getInt("DepartmentID");
    }

    return id;
  }
  
  public String[] searchDepartmentList() throws Exception
  {
    String sqlStatement = "SELECT COUNT(*) AS num FROM department";

    ResultSet result = stmt.executeQuery(sqlStatement);

    int num = 0;
    if (result.next()) {
      num = result.getInt("num");
    }
   
    String[] departmentlist = new String[num];

    sqlStatement = "SELECT DepartmentName FROM department";

    result = stmt.executeQuery(sqlStatement);

    int index = 0;
    while (result.next()) {
      departmentlist[index++] = result.getString("DepartmentName");
    }

    return departmentlist;
  }
 
  public String[] searchDepartmentList(int field, boolean isDesc) throws Exception
  {
    String sqlStatement = "SELECT COUNT(*) AS num FROM department";

    ResultSet result = stmt.executeQuery(sqlStatement);

    int num = 0;
    if (result.next()) {
      num = result.getInt("num");
    }
   
    String[] departmentlist = new String[num];
    sqlStatement = "SELECT DepartmentID, DepartmentName FROM department ";

    if (field == 0) {           // Department ID
      if (isDesc == false) {    // Order by ASC
        sqlStatement += "ORDER BY DepartmentID ASC";

      } else {                  // Order by DESC
        sqlStatement += "ORDER BY DepartmentID DESC";
      }

    } else {                    // Department Name
      if (isDesc == false) {    // Order by ASC
        sqlStatement += "ORDER BY DepartmentName ASC";

      } else {                  // Order by DESC
        sqlStatement += "ORDER BY DepartmentName DESC";   
      }      
    }
   
    result = stmt.executeQuery(sqlStatement);

    int index = 0;
    while (result.next()) {
      int did        = result.getInt("DepartmentID");
      String name   = result.getString("DepartmentName");
      departmentlist[index++] = String.format("%12d\t  %s\n", did, name);
    }
   
    return departmentlist;
  }
  
  public String[] getColumnNames() throws Exception
  {
   
    String sqlStatement = "SELECT DepartmentID as 'Department ID', " + 
                          "DepartmentName as 'Name' FROM department";

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
    String sqlStatement = "SELECT COUNT(*) AS num FROM department";

    ResultSet result = stmt.executeQuery(sqlStatement);

    int num = 0;
    if (result.next()) {
      num = result.getInt("num");
    }
    String[][] data = new String[num][2];
    
    sqlStatement = "SELECT * FROM department";

    result = stmt.executeQuery(sqlStatement);


    int index = 0;
    while (result.next()) {
      int did       = result.getInt("DepartmentID");
      String name   = result.getString("DepartmentName");
      data[index][0] = Integer.toString(did);
      data[index][1] = name;
      index++;
    }
    
    return data;
  }

  
  public void closeStatement()  throws Exception
  {
    this.stmt.close();
  }
}