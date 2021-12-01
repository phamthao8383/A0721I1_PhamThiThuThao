
CREATE TABLE `student-management`.`Class`(
`id` INT NOT NULL,
`name` VARCHAR(45) NULL,
PRIMARY KEY(`id`)
);
CREATE TABLE `student-management`.`Teacher`(
`id` INT NOT NULL,
`name` VARCHAR(45) NULL,
`age` INT NULL,
`country` VARCHAR(45) NULL,
PRIMARY KEY(`id`)

);