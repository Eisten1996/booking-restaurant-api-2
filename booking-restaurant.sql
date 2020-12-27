
CREATE SCHEMA IF NOT EXISTS `BOOKING_RESTAURANT` DEFAULT CHARACTER SET UTF8 ;
USE `BOOKING_RESTAURANT` ;

-- -----------------------------------------------------
-- Table `BOOKING_RESTAURANT`.`RESTAURANT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BOOKING_RESTAURANT`.`RESTAURANT` (
  `ID` INT(19) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NULL,
  `DESCRIPTION` VARCHAR(100) NULL,
  `ADDRESS` VARCHAR(100) NULL,
  `IMAGE` VARCHAR(500) NULL,
  PRIMARY KEY (`ID`))
ENGINE = INNODB;


-- -----------------------------------------------------
-- Table `BOOKING_RESTAURANT`.`RESERVATION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BOOKING_RESTAURANT`.`RESERVATION` (
  `ID` INT(19) NOT NULL AUTO_INCREMENT,
  `LOCATOR` VARCHAR(45) NULL,
  `PERSON` INT(19) NULL,
  `DATE` DATE NULL,
  `TURN` VARCHAR(45) NULL,
  `RESTAURANT_ID` INT(19) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_RESERVATION_RESTAURANT_idx` (`RESTAURANT_ID` ASC),
  CONSTRAINT `fk_RESERVATION_RESTAURANT`
    FOREIGN KEY (`RESTAURANT_ID`)
    REFERENCES `BOOKING_RESTAURANT`.`RESTAURANT` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = INNODB;


-- -----------------------------------------------------
-- Table `BOOKING_RESTAURANT`.`TURN`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BOOKING_RESTAURANT`.`TURN` (
  `ID` INT(19) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NULL,
  `RESTAURANT_ID` INT(19) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_TURN_RESTAURANT1_idx` (`RESTAURANT_ID` ASC),
  CONSTRAINT `fk_TURN_RESTAURANT1`
    FOREIGN KEY (`RESTAURANT_ID`)
    REFERENCES `BOOKING_RESTAURANT`.`RESTAURANT` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = INNODB;


-- -----------------------------------------------------
-- Table `BOOKING_RESTAURANT`.`BOARD`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BOOKING_RESTAURANT`.`BOARD` (
  `ID` INT(19) NOT NULL AUTO_INCREMENT,
  `CAPACITY` INT(19) NULL,
  `NUMBER` INT(19) NULL,
  `RESTAURANT_ID` INT(19) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_BOARD_RESTAURANT1_idx` (`RESTAURANT_ID` ASC),
  CONSTRAINT `fk_BOARD_RESTAURANT1`
    FOREIGN KEY (`RESTAURANT_ID`)
    REFERENCES `BOOKING_RESTAURANT`.`RESTAURANT` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = INNODB;

-- -----------------------------------------------------
-- INSERT TABLE RESTAURANT
-- -----------------------------------------------------
INSERT INTO `booking_restaurant`.`restaurant` 
(`ID`, `NAME`, `DESCRIPTION`, `ADDRESS`, `IMAGE`) VALUES 
('1', 'BURGUER HULL', 'Todo tipo de hamburguesa', 'Calle Puig 4', 'https://lh3.googleusercontent.com/proxy/DibghlCyooZaMi5QtfEI_kqHBC5xBaTjA4qBSuOoscWXRWc5so3-Hf2Xzdi89-SQr4HrWkmgDCTzBMxA7vPG42HeLXVJJZhpf1IwO7hFMdBYRzUcfwQ5jalEEQeypsxNa_EVE4hbLdRTmGs');

INSERT INTO `booking_restaurant`.`restaurant` 
(`ID`, `NAME`, `DESCRIPTION`, `ADDRESS`, `IMAGE`) VALUES 
('2', 'KFC', 'Venda de los mejores pollos', 'Calle Galindo 5', 'https://i0.wp.com/exitosanoticias.pe/v1/wp-content/uploads/2020/04/restaurantes-1.png');

INSERT INTO `booking_restaurant`.`restaurant` 
(`ID`, `NAME`, `DESCRIPTION`, `ADDRESS`, `IMAGE`) VALUES 
('3', 'Pizza Hut', 'Venda de las mejores pizzas', 'Calle Civil 15', 'https://cdn.futbolperuano.com/sdi/2020/05/14/peru-que-restaurantes-retornaran-tras-fin-de-cuarentena-832342.jpg');

-- -----------------------------------------------------
-- INSERT TABLE TURN
-- -----------------------------------------------------
INSERT INTO `booking_restaurant`.`turn` 
(`ID`, `NAME`, `RESTAURANT_ID`) VALUES 
(1, 'TURNO_10_00', 1);
INSERT INTO `booking_restaurant`.`turn` 
(`ID`, `NAME`, `RESTAURANT_ID`) VALUES 
(2, 'TURNO_11_00', 1);
INSERT INTO `booking_restaurant`.`turn` 
(`ID`, `NAME`, `RESTAURANT_ID`) VALUES 
(3, 'TURNO_12_00', 1);
INSERT INTO `booking_restaurant`.`turn` 
(`ID`, `NAME`, `RESTAURANT_ID`) VALUES 
(4, 'TURNO_13_00', 1);

INSERT INTO `booking_restaurant`.`turn` 
(`ID`, `NAME`, `RESTAURANT_ID`) VALUES 
(5, 'TURNO_10_00', 2);
INSERT INTO `booking_restaurant`.`turn` 
(`ID`, `NAME`, `RESTAURANT_ID`) VALUES 
(6, 'TURNO_11_00', 2);
INSERT INTO `booking_restaurant`.`turn` 
(`ID`, `NAME`, `RESTAURANT_ID`) VALUES 
(7, 'TURNO_12_00', 2);
INSERT INTO `booking_restaurant`.`turn` 
(`ID`, `NAME`, `RESTAURANT_ID`) VALUES 
(8, 'TURNO_13_00', 2);

-- -----------------------------------------------------
-- INSERT TABLE BOARD
-- -----------------------------------------------------
INSERT INTO `booking_restaurant`.`board`
(`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES 
(1, 3, 1, 1);
INSERT INTO `booking_restaurant`.`board`
(`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES 
(2, 6, 2, 1);
INSERT INTO `booking_restaurant`.`board`
(`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES 
(3, 2, 3, 1);
INSERT INTO `booking_restaurant`.`board`
(`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES 
(4, 5, 4, 1);

INSERT INTO `booking_restaurant`.`board`
(`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES 
(5, 4, 1, 2);
INSERT INTO `booking_restaurant`.`board`
(`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES 
(6, 6, 2, 2);
INSERT INTO `booking_restaurant`.`board`
(`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES 
(7, 4, 3, 2);
INSERT INTO `booking_restaurant`.`board`
(`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES 
(8, 8, 4, 2);

-- -----------------------------------------------------
-- INSERT TABLE RESERVATION
-- -----------------------------------------------------
INSERT INTO `booking_restaurant`.`reservation` 
(`ID`, `LOCATOR`, `PERSON`, `DATE`, `TURN`, `RESTAURANT_ID`) VALUES 
('1', 'BURGUER HULL 6', '6', '2020-12-12', 'TURNO_10_00', '1');
INSERT INTO `booking_restaurant`.`reservation` 
(`ID`, `LOCATOR`, `PERSON`, `DATE`, `TURN`, `RESTAURANT_ID`) VALUES 
('2', 'BURGUER HULL 4', '4', '2020-10-10', 'TURNO_11_00', '1');

ALTER TABLE `booking_restaurant`.`restaurant` 
ADD COLUMN `PRICE` INT(19) NULL AFTER `IMAGE`;

ALTER TABLE `booking_restaurant`.`reservation` 
ADD COLUMN `NAME` VARCHAR(45) NULL AFTER `RESTAURANT_ID`,
ADD COLUMN `EMAIL` VARCHAR(45) NULL AFTER `NAME`,
ADD COLUMN `PAYMENT` BLOB NULL AFTER `EMAIL`;

-- -----------------------------------------------------
-- Table `mydb`.`NOTIFICATION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_restaurant`.`NOTIFICATION` (
  `ID` INT NOT NULL,
  `TEMPLATE` VARCHAR(8000) NULL,
  `TEMPLATE_CODE` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;

INSERT INTO `BOOKING_RESTAURANT`.`NOTIFICATION` (`ID`, `TEMPLATE`, `TEMPLATE_CODE`) VALUES 
(1, '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Booking</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body style="margin: 0; padding: 0;">
  <table align="center" border="0" cellpadding="0" cellspacing="0" width="400" style="border-collapse: collapse;font-family: Arial, sans-serif; font-size: 16px; color: #9b9b9b; max-width: 600px;">
    <tr>
      <td colspan="3" width="100%" style="text-align: left;padding: 0 0 30px 0; width: 100%;">
          <img src="https://www.publicdomainpictures.net/pictures/270000/velka/restaurant-reservation-food-cus.jpg" height="230" width="100%" alt="">
      </td>
    </tr>
    <tr>
      <td colspan="3" width="100%" style="width: 100%;">
        <p style="margin: 0 0 20px 0;">Hola {name}</p>
        <p style="margin: 0 0 20px 0;"><b>Has realizado tu pago con éxito.</b> En caso de que no puedas acudir debes cancelar la reserva lo antes posible</p>
        <p style="margin: 0 0 30px 0;"></p>
      </td>
    </tr>
    <tr>
      <td width="180"></td>
      <td bgcolor="#c90c0c" width="240px" style="text-align: center;
          width: 240px;
          display: block;
          border: 1px solid transparent;
          border-radius: 2px;
          font-weight: 700;
          padding: 15px 0;"
          >
        <a href="https://booking-2491e.firebaseapp.com/cancel" width="240" height="50" href="#" style="color: #ffffff;text-decoration: none;margin: 0 auto 30px;">Cancelar reserva</a>
      </td>
      <td width="180"></td>
    </tr>
    <tr>
      <td colspan="3" width="100%" style="width: 100%; padding: 30px 0">
        <p style="margin: 0 0 3px 0;">Gracias</p>
        <p style="margin: 0 0 20px 0;">El equipo Booking-Restaurant</p>
      </td>
    </tr>
  </table>
</body>
</html>', 'PAYMENT');



INSERT INTO `BOOKING_RESTAURANT`.`NOTIFICATION` (`ID`, `TEMPLATE`, `TEMPLATE_CODE`) VALUES 
(2, '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Booking</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body style="margin: 0; padding: 0;">
  <table align="center" border="0" cellpadding="0" cellspacing="0" width="400" style="border-collapse: collapse;font-family: Arial, sans-serif; font-size: 16px; color: #9b9b9b; max-width: 600px;">
    <tr>
      <td colspan="3" width="100%" style="text-align: left;padding: 0 0 30px 0; width: 100%;">
          <img src="https://www.publicdomainpictures.net/pictures/270000/velka/restaurant-reservation-food-cus.jpg" height="230" width="100%" alt="">
      </td>
    </tr>
    <tr>
      <td colspan="3" width="100%" style="width: 100%;">
        <p style="margin: 0 0 20px 0;">Hola {name}</p>
        <p style="margin: 0 0 20px 0;"><b>Has cancelado tu reserva con éxito.</b> A continuación puedes realizar una nueva reserva.</p>
        <p style="margin: 0 0 30px 0;"></p>
      </td>
    </tr>
    <tr>
      <td width="180"></td>
      <td bgcolor="#7eb548" width="240px" style="text-align: center;
          width: 240px;
          display: block;
          border: 1px solid transparent;
          border-radius: 2px;
          font-weight: 700;
          padding: 15px 0;"
          >
        <a href="https://booking-2491e.firebaseapp.com/" width="240" height="50" href="#" style="color: #ffffff;text-decoration: none;margin: 0 auto 30px;">Reservar</a>
      </td>
      <td width="180"></td>
    </tr>
    <tr>
      <td colspan="3" width="100%" style="width: 100%; padding: 30px 0">
        <p style="margin: 0 0 3px 0;">Gracias</p>
        <p style="margin: 0 0 20px 0;">El equipo Booking-Restaurant</p>
      </td>
    </tr>
  </table>
</body>
</html>', 'CANCEL');



INSERT INTO `BOOKING_RESTAURANT`.`NOTIFICATION` (`ID`, `TEMPLATE`, `TEMPLATE_CODE`) VALUES 
(3, '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Booking</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body style="margin: 0; padding: 0;">
  <table align="center" border="0" cellpadding="0" cellspacing="0" width="400" style="border-collapse: collapse;font-family: Arial, sans-serif; font-size: 16px; color: #9b9b9b; max-width: 600px;">
    <tr>
      <td colspan="3" width="100%" style="text-align: left;padding: 0 0 30px 0; width: 100%;">
          <img src="https://www.publicdomainpictures.net/pictures/270000/velka/restaurant-reservation-food-cus.jpg" height="230" width="100%" alt="">
      </td>
    </tr>
    <tr>
      <td colspan="3" width="100%" style="width: 100%;">
        <p style="margin: 0 0 20px 0;">Hola {name}</p>
        <p style="margin: 0 0 20px 0;"><b>Has realizado tu reserva correctamente</b>. En caso de que no puedas acudir debes cancelar la reserva lo antes posible</p>
        <p style="margin: 0 0 30px 0;"></p>
      </td>
    </tr>
    <tr>
      <td width="180"></td>
      <td bgcolor="#c90c0c" width="240px" style="text-align: center;
          width: 240px;
          display: block;
          border: 1px solid transparent;
          border-radius: 2px;
          font-weight: 700;
          padding: 15px 0;"
          >
        <a href="https://booking-2491e.firebaseapp.com/cancel" width="240" height="50" href="#" style="color: #ffffff;text-decoration: none;margin: 0 auto 30px;">Cancelar reserva</a>
      </td>
      <td width="180"></td>
    </tr>
    <tr>
      <td colspan="3" width="100%" style="width: 100%; padding: 30px 0">
        <p style="margin: 0 0 3px 0;">Gracias</p>
        <p style="margin: 0 0 20px 0;">El equipo Booking-Restaurant</p>
      </td>
    </tr>
  </table>
</body>
</html>', 'RESERVATION');

