DELIMITER //

CREATE DEFINER=`root`@`%` PROCEDURE `FindDepartmentID`(id int)
BEGIN
SELECT * FROM department WHERE DepartmentID = id;
END //

CREATE DEFINER=`root`@`%` PROCEDURE `FindProfessorID`(id int)
BEGIN
SELECT * FROM professor WHERE ProfessorID = id;
END //

CREATE DEFINER=`root`@`%` PROCEDURE `FindCourseID`(id int)
BEGIN
SELECT * FROM course WHERE CourseID = id;
END //

CREATE DEFINER=`root`@`%` PROCEDURE `FindEnrollmentID`(id int)
BEGIN
SELECT * FROM enrollment WHERE EnrollmentID = id;
END //

CREATE DEFINER=`root`@`%` PROCEDURE `GetNextProfessorID`()
BEGIN
SELECT `AUTO_INCREMENT` AS id FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'cs136' AND TABLE_NAME = 'professor';
END //

CREATE DEFINER=`root`@`%` PROCEDURE `GetNextDepartmentID`()
BEGIN
SELECT `AUTO_INCREMENT` AS id FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'cs136' AND TABLE_NAME = 'department';
END //

CREATE DEFINER=`root`@`%` PROCEDURE `GetNextCourseID`()
BEGIN
SELECT `AUTO_INCREMENT` AS id FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'cs136' AND TABLE_NAME = 'course';
END //

CREATE DEFINER=`root`@`%` PROCEDURE `GetNextEnrollmentID`()
BEGIN
SELECT `AUTO_INCREMENT` AS id FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'cs136' AND TABLE_NAME = 'enrollment';
END //
DELIMITER ;

SET information_schema_stats_expiry = 0;