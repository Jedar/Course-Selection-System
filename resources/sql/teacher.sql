CREATE TABLE `course_selection_system`.`teacher` (
  `teacher_id` INT NOT NULL,
  `teacher_name` VARCHAR(45) NULL DEFAULT NULL,
  `title` VARCHAR(45) NULL DEFAULT NULL,
  `school_abbr` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`teacher_id`),
  INDEX `abbr_idx` (`school_abbr` ASC),
  CONSTRAINT `teacher_abbr`
    FOREIGN KEY (`school_abbr`)
    REFERENCES `course_selection_system`.`school` (`abbr`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);