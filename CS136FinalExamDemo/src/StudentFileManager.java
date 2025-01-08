import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


import com.google.gson.Gson;

/**
* StudentFileManager Class
*/
public class StudentFileManager
{
  private MyGenericList<Student> studentList;
  private String studentFileName;
  private int last_sid;

  /**
   * Constructor
   * @param filename
   */
  StudentFileManager(String filename) throws IOException
  {
    // Create an MyGenericList to hold some Student objects.
    studentList = new MyGenericList<>();
    File fileStudent = new File(filename);
    int maxId = 0;

    studentFileName = filename;
    if (fileStudent.exists()) {
      // Open file.
      Scanner inputFile = new Scanner(fileStudent);
  
      while (inputFile.hasNext()) {
        // Read the student information from the file.
        String str = inputFile.nextLine();
  
        // A snippet of code to parse the comma separated fields. 
        String[] student_Array = str.split(",");
  
        int id       = Integer.parseInt(student_Array[0]);
  
        // A snippet of code to parse the space separated fields. 
        String[] name_Array = student_Array[1].split(" ");
        String fname;
        String lname;
        String addr;
        String city;
        String state;
        String zip;
        if (name_Array.length < 1) {
          fname = "";
          lname = "";           

        } else if (name_Array.length < 2) {
          fname = name_Array[0];
          lname = "";           

        } else {
          fname = "";
          for (int i = 0; i < name_Array.length - 1; i++) {
            fname += name_Array[i];
            if (i < name_Array.length - 2) {
              fname += " "; 
            }
          }
          lname = name_Array[name_Array.length-1];
        }
  
        if (student_Array.length < 3) {
          addr = "";

        } else {
          addr = student_Array[2];
        }
  
        if (student_Array.length < 4) {
          city = "";

        } else {
          city = student_Array[3];
        }
  
        if (student_Array.length < 5) {
          state = "";

        } else {
          state = student_Array[4];
        }
  
        // Bug Fixed - 
        // When zip is empty, it causes student_Array[5] not to exist. 
        if (student_Array.length < 6) {
          zip = "";

        } else {
          zip   = student_Array[5];
        }
        // Add a student to the ArrayList.
        studentList.add(new Student(id, fname, lname, addr, city, state, zip));

        // Set the last student ID for a new student.
        //last_sid = id;
        maxId = Math.max(maxId, id);
      }
      last_sid = maxId;
  
      // Close file.
      inputFile.close();                        
    }
 }

  /**
   * addStudent method
   * Calls GetStudent method with id to check if the student with that id exist
   * in the Student ArrayList.
   * If no, then adds the student to the end of the ArrayList.
   * Opens the file and writes the ArrayList to the file. Return true.
   * If the student with id exist, Displays error message. Return false
   * @param id The student ID.
   * @param fname The student first name.
   * @param lname The student last name.
   * @param address The address.
   * @param city The city.
   * @param state The state.
   * @param zip The zip code.
   */
  public void addStudent(int id, String fname, String lname, String address,
                        String city,  String state, String zip)
                        throws Exception
  {
   
    int sid = last_sid + 1;
   
    // Calls getStudentInfo method with id to check if the student with 
    // that id exist in the Student ArrayList.
    Student studentInfo = getStudentInfo(id);

    // If no, then adds the student to the end of the ArrayList.
    // Opens the file and writes the ArrayList to the file.
    if (studentInfo == null) {
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

      studentList.add(new Student(sid, fname, lname, address, city, state, zip));

      FileWriter fwriter     = new FileWriter(studentFileName, false);

      PrintWriter outputFile = new PrintWriter(fwriter);

      for (int index = 0; index < studentList.size(); index++) {
        studentInfo = studentList.get(index);
        outputFile.print(studentInfo.getId() + ",");
        outputFile.print(studentInfo.getFName() + " ");
        outputFile.print(studentInfo.getLName() + ",");
        outputFile.print(studentInfo.getAddress() + ",");
        outputFile.print(studentInfo.getCity() + ",");
        outputFile.print(studentInfo.getState() + ",");
        outputFile.println(studentInfo.getZip());
      }                 
      outputFile.close();
     
      // Update last_eid to the last enrollment ID.
      last_sid = sid;

    } else {
      // If the student with id exist, throw an InvalidStudentIDExist exception.
      throw new InvalidStudentIDExist(id);
    }       
  }

  /**
   * getStudentInfo method
   * Checks to see if the student with that id exist in the ArrayList.
   * If yes, then read the student info into student object and returns student object.
   * If the student with id does not exist, return null.
   * @param id
   * @return
   */
  public Student getStudentInfo(int id)
  {
    Student studentInfo = null;

    // Check to see if the student with that id exist in the MyGenericList.
    for (int index = 0; index < studentList.size(); index++) {
      if (id == studentList.get(index).getId()) {
        // If yes, then read the student info into student object and 
        // returns student object.
        studentInfo = studentList.get(index);
      }
    }      

    return studentInfo;
  }

  /**
   * UpdateStudent method
   * Calls GetStudent method with id to check to see if the student with that id exist
   * in the Student ArrayList.
   * If found, updates the objects in the Arraylist for that student id.
   * Writes the whole arraylist back to the file and returns true.
   * If not found, displays error message and returns false.
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
    // Calls getStudentInfo method with id to check to see if the student with 
    // that id exist in the Student ArrayList.
    Student studentInfo = getStudentInfo(id);

    // If found, updates the objects in the Arraylist for that student id.
    // Writes the whole arraylist back to the file and returns true.
    if (studentInfo != null) {
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

      FileWriter fwriter     = new FileWriter(studentFileName, false);

      PrintWriter outputFile = new PrintWriter(fwriter);

      for (int index = 0; index < studentList.size(); index++) {
        studentInfo = studentList.get(index);

        if (id == studentInfo.getId()) {
          // call the mutator methods of Student Object 
          // to set the student infomation.
          studentInfo.setFName(fname);
          studentInfo.setLName(lname);
          studentInfo.setAddress(address);
          studentInfo.setCity(city);
          studentInfo.setState(state);
          studentInfo.setZip(zip);

          // Set a Student object in the ArrayList.
          studentList.set(index, studentInfo);          
        }

        outputFile.print(studentInfo.getId() + ",");
        outputFile.print(studentInfo.getFName() + " ");
        outputFile.print(studentInfo.getLName() + ",");
        outputFile.print(studentInfo.getAddress() + ",");
        outputFile.print(studentInfo.getCity() + ",");
        outputFile.print(studentInfo.getState() + ",");
        outputFile.println(studentInfo.getZip());
      }                 
      outputFile.close();

    } else {
      // If not found, throw an InvalidStudentID exception.
      throw new InvalidStudentID(id);
    }   
  }

  /**
   * deleteStudent method
   * @param id The student ID.
   */
  public void deleteStudent(int id) throws Exception
  {
    // Calls getStudentInfo method with id to check to see if the student with 
    // that id exist in the Student ArrayList.
    Student studentInfo = getStudentInfo(id);

    // If found, updates the objects in the Arraylist for that student id.
    // Writes the whole arraylist back to the file and returns true.
    if (studentInfo != null) {
      // If the student information is empty, 
      // it throws an InvalidStudentInfo exception.
      if (id < 0) {
        throw new InvalidStudentInfo("Student ID");
      }

      FileWriter fwriter     = new FileWriter(studentFileName, false);

      PrintWriter outputFile = new PrintWriter(fwriter);

      for (int index = 0; index < studentList.size(); index++) {
        studentInfo = studentList.get(index);

        if (id == studentInfo.getId()) {

          // delete a Student object in the ArrayList.
          studentList.delete(index);
          continue;
        }

        outputFile.print(studentInfo.getId() + ",");
        outputFile.print(studentInfo.getFName() + " ");
        outputFile.print(studentInfo.getLName() + ",");
        outputFile.print(studentInfo.getAddress() + ",");
        outputFile.print(studentInfo.getCity() + ",");
        outputFile.print(studentInfo.getState() + ",");
        outputFile.println(studentInfo.getZip());
      }                 
      outputFile.close();

    } else {
      // If not found, throw an InvalidStudentID exception.
      throw new InvalidStudentID(id);
    }   
  }
  
  /**
   * getStudentLastId method
   * @return id
   */
  public int getStudentNewId() 
  {
    return last_sid + 1;
  }
 
  /**
   * getStudentFName method
   * @param id
   * @return
   */
  public String getStudentFName(int id) throws Exception
  {
    Student studentInfo = getStudentInfo(id);

    if (studentInfo != null) {
      return studentInfo.getFName();

    } else {
      throw new InvalidStudentID(id);
    }
  }

  /**
   * getStudentFName method
   * @param id
   * @return
   */
  public String getStudentLName(int id) throws Exception
  {
    Student studentInfo = getStudentInfo(id);

    if (studentInfo != null) {
      return studentInfo.getLName();

    } else {
      throw new InvalidStudentID(id);
    }
  }

  /**
   * getStudentAddress method
   * @param id
   * @return
   */
  public String getStudentAddress(int id) throws Exception 
  {
    Student studentInfo = getStudentInfo(id);

    if (studentInfo != null) {
      return studentInfo.getAddress();

    } else {
      throw new InvalidStudentID(id);
    }
  }

  /**
   * getStudentCity method
   * @param id
   * @return
   */
  public String getStudentCity(int id) throws Exception 
  {
    Student studentInfo = getStudentInfo(id);

    if (studentInfo != null) {
      return studentInfo.getCity();

    } else {
      throw new InvalidStudentID(id);
    }
  }

  /**
   * getStudentState method
   * @param id
   * @return
   */
  public String getStudentState(int id) throws Exception 
  {
    Student studentInfo = getStudentInfo(id);

    if (studentInfo != null) {
      return studentInfo.getState();

    } else {
      throw new InvalidStudentID(id);
    }
  }

  /**
   * getStudentZipCode method
   * @param id
   * @return
   */
  public String getStudentZipCode(int id) throws Exception 
  {
    Student studentInfo = getStudentInfo(id);

    if (studentInfo != null) {
      return studentInfo.getZip();

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
 

  /**
   * setStudentIdSort method
   * @param isDesc
   * @return
   */
  public void setStudentIdSort(boolean isDesc)
  {
    studentList.sort(isDesc);
  }
  
  public String[] searchStudentList(int field, boolean isDesc)
  {
    String[] studentlistArry = new String[last_sid];
    Student studentInfo;
    int index = 0;
    
    if (field == 0) {           // Student ID
      if (isDesc == false) {
        for (int i = 1; i <= last_sid; i++) {
          studentInfo = getStudentInfo(i);
          if (studentInfo != null) {
            int sid        = studentInfo.getId();
            String fname   = studentInfo.getFName();
            String lname   = studentInfo.getLName();
            String address = studentInfo.getAddress() + " " +
                             studentInfo.getCity() + ", " +
                             studentInfo.getState() + " " +
                             studentInfo.getZip();
            studentlistArry[index++] = String.format("%15d\t%s\t%s\n", sid, fname + " " + lname, address);
          }
        }
        
      } else {
        for (int i = last_sid; i > 0; i--) {
          studentInfo = getStudentInfo(i);
          if (studentInfo != null) {
            int sid        = studentInfo.getId();
            String fname   = studentInfo.getFName();
            String lname   = studentInfo.getLName();
            String address = studentInfo.getAddress() + " " +
                             studentInfo.getCity() + ", " +
                             studentInfo.getState() + " " +
                             studentInfo.getZip();
            studentlistArry[index++] = String.format("%15d\t%s\t%s\n", sid, fname + " " + lname, address);
          }
        }        
      }

    } else if (field == 1) {    // Student Last Name
      studentList.sort(isDesc);
      
      // Check to see if the student with that id exist in the ArrayList.
      for (int i = 0; i < studentList.size(); i++) {
        studentInfo = studentList.get(i);
        if (studentInfo != null) {
          int sid        = studentInfo.getId();
          String fname   = studentInfo.getFName();
          String lname   = studentInfo.getLName();
          String address = studentInfo.getAddress() + " " +
                           studentInfo.getCity() + ", " +
                           studentInfo.getState() + " " +
                           studentInfo.getZip();
          studentlistArry[index++] = String.format("%15d\t%s\t%s\n", sid, fname + " " + lname, address);
        }
      }     
    }
    
    return studentlistArry;
  }
}