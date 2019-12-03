CREATE TABLE `course_selection_system`.`student` (
  `student_id` INT NOT NULL,
  `student_name` VARCHAR(45) NULL DEFAULT NULL,
  `school_abbr` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`student_id`),
  INDEX `abbr_idx` (`school_abbr` ASC),
  CONSTRAINT `student_abbr`
    FOREIGN KEY (`school_abbr`)
    REFERENCES `course_selection_system`.`school` (`abbr`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);
