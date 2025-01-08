use cs136;

create table student (
	StudentID int NOT NULL AUTO_INCREMENT,
	FirstName varchar(255) NOT NULL,
	LastName varchar(255) NOT NULL,
	Address varchar(255) NOT NULL,
	City	varchar(32) NOT NULL,
	State	varchar(32) NOT NULL,
	ZipCode varchar(5) NOT NULL,
	PRIMARY KEY (StudentID)
);

create table department (
	DepartmentID int AUTO_INCREMENT,
	DepartmentName varchar(255) NOT NULL,
	PRIMARY KEY (DepartmentID)
);

create table professor (
	ProfessorID int AUTO_INCREMENT,
	ProfessorName varchar(255) NOT NULL,
	DepartmentID int NOT NULL,
	PRIMARY KEY (ProfessorID),
	FOREIGN KEY (DepartmentID) REFERENCES department(DepartmentID)
);

create table course (
	CourseID int AUTO_INCREMENT,
	CourseName varchar(255) NOT NULL,
	CourseDescription varchar(255) NOT NULL,
	CourseNumber int NOT NULL,
	DepartmentID int NOT NULL,
	ProfessorID int NOT NULL,
	PRIMARY KEY (CourseID),
	FOREIGN KEY (DepartmentID) REFERENCES department(DepartmentID),
	FOREIGN KEY (ProfessorID) REFERENCES professor(ProfessorID)
);

create table enrollment (
	EnrollmentID int AUTO_INCREMENT,
	StudentID int NOT NULL,
	CourseID int NOT NULL,
	Year int NOT NULL,
	Semester varchar(16) NOT NULL,
	Grade varchar(1),
	PRIMARY KEY (EnrollmentID),
	FOREIGN KEY (StudentID) REFERENCES student(StudentID),
	FOREIGN KEY (CourseID) REFERENCES course(CourseID)
);