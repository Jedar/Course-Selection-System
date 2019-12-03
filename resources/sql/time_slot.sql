CREATE TABLE `course_selection_system`.`time_slot` (
  `time_slot_id` INT NOT NULL,
  `day` INT NOT NULL,
  `start_time` TIME NOT NULL,
  `end_time` TIME NULL,
  PRIMARY KEY (`time_slot_id`, `day`, `start_time`));