drop database caixaeletronico;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `caixaeletronico` DEFAULT CHARACTER SET utf8 ;
USE `caixaeletronico` ;

-- -----------------------------------------------------
-- Table `caixaeletronico`.`banco`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `caixaeletronico`.`banco` (
  `id_banco` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `numero_banco` INT(10) UNSIGNED NOT NULL ,
  `nome_banco` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`id_banco`) ,
  UNIQUE INDEX `uk_banco` (`numero_banco` ASC)) 
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `caixaeletronico`.`agencia`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `caixaeletronico`.`agencia` (
  `id_agencia` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `numero_banco` INT(10) UNSIGNED NOT NULL ,
  `numero_agencia` INT(10) UNSIGNED NOT NULL ,
  `nome` VARCHAR(100) NOT NULL ,
  `endereco` VARCHAR(200) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_agencia`) ,
  INDEX `idx_agencia` (`numero_agencia` ASC),
  INDEX `fk_agenda_banco` (`numero_banco` ASC) ,
  CONSTRAINT `fk_agenda_banco`
    FOREIGN KEY (`numero_banco` )
    REFERENCES `caixaeletronico`.`banco` (`numero_banco` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `caixaeletronico`.`cliente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `caixaeletronico`.`cliente` (
  `id_cliente` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  `cpf` CHAR(11) NOT NULL ,
  `rg` CHAR(9) NOT NULL ,
  `endereco` VARCHAR(200) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_cliente`) ,
  UNIQUE INDEX `uk_cliente` (`cpf` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `caixaeletronico`.`conta`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `caixaeletronico`.`conta` (
  `id_conta` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `numero_agencia` INT(10) UNSIGNED NOT NULL ,
  `numero_banco` INT(10) UNSIGNED NOT NULL ,
  `numero_conta` INT(10) UNSIGNED NOT NULL ,
  `id_cliente` INT(10) UNSIGNED NOT NULL,
  `saldo` DECIMAL(10,2) NOT NULL ,
  `bloqueado` BOOLEAN NOT NULL,
  PRIMARY KEY (`id_conta`) ,
  UNIQUE INDEX `uk_num_conta` (`numero_conta` ASC) ,
  INDEX `fk_conta_agencia` (`numero_agencia` ASC) ,
  INDEX `fk_conta_banco` (`numero_banco` ASC) ,
  INDEX `fk_conta_cliente` (`id_cliente` ASC) ,
  CONSTRAINT `fk_conta_agencia`
    FOREIGN KEY (`numero_agencia` )
    REFERENCES `caixaeletronico`.`agencia` (`numero_agencia` ),
  CONSTRAINT `fk_conta_banco`
    FOREIGN KEY (`numero_banco` )
    REFERENCES `caixaeletronico`.`banco` (`numero_banco` ),
  CONSTRAINT `fk_conta_cliente`
    FOREIGN KEY (`id_cliente` )
    REFERENCES `caixaeletronico`.`cliente` (`id_cliente` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `caixaeletronico`.`movimento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `caixaeletronico`.`movimento` (
  `id_movimento` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `tipo_movimento` DECIMAL(1,0) NOT NULL ,
  `valor` DECIMAL(9,2) NOT NULL ,
  `numero_conta` INT(10) UNSIGNED NOT NULL ,
  `numero_agencia` INT(10) UNSIGNED NOT NULL ,
  numero_banco INT(10) UNSIGNED NOT NULL ,
  data_movimento date NOT NULL,
  PRIMARY KEY (`id_movimento`) ,
  INDEX `fk_movimento_conta` (`numero_conta` ASC) ,
  INDEX `fk_movimento_agencia` (`numero_agencia` ASC) ,
  INDEX `fk_movimento_banco` (`numero_banco` ASC) ,
  INDEX `idx_tipo_movimento`(`tipo_movimento`),
  CONSTRAINT `fk_movimento_conta`
    FOREIGN KEY (`numero_conta` )
    REFERENCES `caixaeletronico`.`conta` (`numero_conta` ),
  CONSTRAINT `fk_movimento_agencia`
    FOREIGN KEY (`numero_agencia` )
    REFERENCES `caixaeletronico`.`agencia` (`numero_agencia` ),
  CONSTRAINT `fk_movimento_banco`
    FOREIGN KEY (`numero_banco` )
    REFERENCES `caixaeletronico`.`banco` (`numero_banco` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `caixaeletronico`.`saque`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `caixaeletronico`.`saque` (
  `id_saque` INT(10) UNSIGNED NOT NULL ,
  `id_movimento` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`id_saque`, `id_movimento`) ,
  INDEX `fk_saque_movimento` (`id_movimento` ASC) ,
  CONSTRAINT `fk_saque_movimento`
    FOREIGN KEY (`id_movimento` )
    REFERENCES `caixaeletronico`.`movimento` (`id_movimento` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `caixaeletronico`.`transferencia`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `caixaeletronico`.`transferencia` (
  `id_transferencia` INT(10) UNSIGNED NOT NULL ,
  `id_movimento` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`id_transferencia`, `id_movimento`) ,
  INDEX `fk_transferencia_movimento` (`id_movimento` ASC) ,
  CONSTRAINT `fk_transferencia_movimento`
    FOREIGN KEY (`id_movimento` )
    REFERENCES `caixaeletronico`.`movimento` (`id_movimento` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
-- -----------------------------------------------------
-- Table `caixaeletronico`.`debito_automatico`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `caixaeletronico`.`debito_automatico` (
  `id_debito_automatico` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `id_movimento` INT(10) UNSIGNED NOT NULL ,
  `nrc_conta` INT(10) UNSIGNED NOT NULL ,
  `categoria` VARCHAR(20) NOT NULL ,
  `operadora` VARCHAR(100) NOT NULL ,
  
  PRIMARY KEY (`id_debito_automatico`, `id_movimento`) ,
  INDEX `fk_debito_movimento` (`id_movimento` ASC) ,
  CONSTRAINT `fk_debito_movimento`
    FOREIGN KEY (`id_movimento` )
    REFERENCES `caixaeletronico`.`movimento` (`id_movimento` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `caixaeletronico`.`dispenser`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `caixaeletronico`.`dispenser` (
  `nota` INT(10) UNSIGNED NOT NULL ,
  `quantidade_nota` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`nota`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `caixaeletronico`.`operacao`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `caixaeletronico`.`operacao` (
  `tipo_movimento` DECIMAL(1,0) NOT NULL ,
  `data_operacao` date NOT NULL ,
  `quantidade_operacao` INT(10) UNSIGNED NOT NULL ,
    
  PRIMARY KEY (`tipo_movimento`, `data_operacao`) ,
  INDEX `fk_operacao_movimento` (`tipo_movimento` ASC) ,
  CONSTRAINT `fk_operacao_movimento`
    FOREIGN KEY (`tipo_movimento` )
    REFERENCES `caixaeletronico`.`movimento` (`tipo_movimento` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


USE `caixaeletronico` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
