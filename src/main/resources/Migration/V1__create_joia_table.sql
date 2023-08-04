CREATE TABLE IF NOT EXISTS `joias` (
    `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `valor` FLOAT,
    `peso` FLOAT,
    `material` VARCHAR(50),
    `quantidade` INT,
    `tipo` VARCHAR(20)
)