CREATE TABLE `course_selection_system`.`course` (
  `course_id` INT NOT NULL,
  `course_name` VARCHAR(45) NOT NULL,
  `credits` INT NOT NULL,
  `credit_hours` INT NOT NULL,
  `school_abbr` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`course_id`),
  INDEX `course_school_idx` (`school_abbr` ASC),
  CONSTRAINT `course_school`
    FOREIGN KEY (`school_abbr`)
    REFERENCES `course_selection_system`.`school` (`abbr`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);