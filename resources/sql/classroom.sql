CREATE TABLE `course_selection_system`.`classroom` (
  `building` VARCHAR(45) NOT NULL,
  `room_number` VARCHAR(45) NOT NULL,
  `classroom_capacity` INT NOT NULL,
  PRIMARY KEY (`building`, `room_number`));