CREATE TABLE `course_selection_system`.`take_drop_time` (
  `year` YEAR(4) NOT NULL,
  `semester` VARCHAR(45) NOT NULL,
  `take_start_time` DATETIME(6) NULL,
  `drop_start_time` DATETIME(6) NULL,
  `take_end_time` DATETIME(6) NULL,
  `drop_end_time` DATETIME(6) NULL,
  PRIMARY KEY (`year`, `semester`));
