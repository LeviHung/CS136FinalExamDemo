import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import java.sql.*;
/**
* StudentDBManager Class
*/
public class StudentDBManager
{
  private Statement stmt;
  
  /**
   * Constructor
   * @param filename
   */
  StudentDBManager(Connection conn) throws Exception
  {

    this.stmt = conn.createStatement();
    
  }

  /**
   * addStudent method
   * @param fname The student first name.
   * @param lname The student last name.
   * @param address The address.
   * @param city The city.
   * @param state The state.
   * @param zip The zip code.
   */
  public void addStudent(String fname, String lname, String address,
                        String city,  String state, String zip)
                        throws Exception
  {
      
    if (fname.isEmpty()) {
      throw new InvalidStudentInfo("First Name");
    }
    if (lname.isEmpty()) {
      throw new InvalidStudentInfo("Last Name");
    }
    if (address.isEmpty()) {
      throw new InvalidStudentInfo("Address");
    }
    if (city.isEmpty()) {
      throw new InvalidStudentInfo("City");
    }
    if (state.isEmpty()) {
      throw new InvalidStudentInfo("State");
    }
    if (zip.isEmpty()) {
      throw new InvalidStudentInfo("Zip Code");
    }

    String sqlStatement = 
       "INSERT INTO student (FirstName, LastName, Address, City, State, ZipCode)" +
       "VALUE ('" + 
       fname + "', '" + 
       lname + "', '" + 
       address + "', '" + 
       city + "', '" + 
       state + "', '" + 
       zip + "')";
    
    // Send the statement to the DBMS
    int rows = stmt.executeUpdate(sqlStatement);
    
    // Display the results
    System.out.println(rows + " row(s) added to the student table");
  }

  /**
   * UpdateStudent method
   * @param id The student ID.
   * @param fname The student first name.
   * @param lname The student name name.
   * @param address The address.
   * @param city The city.
   * @param state The state.
   * @param zip The zip code.
   */
  public void updateStudent(int id, String fname, String lname, String address, 
                            String city, String state, String zip)  
                            throws Exception
  {
    // If the student information is empty, 
    // it throws an InvalidStudentInfo exception.
    if (id < 0) {
      throw new InvalidStudentInfo("Student ID");
    }
    if (fname.isEmpty()) {
      throw new InvalidStudentInfo("First Name");
    }
    if (lname.isEmpty()) {
      throw new InvalidStudentInfo("Last Name");
    }
    if (address.isEmpty()) {
      throw new InvalidStudentInfo("Address");
    }
    if (city.isEmpty()) {
      throw new InvalidStudentInfo("City");
    }
    if (state.isEmpty()) {
      throw new InvalidStudentInfo("State");
    }
    if (zip.isEmpty()) {
      throw new InvalidStudentInfo("Zip Code");
    }

    if (findStudent(id)) {
      // Create an UPDATE statement to update the info for the specified student ID
      String sqlStatement = "UPDATE student " + 
          "SET FirstName = '" + fname + 
          "', LastName = '" + lname + 
          "', Address = '" + address + 
          "', City = '" + city +
          "', State = '" + state +
          "', ZipCode = '" + zip +
          "' WHERE StudentID = " + id;
      
      // Send the UPDATE statement to the DBMS
      int rows = stmt.executeUpdate(sqlStatement);
      
      // Display the results
      System.out.println(rows + " row(s) updated.");
          
          
    } else {
      // If not found, throw an InvalidStudentID exception.
      throw new InvalidStudentID(id);
    }
  }

  private boolean findStudent(int id) throws SQLException
  {
    boolean studentFound; // Flag

    // Create a SELECT statement to get the specified row from the student table.
    //String sqlStatement = "SELECT * FROM student WHERE StudentID = " + id;
    String sqlStatement = "CALL FindStudentID(" + id + ")";

    // Send the SELECT statement to the DBMS.
    ResultSet result = stmt.executeQuery(sqlStatement);
    //ResultSet result = stmt.execute(sqlStatement);
    
    // Display the contents of the result set
    if (result.next()) {
      studentFound = true; 

    } else {
      studentFound = false;
    }
    return studentFound; 
  }

  /**
   * deleteStudent method
   * @param id The student ID.
   */
  public void deleteStudent(int id) throws Exception
  {
    if (findStudent(id)) {
      String sqlStatement = "DELETE FROM student WHERE StudentID = " + id;
      
      // Send the UPDATE statement to the DBMS
      int rows = stmt.executeUpdate(sqlStatement);
      
      // Display the results
      System.out.println(rows + " row(s) deleted.");
          
    } else {
      // If not found, throw an InvalidStudentID exception.
      throw new InvalidStudentID(id);
    }  
  }
  
  /**
   * getStudentLastId method
   * @return id
   */
  public int getStudentNewId() throws Exception
  {
    /*
     String sqlStatement = "SELECT `AUTO_INCREMENT` AS id " +
                          "FROM  INFORMATION_SCHEMA.TABLES " +
                          "WHERE TABLE_SCHEMA = 'cs136'" +
                          "AND   TABLE_NAME   = 'student'";
    */
    String sqlStatement = "CALL GetNextStudentID();";

    ResultSet result = stmt.executeQuery(sqlStatement);

    int id = 0;
    if (result.next()) {
      id = result.getInt("id");
    }
    return id;

  }
 
  /**
   * getStudentInfo method
   * @param id
   * @return
   */
  public Student getStudentInfo(int id) throws Exception
  {
    if (findStudent(id)) {
      String sqlStatement = "SELECT FirstName, LastName, Address, " + 
                            "City, State, ZipCode FROM student " + 
                            "WHERE StudentID = " + id;
      
      ResultSet result = stmt.executeQuery(sqlStatement);
      
      if (result.next()) {
        Student stuInfo = new Student(id,
                                      result.getString("FirstName"),
                                      result.getString("LastName"),
                                      result.getString("Address"),
                                      result.getString("City"),
                                      result.getString("State"),
                                      result.getString("ZipCode"));

        return stuInfo;        

      } else {
        throw new InvalidStudentID(id);
      }

    } else {
      throw new InvalidStudentID(id);
    }
  }
 
  public String[] searchStudentCityState(String zip) throws Exception
  {
    String API_URL = "https://api.zippopotam.us/us/" + zip;
    URL url = new URL(API_URL);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
       
    BufferedReader reader = new BufferedReader(
                               new InputStreamReader(connection.getInputStream()));
    String line;
    StringBuilder response = new StringBuilder();
    while ((line = reader.readLine()) != null) {
      response.append(line);
    }
    reader.close();
        
    Gson gson = new Gson();
    ZipCode zipCode = gson.fromJson(response.toString(), ZipCode.class);

    return new String[] {zipCode.getPlaces()[0].getPlaceName(), 
                         zipCode.getPlaces()[0].getState()};
 }
  
  public String[] searchStudentList(int field, boolean isDesc) throws Exception
  {
    String sqlStatement = "SELECT COUNT(*) AS num FROM student";

    ResultSet result = stmt.executeQuery(sqlStatement);

    int num = 0;
    if (result.next()) {
      num = result.getInt("num");
    }
    
    String[] studentlist = new String[num];
    sqlStatement = "SELECT StudentID, FirstName, LastName, Address, City, State, ZipCode FROM student ";

    if (field == 0) {           // Student ID
      if (isDesc == false) {    // Order by ASC
        sqlStatement += "ORDER BY StudentID ASC";

      } else {                  // Order by DESC
        sqlStatement += "ORDER BY StudentID DESC";
      }

    } else {                    // LastName
      if (isDesc == false) {    // Order by ASC
        sqlStatement += "ORDER BY LastName ASC";

      } else {                  // Order by DESC
        sqlStatement += "ORDER BY LastName DESC";    
      }      
    }
    
    result = stmt.executeQuery(sqlStatement);

    int index = 0;
    while (result.next()) {
      int sid        = result.getInt("StudentID");
      String fname   = result.getString("FirstName");
      String lname   = result.getString("LastName");
      String address = result.getString("Address") + " " +
                       result.getString("City") + ", " +
                       result.getString("State") + " " +
                       result.getString("ZipCode");
      studentlist[index++] = String.format("%10d\t%s\t%s\n", sid, lname + ", " + fname , address);
      
    }
    
    return studentlist;
  }
  
  public void closeStatement()  throws Exception
  {
    this.stmt.close();
  }

}