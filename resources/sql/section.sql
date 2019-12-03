CREATE TABLE `course_selection_system`.`section` (
  `course_id` INT NOT NULL,
  `section_id` VARCHAR(45) NOT NULL,
  `year` YEAR(4) NOT NULL,
  `semester` VARCHAR(45) NOT NULL,
  `section_capacity` INT NOT NULL,
  `building` VARCHAR(45) NULL,
  `room_number` VARCHAR(45) NULL,
  `time_slot_id` INT NULL,
  PRIMARY KEY (`course_id`, `section_id`, `year`, `semester`),
  INDEX `section_time_slot_idx` (`time_slot_id` ASC),
  CONSTRAINT `section_time_slot`
    FOREIGN KEY (`time_slot_id`)
    REFERENCES `course_selection_system`.`time_slot` (`time_slot_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
