// Levi Hung
// 11/19/24
// CS 136 Final Exam Project

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import java.sql.*;

/**
The Main class demonstrates a menu system.
*/

public class CS136FinalExamDemo extends JFrame
{
  private JLabel fileTopicLabel;
  private final int LABEL_WIDTH = 520;
  private final int LABEL_HEIGHT = 550;
    
  // The following will reference menu components.
  private JMenuBar menuBar; 
  private JMenu fileMenu;
  private JMenu studentMenu;
  private JMenu professorMenu;
  private JMenu departmentMenu;
  private JMenu courseMenu;
  private JMenu enrollMenu;
  private JMenu gradeMenu;
  private JMenu reportMenu;
    
  private JMenuItem exitItem;
  private JMenuItem addStudentItem;
  private JMenuItem viewStudentItem;
  private JMenuItem editStudentItem;
  private JMenuItem listStudentItem;
  private JMenuItem addProfessorItem;
  private JMenuItem viewProfessorItem;
  private JMenuItem editProfessorItem;
  private JMenuItem listProfessorItem;
  private JMenuItem addDepartmentItem;
  private JMenuItem viewDepartmentItem;
  private JMenuItem editDepartmentItem;
  private JMenuItem listDepartmentItem;
  private JMenuItem addCourseItem;
  private JMenuItem viewCourseItem;
  private JMenuItem editCourseItem;
  private JMenuItem listCourseItem;
  private JMenuItem addEnrollItem;
  private JMenuItem viewEnrollItem;
  private JMenuItem editEnrollItem;
  private JMenuItem listEnrollItem;
  private JMenuItem viewGradeItem;
  private JMenuItem editGradeItem;
  private JMenuItem generateReportItem;
    
  private JPanel    studentPanel;
  private JPanel    studentListPanel;
  private JPanel    professorPanel;
  private JPanel    professorListPanel;
  private JPanel    departmentPanel;
  private JPanel    departmentListPanel;
  private JPanel    coursePanel;
  private JPanel    courseListPanel;
  private JPanel    enrollPanel;
  private JPanel    enrollListPanel;
  private JPanel    gradePanel;
  private JPanel    gradeEditPanel;
  private JPanel    reportPanel;
    
  private JLabel studentTopicLabel;
  private JLabel studentIDTextLabel;
  private JLabel studentFNameTextLabel;
  private JLabel studentLNameTextLabel;
  private JLabel studentAddressTextLabel;
  private JLabel studentCityTextLabel;
  private JLabel studentStateTextLabel;
  private JLabel studentZipCodeTextLabel;

  private JTextField studentIDTField;
  private JTextField studentFNameTField;
  private JTextField studentLNameTField;
  private JTextField studentAddressTField;
  private JTextField studentZipCodeTField;
    
  private JButton studentButton;
  private JButton studentCancelButton;
  private JButton studentSearchButton;
  private JButton studentSearchZipButton;
  private JButton studentDeleteButton;

  private JComboBox<String> studentListSortComboBox;
  private JComboBox<String> studentListOrderComboBox;
  private JButton studentListButton;
  private JTextArea studentListTextArea;


  private JLabel professorTopicLabel;
  private JLabel professorIDTextLabel;
  private JLabel professorNameTextLabel;
  private JLabel professorDepartmentTextLabel;

  private JTextField professorIDTField;
  private JTextField professorNameTField;
  private JComboBox<String>  professorDepartmentComboBox;
  
  private JButton professorButton;
  private JButton professorCancelButton;
  private JButton professorSearchButton;
  private JButton professorDeleteButton;
    
  private JComboBox<String> professorListSortComboBox;
  private JComboBox<String> professorListOrderComboBox;
  private JButton professorListButton;
  private JTextArea professorListTextArea;
  private JTable professorListTable;
  
  private JLabel departmentTopicLabel;
  private JLabel departmentIDTextLabel;
  private JLabel departmentNameTextLabel;

  private JTextField departmentIDTField;
  private JTextField departmentNameTField;
  
  private JButton departmentButton;
  private JButton departmentCancelButton;
  private JButton departmentSearchButton;
  private JButton departmentDeleteButton;

  private JComboBox<String> departmentListSortComboBox;
  private JComboBox<String> departmentListOrderComboBox;
  private JButton departmentListButton;
  private JTextArea departmentListTextArea;
  private JTable departmentListTable;
  
  private JLabel courseTopicLabel;
  private JLabel courseIDTextLabel;
  private JLabel courseNameTextLabel;
  private JLabel courseDescriptionTextLabel;
  private JLabel courseNumberTextLabel;
  private JLabel courseDepartmentTextLabel;
  private JLabel courseProfessorTextLabel;
  
  private JTextField courseIDTField;
  private JTextField courseNameTField;
  private JTextField courseDescriptionTField;
  private JTextField courseNumberTField;
  private JComboBox<String>  courseDepartmentComboBox;  
  private JComboBox<String>  courseProfessorComboBox;
    
  private JButton courseButton;
  private JButton courseCancelButton;
  private JButton courseSearchButton;
  private JButton courseDeleteButton;
  
  private JComboBox<String> courseListSortComboBox;
  private JComboBox<String> courseListOrderComboBox;
  private JButton courseListButton;
  private JTextArea courseListTextArea;

  
  private JLabel enrollTopicLabel;
  private JLabel enrollIDTextLabel;
  private JLabel enrollStudentIDTextLabel;
  private JLabel enrollStudentNameTextLabel;
  private JLabel enrollCourseIDTextLabel;
  private JLabel enrollCourseNameTextLabel;
  private JLabel enrollYearTextLabel;
  private JLabel enrollSemesterTextLabel;
  private JLabel enrollGradeTextLabel;

  
  private JTextField enrollIDTField;
  private JTextField enrollStudentIDTField;
  private JComboBox<String>  enrollCourseIDComboBox;
  private JTextField enrollYearTField;
  private JComboBox<String>  enrollSemesterComboBox;
  private JComboBox<String>  enrollGradeComboBox;
    
  //private JTextField enrollGradeTField;
    
  private JButton enrollButton;
  private JButton enrollCancelButton;
  private JButton enrollSearchButton;
  private JButton enrollStudentCheckButton;
  private JButton enrollDeleteButton;
  
  private JComboBox<String> enrollListSortComboBox;
  private JComboBox<String> enrollListOrderComboBox;
  private JButton enrollListButton;
  private JTextArea enrollListTextArea;
  
  private JLabel gradeTopicLabel;
  private JLabel gradeEditTopicLabel;
  private JTextField gradeStudentIDTField;
  private JComboBox<String>  gradeSemesterComboBox;
  private JTextField gradeYearTField;
  private JTextArea gradeTextArea;
  private JButton gradeButton;

  private JTextField gradeEnrollIDTField;
  private JLabel gradeEnrollIDTextLabel;

  private JLabel gradeStudentIDTextLabel;
  private JLabel gradeStudentNameTextLabel;
  private JLabel gradeCourseIDTextLabel;
  private JLabel gradeCourseNameTextLabel;
  private JLabel gradeYearTextLabel;
  private JLabel gradeSemesterTextLabel;

  private JButton gradeSearchButton;
  private JButton gradeEditButton;
  private JButton gradeCancelButton;

  //private JTextField gradeGradeTField;
  private JComboBox<String> gradeGradeComboBox;
  
  private JLabel reportTopicLabel;
  private JComboBox<String> reportCourseIDNameComboBox;
  private JComboBox<String> reportSemesterComboBox;
  private JTextField reportYearTField;
  private JTextArea reportTextArea;
  private JButton reportButton;
    
  // Use MyGenericList
  private static StudentFileManager  studentFM;
  //private static StudentDBManager    studentDM;
  private static ProfessorDBManager  professorDM;
  private static DepartmentDBManager departmentDM;
  private static CourseDBManager     courseDM;
  private static EnrollmentDBManager enrollmentDM;
  private static Connection          conn;
  
  public static final int MSG_ERROR     = 2;
  
  public static final int PANEL_FILE            = 0;
  public static final int PANEL_STUDENT         = 1;
  public static final int PANEL_STUDENT_LIST    = 2;
  public static final int PANEL_INSTRUCTOR      = 3;
  public static final int PANEL_INSTRUCTOR_LIST = 4;
  public static final int PANEL_DEPARTMENT      = 5;
  public static final int PANEL_DEPARTMENT_LIST = 6;
  public static final int PANEL_COURSE          = 7;
  public static final int PANEL_COURSE_LIST     = 8;
  public static final int PANEL_ENROLL          = 9;
  public static final int PANEL_ENROLL_LIST     = 10;
  public static final int PANEL_GRADE           = 11;
  public static final int PANEL_GRADE_EDIT      = 12;
  public static final int PANEL_REPORT          = 13;

  /**
   *  Constructor
   */
    
  public CS136FinalExamDemo()
  {
    // Set the title.
    setTitle("CS 136 Final Exam Project");
        
    // Specify an action for the close button.
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    // Create the fileTopicLabel label.
    fileTopicLabel = new JLabel("Welcome to CS 136 Final Exam Project.",
                                SwingConstants.CENTER);
    fileTopicLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        
    // Set the label's preferred size.
    fileTopicLabel.setPreferredSize(new Dimension(LABEL_WIDTH, LABEL_HEIGHT));
        
    // Set the label's foreground color.
    fileTopicLabel.setForeground(Color.black);
        
    // Add the label to the content pane.
    add(fileTopicLabel);
             
    // Build the menu bar.
    buildMenuBar();
        
    // Pack and display the window.
    pack();
    setVisible(true);
  }

  /**
   * The main method creates an instance of the
   * MenuWindow class, which causes it to display
   * its window.
   */

  public static void main(String[] args)
  {
    
    String DB_URL = "";
    String DB_Username = "";
    String DB_Password = "";
    final String CONFIG_FILE = "app.config";
          
    try {
      
      File fileConfig = new File(CONFIG_FILE);

      // Open file.
      Scanner inputFile = new Scanner(fileConfig);
  
      while (inputFile.hasNext()) {
        // Read the student information from the file.
        String str = inputFile.nextLine();
  
        String decodeStr = Cipher.decode(str, 12);
        
        // A snippet of code to parse the comma separated fields. 
        String[] DB_Array = decodeStr.split(";");
        DB_URL = DB_Array[0];
        DB_Username = DB_Array[1];
        DB_Password = DB_Array[2];
      }
  
      // Close file.
      inputFile.close();
      
      // Create a connection to the database.
      conn = DriverManager.getConnection(DB_URL, DB_Username, DB_Password);
      System.out.println("Connection to CS136 database created.");

      Statement stmt = conn.createStatement();
      
      // Get the real value of the auto_increment field in the tables 
      // rather than the value in the cache.
      String sqlStatement = "SET information_schema_stats_expiry = 0;";
      
      stmt.execute(sqlStatement);
      
      stmt.close();
      
      // Use MyGenericList
      // Create a StudentFileManager object passing student as the filename.
      studentFM = new StudentFileManager("student");
      /*
      // Create a StudentDBManager object passing conn.
      studentDM = new StudentDBManager(conn);
      */
      
      // Create a ProfessorDBManager object passing conn.
      professorDM = new ProfessorDBManager(conn);

      // Create a DepartmentFileManager object passing conn.
      departmentDM = new DepartmentDBManager(conn);

      // Create a CourseFileManager object passing course as the filename.
      courseDM = new CourseDBManager(conn);
    
      // Create a EnrollmentFileManager object passing enrollment as the filename.
      enrollmentDM = new EnrollmentDBManager(conn);

      new CS136FinalExamDemo();

    } catch (IOException e) {
      System.out.println("ERROR: " + e.getMessage());
      e.printStackTrace();

    } catch(Exception ex) {
      System.out.println("ERROR: " + ex.getMessage());
    }
  }
  
  /**
   *  The buildMenuBar method builds the menu bar.
   */
    
  private void buildMenuBar()
  {
    // Create the menu bar.
    menuBar = new JMenuBar();
        
    // Create the file, student, course, and enrollment menus.
    buildFileMenu();
    buildStudentMenu();
    buildProfessorMenu();
    buildDepartmentMenu();
    buildCourseMenu();
    buildEnrollMenu();
    buildGradeMenu();
    buildReportMenu();
        
    // Add the file, student, course, and enrollment menus to the menu bar.
    menuBar.add(fileMenu);
    menuBar.add(studentMenu);
    menuBar.add(professorMenu);
    menuBar.add(departmentMenu);
    menuBar.add(courseMenu);
    menuBar.add(enrollMenu);
    menuBar.add(gradeMenu);
    menuBar.add(reportMenu);
        
    // Set the window's menu bar.
    setJMenuBar(menuBar);
          
    buildStudentPanel();
    buildStudentListPanel();
    buildProfessorPanel();
    buildProfessorListPanel();
    buildDepartmentPanel();
    buildDepartmentListPanel();
    buildCoursePanel();
    buildCourseListPanel();
    buildEnrollPanel();
    buildEnrollListPanel();
    buildGradePanel();
    buildGradeEditPanel();
    buildReportPanel();
  }
    
  /**
   *  The buildFileMenu method builds the File menu and its items.
   */
    
  private void buildFileMenu()
  {
    // Create an Exit menu item.
    exitItem = new JMenuItem("Exit");
    exitItem.setMnemonic(KeyEvent.VK_X);
    exitItem.addActionListener(new ExitListener());
        
    // Create a JMenu object for the File menu.
    fileMenu = new JMenu("File");
    fileMenu.setMnemonic(KeyEvent.VK_F);
        
    // Add the Exit menu item to the File menu.
    fileMenu.add(exitItem);
  }
    
  /**
   *  The buildStudentMenu method builds the student menu and its items.
   */
    
  private void buildStudentMenu()
  {
    // Create the menu items of add, view, and edit student.
    // Add the action listener to each one.
    addStudentItem = new JMenuItem("Add");
    addStudentItem.setMnemonic(KeyEvent.VK_B);
    addStudentItem.addActionListener(new studentListener());
        
    viewStudentItem = new JMenuItem("View");
    viewStudentItem.setMnemonic(KeyEvent.VK_R);
    viewStudentItem.addActionListener(new studentListener());
        
    editStudentItem = new JMenuItem("Edit");
    editStudentItem.setMnemonic(KeyEvent.VK_U);
    editStudentItem.addActionListener(new studentListener());

    listStudentItem = new JMenuItem("List");
    listStudentItem.setMnemonic(KeyEvent.VK_U);
    listStudentItem.addActionListener(new studentListener());

    // Create a JMenu object for the student menu.
    studentMenu = new JMenu("Student");
    studentMenu.setMnemonic(KeyEvent.VK_T);
        
    // Add the menu items to the student menu.
    studentMenu.add(addStudentItem);
    studentMenu.add(viewStudentItem);
    studentMenu.add(editStudentItem);
    studentMenu.add(listStudentItem);
  }

  /**
   *  The buildProfessorMenu method builds the professor menu and its items.
   */
    
  private void buildProfessorMenu()
  {
    // Create the menu items of add, view, and edit professor.
    // Add the action listener to each one.
    addProfessorItem = new JMenuItem("Add");
    addProfessorItem.setMnemonic(KeyEvent.VK_B);
    addProfessorItem.addActionListener(new professorListener());
        
    viewProfessorItem = new JMenuItem("View");
    viewProfessorItem.setMnemonic(KeyEvent.VK_R);
    viewProfessorItem.addActionListener(new professorListener());
        
    editProfessorItem = new JMenuItem("Edit");
    editProfessorItem.setMnemonic(KeyEvent.VK_U);
    editProfessorItem.addActionListener(new professorListener());
        
    listProfessorItem = new JMenuItem("List");
    listProfessorItem.setMnemonic(KeyEvent.VK_U);
    listProfessorItem.addActionListener(new professorListener());
    
    // Create a JMenu object for the professor menu.
    professorMenu = new JMenu("Professor");
    professorMenu.setMnemonic(KeyEvent.VK_T);
        
    // Add the menu items to the professor menu.
    professorMenu.add(addProfessorItem);
    professorMenu.add(viewProfessorItem);
    professorMenu.add(editProfessorItem);
    professorMenu.add(listProfessorItem);
  }

  /**
   *  The buildDepartmentMenu method builds the department menu and its items.
   */
    
  private void buildDepartmentMenu()
  {
    // Create the menu items of add, view, and edit department.
    // Add the action listener to each one.
    addDepartmentItem = new JMenuItem("Add");
    addDepartmentItem.setMnemonic(KeyEvent.VK_B);
    addDepartmentItem.addActionListener(new departmentListener());
        
    viewDepartmentItem = new JMenuItem("View");
    viewDepartmentItem.setMnemonic(KeyEvent.VK_R);
    viewDepartmentItem.addActionListener(new departmentListener());
        
    editDepartmentItem = new JMenuItem("Edit");
    editDepartmentItem.setMnemonic(KeyEvent.VK_U);
    editDepartmentItem.addActionListener(new departmentListener());

    listDepartmentItem = new JMenuItem("List");
    listDepartmentItem.setMnemonic(KeyEvent.VK_U);
    listDepartmentItem.addActionListener(new departmentListener());

    // Create a JMenu object for the department menu.
    departmentMenu = new JMenu("Department");
    departmentMenu.setMnemonic(KeyEvent.VK_T);
        
    // Add the menu items to the department menu.
    departmentMenu.add(addDepartmentItem);
    departmentMenu.add(viewDepartmentItem);
    departmentMenu.add(editDepartmentItem);
    departmentMenu.add(listDepartmentItem);
  }
  /**
   *  The buildCourseMenu method builds the course menu and its items.
   */
    
  private void buildCourseMenu()
  {
    // Create the menu items of add, view, and edit course.
    // Add the action listener to each one.
    addCourseItem = new JMenuItem("Add");
    addCourseItem.setMnemonic(KeyEvent.VK_B);
    addCourseItem.addActionListener(new courseListener());
        
    viewCourseItem = new JMenuItem("View");
    viewCourseItem.setMnemonic(KeyEvent.VK_R);
    viewCourseItem.addActionListener(new courseListener());
        
    editCourseItem = new JMenuItem("Edit");
    editCourseItem.setMnemonic(KeyEvent.VK_U);
    editCourseItem.addActionListener(new courseListener());

    listCourseItem = new JMenuItem("List");
    listCourseItem.setMnemonic(KeyEvent.VK_U);
    listCourseItem.addActionListener(new courseListener());

    // Create a JMenu object for the course menu.
    courseMenu = new JMenu("Course");
    courseMenu.setMnemonic(KeyEvent.VK_T);
        
    // Add the menu items to the course menu.
    courseMenu.add(addCourseItem);
    courseMenu.add(viewCourseItem);
    courseMenu.add(editCourseItem);
    courseMenu.add(listCourseItem);
  }
    
  /**
   *  The buildEnrollMenu method builds the enrollment menu and its items.
   */
    
  private void buildEnrollMenu()
  {
    // Create the menu items of add, view, and edit course.
    // Add the action listener to each one.
    addEnrollItem = new JMenuItem("Add");
    addEnrollItem.setMnemonic(KeyEvent.VK_B);
    addEnrollItem.addActionListener(new enrollListener());
        
    viewEnrollItem = new JMenuItem("View");
    viewEnrollItem.setMnemonic(KeyEvent.VK_R);
    viewEnrollItem.addActionListener(new enrollListener());
        
    editEnrollItem = new JMenuItem("Edit");
    editEnrollItem.setMnemonic(KeyEvent.VK_U);
    editEnrollItem.addActionListener(new enrollListener());

    listEnrollItem = new JMenuItem("List");
    listEnrollItem.setMnemonic(KeyEvent.VK_U);
    listEnrollItem.addActionListener(new enrollListener());

    // Create a JMenu object for the r menu.
    enrollMenu = new JMenu("Enrollment");
    enrollMenu.setMnemonic(KeyEvent.VK_T);
        
    // Add the menu items to the enrollment menu.
    enrollMenu.add(addEnrollItem);
    enrollMenu.add(viewEnrollItem);
    enrollMenu.add(editEnrollItem);
    enrollMenu.add(listEnrollItem);
  }

  /**
   *  The buildGradeMenu method builds the grade menu and its items.
   */
    
  private void buildGradeMenu()
  {
    // Create the menu items of add, view, and edit course.
    // Add the action listener to each one.
    viewGradeItem = new JMenuItem("View");
    viewGradeItem.setMnemonic(KeyEvent.VK_B);
    viewGradeItem.addActionListener(new gradeListener());
    
    editGradeItem = new JMenuItem("Edit");
    editGradeItem.setMnemonic(KeyEvent.VK_U);
    editGradeItem.addActionListener(new gradeListener());
    
    // Create a JMenu object for the grade menu.
    gradeMenu = new JMenu("Grade");
    gradeMenu.setMnemonic(KeyEvent.VK_T);
        
    // Add the menu items to the grade menu.
    gradeMenu.add(viewGradeItem);

    gradeMenu.add(editGradeItem);
  }  
  
  /**
   *  The buildReportMenu method builds the reports menu and its items.
   */
    
  private void buildReportMenu()
  {
    // Create the menu items of generate reports.
    // Add the action listener to each one.
    generateReportItem = new JMenuItem("Generate");
    generateReportItem.setMnemonic(KeyEvent.VK_B);
    generateReportItem.addActionListener(new reportListener());
        
    // Create a JMenu object for the report menu.
    reportMenu = new JMenu("Reports");
    reportMenu.setMnemonic(KeyEvent.VK_T);
        
    // Add the menu items to the report menu.
    reportMenu.add(generateReportItem);
  }
    
  /**
   *  The buildStudentPanel method builds the student panel and its objects.
   */
    
  private void buildStudentPanel()
  {
    studentPanel = new JPanel();
    studentPanel.setLayout(null);
        
    // Create the studentTopicLabel label and studentIDTField TextField.
    studentTopicLabel = new JLabel("Add Student");
    studentTopicLabel.setBounds(240, 30, 200, 30);
    studentTopicLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        
    JLabel studentIDLabel = new JLabel("Student ID");
    studentIDLabel.setBounds(140, 100, 100, 20);
           
    // Create the other labels and TextFields.
    studentIDTField = new   JTextField(30);
    studentIDTField.setBounds(240, 100, 170, 20);

    studentIDTextLabel = new   JLabel("");
    studentIDTextLabel.setBounds(245, 100, 170, 20);

    studentSearchButton = new JButton("Search");
    studentSearchButton.setBounds(430, 100, 100, 20);
    studentSearchButton.addActionListener(new studentButtonListener());
        
    JLabel studentFNameLabel =  new JLabel("First Name");
    studentFNameLabel.setBounds(140, 150, 100, 20);

    studentFNameTextLabel  = new   JLabel("");
    studentFNameTextLabel.setBounds(245, 150, 170, 20);

    studentFNameTField  = new   JTextField(30);
    studentFNameTField.setBounds(240, 150, 170, 20);
        
    JLabel studentLNameLabel =  new JLabel("Last Name");
    studentLNameLabel.setBounds(140, 200, 100, 20);

    studentLNameTextLabel  = new   JLabel("");
    studentLNameTextLabel.setBounds(245, 200, 170, 20);

    studentLNameTField  = new   JTextField(30);
    studentLNameTField.setBounds(240, 200, 170, 20);
            
    JLabel studentAddressLabel =    new JLabel("Address");
    studentAddressLabel.setBounds(140, 250, 100, 20);

    studentAddressTextLabel    = new   JLabel("");
    studentAddressTextLabel.setBounds(245, 250, 200, 20);

    studentAddressTField    = new   JTextField(30);
    studentAddressTField.setBounds(240, 250, 170, 20);
        
    JLabel studentCityLabel =   new JLabel("City");
    studentCityLabel.setBounds(140, 300, 100, 20);
        
    //studentCityTField = new   JTextField(30);
    studentCityTextLabel   = new JLabel("");
    studentCityTextLabel.setBounds(245, 300, 170, 20);
        
    JLabel stateLabel = new JLabel("State");
    stateLabel.setBounds(140, 350, 100, 20);
                
    studentStateTextLabel = new JLabel("");
    studentStateTextLabel.setBounds(245, 350, 170, 20);
        
    JLabel studentZipCodeLabel =    new JLabel("Zip Code");
    studentZipCodeLabel.setBounds(140, 400, 100, 20);

    studentZipCodeTextLabel    = new   JLabel("");
    studentZipCodeTextLabel.setBounds(245, 400, 170, 20);
    
    studentZipCodeTField    = new   JTextField(30);
    studentZipCodeTField.setBounds(240, 400, 170, 20);
        
    studentSearchZipButton = new JButton("Search Zip");
    studentSearchZipButton.setBounds(430, 400, 100, 20);
    studentSearchZipButton.addActionListener(new studentButtonListener());

    
    // Create the add and cancel buttons.
    studentButton = new JButton("Add");
    studentButton.setBounds(140, 500, 100, 20);
    studentButton.addActionListener(new studentButtonListener());
        
    studentCancelButton = new JButton("Cancel");
    studentCancelButton.setBounds(270, 500, 100, 20);
    studentCancelButton.addActionListener(new studentButtonListener());

    studentDeleteButton = new JButton("Delete");
    studentDeleteButton.setBounds(400, 500, 100, 20);
    studentDeleteButton.addActionListener(new studentButtonListener());

    // Add the objects  to the student panel.
    studentPanel.add(studentTopicLabel);
    studentPanel.add(studentIDLabel);
    studentPanel.add(studentIDTextLabel);
    studentPanel.add(studentIDTField);
    studentPanel.add(studentSearchButton);
    studentPanel.add(studentFNameLabel);
    studentPanel.add(studentFNameTextLabel);
    studentPanel.add(studentFNameTField);
    studentPanel.add(studentLNameLabel);
    studentPanel.add(studentLNameTextLabel);
    studentPanel.add(studentLNameTField);
    studentPanel.add(studentAddressLabel);
    studentPanel.add(studentAddressTextLabel);
    studentPanel.add(studentAddressTField);
    studentPanel.add(studentCityLabel);
    studentPanel.add(studentCityTextLabel);
    studentPanel.add(stateLabel);
    studentPanel.add(studentStateTextLabel);
    studentPanel.add(studentZipCodeLabel);
    studentPanel.add(studentZipCodeTextLabel);
    studentPanel.add(studentZipCodeTField);
    studentPanel.add(studentSearchZipButton);
    studentPanel.add(studentButton);
    studentPanel.add(studentCancelButton);   
    studentPanel.add(studentDeleteButton);  
  }

  /**
   *  The buildStudentPanel method builds the student panel and its objects.
   */
    
  private void buildStudentListPanel()
  {
    studentListPanel = new JPanel();
    
    studentListPanel.setLayout(null);
        
    // Create the fileTopicLabel label and studentIDTField TextField.
    JLabel studentListTopicLabel = new JLabel("List Student");
    studentListTopicLabel.setBounds(240, 30, 200, 30);
    studentListTopicLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
         
    JLabel studentListSortLabel = new JLabel("Sort by");
    studentListSortLabel.setBounds(30, 100, 150, 20);        
                 
    String[] sort = {"Student ID", "Student Name"};
        
    studentListSortComboBox = new JComboBox<>(sort);
    studentListSortComboBox.setBounds(20, 150, 170, 20);

    JLabel studentListOrderLabel = new JLabel("Order");
    studentListOrderLabel.setBounds(200, 100, 150, 20);        
                 
    String[] order = {"asecending", "descending"};
        
    studentListOrderComboBox = new JComboBox<>(order);
    studentListOrderComboBox.setBounds(200, 150, 150, 20);

    
    studentListButton = new JButton("List");
    studentListButton.addActionListener(new studentListButtonListener());
    studentListButton.setBounds(420, 150, 105, 20);
        
    studentListTextArea = new JTextArea();
    studentListTextArea.setBounds(20, 200, 540, 320);
         
    JScrollPane scroll = new JScrollPane(studentListTextArea);
    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroll.setBounds(20, 200, 550, 320);
         
    // Add the objects to the grade panel.
    studentListPanel.add(studentListTopicLabel);
    studentListPanel.add(studentListSortLabel);
    studentListPanel.add(studentListOrderLabel);
    studentListPanel.add(studentListSortComboBox);
    studentListPanel.add(studentListOrderComboBox);
    studentListPanel.add(studentListButton);
    studentListPanel.add(scroll);       
  }

  /**
   *  The buildProfessorPanel method builds the professor panel and its objects.
   */
    
  private void buildProfessorPanel()
  {
    professorPanel = new JPanel();
            
    professorPanel.setLayout(null);
        
    // Create the professorTopicLabel label and professorIDTField TextField.
    professorTopicLabel = new JLabel("Add Professor");
    professorTopicLabel.setBounds(240, 30, 200, 30);
    professorTopicLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        
    JLabel professorIDLabel =  new JLabel("Professor ID");
    professorIDLabel.setBounds(140, 100, 100, 20);
        
    // Create the other labels and TextFields.
    professorIDTField = new   JTextField(30);
    professorIDTField.setBounds(240, 100, 170, 20);

    professorIDTextLabel = new   JLabel("");
    professorIDTextLabel.setBounds(245, 100, 120, 20);

    professorSearchButton = new JButton("Search");
    professorSearchButton.setBounds(430, 100, 100, 20);
    professorSearchButton.addActionListener(new professorButtonListener());
        
    JLabel professorNameLabel =  new JLabel("Name");
    professorNameLabel.setBounds(140, 150, 100, 20);

    professorNameTextLabel  = new   JLabel("");
    professorNameTextLabel.setBounds(245, 150, 120, 20);

    professorNameTField  = new   JTextField(30);
    professorNameTField.setBounds(240, 150, 170, 20);
        
    JLabel professorDepartmentLabel = new JLabel("Department");
    professorDepartmentLabel.setBounds(140, 200, 100, 20);

    professorDepartmentTextLabel  = new   JLabel("");
    professorDepartmentTextLabel.setBounds(245, 200, 120, 20);

    String[] department = {""};
    professorDepartmentComboBox = new JComboBox<>(department);
    professorDepartmentComboBox.setBounds(240, 200, 170, 20);

    try {
      DefaultTableModel model = new DefaultTableModel();
      String[] column = professorDM.getColumnNames();
      model.addColumn(column[0]);
      model.addColumn(column[1]);
      model.addColumn(column[2]);
      professorListTable = new JTable(model);
      professorListTable.setEnabled(false);
      
      String[][] data = professorDM.getData();

      model = (DefaultTableModel) professorListTable.getModel();
      for (int i = 0; i < data.length; i++) {
        model.addRow(new Object[]{data[i][0], data[i][1], data[i][2]});        
      }
            
    } catch (Exception ex) {
      showError(ex.getMessage());
    }
    
    professorListTable.setBounds(140, 250, 300, 200);
    
    JScrollPane scroll = new JScrollPane(professorListTable);
    //scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroll.setBounds(140, 250, 300, 200);
    
    // Create the add and cancel buttons.
    professorButton = new JButton("Add");
    professorButton.setBounds(140, 500, 100, 20);
    professorButton.addActionListener(new professorButtonListener());
        
    professorCancelButton = new JButton("Cancel");
    professorCancelButton.setBounds(270, 500, 100, 20);
    professorCancelButton.addActionListener(new professorButtonListener());

    professorDeleteButton = new JButton("Delete");
    professorDeleteButton.setBounds(400, 500, 100, 20);
    professorDeleteButton.addActionListener(new professorButtonListener());

    // Add the objects  to the professor panel.
    professorPanel.add(professorTopicLabel);
    professorPanel.add(professorIDLabel);
    professorPanel.add(professorIDTextLabel);
    professorPanel.add(professorIDTField);
    professorPanel.add(professorSearchButton);
    professorPanel.add(professorNameLabel);
    professorPanel.add(professorNameTextLabel);
    professorPanel.add(professorNameTField);
    professorPanel.add(professorDepartmentLabel);
    professorPanel.add(professorDepartmentTextLabel);
    professorPanel.add(professorDepartmentComboBox);
    professorPanel.add(professorButton);
    professorPanel.add(professorCancelButton);
    professorPanel.add(professorDeleteButton);
    professorPanel.add(scroll);
        
  } 
  
  private void buildProfessorListPanel()
  {
    professorListPanel = new JPanel();
    
    professorListPanel.setLayout(null);
        
    JLabel professorListTopicLabel = new JLabel("List Professor");
    professorListTopicLabel.setBounds(240, 30, 200, 30);
    professorListTopicLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
         
    JLabel professorListSortLabel = new JLabel("Sort by");
    professorListSortLabel.setBounds(30, 100, 170, 20);        
                 
    String[] sort = {"Professor ID", "Professor Name"};
        
    professorListSortComboBox = new JComboBox<>(sort);
    professorListSortComboBox.setBounds(20, 150, 170, 20);

    JLabel professorListOrderLabel = new JLabel("Order");
    professorListOrderLabel.setBounds(210, 100, 150, 20);        
                 
    String[] order = {"asecending", "descending"};
        
    professorListOrderComboBox = new JComboBox<>(order);
    professorListOrderComboBox.setBounds(200, 150, 150, 20);

    
    professorListButton = new JButton("List");
    professorListButton.addActionListener(new professorListButtonListener());
    professorListButton.setBounds(420, 150, 105, 20);
        
    professorListTextArea = new JTextArea();
    professorListTextArea.setBounds(20, 200, 540, 320);
         
    JScrollPane scroll = new JScrollPane(professorListTextArea);
    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroll.setBounds(20, 200, 550, 320);
         
    // Add the objects to the grade panel.
    professorListPanel.add(professorListTopicLabel);
    professorListPanel.add(professorListSortLabel);
    professorListPanel.add(professorListOrderLabel);
    professorListPanel.add(professorListSortComboBox);
    professorListPanel.add(professorListOrderComboBox);
    professorListPanel.add(professorListButton);
    professorListPanel.add(scroll);       
  }  
  
  /**
   *  The buildDepartmentPanel method builds the department panel and its objects.
   */
    
  private void buildDepartmentPanel()
  {
    departmentPanel = new JPanel();
            
    departmentPanel.setLayout(null);
        
    // Create the departmentTopicLabel label and departmentIDTField TextField.
    departmentTopicLabel = new JLabel("Add Department");
    departmentTopicLabel.setBounds(240, 30, 200, 30);
    departmentTopicLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        
    JLabel departmentIDLabel =  new JLabel("Department ID");
    departmentIDLabel.setBounds(140, 100, 100, 20);
        
    // Create the other labels and TextFields.
    departmentIDTField = new   JTextField(30);
    departmentIDTField.setBounds(240, 100, 170, 20);

    departmentIDTextLabel = new   JLabel("");
    departmentIDTextLabel.setBounds(245, 100, 170, 20);

    departmentSearchButton = new JButton("Search");
    departmentSearchButton.setBounds(430, 100, 100, 20);
    departmentSearchButton.addActionListener(new departmentButtonListener());
        
    JLabel departmentNameLabel =  new JLabel("Name");
    departmentNameLabel.setBounds(140, 150, 100, 20);

    departmentNameTextLabel  = new   JLabel("");
    departmentNameTextLabel.setBounds(245, 150, 170, 20);

    departmentNameTField  = new   JTextField(30);
    departmentNameTField.setBounds(240, 150, 170, 20);
    
    try {      
      DefaultTableModel model = new DefaultTableModel();
      String[] column = departmentDM.getColumnNames();
      model.addColumn(column[0]);
      model.addColumn(column[1]);
      departmentListTable = new JTable(model);      
      departmentListTable.setEnabled(false);
      
      String[][] data = departmentDM.getData();

      model = (DefaultTableModel) departmentListTable.getModel();
      for (int i = 0; i < data.length; i++) {
        model.addRow(new Object[]{data[i][0], data[i][1]});        
      }
            
    } catch (Exception ex) {
      showError(ex.getMessage());
    }
    
    departmentListTable.setBounds(140, 250, 300, 200);

    JScrollPane scroll = new JScrollPane(departmentListTable);
    //scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroll.setBounds(140, 250, 300, 200);
    
    // Create the add and cancel buttons.
    departmentButton = new JButton("Add");
    departmentButton.setBounds(140, 500, 100, 20);
    departmentButton.addActionListener(new departmentButtonListener());
        
    departmentCancelButton = new JButton("Cancel");
    departmentCancelButton.setBounds(270, 500, 100, 20);
    departmentCancelButton.addActionListener(new departmentButtonListener());
        
    departmentDeleteButton = new JButton("Delete");
    departmentDeleteButton.setBounds(400, 500, 100, 20);
    departmentDeleteButton.addActionListener(new departmentButtonListener());

    // Add the objects  to the department panel.
    departmentPanel.add(departmentTopicLabel);
    departmentPanel.add(departmentIDLabel);
    departmentPanel.add(departmentIDTextLabel);
    departmentPanel.add(departmentIDTField);
    departmentPanel.add(departmentSearchButton);
    departmentPanel.add(departmentNameLabel);
    departmentPanel.add(departmentNameTextLabel);
    departmentPanel.add(departmentNameTField);
    departmentPanel.add(departmentButton);
    departmentPanel.add(departmentCancelButton);
    departmentPanel.add(departmentDeleteButton);
    departmentPanel.add(scroll); 
  } 
  
  private void buildDepartmentListPanel()
  {
    departmentListPanel = new JPanel();
    
    departmentListPanel.setLayout(null);
        
    JLabel departmentListTopicLabel = new JLabel("List Department");
    departmentListTopicLabel.setBounds(240, 30, 200, 30);
    departmentListTopicLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
         
    JLabel departmentListSortLabel = new JLabel("Sort by");
    departmentListSortLabel.setBounds(30, 100, 170, 20);        
                 
    String[] sort = {"Department ID", "Department Name"};
        
    departmentListSortComboBox = new JComboBox<>(sort);
    departmentListSortComboBox.setBounds(20, 150, 170, 20);

    JLabel departmentListOrderLabel = new JLabel("Order");
    departmentListOrderLabel.setBounds(210, 100, 150, 20);        
                 
    String[] order = {"asecending", "descending"};
        
    departmentListOrderComboBox = new JComboBox<>(order);
    departmentListOrderComboBox.setBounds(200, 150, 150, 20);
    
    departmentListButton = new JButton("List");
    departmentListButton.addActionListener(new departmentListButtonListener());
    departmentListButton.setBounds(420, 150, 105, 20);
        
    departmentListTextArea = new JTextArea();
    departmentListTextArea.setBounds(20, 200, 540, 320);
    

    JScrollPane scroll = new JScrollPane(departmentListTextArea);
    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroll.setBounds(20, 200, 550, 320);
         
    // Add the objects to the grade panel.
    departmentListPanel.add(departmentListTopicLabel);
    departmentListPanel.add(departmentListSortLabel);
    departmentListPanel.add(departmentListOrderLabel);
    departmentListPanel.add(departmentListSortComboBox);
    departmentListPanel.add(departmentListOrderComboBox);
    departmentListPanel.add(departmentListButton);
    departmentListPanel.add(scroll);       
  }  
  /**
   *  The buildCoursePanel method builds the course panel and its objects.
   */
    
  private void buildCoursePanel()
  {
    coursePanel = new JPanel();
            
    coursePanel.setLayout(null);
        
    // Create the courseTopicLabel label and studentIDTField TextField.
    courseTopicLabel = new JLabel("Add Course");
    courseTopicLabel.setBounds(240, 30, 200, 30);
    courseTopicLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        
    JLabel CourseIDLabel =  new JLabel("Course ID");
    CourseIDLabel.setBounds(140, 100, 100, 20);
        
    courseIDTField  = new   JTextField(30);
    courseIDTField.setBounds(240, 100, 170, 20);
        
    courseIDTextLabel = new   JLabel("");
    courseIDTextLabel.setBounds(245, 100, 170, 20);

    courseSearchButton = new JButton("Search");
    courseSearchButton.setBounds(430, 100, 100, 20);
    courseSearchButton.addActionListener(new courseButtonListener());
        
    // Create the other labels and TextFields.
    JLabel courseNameLabel =    new JLabel("Course Name");
    courseNameLabel.setBounds(140, 150, 100, 20);
        
    courseNameTextLabel  = new   JLabel("");
    courseNameTextLabel.setBounds(245, 150, 170, 20);

    courseNameTField    = new   JTextField(30);
    courseNameTField.setBounds(240, 150, 170, 20);
        
    JLabel courseDescriptionLabel = new JLabel("Description");
    courseDescriptionLabel.setBounds(140, 200, 100, 20);

    courseDescriptionTextLabel = new   JLabel("");
    courseDescriptionTextLabel.setBounds(245, 200, 170, 20);

    courseDescriptionTField = new   JTextField(30);
    courseDescriptionTField.setBounds(240, 200, 170, 20);
         
    JLabel courseNumberLabel =  new JLabel("Number");
    courseNumberLabel.setBounds(140, 250, 100, 20);

    courseNumberTextLabel  = new    JLabel("");
    courseNumberTextLabel.setBounds(245, 250, 170, 20);

    courseNumberTField  = new   JTextField(30);
    courseNumberTField.setBounds(240, 250, 170, 20);

    JLabel courseDepartmentLabel =   new JLabel("Department");
    courseDepartmentLabel.setBounds(140, 300, 100, 20);

    courseDepartmentTextLabel = new JLabel("");
    courseDepartmentTextLabel.setBounds(245, 300, 120, 20);

    String[] department = {""};
    courseDepartmentComboBox = new JComboBox<>(department);
    courseDepartmentComboBox.setBounds(240, 300, 170, 20);
    
    courseDepartmentComboBox.addActionListener(new DepartmentChangeListener());

    JLabel courseProfessorLabel =  new JLabel("Professor");
    courseProfessorLabel.setBounds(140, 350, 100, 20);

    courseProfessorTextLabel = new JLabel("");
    courseProfessorTextLabel.setBounds(245, 350, 120, 20);

    String[] professor = {""};
    courseProfessorComboBox = new JComboBox<>(professor);
    courseProfessorComboBox.setBounds(240, 350, 170, 20);
    
    // Create the add and cancel buttons.
    courseButton = new JButton("Add");
    courseButton.setBounds(140, 500, 100, 20);
    courseButton.addActionListener(new courseButtonListener());
         
    courseCancelButton = new JButton("Cancel");
    courseCancelButton.setBounds(270, 500, 100, 20);
    courseCancelButton.addActionListener(new courseButtonListener());
        
    courseDeleteButton = new JButton("Delete");
    courseDeleteButton.setBounds(400, 500, 100, 20);
    courseDeleteButton.addActionListener(new courseButtonListener());

    // Add the objects  to the course panel.
    coursePanel.add(courseTopicLabel);
    coursePanel.add(CourseIDLabel);
    coursePanel.add(courseIDTField);
    coursePanel.add(courseIDTextLabel);
    coursePanel.add(courseSearchButton);
    coursePanel.add(courseNameLabel);
    coursePanel.add(courseNameTextLabel);
    coursePanel.add(courseNameTField);
    coursePanel.add(courseDescriptionLabel);
    coursePanel.add(courseDescriptionTextLabel);
    coursePanel.add(courseDescriptionTField);
    coursePanel.add(courseNumberLabel);
    coursePanel.add(courseNumberTextLabel);
    coursePanel.add(courseNumberTField);
    coursePanel.add(courseDepartmentLabel);
    coursePanel.add(courseDepartmentTextLabel);
    coursePanel.add(courseDepartmentComboBox);
    coursePanel.add(courseProfessorLabel);
    coursePanel.add(courseProfessorTextLabel);
    coursePanel.add(courseProfessorComboBox);
    coursePanel.add(courseButton);
    coursePanel.add(courseCancelButton);
    coursePanel.add(courseDeleteButton);
  }  
    
  private void buildCourseListPanel()
  {
    courseListPanel = new JPanel();
    
    courseListPanel.setLayout(null);
        
    JLabel courseListTopicLabel = new JLabel("List Course");
    courseListTopicLabel.setBounds(240, 30, 200, 30);
    courseListTopicLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
         
    JLabel courseListSortLabel = new JLabel("Sort by");
    courseListSortLabel.setBounds(30, 100, 170, 20);        
                 
    String[] sort = {"Course ID", "Course Name"};
        
    courseListSortComboBox = new JComboBox<>(sort);
    courseListSortComboBox.setBounds(20, 150, 170, 20);

    JLabel courseListOrderLabel = new JLabel("Order");
    courseListOrderLabel.setBounds(210, 100, 150, 20);        
                 
    String[] order = {"asecending", "descending"};
        
    courseListOrderComboBox = new JComboBox<>(order);
    courseListOrderComboBox.setBounds(200, 150, 150, 20);

    courseListButton = new JButton("List");
    courseListButton.addActionListener(new courseListButtonListener());
    courseListButton.setBounds(420, 150, 105, 20);
        
    courseListTextArea = new JTextArea();
    courseListTextArea.setBounds(20, 200, 540, 320);
         
    JScrollPane scroll = new JScrollPane(courseListTextArea);
    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroll.setBounds(20, 200, 550, 320);
         
    // Add the objects to the grade panel.
    courseListPanel.add(courseListTopicLabel);
    courseListPanel.add(courseListSortLabel);
    courseListPanel.add(courseListOrderLabel);
    courseListPanel.add(courseListSortComboBox);
    courseListPanel.add(courseListOrderComboBox);
    courseListPanel.add(courseListButton);
    courseListPanel.add(scroll);       
  }  
  /**
   *  The buildEnrollPanel method builds the enrollment panel and its objects.
   */
    
  private void buildEnrollPanel()
  {
    enrollPanel = new JPanel();
            
    enrollPanel.setLayout(null);
        
    // Create the fileTopicLabel label and studentIDTField TextField.
    enrollTopicLabel = new JLabel("Add Enrollment");
    enrollTopicLabel.setBounds(240, 30, 200, 30);
    enrollTopicLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
         
    JLabel enrollIDLabel =  new JLabel("Enrollment ID");
    enrollIDLabel.setBounds(140, 100, 100, 20);
        
    enrollIDTField  = new   JTextField(30);
    enrollIDTField.setBounds(240, 100, 170, 20);

    enrollIDTextLabel  = new   JLabel("");
    enrollIDTextLabel.setBounds(245, 100, 170, 20);
    
    enrollSearchButton = new JButton("Search");
    enrollSearchButton.setBounds(430, 100, 100, 20);
    enrollSearchButton.addActionListener(new enrollButtonListener());
        
    // Create the other labels and TextFields.
    JLabel enrollStudentIDLabel =   new JLabel("Student ID");
    enrollStudentIDLabel.setBounds(140, 150, 100, 20);
        
    enrollStudentIDTField   = new   JTextField(30);
    enrollStudentIDTField.setBounds(240, 150, 170, 20);

    enrollStudentIDTField.putClientProperty( "JTextField.selectAllOnFocusPolicy", "never" );
    
    enrollStudentIDTextLabel   = new   JLabel("");
    enrollStudentIDTextLabel.setBounds(245, 150, 120, 20);

    enrollStudentCheckButton = new JButton("Search SID");
    enrollStudentCheckButton.setBounds(430, 150, 100, 20);
    enrollStudentCheckButton.addActionListener(new enrollButtonListener());
        
    JLabel enrollStudentNameLabel = new JLabel("Student Name");
    enrollStudentNameLabel.setBounds(140, 200, 170, 20);
        
    enrollStudentNameTextLabel = new   JLabel("");
    enrollStudentNameTextLabel.setBounds(245, 200, 170, 20);
    
    JLabel enrollCourseIDLabel =    new JLabel("Course ID");
    enrollCourseIDLabel.setBounds(140, 250, 100, 20);
        
    String[] course = {""};
    enrollCourseIDComboBox  = new   JComboBox<>(course);
    enrollCourseIDComboBox.setBounds(240, 250, 170, 20);

    enrollCourseIDComboBox.addActionListener(new enrollCourseChangeListener());
    
    enrollCourseIDTextLabel    = new   JLabel("");
    enrollCourseIDTextLabel.setBounds(245, 250, 170, 20);
        
    JLabel enrollCourseNameLabel =  new JLabel("Course Name");
    enrollCourseNameLabel.setBounds(140, 300, 100, 20);

    enrollCourseNameTextLabel  = new   JLabel("");
    enrollCourseNameTextLabel.setBounds(245, 300, 170, 20);

    JLabel enrollYearLabel =    new JLabel("Year");
    enrollYearLabel.setBounds(140, 350, 100, 20);
        
    enrollYearTField    = new   JTextField(30);
    enrollYearTField.setBounds(240, 350, 170, 20);

    enrollYearTextLabel    = new   JLabel("");
    enrollYearTextLabel.setBounds(245, 350, 170, 20);

    JLabel enrollSemesterLabel =    new JLabel("Semester");
    enrollSemesterLabel.setBounds(140, 400, 100, 20);
                
    String[] semester = {"spring", "summer", "fall", "winter"};
        
    enrollSemesterComboBox = new JComboBox<>(semester);
    enrollSemesterComboBox.setBounds(240, 400, 170, 20);

    enrollSemesterTextLabel = new JLabel("");
    enrollSemesterTextLabel.setBounds(245, 400, 170, 20);
    
    JLabel enrollGradeLabel =   new JLabel("Grade");
    enrollGradeLabel.setBounds(140, 450, 100, 20);

    String[] grade = {"", "A", "B", "C", "D", "E", "F", "W", "P"};
    
    enrollGradeComboBox = new JComboBox<>(grade);
    enrollGradeComboBox.setBounds(240, 450, 170, 20);

    enrollGradeTextLabel   = new   JLabel("");
    enrollGradeTextLabel.setBounds(245, 450, 170, 20);

    // Create the add and cancel buttons.
    enrollButton = new JButton("Add");
    enrollButton.setBounds(140, 500, 100, 20);
    enrollButton.addActionListener(new enrollButtonListener());
         
    enrollCancelButton = new JButton("Cancel");
    enrollCancelButton.setBounds(270, 500, 100, 20);
    enrollCancelButton.addActionListener(new enrollButtonListener());
        
    enrollDeleteButton = new JButton("Delete");
    enrollDeleteButton.setBounds(400, 500, 100, 20);
    enrollDeleteButton.addActionListener(new enrollButtonListener());

    // Add the objects to the enrollment panel.
    enrollPanel.add(enrollTopicLabel);
    enrollPanel.add(enrollIDLabel);
    enrollPanel.add(enrollIDTextLabel);
    enrollPanel.add(enrollIDTField);
    enrollPanel.add(enrollSearchButton);
    enrollPanel.add(enrollStudentIDLabel);
    enrollPanel.add(enrollStudentIDTField);
    enrollPanel.add(enrollStudentIDTextLabel);
    enrollPanel.add(enrollStudentCheckButton);
    enrollPanel.add(enrollStudentNameLabel);
    enrollPanel.add(enrollStudentNameTextLabel);
    enrollPanel.add(enrollCourseIDLabel);
    enrollPanel.add(enrollCourseIDComboBox);
    enrollPanel.add(enrollCourseIDTextLabel);
    enrollPanel.add(enrollCourseNameLabel);
    enrollPanel.add(enrollCourseNameTextLabel);
    enrollPanel.add(enrollYearLabel);
    enrollPanel.add(enrollYearTField);
    enrollPanel.add(enrollYearTextLabel);
    enrollPanel.add(enrollSemesterLabel);
    enrollPanel.add(enrollSemesterComboBox);
    enrollPanel.add(enrollSemesterTextLabel);
    enrollPanel.add(enrollGradeLabel);
    enrollPanel.add(enrollGradeComboBox);
    enrollPanel.add(enrollGradeTextLabel);
    enrollPanel.add(enrollButton);
    enrollPanel.add(enrollCancelButton);
    enrollPanel.add(enrollDeleteButton);
  }  
  
  private void buildEnrollListPanel()
  {
    enrollListPanel = new JPanel();
    
    enrollListPanel.setLayout(null);
        
    JLabel enrollListTopicLabel = new JLabel("List Enrollment");
    enrollListTopicLabel.setBounds(240, 30, 200, 30);
    enrollListTopicLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
         
    JLabel enrollListSortLabel = new JLabel("Sort by");
    enrollListSortLabel.setBounds(30, 100, 170, 20);        
                 
    String[] sort = {"Enrollment ID", "Student ID"};
        
    enrollListSortComboBox = new JComboBox<>(sort);
    enrollListSortComboBox.setBounds(20, 150, 170, 20);

    JLabel enrollListOrderLabel = new JLabel("Order");
    enrollListOrderLabel.setBounds(210, 100, 150, 20);        
                 
    String[] order = {"asecending", "descending"};
        
    enrollListOrderComboBox = new JComboBox<>(order);
    enrollListOrderComboBox.setBounds(200, 150, 150, 20);

    enrollListButton = new JButton("List");
    enrollListButton.addActionListener(new enrollListButtonListener());
    enrollListButton.setBounds(420, 150, 105, 20);
        
    enrollListTextArea = new JTextArea();
    enrollListTextArea.setBounds(20, 200, 540, 320);
         
    JScrollPane scroll = new JScrollPane(enrollListTextArea);
    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroll.setBounds(20, 200, 550, 320);
         
    // Add the objects to the grade panel.
    enrollListPanel.add(enrollListTopicLabel);
    enrollListPanel.add(enrollListSortLabel);
    enrollListPanel.add(enrollListOrderLabel);
    enrollListPanel.add(enrollListSortComboBox);
    enrollListPanel.add(enrollListOrderComboBox);
    enrollListPanel.add(enrollListButton);
    enrollListPanel.add(scroll);       
  }  
  
  /**
   *  The buildGradePanel method builds the grade panel and its objects.
   */
    
  private void buildGradePanel()
  {
    gradePanel = new JPanel();
            
    gradePanel.setLayout(null);
        
    // Create the fileTopicLabel label and studentIDTField TextField.
    gradeTopicLabel = new JLabel("View Grade");
    gradeTopicLabel.setBounds(240, 30, 200, 30);
    gradeTopicLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
         
    JLabel courseNameLabel = new JLabel("Student ID");
    JLabel semesterLabel   = new JLabel("Semester");
    JLabel yearrLabel      = new JLabel("Year");
    courseNameLabel.setBounds(30, 100, 100, 20);
    semesterLabel.setBounds(190, 100, 100, 20);
    yearrLabel.setBounds(310, 100, 100, 20);
        
    gradeStudentIDTField = new JTextField();
    gradeStudentIDTField.setBounds(20, 150, 120, 20);
        
    String[] semester = {"spring", "summer", "fall", "winter"};
        
    gradeSemesterComboBox = new JComboBox<>(semester);
    gradeSemesterComboBox.setBounds(180, 150, 110, 20);
        
    gradeYearTField = new JTextField();
    gradeYearTField.setBounds(300, 150, 100, 20);
        
    gradeButton = new JButton("View");
    gradeButton.addActionListener(new gradeButtonListener());
    gradeButton.setBounds(420, 150, 105, 20);
        
    gradeTextArea = new JTextArea();
    gradeTextArea.setBounds(20, 200, 540, 320);
         
    JScrollPane scroll = new JScrollPane(gradeTextArea);
    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroll.setBounds(20, 200, 550, 320);
         
    // Add the objects to the grade panel.
    gradePanel.add(gradeTopicLabel);
    gradePanel.add(courseNameLabel);
    gradePanel.add(semesterLabel);
    gradePanel.add(yearrLabel);
    gradePanel.add(gradeStudentIDTField);
    gradePanel.add(gradeSemesterComboBox);
    gradePanel.add(gradeYearTField);
    gradePanel.add(gradeButton);
    gradePanel.add(scroll);
  }  

  /**
   *  The buildEnrollPanel method builds the enrollment panel and its objects.
   */
    
  private void buildGradeEditPanel()
  {
    gradeEditPanel = new JPanel();
            
    gradeEditPanel.setLayout(null);
        
    // Create the fileTopicLabel label and studentIDTField TextField.
    gradeEditTopicLabel = new JLabel("Edit Grade");
    gradeEditTopicLabel.setBounds(240, 30, 200, 30);
    gradeEditTopicLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
         
    JLabel gradeIDLabel =  new JLabel("Enrollment ID");
    gradeIDLabel.setBounds(140, 100, 100, 20);
        
    gradeEnrollIDTField  = new   JTextField(30);
    gradeEnrollIDTField.setBounds(240, 100, 170, 20);
    
    gradeEnrollIDTextLabel  = new   JLabel("");
    gradeEnrollIDTextLabel.setBounds(245, 100, 170, 20);

    gradeSearchButton = new JButton("Search");
    gradeSearchButton.setBounds(430, 100, 100, 20);
    gradeSearchButton.addActionListener(new gradeEditButtonListener());
        
    // Create the other labels and TextFields.
    JLabel gradeStudentIDLabel =   new JLabel("Student ID");
    gradeStudentIDLabel.setBounds(140, 150, 100, 20);
            
    gradeStudentIDTextLabel   = new   JLabel("");
    gradeStudentIDTextLabel.setBounds(245, 150, 170, 20);
        
    JLabel gradeStudentNameLabel = new JLabel("Student Name");
    gradeStudentNameLabel.setBounds(140, 200, 120, 20);
        
    gradeStudentNameTextLabel = new   JLabel("");
    gradeStudentNameTextLabel.setBounds(245, 200, 170, 20);
    
    JLabel gradeCourseIDLabel =    new JLabel("Course ID");
    gradeCourseIDLabel.setBounds(140, 250, 100, 20);
    
    gradeCourseIDTextLabel    = new   JLabel("");
    gradeCourseIDTextLabel.setBounds(245, 250, 170, 20);
        
    JLabel gradeCourseNameLabel =  new JLabel("Course Name");
    gradeCourseNameLabel.setBounds(140, 300, 100, 20);

    gradeCourseNameTextLabel  = new   JLabel("");
    gradeCourseNameTextLabel.setBounds(245, 300, 170, 20);

    JLabel gradeYearLabel =    new JLabel("Year");
    gradeYearLabel.setBounds(140, 350, 100, 20);

    gradeYearTextLabel    = new   JLabel("");
    gradeYearTextLabel.setBounds(245, 350, 170, 20);

    JLabel gradeSemesterLabel =    new JLabel("Semester");
    gradeSemesterLabel.setBounds(140, 400, 100, 20);       

    gradeSemesterTextLabel = new JLabel("");
    gradeSemesterTextLabel.setBounds(245, 400, 170, 20);
    
    JLabel gradeGradeLabel =   new JLabel("Grade");
    gradeGradeLabel.setBounds(140, 450, 100, 20);

    String[] grade = {"", "A", "B", "C", "D", "E", "F", "W", "P"};
    
    gradeGradeComboBox = new JComboBox<>(grade);
    gradeGradeComboBox.setBounds(240, 450, 170, 20);

    // Create the add and cancel buttons.
    gradeEditButton = new JButton("Edit");
    gradeEditButton.setBounds(140, 500, 100, 20);
    gradeEditButton.addActionListener(new gradeEditButtonListener());
         
    gradeCancelButton = new JButton("Cancel");
    gradeCancelButton.setBounds(270, 500, 100, 20);
    gradeCancelButton.addActionListener(new gradeEditButtonListener());
        
    // Add the objects to the enrollment panel.
    gradeEditPanel.add(gradeEditTopicLabel);
    gradeEditPanel.add(gradeIDLabel);
    gradeEditPanel.add(gradeEnrollIDTextLabel);
    gradeEditPanel.add(gradeEnrollIDTField);
    gradeEditPanel.add(gradeSearchButton);
    gradeEditPanel.add(gradeStudentIDLabel);
    gradeEditPanel.add(gradeStudentIDTextLabel);
    gradeEditPanel.add(gradeStudentNameLabel);
    gradeEditPanel.add(gradeStudentNameTextLabel);
    gradeEditPanel.add(gradeCourseIDLabel);
    gradeEditPanel.add(gradeCourseIDTextLabel);
    gradeEditPanel.add(gradeCourseNameLabel);
    gradeEditPanel.add(gradeCourseNameTextLabel);
    gradeEditPanel.add(gradeYearLabel);
    gradeEditPanel.add(gradeYearTextLabel);
    gradeEditPanel.add(gradeSemesterLabel);
    gradeEditPanel.add(gradeSemesterTextLabel);
    gradeEditPanel.add(gradeGradeLabel);
    gradeEditPanel.add(gradeGradeComboBox);
    gradeEditPanel.add(gradeEditButton);
    gradeEditPanel.add(gradeCancelButton);
  }  
  
  /**
   *  The buildEnrollPanel method builds the enrollment panel and its objects.
   */
    
  private void buildReportPanel()
  {
    reportPanel = new JPanel();
            
    reportPanel.setLayout(null);
        
    reportTopicLabel = new JLabel("Generate Reports");
    reportTopicLabel.setBounds(240, 30, 200, 30);
    reportTopicLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
         
    JLabel courseNameLabel = new JLabel("Course ID Name");
    JLabel semesterLabel   = new JLabel("Semester");
    JLabel yearrLabel      = new JLabel("Year");
    courseNameLabel.setBounds(30, 100, 140, 20);
    semesterLabel.setBounds(190, 100, 100, 20);
    yearrLabel.setBounds(310, 100, 100, 20);
         
    String[] courseList = {""};

    reportCourseIDNameComboBox = new JComboBox<>(courseList);
    reportCourseIDNameComboBox.setBounds(20, 150, 140, 20);
        
    String[] semester = {"spring", "summer", "fall", "winter"};
        
    reportSemesterComboBox = new JComboBox<>(semester);
    reportSemesterComboBox.setBounds(180, 150, 110, 20);
        
    reportYearTField = new JTextField();
    reportYearTField.setBounds(300, 150, 100, 20);
        
    reportButton = new JButton("Generate");
    reportButton.addActionListener(new reportButtonListener());
    reportButton.setBounds(420, 150, 105, 20);
        
    reportTextArea = new JTextArea();
    reportTextArea.setBounds(20, 200, 540, 320);
         
    JScrollPane scroll = new JScrollPane(reportTextArea);
    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scroll.setBounds(20, 200, 550, 320);
         
    // Add the objects to the report panel.
    reportPanel.add(reportTopicLabel);
    reportPanel.add(courseNameLabel);
    reportPanel.add(semesterLabel);
    reportPanel.add(yearrLabel);
    reportPanel.add(reportCourseIDNameComboBox);
    reportPanel.add(reportSemesterComboBox);
    reportPanel.add(reportYearTField);
    reportPanel.add(reportButton);
    reportPanel.add(scroll);
  }  
    
  private void clearStudentInfo()
  {
    studentIDTField.setText("");
    studentFNameTField.setText("");
    studentLNameTField.setText("");
    studentAddressTField.setText("");
    studentZipCodeTField.setText("");
    studentFNameTextLabel.setText("");
    studentLNameTextLabel.setText("");
    studentAddressTextLabel.setText("");
    studentCityTextLabel.setText("");
    studentStateTextLabel.setText("");
    studentZipCodeTextLabel.setText("");
  }

  private void clearProfessorInfo()
  {
    professorIDTField.setText("");
    professorNameTField.setText("");
    professorNameTextLabel.setText("");
    professorDepartmentComboBox.setSelectedIndex(-1);
    professorDepartmentTextLabel.setText("");
  }

  private void clearDepartmentInfo()
  {
    departmentIDTField.setText("");
    departmentNameTField.setText("");
    departmentNameTextLabel.setText("");
  }

  private void clearCourseInfo()
  {
    courseIDTField.setText("");
    courseNameTField.setText("");
    courseDescriptionTField.setText("");
    courseNumberTField.setText("");
  
    courseDepartmentComboBox.setSelectedIndex(-1);
    courseProfessorComboBox.setSelectedIndex(-1);

    courseNameTextLabel.setText("");
    courseDescriptionTextLabel.setText("");
    courseNumberTextLabel.setText("");
    courseDepartmentTextLabel.setText("");
    courseProfessorTextLabel.setText("");
  }
    
  private void clearEnrollInfo()
  {
    enrollIDTField.setText("");
    enrollStudentIDTField.setText("");
    enrollCourseIDComboBox.setSelectedIndex(-1);
    enrollYearTField.setText("");
    enrollSemesterComboBox.setSelectedIndex(-1);
    enrollGradeComboBox.setSelectedIndex(-1);
    enrollStudentIDTextLabel.setText("");
    enrollStudentNameTextLabel.setText("");
    enrollCourseIDTextLabel.setText("");
    enrollCourseNameTextLabel.setText("");
    enrollYearTextLabel.setText("");
    enrollSemesterTextLabel.setText("");
    enrollGradeTextLabel.setText("");
  }

  private void clearGradeInfo()
  {
    gradeStudentIDTField.setText("");
    gradeSemesterComboBox.setSelectedIndex(-1);
    gradeYearTField.setText("");
    gradeTextArea.setText("");
  }

  private void clearGradeEditInfo()
  {
    gradeEnrollIDTField.setText("");
    gradeGradeComboBox.setSelectedIndex(-1);
    gradeStudentIDTextLabel.setText("");
    gradeStudentNameTextLabel.setText("");
    gradeCourseIDTextLabel.setText("");
    gradeCourseNameTextLabel.setText("");
    gradeYearTextLabel.setText("");
    gradeSemesterTextLabel.setText("");
  }

  private void clearReportInfo()
  {
    reportCourseIDNameComboBox.setSelectedIndex(-1);
    reportSemesterComboBox.setSelectedIndex(-1);
    reportYearTField.setText("");
    reportTextArea.setText("");
  }

  private void showInfo(String msg)
  {
    JOptionPane.showMessageDialog(null, msg, "Information", 
                                  JOptionPane.INFORMATION_MESSAGE);
  }

  private void showWarning(String msg)
  {
    JOptionPane.showMessageDialog(null, msg, "Warning", 
                                  JOptionPane.WARNING_MESSAGE);
  }

  private void showError(String msg)
  {
    JOptionPane.showMessageDialog(null, msg, "Error", 
                                  JOptionPane.ERROR_MESSAGE);
  }

  private void setPanelVisible(int panel) 
  {
    
    fileTopicLabel.setVisible(false);
    studentPanel.setVisible(false);
    studentListPanel.setVisible(false);
    professorPanel.setVisible(false);
    professorListPanel.setVisible(false);
    departmentPanel.setVisible(false);
    departmentListPanel.setVisible(false);
    coursePanel.setVisible(false);
    courseListPanel.setVisible(false);
    enrollPanel.setVisible(false);
    enrollListPanel.setVisible(false);
    gradePanel.setVisible(false);
    gradeEditPanel.setVisible(false);
    reportPanel.setVisible(false);
  
    switch (panel) {
      case PANEL_STUDENT:
        studentPanel.setVisible(true);
        break;
      case PANEL_STUDENT_LIST:
        studentListPanel.setVisible(true);
        break;
      case PANEL_INSTRUCTOR:
        professorPanel.setVisible(true);
        break;
      case PANEL_INSTRUCTOR_LIST:
        professorListPanel.setVisible(true);
        break;
      case PANEL_DEPARTMENT:
        departmentPanel.setVisible(true);
        break;
      case PANEL_DEPARTMENT_LIST:
        departmentListPanel.setVisible(true);
        break;
      case PANEL_COURSE:
        coursePanel.setVisible(true);
        break;
      case PANEL_COURSE_LIST:
        courseListPanel.setVisible(true);
        break;
      case PANEL_ENROLL:
        enrollPanel.setVisible(true);
        break;
      case PANEL_ENROLL_LIST:
        enrollListPanel.setVisible(true);
        break;
      case PANEL_GRADE:
        gradePanel.setVisible(true);
        break;
      case PANEL_GRADE_EDIT:
        gradeEditPanel.setVisible(true);
        break;
      case PANEL_REPORT:
        reportPanel.setVisible(true);
        break;
      default:
        break;
    }
  }
  /**
   *  Private inner class that handles the event that
   *  is generated when the user selects Exit from
   *  the File menu.
   */
    
  private class ExitListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      // Close the connection
      try {
        // Use MyGenericList
        //studentDM.closeStatement();
        professorDM.closeStatement();
        departmentDM.closeStatement();
        courseDM.closeStatement();
        enrollmentDM.closeStatement();
        
        conn.close();
      } 
      catch (Exception ex) {
        System.out.println("ERROR: " + ex.getMessage());
      }
      System.exit(0);
    }
  }
    
  /**
   *  Private inner class that handles the event that
   *  is generated when the user selects a menuItem from
   *  the student menu.
   */
    
  private class studentListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      // Get the action command.
      String actionCommand = e.getActionCommand();
      
      if (actionCommand.equals("List")) {
        studentListTextArea.setText("");
        studentListSortComboBox.setSelectedIndex(0);
        studentListOrderComboBox.setSelectedIndex(0);

        setPanelVisible(PANEL_STUDENT_LIST);

        add(studentListPanel);
        
      } else {
        
        setPanelVisible(PANEL_STUDENT);

        add(studentPanel);
            
        // Determine which button was clicked and display
        // a message.
        if (actionCommand.equals("Add")) {
          clearStudentInfo();       
          studentTopicLabel.setText("Add Student");
  
          try {
            // Use MyGenericList
            int sid = studentFM.getStudentNewId();
            //int sid = studentDM.getStudentNewId();
            studentIDTextLabel.setText(Integer.toString(sid));
            studentIDTField.setText(Integer.toString(sid));
            studentIDTextLabel.setVisible(true);
            studentFNameTField.setVisible(true);
            studentLNameTField.setVisible(true);
            studentAddressTField.setVisible(true);
            studentZipCodeTField.setVisible(true);
    
            studentIDTField.setVisible(false);
    
            studentFNameTextLabel.setVisible(false);
            studentLNameTextLabel.setVisible(false);
            studentAddressTextLabel.setVisible(false);
            studentZipCodeTextLabel.setVisible(false);
            
            studentSearchButton.setVisible(false);
            studentButton.setVisible(true);
            studentCancelButton.setVisible(true);
            studentButton.setText("Add");
            studentSearchZipButton.setVisible(true);
            studentDeleteButton.setVisible(false);
            
          } 
          catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
          }
  
        } else if (actionCommand.equals("View")) {
          clearStudentInfo();       
          studentTopicLabel.setText("View Student");
          studentIDTextLabel.setVisible(false);
          studentIDTField.setVisible(true);
  
          studentFNameTextLabel.setVisible(true);
          studentLNameTextLabel.setVisible(true);
          studentAddressTextLabel.setVisible(true);
          studentZipCodeTextLabel.setVisible(true);
  
          studentFNameTField.setVisible(false);
          studentLNameTField.setVisible(false);
          studentAddressTField.setVisible(false);
          studentZipCodeTField.setVisible(false);
  
          
          studentSearchButton.setVisible(true);
          studentButton.setVisible(false);
          studentCancelButton.setVisible(false);
          studentSearchZipButton.setVisible(false);
          studentDeleteButton.setVisible(false);

        } else if (actionCommand.equals("Edit")) {       
          clearStudentInfo();
          studentTopicLabel.setText("Edit Student");
          studentIDTField.setVisible(true);
          
          studentFNameTField.setVisible(true);
          studentLNameTField.setVisible(true);
          studentAddressTField.setVisible(true);
          studentZipCodeTField.setVisible(true);
  
          studentIDTextLabel.setVisible(false);
          studentFNameTextLabel.setVisible(false);
          studentLNameTextLabel.setVisible(false);
          studentAddressTextLabel.setVisible(false);
          studentZipCodeTextLabel.setVisible(false);
  
          studentSearchButton.setVisible(true);
          studentButton.setVisible(true);
          studentCancelButton.setVisible(true);
          studentButton.setText("Edit");
          studentSearchZipButton.setVisible(false);
          studentDeleteButton.setVisible(false);
        }
      }
    }
  }
    
  /**
   * Private inner class that handles the event when
   * the user clicks a button.
   */
    
  private class studentButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      // Get the action command.
      String actionCommand = event.getActionCommand();
      try {
        if (actionCommand.equals("Cancel")) {
          clearStudentInfo();
  
          if (studentTopicLabel.getText() == "Edit Student") {
            studentIDTField.setText("");
            studentIDTField.setVisible(true);
            studentIDTextLabel.setVisible(false);
            studentSearchButton.setVisible(true);
            studentDeleteButton.setVisible(false);
          }

        } else if (actionCommand.equals("Search")) {
          // Call the accessor methods of studentFileManager Object 
          // to get the student's information and display it.
          int id         = Integer.parseInt(studentIDTField.getText());
          
          // Use MyGenericList
          String fname   = studentFM.getStudentFName(id);
          String lname   = studentFM.getStudentLName(id);
          String address = studentFM.getStudentAddress(id);
          String city    = studentFM.getStudentCity(id);
          String state   = studentFM.getStudentState(id);
          String zipCode = studentFM.getStudentZipCode(id);
          /*
          Student stuInfo = studentDM.getStudentInfo(id);
          String fname   = stuInfo.getFName();
          String lname   = stuInfo.getLName();
          String address = stuInfo.getAddress();
          String city    = stuInfo.getCity();
          String state   = stuInfo.getState();
          String zipCode = stuInfo.getZip();
          */
        
          if (studentTopicLabel.getText() == "View Student") {
            studentFNameTextLabel.setText(fname);
            studentLNameTextLabel.setText(lname);
            studentAddressTextLabel.setText(address);
            studentCityTextLabel.setText(city);
            studentStateTextLabel.setText(state);
            studentZipCodeTextLabel.setText(zipCode);

          } else if (studentTopicLabel.getText() == "Edit Student") {  
            studentIDTextLabel.setText(Integer.toString(id));            
            studentFNameTField.setText(fname);
            studentLNameTField.setText(lname);
            studentAddressTField.setText(address);
            studentCityTextLabel.setText(city);
            studentStateTextLabel.setText(state);
            studentZipCodeTField.setText(zipCode);
            studentIDTField.setVisible(false);
            studentIDTextLabel.setVisible(true);
            studentSearchButton.setVisible(false);
            studentSearchZipButton.setVisible(true);
            studentDeleteButton.setVisible(true);
            studentAddressTField.setCaretPosition(0);
          } 

        } else {    // actionCommand.equals("Add" or "Edit" or "Search Zip" or "Delete")                
          String[] strCityState = new String[2];
          // Use MyGenericList
          strCityState = studentFM.searchStudentCityState(studentZipCodeTField.getText());
          //strCityState = studentDM.searchStudentCityState(studentZipCodeTField.getText());
          studentCityTextLabel.setText(strCityState[0]);
          studentStateTextLabel.setText(strCityState[1]);
          
          int id          = Integer.parseInt(studentIDTField.getText());
          String fname    = studentFNameTField.getText();
          String lname    = studentLNameTField.getText();
          String address  = studentAddressTField.getText();
          String city     = studentCityTextLabel.getText();
          String state    = studentStateTextLabel.getText();               
          String zip      = studentZipCodeTField.getText();
          
          if (actionCommand.equals("Add")) {
            // Call addStudent method to add the student to the end of the ArrayList
            // and write the student information in the file. 
            // Use MyGenericList
            studentFM.addStudent(id, fname, lname, address, city, state, zip);
            //studentDM.addStudent(fname, lname, address, city, state, zip);
            showInfo("Add Student Successfully.");    
            clearStudentInfo();

            // Use MyGenericList
            int sid = studentFM.getStudentNewId();
            //int sid = studentDM.getStudentNewId();
            studentIDTextLabel.setText(Integer.toString(sid));
            studentIDTField.setText(Integer.toString(sid));

          } else if (actionCommand.equals("Edit")) {
            // Call updateStudent method to update the student of the ArrayList
            // and write the student information in the file. 
            // Use MyGenericList
            studentFM.updateStudent(id, fname, lname, address, city, state, zip);
            //studentDM.updateStudent(id, fname, lname, address, city, state, zip);
            showInfo("Edit Student successfully.");
            //clearStudentInfo();

          } else if (actionCommand.equals("Delete")) {
            // Use MyGenericList
            studentFM.deleteStudent(id);
            //studentDM.deleteStudent(id);
            enrollmentDM.deleteEnrollmentByStudentId(id);
            
            showInfo("Delete Student successfully.");
            clearStudentInfo();

            studentIDTField.setText("");
            studentIDTField.setVisible(true);
            studentIDTextLabel.setVisible(false);
            studentSearchButton.setVisible(true);
            studentDeleteButton.setVisible(false);
          }
        }

      } catch (InvalidStudentID e) {
        showWarning(e.getMessage());
        clearStudentInfo();

      } catch (InvalidStudentIDExist | InvalidStudentInfo e) {
        showWarning(e.getMessage());           

      } catch (NumberFormatException e) {
        showWarning("The student ID must be integer.");            
        clearStudentInfo();

      } catch (IOException e) {
        showWarning("Zip Code [" + e.getMessage().substring(29) + "] does not exsit.");
        studentCityTextLabel.setText("");
        studentStateTextLabel.setText("");

      } catch (Exception e) {
        showError(e.getMessage());
        clearStudentInfo();
      }
    }
  }

  /**
   * Private inner class that handles the event when
   * the user clicks a button.
   */
   
 private class studentListButtonListener implements ActionListener
 {
   public void actionPerformed(ActionEvent event)
   {
     studentListTextArea.setText("");
       
     String sortStr = (String) studentListSortComboBox.getSelectedItem();
     String orderStr = (String) studentListOrderComboBox.getSelectedItem();;
     int field = 0;
     boolean isDesc = false;
     if (sortStr.equals("Student Name")) {
       field = 1;
     }

     if (orderStr.equals("descending")) {
       isDesc = true;
     }         

     String studentText = "";
     studentText = "Student ID:\tStudent Name:\t Address:\n" +
                   "----------------------------------------------------------------\n";
     studentListTextArea.append(studentText);

     try {
       // Use MyGenericList
       String[] studentList = studentFM.searchStudentList(field, isDesc);
       //String[] studentList = studentDM.searchStudentList(field, isDesc);
       for (int i = 0; i < studentList.length; i++) {
         studentListTextArea.append(studentList[i]);
       }

     } catch (Exception ex) {
       showError(ex.getMessage());
     }
   }
 } 
  
  /**
   *  Private inner class that handles the event that
   *  is generated when the user selects a menuItem from
   *  the professor menu.
   */
    
  private class professorListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      // Get the action command.
      String actionCommand = e.getActionCommand();
        
        
      // Determine which button was clicked and display
      // a message.
      if (actionCommand.equals("List")) {
        professorListTextArea.setText("");
        professorListSortComboBox.setSelectedIndex(0);
        professorListOrderComboBox.setSelectedIndex(0);
        setPanelVisible(PANEL_INSTRUCTOR_LIST);
        add(professorListPanel);

      } else {
        setPanelVisible(PANEL_INSTRUCTOR);
        add(professorPanel);

        try 
        {
          if (actionCommand.equals("Add")) {
            clearProfessorInfo();         
            professorTopicLabel.setText("Add Professor");
  
            professorIDTextLabel.setText(Integer.toString(professorDM.getProfessorNewId()));
            professorIDTField.setText(Integer.toString(professorDM.getProfessorNewId()));
            professorIDTextLabel.setVisible(true);
            professorNameTField.setVisible(true);
            professorDepartmentComboBox.setVisible(true);
    
            professorIDTField.setVisible(false);
            professorNameTextLabel.setVisible(false);
            professorDepartmentTextLabel.setVisible(false);
    
            
            professorSearchButton.setVisible(false);
            professorButton.setVisible(true);
            professorCancelButton.setVisible(true);            
            professorDeleteButton.setVisible(false);
            
            professorButton.setText("Add");
    
            professorDepartmentComboBox.removeAllItems();
          
            String[] departmentList = departmentDM.searchDepartmentList();
            for (int i = 0; i < departmentList.length; i++) {
              professorDepartmentComboBox.addItem(departmentList[i]);
            }
            professorDepartmentComboBox.setSelectedIndex(-1);
          
          } else if (actionCommand.equals("View")) {
            clearProfessorInfo();         
            professorTopicLabel.setText("View Professor");
            professorIDTextLabel.setVisible(false);
            professorIDTField.setVisible(true);
    
            professorNameTextLabel.setVisible(true);
            professorDepartmentTextLabel.setVisible(true);
    
            professorNameTField.setVisible(false);
            professorDepartmentComboBox.setVisible(false);
    
            
            professorSearchButton.setVisible(true);
            professorButton.setVisible(false);
            professorCancelButton.setVisible(false);
            professorDeleteButton.setVisible(false);
          
          } else if (actionCommand.equals("Edit")) {         
            clearProfessorInfo();
            professorTopicLabel.setText("Edit Professor");
            professorIDTField.setVisible(true);
            
            professorNameTField.setVisible(true);
            professorDepartmentComboBox.setVisible(true);
    
            professorIDTextLabel.setVisible(false);
            professorNameTextLabel.setVisible(false);
            professorDepartmentTextLabel.setVisible(false);
    
            professorSearchButton.setVisible(true);
            professorButton.setVisible(true);
            professorCancelButton.setVisible(true);
            professorDeleteButton.setVisible(false);
            
            professorButton.setText("Edit");
            
            professorDepartmentComboBox.removeAllItems();

            String[] departmentList = departmentDM.searchDepartmentList();
            for (int i = 0; i < departmentList.length; i++) {
              professorDepartmentComboBox.addItem(departmentList[i]);
            }
            professorDepartmentComboBox.setSelectedIndex(-1);
          }
        
          String[][] data = professorDM.getData();
  
          DefaultTableModel model = (DefaultTableModel) professorListTable.getModel();
          model.setRowCount(0);
          for (int i = 0; i < data.length; i++) {
            model.addRow(new Object[]{data[i][0], data[i][1], data[i][2]});        
          } 

        } catch (Exception ex) {
          showError(ex.getMessage());
        }  
      }
    }
  }
    
  /**
   * Private inner class that handles the event when
   * the user clicks a button.
   */
    
  private class professorButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      // Get the action command.
      String actionCommand = event.getActionCommand();

      try {
        if (actionCommand.equals("Cancel")) {
          clearProfessorInfo();
  
          if (professorTopicLabel.getText() == "Edit Professor") {
            professorIDTField.setText("");
            professorIDTField.setVisible(true);
            professorIDTextLabel.setVisible(false);
            professorSearchButton.setVisible(true);
            professorDeleteButton.setVisible(false);
          }
  
        } else if (actionCommand.equals("Search")) {
          // Call the accessor methods of professorFileManager Object 
          // to get the professor's information and display it.
          int id         = Integer.parseInt(professorIDTField.getText());
          
          Professor profInfo = professorDM.getProfessorInfo(id);
          String name    = profInfo.getName();
          int did        = profInfo.getDepartmentId();
          
          Department deptInfo = departmentDM.getDepartmentInfo(did);
          
          String department  = deptInfo.getName();
          
          if (professorTopicLabel.getText() == "View Professor") {
            professorNameTextLabel.setText(name);
            professorDepartmentTextLabel.setText(department);

          } else if (professorTopicLabel.getText() == "Edit Professor") {
            professorIDTextLabel.setText(Integer.toString(id));
            professorNameTField.setText(name);
            professorDepartmentComboBox.setSelectedItem(department);
            professorIDTField.setVisible(false);
            professorIDTextLabel.setVisible(true);
            professorSearchButton.setVisible(false);  
            professorDeleteButton.setVisible(true);
          } 

        } else {    //  actionCommand.equals("Add" or "Edit" or "Delete")
          int id          = Integer.parseInt(professorIDTField.getText());
          String name     = professorNameTField.getText();
          
          String department = (String) professorDepartmentComboBox.getSelectedItem();
          int did         = departmentDM.getDepartmentIDByName(department);
          
          if (actionCommand.equals("Add")) {
            // Call addProfessor method to add the professor to the end of the ArrayList
            // and write the professor information in the file. 
            professorDM.addProfessor(name, did);
            showInfo("Add Professor Successfully.");    
            clearProfessorInfo();
            int pid = professorDM.getProfessorNewId();
            professorIDTextLabel.setText(Integer.toString(pid));
            professorIDTField.setText(Integer.toString(pid));

          } else if (actionCommand.equals("Edit")) {
            // Call updateProfessor method to update the professor of the ArrayList
            // and write the professor information in the file. 
            professorDM.updateProfessor(id, name, did);
            showInfo("Edit Professor successfully.");
            //clearProfessorInfo();

          } else if (actionCommand.equals("Delete")) {
            professorDM.deleteProfessor(id);
            showInfo("Delete Professor successfully.");
            clearProfessorInfo();
            professorIDTField.setText("");
            professorIDTField.setVisible(true);
            professorIDTextLabel.setVisible(false);
            professorSearchButton.setVisible(true);
            professorDeleteButton.setVisible(false);
          }
          
          String[][] data = professorDM.getData();
          
          DefaultTableModel model = (DefaultTableModel) professorListTable.getModel();
          model.setRowCount(0);
          for (int i = 0; i < data.length; i++) {
            model.addRow(new Object[]{data[i][0], data[i][1], data[i][2]});        
          } 
        }

      } catch (InvalidProfessorID e) {
        showWarning(e.getMessage());
        clearProfessorInfo();

      } catch (InvalidProfessorIDExist | InvalidProfessorInfo e) {
        showWarning(e.getMessage());

      } catch (NumberFormatException e) {
        showWarning("The professor ID must be integer.");
        clearProfessorInfo();

      } catch (Exception e) {
        showError(e.getMessage());
        clearProfessorInfo();
      }
    }
  }
  
  private class professorListButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      professorListTextArea.setText("");
         
      String sortStr = (String) professorListSortComboBox.getSelectedItem();
      String orderStr = (String) professorListOrderComboBox.getSelectedItem();;
      int field = 0;
      boolean isDesc = false;
      if (sortStr.equals("Professor Name")) {
        field = 1;
      }
  
      if (orderStr.equals("descending")) {
        isDesc = true;
      }         
  
      String professorText = "";
      professorText = "Professor ID:\tName:\tDepartment ID:\n" +
                    "----------------------------------------------------------------\n";
      professorListTextArea.append(professorText);
      try {
        String[] instuctorList = professorDM.searchProfessorList(field, isDesc);
        for (int i = 0; i < instuctorList.length; i++) {
          professorListTextArea.append(instuctorList[i]);
        }

      } catch (Exception ex) {
        showError(ex.getMessage());
      }
    }
  }
  
  /**
   *  Private inner class that handles the event that
   *  is generated when the user selects a menuItem from
   *  the professor menu.
   */
    
  private class departmentListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      // Get the action command.
      String actionCommand = e.getActionCommand();
      
      if (actionCommand.equals("List")) {
        departmentListTextArea.setText("");
        departmentListSortComboBox.setSelectedIndex(0);
        departmentListOrderComboBox.setSelectedIndex(0);
        setPanelVisible(PANEL_DEPARTMENT_LIST);
        add(departmentListPanel);

      } else {
        setPanelVisible(PANEL_DEPARTMENT);
        add(departmentPanel);

        try {
          // Determine which button was clicked and display a message.
          if (actionCommand.equals("Add")) {
            clearDepartmentInfo();         
            departmentTopicLabel.setText("Add Department");
  
            int did = departmentDM.getDepartmentNewId();
            departmentIDTextLabel.setText(Integer.toString(did));
            departmentIDTField.setText(Integer.toString(did));
            departmentIDTextLabel.setVisible(true);
            departmentNameTField.setVisible(true);
            departmentIDTField.setVisible(false);
            departmentNameTextLabel.setVisible(false);
            departmentSearchButton.setVisible(false);
            departmentButton.setVisible(true);
            departmentCancelButton.setVisible(true);
            departmentDeleteButton.setVisible(false);
            departmentButton.setText("Add");
                    
          } else if (actionCommand.equals("View")) {
            clearDepartmentInfo();         
            departmentTopicLabel.setText("View Department");
            departmentIDTextLabel.setVisible(false);
            departmentIDTField.setVisible(true);
            departmentNameTextLabel.setVisible(true);
            departmentNameTField.setVisible(false);
            departmentSearchButton.setVisible(true);
            departmentButton.setVisible(false);
            departmentCancelButton.setVisible(false);
            departmentDeleteButton.setVisible(false);

          } else if (actionCommand.equals("Edit")) {         
            clearDepartmentInfo();
            departmentTopicLabel.setText("Edit Department");
            departmentIDTField.setVisible(true);
            departmentNameTField.setVisible(true);
            departmentIDTextLabel.setVisible(false);
            departmentNameTextLabel.setVisible(false);
            departmentSearchButton.setVisible(true);
            departmentButton.setVisible(true);
            departmentCancelButton.setVisible(true);
            departmentDeleteButton.setVisible(false);
            departmentButton.setText("Edit");
          }
          
          String[][] data = departmentDM.getData();

          DefaultTableModel model = (DefaultTableModel) departmentListTable.getModel();
          model.setRowCount(0);
          for (int i = 0; i < data.length; i++) {
            model.addRow(new Object[]{data[i][0], data[i][1]});        
          }  
          
        } catch (Exception ex) {
          showError(ex.getMessage());
        }
      }
    }
  }
    
  /**
   * Private inner class that handles the event when
   * the user clicks a button.
   */
    
  private class departmentButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      // Get the action command.
      String actionCommand = event.getActionCommand();
        
      try  {
        if (actionCommand.equals("Cancel")) {
          clearDepartmentInfo();
  
          if (departmentTopicLabel.getText() == "Edit Department") {
            departmentIDTField.setText("");
            departmentIDTField.setVisible(true);
            departmentIDTextLabel.setVisible(false);
            departmentSearchButton.setVisible(true);
            departmentDeleteButton.setVisible(false);
          }
  
        } else if (actionCommand.equals("Search")) {
          // Call the accessor methods of departmentFileManager Object 
          // to get the department's information and display it.
          int did         = Integer.parseInt(departmentIDTField.getText());
          Department deptInfo = departmentDM.getDepartmentInfo(did);
          String department  = deptInfo.getName();
        
          if (departmentTopicLabel.getText() == "View Department") {
            departmentNameTextLabel.setText(department);

          } else if (departmentTopicLabel.getText() == "Edit Department") {
            departmentIDTextLabel.setText(Integer.toString(did));
            departmentNameTField.setText(department);
            departmentIDTField.setVisible(false);
            departmentIDTextLabel.setVisible(true);
            departmentSearchButton.setVisible(false);  
            departmentDeleteButton.setVisible(true);
          }
  

        } else {  // actionCommand.equals("Add" or "Edit" or "Delete")
          int id          = Integer.parseInt(departmentIDTField.getText());
          String name     = departmentNameTField.getText();
          
          if (actionCommand.equals("Add")) {
            departmentDM.addDepartment(name);
            showInfo("Add Department Successfully.");    
            clearDepartmentInfo();
            int did = departmentDM.getDepartmentNewId();
            departmentIDTextLabel.setText(Integer.toString(did));
            departmentIDTField.setText(Integer.toString(did));

          } else if (actionCommand.equals("Edit")) {
            // Call updateDepartment method to update the department of the ArrayList
            // and write the department information in the file. 
            departmentDM.updateDepartment(id, name);
            showInfo("Edit Department successfully.");

          } else if (actionCommand.equals("Delete")) {
            departmentDM.deleteDepartment(id);
            showInfo("Delete Department successfully.");
            clearDepartmentInfo();
            departmentIDTField.setText("");
            departmentIDTField.setVisible(true);
            departmentIDTextLabel.setVisible(false);
            departmentSearchButton.setVisible(true);
            departmentDeleteButton.setVisible(false);
          }

          String[][] data = departmentDM.getData();

          DefaultTableModel model = (DefaultTableModel) departmentListTable.getModel();
          model.setRowCount(0);
          for (int i = 0; i < data.length; i++) {
            model.addRow(new Object[]{data[i][0], data[i][1]});        
          }
        }
      
      } catch (InvalidDepartmentID e) {
        showWarning(e.getMessage());
        clearDepartmentInfo();

      } catch (InvalidDepartmentIDExist | InvalidDepartmentInfo e) {
        showWarning(e.getMessage());           

      } catch (NumberFormatException e) {
        showWarning("The department ID must be integer.");
        clearDepartmentInfo();  
      
      } catch (IOException e) {
        showError(e.getMessage());
      
      } catch (Exception e) {
        showError(e.getMessage());
        clearDepartmentInfo(); 
      }
    }
  }
  
  private class departmentListButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      departmentListTextArea.setText("");
         
      String sortStr = (String) departmentListSortComboBox.getSelectedItem();
      String orderStr = (String) departmentListOrderComboBox.getSelectedItem();;
      int field = 0;
      boolean isDesc = false;
      if (sortStr.equals("Department Name")) {
        field = 1;
      }
  
      if (orderStr.equals("descending")) {
        isDesc = true;
      }         
  
      String departmentText = "";
      departmentText = "Department ID:  Name:\n" +
                    "----------------------------------------------------------------\n";
      departmentListTextArea.append(departmentText);

      try {
        String[] departmentList = departmentDM.searchDepartmentList(field, isDesc);
        for (int i = 0; i < departmentList.length; i++) {
          departmentListTextArea.append(departmentList[i]);
        }       

      } catch (Exception ex) {
        showError(ex.getMessage());
      }
    }
  }
  
  /**
   *  Private inner class that handles the event that
   *  is generated when the user selects a menuItem from
   *  the course menu.
   */
    
  private class courseListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      // Get the action command.
      String actionCommand = e.getActionCommand();
        
      if (actionCommand.equals("List")) {
        courseListTextArea.setText("");
        courseListSortComboBox.setSelectedIndex(0);
        courseListOrderComboBox.setSelectedIndex(0);
        setPanelVisible(PANEL_COURSE_LIST);
        add(courseListPanel);

      } else {
        setPanelVisible(PANEL_COURSE);          
        add(coursePanel);          
        clearCourseInfo();        

        try {
          // Determine which button was clicked and display a message.
          if (actionCommand.equals("Add")) {
            courseTopicLabel.setText("Add Course");
            courseIDTextLabel.setText(Integer.toString(courseDM.getCourseNewId()));
            courseIDTField.setText(Integer.toString(courseDM.getCourseNewId()));
            courseIDTextLabel.setVisible(true);
            courseIDTField.setVisible(false);
            courseNameTField.setVisible(true);
            courseDescriptionTField.setVisible(true);
            courseNumberTField.setVisible(true);
            courseDepartmentComboBox.setVisible(true);
            courseProfessorComboBox.setVisible(true);
            courseNameTextLabel.setVisible(false);
            courseDescriptionTextLabel.setVisible(false);
            courseNumberTextLabel.setVisible(false);
            courseDepartmentTextLabel.setVisible(false);
            courseProfessorTextLabel.setVisible(false);
            courseSearchButton.setVisible(false);       
            courseButton.setVisible(true);
            courseCancelButton.setVisible(true);
            courseDeleteButton.setVisible(false);
            courseButton.setText("Add");
            courseDepartmentComboBox.removeAllItems();
            String[] departmentList = departmentDM.searchDepartmentList();
            for (int i = 0; i < departmentList.length; i++) {
              courseDepartmentComboBox.addItem(departmentList[i]);
            }
            courseDepartmentComboBox.setSelectedIndex(-1);
            courseProfessorComboBox.removeAllItems();
            courseProfessorComboBox.setSelectedIndex(-1);  

          } else if (actionCommand.equals("View")) {
            courseTopicLabel.setText("View Course");
            courseIDTextLabel.setVisible(false);
            courseIDTField.setVisible(true);
            courseNameTextLabel.setVisible(true);
            courseDescriptionTextLabel.setVisible(true);
            courseNumberTextLabel.setVisible(true);
            courseDepartmentTextLabel.setVisible(true);
            courseProfessorTextLabel.setVisible(true);
            courseNameTField.setVisible(false);
            courseDescriptionTField.setVisible(false);
            courseNumberTField.setVisible(false);
            courseDepartmentComboBox.setVisible(false);
            courseProfessorComboBox.setVisible(false);
            courseSearchButton.setVisible(true);
            courseButton.setVisible(false);
            courseCancelButton.setVisible(false);
            courseDeleteButton.setVisible(false);
            
          } else if (actionCommand.equals("Edit")) {
            courseTopicLabel.setText("Edit Course");
            courseIDTField.setVisible(true);
            courseNameTField.setVisible(true);
            courseDescriptionTField.setVisible(true);
            courseNumberTField.setVisible(true);
            courseDepartmentComboBox.setVisible(true);
            courseProfessorComboBox.setVisible(true);
            courseIDTextLabel.setVisible(false);
            courseNameTextLabel.setVisible(false);
            courseDescriptionTextLabel.setVisible(false);
            courseNumberTextLabel.setVisible(true);
            courseDepartmentTextLabel.setVisible(false);
            courseProfessorTextLabel.setVisible(false);
            courseSearchButton.setVisible(true);
            courseButton.setVisible(true);
            courseCancelButton.setVisible(true);
            courseDeleteButton.setVisible(false);
            courseSearchButton.setVisible(true);
            courseButton.setText("Edit");            
            courseDepartmentComboBox.removeAllItems();
            
            String[] departmentList = departmentDM.searchDepartmentList();
            for (int i = 0; i < departmentList.length; i++) {
              courseDepartmentComboBox.addItem(departmentList[i]);
            }
            courseDepartmentComboBox.setSelectedIndex(-1);
            courseProfessorComboBox.removeAllItems();
            courseProfessorComboBox.setSelectedIndex(-1);
          }

        } catch (Exception ex) {
          showError(ex.getMessage());
        }
      }
    }
  }

  private void updateProfessorComboBox(int did)
  {
    courseProfessorComboBox.removeAllItems();
    try {      
      String[] professorList = professorDM.searchProfessorList(did);
      for (int i = 0; i < professorList.length; i++) {
        courseProfessorComboBox.addItem(professorList[i]);
      }
      courseProfessorComboBox.setSelectedIndex(-1);
      
    } catch (Exception ex) {
      System.out.println("ERROR: " + ex.getMessage());
    }
  }
  
  private class DepartmentChangeListener implements ActionListener 
  {
    @Override
    public void actionPerformed(ActionEvent e) 
    {
      try {
        String department = (String) courseDepartmentComboBox.getSelectedItem();
        int selectedDid  = departmentDM.getDepartmentIDByName(department);

        courseProfessorComboBox.removeAllItems();
        String[] professorList = professorDM.searchProfessorList(selectedDid);
        for (int i = 0; i < professorList.length; i++) {
          courseProfessorComboBox.addItem(professorList[i]);
        }
        courseProfessorComboBox.setSelectedIndex(-1);

      } catch (Exception ex) {
        System.out.println("ERROR: " + ex.getMessage());
      }
    }
  }
  /**
   * Private inner class that handles the event when
   * the user clicks a button.
   */
    
  private class courseButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      // Get the action command.
      String actionCommand = event.getActionCommand();
        
      try {
        if (actionCommand.equals("Cancel")) {
          clearCourseInfo();
  
          if (courseTopicLabel.getText() == "Edit Course") {
            courseIDTField.setText("");
            courseIDTField.setVisible(true);
            courseIDTextLabel.setVisible(false);
            courseSearchButton.setVisible(true);
            courseDeleteButton.setVisible(false);
          }
  
        } else if (actionCommand.equals("Search")) {
       
          // Call the accessor methods of courseFileManager Object 
          // to get the student's information and display it.
          int id        = Integer.parseInt(courseIDTField.getText());
          
          Course courseInfo = courseDM.getCourseInfo(id);
          String name   = courseInfo.getCourseName();
          String desc   = courseInfo.getCourseDesc();
          int number    = courseInfo.getCourseNumber();
          int did       = courseInfo.getCourseDepartmentId();
          int iid       = courseInfo.getCourseProfessorId();
          
          Department deptInfo = departmentDM.getDepartmentInfo(did);          
          String department  = deptInfo.getName();

          Professor profInfo = professorDM.getProfessorInfo(iid);

          String professor = profInfo.getName();

          if (courseTopicLabel.getText() == "View Course") {
            courseNameTextLabel.setText(name);
            courseDescriptionTextLabel.setText(desc);
            courseNumberTextLabel.setText(Integer.toString(number));
            courseDepartmentTextLabel.setText(department);
            courseProfessorTextLabel.setText(professor);

          } else if (courseTopicLabel.getText() == "Edit Course") {
            courseIDTextLabel.setText(Integer.toString(id));
            courseNameTField.setText(name);
            courseDescriptionTField.setText(desc);
            courseNumberTField.setText(String.valueOf(number));
            courseDepartmentComboBox.setSelectedItem(department);
            updateProfessorComboBox(did);
            courseProfessorComboBox.setSelectedItem(professor);
            courseIDTField.setVisible(false);
            courseIDTextLabel.setVisible(true);
            courseSearchButton.setVisible(false);
            courseDeleteButton.setVisible(true);
          }
        } else {    // actionCommand.equals("Add" or "Edit" or "Delete"
          int id        = Integer.parseInt(courseIDTField.getText());
          String name   = courseNameTField.getText();
          String desc   = courseDescriptionTField.getText();
          int number    = Integer.parseInt(courseNumberTField.getText());
          //int did       = courseDepartmentComboBox.getSelectedIndex() + 1;
          
          String department = (String) courseDepartmentComboBox.getSelectedItem();
          int did         = departmentDM.getDepartmentIDByName(department);

          
          String professor = (String) courseProfessorComboBox.getSelectedItem();
          int iid       = professorDM.searchProfessorId(professor, did);
          
          if (actionCommand.equals("Add"))
          {
            // Call addCourse method to add the student to the end of the ArrayList
            // and write the student information in the file. 
            courseDM.addCourse(name, desc, number, did, iid);
            showInfo("Add Course successfully.");
            clearCourseInfo();
            int cid = courseDM.getCourseNewId();
            courseIDTextLabel.setText(Integer.toString(cid));
            courseIDTField.setText(Integer.toString(cid));
            
          }
          else if (actionCommand.equals("Edit"))
          {
            // Call updateStudent method to update the student of the ArrayList
            // and write the student information in the file. 
            courseDM.updateCourse(id, name, desc, number, did, iid);
            showInfo("Edit Course successfully.");
          }
          else if (actionCommand.equals("Delete"))
          {
            courseDM.deleteCourse(id);
            showInfo("Delete Course successfully.");
            clearCourseInfo();
            courseIDTField.setText("");
            courseIDTField.setVisible(true);
            courseIDTextLabel.setVisible(false);
            courseSearchButton.setVisible(true);
            courseDeleteButton.setVisible(false);

          }
        }
      } catch (InvalidCourseID e) {
        showWarning(e.getMessage());           
        clearCourseInfo();

      } catch (InvalidCourseIDExist | InvalidCourseInfo e) {
        showWarning(e.getMessage());           

      } catch (NumberFormatException e) {
        showWarning("The Course ID and number must be integer.");              
        clearCourseInfo();
      
      } catch (IOException e) {           
        showError(e.getMessage());
      
      } catch (Exception e) {
        showError(e.getMessage());
        clearCourseInfo();
      }
    }
  }
    
  /**
   *  Private inner class that handles the event that
   *  is generated when the user selects a menuItem from
   *  the enrollment menu.
   */
  private class enrollListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      // Get the action command.
      String actionCommand = e.getActionCommand();
        
      if (actionCommand.equals("List")) {
        enrollListTextArea.setText("");
        enrollListSortComboBox.setSelectedIndex(0);
        enrollListOrderComboBox.setSelectedIndex(0);
        setPanelVisible(PANEL_ENROLL_LIST);
        add(enrollListPanel);

      } else {    
        // Determine which button was clicked and display a message.
        setPanelVisible(PANEL_ENROLL);
        add(enrollPanel);
        clearEnrollInfo();
        try {
          if (actionCommand.equals("Add")) {
            enrollTopicLabel.setText("Add Enrollment");
            int eid = enrollmentDM.getEnrollmentNewId();
            enrollIDTextLabel.setText(Integer.toString(eid));
            enrollIDTField.setText(Integer.toString(eid));
            enrollIDTextLabel.setVisible(true);
            enrollIDTField.setVisible(false);
            enrollStudentIDTField.setVisible(true);
            enrollCourseIDComboBox.setVisible(true);
            enrollCourseIDComboBox.removeAllItems();
            String[] courseList = courseDM.searchCourseList();
            for (int i = 0; i < courseList.length; i++) {
              enrollCourseIDComboBox.addItem(courseList[i]);
            }
            enrollCourseIDComboBox.setSelectedIndex(-1);
            enrollYearTField.setVisible(true);
            enrollSemesterComboBox.setVisible(true);
            enrollGradeComboBox.setVisible(true);            
            enrollStudentIDTextLabel.setVisible(false);
            enrollCourseIDTextLabel.setVisible(false);
            enrollYearTextLabel.setVisible(false);
            enrollSemesterTextLabel.setVisible(false);
            enrollGradeTextLabel.setVisible(false);
            enrollSearchButton.setVisible(false);
            enrollButton.setVisible(true);
            enrollButton.setText("Add");
            enrollCancelButton.setVisible(true);
            enrollDeleteButton.setVisible(false);
            enrollStudentCheckButton.setVisible(true);

          } else if (actionCommand.equals("View")) {
            enrollTopicLabel.setText("View Enrollment");
            enrollIDTField.setVisible(true);
            enrollStudentIDTextLabel.setVisible(true);
            enrollCourseIDTextLabel.setVisible(true);
            enrollYearTextLabel.setVisible(true);
            enrollSemesterTextLabel.setVisible(true);
            enrollGradeTextLabel.setVisible(true);    
            enrollIDTextLabel.setVisible(false);
            enrollStudentIDTField.setVisible(false);
            enrollCourseIDComboBox.setVisible(false);
            enrollYearTField.setVisible(false);
            enrollSemesterComboBox.setVisible(false);
            enrollGradeComboBox.setVisible(false);
            enrollSearchButton.setVisible(true);
            enrollButton.setVisible(false);
            enrollCancelButton.setVisible(false);
            enrollDeleteButton.setVisible(false);
            enrollStudentCheckButton.setVisible(false);

          } else if (actionCommand.equals("Edit")) {
            enrollTopicLabel.setText("Edit Enrollment");
            enrollIDTField.setVisible(true);
            enrollStudentIDTField.setVisible(true);
            enrollCourseIDComboBox.setVisible(true);
            enrollCourseIDComboBox.removeAllItems();
            String[] courseList = courseDM.searchCourseList();
            for (int i = 0; i < courseList.length; i++) {
              enrollCourseIDComboBox.addItem(courseList[i]);
            }
            enrollCourseIDComboBox.setSelectedIndex(-1);
            enrollYearTField.setVisible(true);
            enrollSemesterComboBox.setVisible(true);
            enrollGradeComboBox.setVisible(true);            
            enrollIDTextLabel.setVisible(false);
            enrollStudentIDTextLabel.setVisible(false);
            enrollCourseIDTextLabel.setVisible(false);
            enrollYearTextLabel.setVisible(false);
            enrollSemesterTextLabel.setVisible(false);
            enrollGradeTextLabel.setVisible(false);
            enrollSearchButton.setVisible(true);
            enrollButton.setVisible(true);
            enrollButton.setText("Edit");
            enrollCancelButton.setVisible(true);
            enrollDeleteButton.setVisible(false);
            enrollStudentCheckButton.setVisible(true);
          }

        } catch (Exception ex) {
          System.out.println("ERROR: " + ex.getMessage());
        }
      }
    }
  }
  
  
  private class courseListButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      courseListTextArea.setText("");
         
      String sortStr = (String) courseListSortComboBox.getSelectedItem();
      String orderStr = (String) courseListOrderComboBox.getSelectedItem();;
      int field = 0;
      boolean isDesc = false;
      if (sortStr.equals("Course Name")) {
        field = 1;
      }
  
      if (orderStr.equals("descending")) {
        isDesc = true;
      }         
  
      String courseText = "";
      courseText = "Course ID:\tName:\tDescription:\tNumber: Department ID: Professor ID:\n" +
                    "----------------------------------------------------------------\n";
      courseListTextArea.append(courseText);

      try {
        String[] courseList = courseDM.searchCourseList(field, isDesc);
        for (int i = 0; i < courseList.length; i++) {
          courseListTextArea.append(courseList[i]);
        }       

      } catch (Exception ex) {
        showError(ex.getMessage());
      }
    }
  }
  
  private class enrollCourseChangeListener implements ActionListener 
  {
    @Override
    public void actionPerformed(ActionEvent event) 
    {
      String strCid = (String) enrollCourseIDComboBox.getSelectedItem();

      try {
        if (strCid != null) {    
          Course courseInfo = courseDM.getCourseInfo(Integer.parseInt(strCid));
          String name   = courseInfo.getCourseName();
          enrollCourseNameTextLabel.setText(name);

        } else {
          enrollCourseNameTextLabel.setText("");
        }
      
      } catch (InvalidCourseID e) {
        showWarning(e.getMessage());           

      } catch (NumberFormatException e) {
        showWarning("The Course ID must be an integer.");              

      } catch (Exception e) {
        showError(e.getMessage());
      }        
    }
  }

  /**
   * Private inner class that handles the event when
   * the user clicks a button.
   */
    
  private class enrollButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      String actionCommand = event.getActionCommand();
      
      if (actionCommand.equals("Cancel")) {
        clearEnrollInfo();
        if (enrollTopicLabel.getText() == "Edit Enrollment") {
          enrollIDTField.setText("");
          enrollIDTField.setVisible(true);
          enrollIDTextLabel.setVisible(false);
          enrollSearchButton.setVisible(true);
          enrollDeleteButton.setVisible(false);
        }

      } else if (actionCommand.equals("Search SID")) {
        try {
          enrollStudentNameTextLabel.setText("");
          int sid       = Integer.parseInt(enrollStudentIDTField.getText());
          // Use MyGenernicList
          String fname  = studentFM.getStudentFName(sid);
          String lname  = studentFM.getStudentLName(sid);
          /*
          Student stuInfo = studentDM.getStudentInfo(sid);
          String fname  = stuInfo.getFName();
          String lname  = stuInfo.getLName();
          */
          enrollStudentNameTextLabel.setText(fname + " " + lname);

        } catch (InvalidStudentID e) {
          showWarning(e.getMessage());     
          
        } catch (NumberFormatException e) {
          showWarning("The student ID must be an integer.");             
        
        } catch (Exception e) {
          showError(e.getMessage());
        }

      } else if (actionCommand.equals("Search")) {
        try {
          // Call the accessor methods of studentFileManager Object 
          // to get the enrollment's information and display it.
          int eid         = Integer.parseInt(enrollIDTField.getText());
          Enrollment enrollmentInfo = enrollmentDM.getEnrollmentInfo(eid);
          int sid         = enrollmentInfo.getSid();
          int cid         = enrollmentInfo.getCid();
          Course courseInfo = courseDM.getCourseInfo(cid);
          String course   = courseInfo.getCourseName();
          int year        = enrollmentInfo.getYear();
          String semester = enrollmentInfo.getSemester();
          String grade    = enrollmentInfo.getGrade();
          
          if (enrollTopicLabel.getText() == "View Enrollment") {
            enrollStudentIDTextLabel.setText(String.valueOf(sid));
            enrollCourseIDTextLabel.setText(String.valueOf(cid));
            enrollYearTextLabel.setText(String.valueOf(year));
            enrollSemesterTextLabel.setText(semester);
            if (grade.length() == 0) {
              enrollGradeTextLabel.setText("");
            } else {
              enrollGradeTextLabel.setText(grade);
            }

          } else if (enrollTopicLabel.getText() == "Edit Enrollment") {
            enrollIDTField.setVisible(false);
            enrollIDTextLabel.setVisible(true);
            enrollIDTextLabel.setText(Integer.toString(eid)); 
            enrollStudentIDTField.setText(String.valueOf(sid));
            enrollCourseIDComboBox.setSelectedItem(Integer.toString(cid));
            enrollYearTField.setText(String.valueOf(year)); 
            if (semester.length() > 0 ) {
              enrollSemesterComboBox.setSelectedItem(semester);

            } else {
              enrollSemesterComboBox.setSelectedIndex(-1);
            }

            if (grade.length() == 0) {
              enrollGradeComboBox.setSelectedIndex(-1);;

            } else {
              enrollGradeComboBox.setSelectedItem(grade);
            }
            
            enrollSearchButton.setVisible(false);
            enrollDeleteButton.setVisible(true);
          }
          
          // Use MyGenericList
          String fname   = studentFM.getStudentFName(sid);
          String lname   = studentFM.getStudentLName(sid);
          /*
          Student stuInfo = studentDM.getStudentInfo(sid);
          String fname  = stuInfo.getFName();
          String lname  = stuInfo.getLName();
          */
          enrollStudentNameTextLabel.setText(fname + " " + lname);
          enrollCourseNameTextLabel.setText(course);
        
        } catch (InvalidEnrollmentID | InvalidStudentID | InvalidCourseID e) {
          showWarning(e.getMessage());
          clearEnrollInfo();

        } catch (NumberFormatException e) {
          showWarning("The enrollment ID must be an integer.");
          clearEnrollInfo();

        } catch (Exception e) {
          showError(e.getMessage());
          clearEnrollInfo();
        }

      } else {  // actionCommand.equals("Add" or "Edit" or "Delete)
        try {
          int sid           = Integer.parseInt(enrollStudentIDTField.getText());
          int cid           = Integer.parseInt((String) enrollCourseIDComboBox.getSelectedItem());
          int year          = Integer.parseInt(enrollYearTField.getText());
          Object semesterObj= enrollSemesterComboBox.getSelectedItem();
          String semester;
          if (semesterObj == null) {
            semester = "";

          } else {
            semester = (String)semesterObj;
          }

          Object gradeObj= enrollGradeComboBox.getSelectedItem();
          String grade;
          if (gradeObj == null) {
            grade = "";
          } else {
            grade = (String)gradeObj;
          }

          if (grade.length() > 1) {
            showWarning("The Grade field must be empty or one letter");

          } else {
            Course courseInfo = courseDM.getCourseInfo(cid);
            int courseNumber    = courseInfo.getCourseNumber();
        
            if (actionCommand.equals("Add")) {
              // Check Course number is less than the enrollment number.
              if (enrollmentDM.getEnrollmentNumber(cid, semester, year) < courseNumber) {
                            
                // Call addStudent method to add the student to the end of the ArrayList
                // and write the student information in the file. 
                enrollmentDM.addEnrollment(sid, cid, year, semester, grade);
                showInfo("Add Enrollment Successfully.");
                clearEnrollInfo();
                int eid = enrollmentDM.getEnrollmentNewId();
                enrollIDTextLabel.setText(Integer.toString(eid));
                enrollIDTField.setText(Integer.toString(eid));

              } else {
                showWarning("Add Enrollment Failed. Exceed the Course Number.");
              }

            } else if (actionCommand.equals("Edit")) {
              if (enrollmentDM.getEnrollmentNumber(cid, semester, year) <= courseNumber) {
                int eid                   = Integer.parseInt(enrollIDTField.getText());
                // Call updateStudent method to update the student of the ArrayList
                // and write the student information in the file. 
                enrollmentDM.updateEnrollment(eid, sid, cid, year, semester, grade);
                showInfo("Edit Enrollment successfully."); 

              } else {
                showWarning("Edit Enrollment Failed. Exceed the Course Number.");
              }

            } else if (actionCommand.equals("Delete")) {
              int eid = Integer.parseInt(enrollIDTField.getText());
              enrollmentDM.deleteEnrollment(eid);
              showInfo("Delete Enrollment successfully.");
              clearEnrollInfo();
              enrollIDTField.setText("");
              enrollIDTField.setVisible(true);
              enrollIDTextLabel.setVisible(false);
              enrollSearchButton.setVisible(true);
              enrollDeleteButton.setVisible(false);
            }
          }

        } catch (InvalidEnrollmentIDExist | 
               InvalidEnrollmentID | 
               InvalidEnrollmentInfo |
               InvalidStudentID | 
               InvalidCourseID e) {
          showWarning(e.getMessage());

        } catch (NumberFormatException e) {
          showWarning("The enrollment ID, Student ID, Course ID, and year must be integers.");
          
        } catch (IOException e) {           
          showError(e.getMessage());
        }
        catch (Exception e) {
          showError(e.getMessage());
        }
      }   
    }
  }
    
  
  private class enrollListButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      enrollListTextArea.setText("");
         
      String sortStr = (String) enrollListSortComboBox.getSelectedItem();
      String orderStr = (String) enrollListOrderComboBox.getSelectedItem();;
      int field = 0;
      boolean isDesc = false;
      if (sortStr.equals("Student ID")) {
        field = 1;
      }
  
      if (orderStr.equals("descending")) {
        isDesc = true;
      }         
  
      String enrollText = "";
      enrollText = "Enrollment ID:\tStudent ID:\tCourse ID:\tYear:\tSemester:\tGrade:\n" +
                    "----------------------------------------------------------------\n";
      enrollListTextArea.append(enrollText);

      try {
        String[] enrollList = enrollmentDM.searchEnrollList(field, isDesc);
        for (int i = 0; i < enrollList.length; i++) {
          enrollListTextArea.append(enrollList[i]);
        }       

      } catch (Exception ex) {
        System.out.println("ERROR: " + ex.getMessage());
      }
    }
  }
  /**
   *  Private inner class that handles the event that
   *  is generated when the user selects a menuItem from
   *  the enrollment menu.
   */
    
  private class gradeListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      // Get the action command.
      String actionCommand = e.getActionCommand();
    
      // Determine which button was clicked and display
      // a message.

      if (actionCommand.equals("View")) {
        setPanelVisible(PANEL_GRADE);
        add(gradePanel);
        clearGradeInfo();

      } else if (actionCommand.equals("Edit")) {
        clearGradeEditInfo();
        setPanelVisible(PANEL_GRADE_EDIT);          
        add(gradeEditPanel);        
        gradeEnrollIDTField.setVisible(true);                
        gradeEnrollIDTextLabel.setVisible(false);
        gradeSearchButton.setVisible(true);
        gradeEditButton.setVisible(true);
        gradeEditButton.setText("Edit");
        gradeCancelButton.setVisible(true);
      }
    }   
  }

  /**
    * Private inner class that handles the event when
    * the user clicks a button.
    */
    
  private class gradeButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      gradeTextArea.setText("");
        
      try {
        String studentID = gradeStudentIDTField.getText();
        int sid = Integer.parseInt(studentID);
        Object semesterObj= gradeSemesterComboBox.getSelectedItem();
        String semesterSearch;
        if (semesterObj == null) {
          semesterSearch = "";

        } else {
          semesterSearch = (String)semesterObj;
        }
        
        int yearSearch = Integer.parseInt(gradeYearTField.getText());
        
        if (studentID.isEmpty() || semesterSearch.isEmpty()) {
          showWarning("The Student ID and Semester fields cannot be empty.");
        } else {
          // Use MyGenericList
          String fname   = studentFM.getStudentFName(sid);
          String lname   = studentFM.getStudentLName(sid);
          /*
          Student stuInfo = studentDM.getStudentInfo(sid);  
          String fname  = stuInfo.getFName();
          String lname  = stuInfo.getLName();
          */
          
          String gradeText = "";
          gradeText = studentID + " " + fname + " " + lname + " " + 
                      semesterSearch + " " + yearSearch +
                       " Grade:\n" + 
                       "Enrollment ID:\tCourse Name:\tGrade\n" +
                       "----------------------------------------------------------------\n";
          gradeTextArea.append(gradeText);
        
          int[] eid = enrollmentDM.getEnrollmentByStudentId(sid);
          for (int eIndex = 0; eIndex < eid.length; eIndex++) {
            if (eid[eIndex] >= 0) {
              Enrollment enrollmentInfo = enrollmentDM.getEnrollmentInfo(eid[eIndex]);
              int cid = enrollmentInfo.getCid();

              Course courseInfo = courseDM.getCourseInfo(cid);
              String courseName   = courseInfo.getCourseName();

              //char grade   = enrollmentInfo.getGrade();
              String grade   = enrollmentInfo.getGrade();
              String semester = enrollmentInfo.getSemester();
              int year = enrollmentInfo.getYear();
              if (semester.equals(semesterSearch) && year == yearSearch) {
                if (courseName.length() > 7) {
                  gradeText= String.format("%10d\t%s\t%s\n",
                      eid[eIndex], courseName, grade);
                } else {
                  gradeText= String.format("%10d\t%s\t%s\n",
                      eid[eIndex], courseName, grade);
                }

                gradeTextArea.append(gradeText);
              }
            }
                      
          }
          gradeTextArea.setCaretPosition(0);
        }
      } catch (InvalidStudentID | InvalidEnrollment e) {
        showWarning(e.getMessage());

      } catch (NumberFormatException e) {
        showWarning("The Student ID and Year field must be an integer.");

      } catch (Exception e) {
        showError(e.getMessage());
      }  
    }
  }  

  /**
   * Private inner class that handles the event when
   * the user clicks a button.
   */
    
  private class gradeEditButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      String actionCommand = event.getActionCommand();
      
      try  {
        if (actionCommand.equals("Cancel")) {
          clearGradeEditInfo();
          if (gradeEditTopicLabel.getText() == "Edit Grade") {
            gradeEnrollIDTField.setText("");
            gradeEnrollIDTField.setVisible(true);
            gradeEnrollIDTextLabel.setVisible(false);
  
            gradeSearchButton.setVisible(true);
          }
        } else if (actionCommand.equals("Search")) {
          // Call the accessor methods of studentFileManager Object 
          // to get the enrollment's information and display it.
          int eid         = Integer.parseInt(gradeEnrollIDTField.getText());

          Enrollment enrollmentInfo = enrollmentDM.getEnrollmentInfo(eid);

          int sid         = enrollmentInfo.getSid();
          int cid         = enrollmentInfo.getCid();
          Course courseInfo = courseDM.getCourseInfo(cid);
          String course   = courseInfo.getCourseName();

          int year        = enrollmentInfo.getYear();
          String semester = enrollmentInfo.getSemester();
          String grade      = enrollmentInfo.getGrade();
          
          gradeEnrollIDTField.setVisible(false);
          gradeEnrollIDTextLabel.setVisible(true);
          gradeEnrollIDTextLabel.setText(String.valueOf(eid));
          gradeStudentIDTextLabel.setText(String.valueOf(sid));
          gradeCourseIDTextLabel.setText(String.valueOf(cid));
          gradeYearTextLabel.setText(String.valueOf(year));
          gradeSemesterTextLabel.setText(semester);
          
          if (grade.length() == 0) {
            gradeGradeComboBox.setSelectedIndex(-1);

          } else {
            gradeGradeComboBox.setSelectedItem(grade);
          }
          
          gradeSearchButton.setVisible(false);

          // Use MyGenericList
          String fname   = studentFM.getStudentFName(sid);
          String lname   = studentFM.getStudentLName(sid);
          /*
          Student stuInfo = studentDM.getStudentInfo(sid);
          String fname  = stuInfo.getFName();
          String lname  = stuInfo.getLName();
          */
          gradeStudentNameTextLabel.setText(fname + " " + lname);  
          gradeCourseNameTextLabel.setText(course);
        
  
        } else {      // actionCommand.equals("Edit")
          int eid           = Integer.parseInt(gradeEnrollIDTField.getText());
          Enrollment enrollmentInfo = enrollmentDM.getEnrollmentInfo(eid);
          int sid         = enrollmentInfo.getSid();
          int cid         = enrollmentInfo.getCid();
          int year        = enrollmentInfo.getYear();
          String semester = enrollmentInfo.getSemester();
          
          Object gradeObj= gradeGradeComboBox.getSelectedItem();
          String grade;
          if (gradeObj == null) {
            grade = "";

          } else {
            grade = (String)gradeObj;
          }

          if (grade.length() > 1) {
            showWarning("The Grade field must be empty or one letter");

          } else {
            // Call updateStudent method to update the student of the ArrayList
            // and write the student information in the file. 
            enrollmentDM.updateEnrollment(eid, sid, cid, year, semester, grade);
            showInfo("Edit Grade successfully."); 
          }
        }
      } catch (InvalidEnrollmentIDExist | 
          InvalidEnrollmentID | 
          InvalidEnrollmentInfo |
          InvalidStudentID | 
          InvalidCourseID e) {
        showWarning(e.getMessage());
        clearEnrollInfo();

      } catch (NumberFormatException e) {
        showWarning("The enrollment ID must be an integer.");
        clearEnrollInfo();

      } catch (IOException e) {           
        showError(e.getMessage());

      } catch (Exception e) {
        showError(e.getMessage());
        clearEnrollInfo();
      }
    }
  }
    
  /**
   *  Private inner class that handles the event that
   *  is generated when the user selects a menuItem from
   *  the enrollment menu.
   */
    
  private class reportListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      reportCourseIDNameComboBox.removeAllItems();

      try {
        String[] courseList = courseDM.searchCourseIDNameList();
        for (int i = 0; i < courseList.length; i++) {
          reportCourseIDNameComboBox.addItem(courseList[i]);
        }
        reportCourseIDNameComboBox.setSelectedIndex(-1);

      } catch (Exception ex) {
        System.out.println("ERROR: " + ex.getMessage());
      }

      setPanelVisible(PANEL_REPORT);  
      add(reportPanel);
      clearReportInfo();
    }   
  }

  /**
    * Private inner class that handles the event when
    * the user clicks a button.
    */
    
  private class reportButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {        
      reportTextArea.setText("");
        
      try {
        String courseIDName = (String) reportCourseIDNameComboBox.getSelectedItem();
        Object semesterObj= reportSemesterComboBox.getSelectedItem();
        String semesterSearch;
        if (semesterObj == null) {
          semesterSearch = "";

        } else {
          semesterSearch = (String)semesterObj;
        }
        
        int yearSearch = Integer.parseInt(reportYearTField.getText());
        
        if (courseIDName == null || semesterSearch.isEmpty()) {
          showWarning("The Course Name and Semester fields cannot be empty.");
        } else {
          String[] courseArray = courseIDName.split(" ");
          int cid = Integer.parseInt(courseArray[0]);
             
          String reportText = "";
          reportText = courseIDName + " " + semesterSearch + " " + yearSearch +
                       " Report:\n" + 
                       "Student Name:\tGrade\n" +
                       "----------------------------------------------------------------\n";
          reportTextArea.append(reportText);
        
          int[] eid = enrollmentDM.getEnrollmentByCourseId(cid);
          for (int eIndex = 0; eIndex < eid.length; eIndex++) {
            if (eid[eIndex] >= 0) {
              Enrollment enrollmentInfo = enrollmentDM.getEnrollmentInfo(eid[eIndex]);
              int sid = enrollmentInfo.getSid();
    
              // Use MyGenericList
              String fname = studentFM.getStudentFName(sid);
              String lname = studentFM.getStudentLName(sid);
              /*
              Student stuInfo = studentDM.getStudentInfo(sid);
              String fname  = stuInfo.getFName();
              String lname  = stuInfo.getLName();
              */
              String grade   = enrollmentInfo.getGrade();
              String semester = enrollmentInfo.getSemester();
              int year = enrollmentInfo.getYear();
              if (semester.equals(semesterSearch) && year == yearSearch) {
                if (fname.length() + lname.length() > 7) {
                  reportText= String.format("%s\t%s\n", fname + " " + lname, grade);

                } else {
                  reportText= String.format("%s\t%s\n", fname + " " + lname, grade);
                }
                reportTextArea.append(reportText);
              }
            }
          }
           
          reportTextArea.setCaretPosition(0);
        }

      } catch (InvalidCourseName | InvalidEnrollment e) {
        reportTextArea.setText("");
        showWarning(e.getMessage());

      } catch (NumberFormatException e) {
        showWarning("The Year field must be an integer.");

      } catch (Exception e) {
        reportTextArea.setText("");
        showError(e.getMessage());
      }  
    }
  }
}