CREATE TABLE `course_selection_system`.`exam` (
  `course_id` INT NOT NULL,
  `section_id` INT NOT NULL,
  `year` YEAR(4) NOT NULL,
  `semester` VARCHAR(45) NOT NULL,
  `exam_date` DATETIME(6) NOT NULL,
  `exam_time_slot_id` INT NULL,
  `exam_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`course_id`, `section_id`, `semester`, `year`, `exam_date`));
