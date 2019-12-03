CREATE TABLE `course_selection_system`.`sec_request` (
  `student_id` VARCHAR(45) NOT NULL,
  `course_id` INT NOT NULL,
  `section_id` INT NOT NULL,
  `year` YEAR(4) NOT NULL,
  `semester` VARCHAR(45) NOT NULL,
  `request_content` LONGTEXT NULL,
  `pass_or_not` TINYINT(1) NULL DEFAULT 0,
  `reply_content` LONGTEXT NULL,
  PRIMARY KEY (`student_id`, `course_id`, `section_id`, `year`, `semester`),
  INDEX `request_section_idx` (`course_id` ASC, `section_id` ASC, `year` ASC, `semester` ASC),
  CONSTRAINT `request_studenet`
    FOREIGN KEY (`student_id`)
    REFERENCES `course_selection_system`.`student` (`student_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `request_section`
    FOREIGN KEY (`course_id` , `section_id` , `year` , `semester`)
    REFERENCES `course_selection_system`.`section` (`course_id` , `section_id` , `year` , `semester`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
