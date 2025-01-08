/**
 * InvalidStudentID exceptions are thrown by the StudentFileManager class 
 * when a invalid student ID is passed to the constructor.
 */
public class InvalidStudentID extends Exception
{
  /**
   * This constructor uses a generic error message.
   * @exception InvalidEmployeeNumber when the number is invalid.
   */
  public InvalidStudentID()
  {
    super("The student with the ID does not exist.");
  }

  /**
   * This constructor specifies the id in the error message.
   * @param student id.
   * @exception InvalidStudentID when the id is invalid.
   */
  public InvalidStudentID(int id)
  {
    super("The student with the ID [" + id + "] does not exist.");
  }
}

/**
 * public class InvalidStudentIDExist extends Exception exceptions 
 * are thrown by the StudentFileManager class 
 * when an exist student ID is added.
 */
class InvalidStudentIDExist extends Exception
{
  /**
   * This constructor uses a generic error message.
   * @exception InvalidStudentIDExist when the student id is exist.
   */
  public InvalidStudentIDExist()
  {
    super("The student with the ID already exists.");
  }

  /**
   * This constructor specifies the id in the error message.
   * @param student id.
   * @exception InvalidStudentIDExist when the student id is exist..
   */
  public InvalidStudentIDExist(int id)
  {
    super("The student with the ID [" + id + "] already exists.");
  }
}

/**
 * public class InvalidStudentIDExist extends Exception exceptions 
 * are thrown by the StudentFileManager class 
 * when an exist student ID is added or updated.
 */
class InvalidStudentInfo extends Exception
{
  /**
   * This constructor uses a generic error message.
   * @exception InvalidStudentInfo when the student info is invalid.
   */
  public InvalidStudentInfo()
  {
    super("The student information is invalid.");
  }

  /**
   * This constructor uses a generic error message.
   * @exception InvalidStudentInfo when the student info is invalid.
   */
  public InvalidStudentInfo(String info)
  {
    super("The " + info + " field is invalid.");
  }
}

/**
 * InvalidProfessorID exceptions are thrown by the ProfessorFileManager class 
 * when a invalid professor ID is passed to the constructor.
 */
class InvalidProfessorID extends Exception
{
  /**
   * This constructor uses a generic error message.
   * @exception InvalidProfessorID when the number is invalid.
   */
  public InvalidProfessorID()
  {
    super("The professor with the ID does not exist.");
  }

  /**
   * This constructor specifies the id in the error message.
   * @param professor id.
   * @exception InvalidProfessorID when the id is invalid.
   */
  public InvalidProfessorID(int id)
  {
    super("The professor with the ID [" + id + "] does not exist.");
  }
}

/**
 * public class InvalidProfessorIDExist extends Exception exceptions 
 * are thrown by the ProfessorFileManager class 
 * when an exist professor ID is added.
 */
class InvalidProfessorIDExist extends Exception
{
  /**
   * This constructor uses a generic error message.
   * @exception InvalidProfessorIDExist when the professor id is exist.
   */
  public InvalidProfessorIDExist()
  {
    super("The professor with the ID already exists.");
  }

  /**
   * This constructor specifies the id in the error message.
   * @param professor id.
   * @exception InvalidStudentIDExist when the professor id is exist..
   */
  public InvalidProfessorIDExist(int id)
  {
    super("The professor with the ID [" + id + "] already exists.");
  }
}

/**
 * public class InvalidProfessorIDExist extends Exception exceptions 
 * are thrown by the ProfessorFileManager class 
 * when an exist professor ID is added or updated.
 */
class InvalidProfessorInfo extends Exception
{
  /**
   * This constructor uses a generic error message.
   * @exception InvalidProfessorInfo when the professor info is invalid.
   */
  public InvalidProfessorInfo()
  {
    super("The professor information is invalid.");
  }

  /**
   * This constructor uses a generic error message.
   * @exception InvalidProfessorInfo when the professor info is invalid.
   */
  public InvalidProfessorInfo(String info)
  {
    super("The " + info + " field is invalid.");
  }
}


/**
 * InvalidDepartmentID exceptions are thrown by the DepartmentFileManager class 
 * when a invalid Department ID is passed to the constructor.
 */
class InvalidDepartmentID extends Exception
{
  /**
   * This constructor uses a generic error message.
   * @exception InvalidDepartmentID when the number is invalid.
   */
  public InvalidDepartmentID()
  {
    super("The department with the ID does not exist.");
  }

  /**
   * This constructor specifies the id in the error message.
   * @param department id.
   * @exception InvalidDepartmentID when the id is invalid.
   */
  public InvalidDepartmentID(int id)
  {
    super("The department with the ID [" + id + "] does not exist.");
  }
}

/**
 * public class InvalidDepartmentIDExist extends Exception exceptions 
 * are thrown by the DepartmentFileManager class 
 * when an exist department ID is added.
 */
class InvalidDepartmentIDExist extends Exception
{
  /**
   * This constructor uses a generic error message.
   * @exception InvalidDepartmentIDExist when the department id is exist.
   */
  public InvalidDepartmentIDExist()
  {
    super("The department with the ID already exists.");
  }

  /**
   * This constructor specifies the id in the error message.
   * @param department id.
   * @exception InvalidStudentIDExist when the department id is exist..
   */
  public InvalidDepartmentIDExist(int id)
  {
    super("The department with the ID [" + id + "] already exists.");
  }
}

/**
 * public class InvalidDepartmentIDExist extends Exception exceptions 
 * are thrown by the departmentFileManager class 
 * when an exist department ID is added or updated.
 */
class InvalidDepartmentInfo extends Exception
{
  /**
   * This constructor uses a generic error message.
   * @exception InvalidDepartmentInfo when the department info is invalid.
   */
  public InvalidDepartmentInfo()
  {
    super("The department information is invalid.");
  }

  /**
   * This constructor uses a generic error message.
   * @exception InvalidDepartmentInfo when the department info is invalid.
   */
  public InvalidDepartmentInfo(String info)
  {
    super("The " + info + " field is invalid.");
  }
}

/**
 * InvalidCourseID exceptions are thrown by the CourseFileManager class 
 * when a invalid course ID is passed to the constructor.
 */
class InvalidCourseID extends Exception
{
  /**
   * This constructor uses a generic error message.
   * @exception InvalidCourseID when the Course ID is invalid.
   */
  public InvalidCourseID()
  {
    super("The Course with the ID does not exist.");
  }

  /**
   * This constructor specifies the id in the error message.
   * @param course id.
   * @exception InvalidCourseID when the id is invalid.
   */
  public InvalidCourseID(int id)
  {
    super("The Course with the ID [" + id + "] does not exist.");
  }
}


/**
 * public class InvalidCourseIDExist extends Exception exceptions 
 * are thrown by the CourseFileManager class 
 * when an exist Course ID is added.
 */
class InvalidCourseIDExist extends Exception
{
  /**
   * This constructor uses a generic error message.
   * @exception InvalidCourseIDExist when the Course id is exist.
   */
  public InvalidCourseIDExist()
  {
    super("The Course with the ID already exists.");
  }

  /**
   * This constructor specifies the id in the error message.
   * @param Course id.
   * @exception InvalidCourseIDExist when the Course id is exist..
   */
  public InvalidCourseIDExist(int id)
  {
    super("The Course with the ID [" + id + "] already exists.");
  }
}

/**
 * public class InvalidCourseInfo extends Exception exceptions 
 * are thrown by the InvalidCourseInfo class 
 * when an exist student ID is added or updated.
 */
class InvalidCourseInfo extends Exception
{
  /**
   * This constructor uses a generic error message.
   * @exception InvalidStudentInfo when the Course info is invalid.
   */
  public InvalidCourseInfo()
  {
    super("The Course information is invalid.");
  }

  /**
   * This constructor uses a generic error message.
   * @exception InvalidCourseInfo when the Course info is invalid.
   */
  public InvalidCourseInfo(String info)
  {
    super("The " + info + " field is invalid.");
  }
}

/**
 * InvalidCourseID exceptions are thrown by the CourseFileManager class 
 * when a invalid course ID is passed to the constructor.
 */
class InvalidCourseName extends Exception
{
  /**
   * This constructor uses a generic error message.
   * @exception InvalidCourseID when the Course ID is invalid.
   */
  public InvalidCourseName()
  {
    super("The Course with the name does not exist.");
  }
}

/**
 * InvalidEnrollmentID exceptions are thrown by the EnrollmentFileManager class 
 * when a invalid enrollment ID is passed to the constructor.
 */
class InvalidEnrollmentID extends Exception
{
  /**
   * This constructor uses a generic error message.
   * @exception InvalidEnrollmentID when the enrollment ID is invalid.
   */
  public InvalidEnrollmentID()
  {
    super("The Enrollment with the ID does not exist.");
  }

  /**
   * This constructor specifies the id in the error message.
   * @param course id.
   * @exception InvalidCourseID when the id is invalid.
   */
  public InvalidEnrollmentID(int id)
  {
    super("The Enrollment with the ID [" + id + "] does not exist.");
  }
}

/**
 * public class InvalidEnrollmentIDExist extends Exception exceptions 
 * are thrown by the EnrollmentFileManager class 
 * when an exist enrollment ID is added.
 */
class InvalidEnrollmentIDExist extends Exception
{
  /**
   * This constructor uses a generic error message.
   * @exception InvalidEnrollmentIDExist when the Enrollment id is exist.
   */
  public InvalidEnrollmentIDExist()
  {
    super("The Enrollment with the SID, CID, Year and Semester already exists.");
  }
}

/**
 * public class InvalidEnrollmentInfo extends Exception exceptions 
 * are thrown by the enrollmentFileManager class 
 * when an exist student ID is added or updated.
 */
class InvalidEnrollmentInfo extends Exception
{
  /**
   * This constructor uses a generic error message.
   * @exception InvalidEnrollmentInfo when the enrollment info is invalid.
   */
  public InvalidEnrollmentInfo()
  {
    super("The Enrollment information is invalid.");
  }

  /**
   * This constructor uses a generic error message.
   * @exception InvalidEnrollmentInfo when the enrollment info is invalid.
   */
  public InvalidEnrollmentInfo(String info)
  {
    super("The " + info + " field is invalid.");
  }
}

/**
 * InvalidEnrollmentID exceptions are thrown by the EnrollmentFileManager class 
 * when a invalid enrollment ID is passed to the constructor.
 */
class InvalidEnrollment extends Exception
{
  /**
   * This constructor uses a generic error message.
   * @exception InvalidEnrollmentID when the enrollment ID is invalid.
   */
  public InvalidEnrollment()
  {
    super("The Enrollment with the Course ID does not exist.");
  }
}