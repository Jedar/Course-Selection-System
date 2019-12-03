CREATE TABLE `course_selection_system`.`teaches` (
  `teacher_id` VARCHAR(45) NOT NULL,
  `course_id` INT NOT NULL,
  `section_id` INT NOT NULL,
  `year` YEAR(4) NOT NULL,
  `semester` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`teacher_id`, `course_id`, `section_id`, `year`, `semester`),
  INDEX `teach_section_idx` (`course_id` ASC, `section_id` ASC, `year` ASC, `semester` ASC),
  CONSTRAINT `teach_teacher`
    FOREIGN KEY (`teacher_id`)
    REFERENCES `course_selection_system`.`teacher` (`teacher_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `teach_section`
    FOREIGN KEY (`course_id` , `section_id` , `year` , `semester`)
    REFERENCES `course_selection_system`.`section` (`course_id` , `section_id` , `year` , `semester`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
