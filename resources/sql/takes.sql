CREATE TABLE `course_selection_system`.`takes` (
  `student_id` VARCHAR(45) NOT NULL,
  `course_id` INT NOT NULL,
  `section_id` INT NOT NULL,
  `year` YEAR(4) NOT NULL,
  `semester` VARCHAR(45) NOT NULL,
  `level` VARCHAR(45) NULL,
  `drop_flag` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`student_id`, `semester`, `year`, `section_id`, `course_id`),
  INDEX `take_section_idx` (`course_id` ASC, `section_id` ASC, `year` ASC, `semester` ASC),
  INDEX `take_grade_idx` (`level` ASC),
  CONSTRAINT `take_student`
    FOREIGN KEY (`student_id`)
    REFERENCES `course_selection_system`.`student` (`student_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `take_section`
    FOREIGN KEY (`course_id` , `section_id` , `year` , `semester`)
    REFERENCES `course_selection_system`.`section` (`course_id` , `section_id` , `year` , `semester`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `take_grade`
    FOREIGN KEY (`level`)
    REFERENCES `course_selection_system`.`level_to_grade` (`level`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
