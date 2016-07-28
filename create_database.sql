CREATE TABLE IF NOT EXISTS `departamenty` (
`id` smallint(6) NOT NULL AUTO_INCREMENT,
`nazwa` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

INSERT INTO `departamenty` (`id`, `nazwa`) VALUES
(2, 'departament 1'),
(10, 'departament 2'),
(11, 'departament 3'),
(16, 'departament 4');

CREATE TABLE IF NOT EXISTS `grupy` (
`login` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
`grupa` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `grupy` (`login`, `grupa`) VALUES
('administrator', 'zalogowany');

CREATE TABLE IF NOT EXISTS `pracownicy` (
`id` smallint(6) NOT NULL AUTO_INCREMENT,
`login` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
`haslo` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
`departament` smallint(6) DEFAULT NULL,
`telefon` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
`miejscowosc` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
`stanowisko` smallint(6) DEFAULT NULL,
`imie` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
`nazwisko` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
`zdjecie` tinyint(1) NOT NULL,
PRIMARY KEY (`id`),
KEY `pracownicy_departament_idx` (`departament`),
KEY `pracownicy_stanowisko_idx` (`stanowisko`),
KEY `login` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

INSERT INTO `pracownicy` (`id`, `login`, `haslo`, `departament`, `telefon`, `miejscowosc`, `stanowisko`, `imie`, `nazwisko`, `zdjecie`) VALUES
(34, 'nowy', '200ceb26807d6bf99fd6f4f0d1ca54d4', 11, '79769796797', 'Zielona Góra', 6, 'Anna', 'Za', 0),
(36, 'admin', '200ceb26807d6bf99fd6f4f0d1ca54d4', 2, '464634', 'Warszawa', 3, 'Adam', 'Nowak', 0),
(39, 'administrator', '200ceb26807d6bf99fd6f4f0d1ca54d4', 2, '65475757', 'Warszawa', 6, 'Jan', 'Kowalski', 0);

CREATE TABLE IF NOT EXISTS `stanowiska` (
`id` smallint(6) NOT NULL AUTO_INCREMENT,
`nazwa` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

INSERT INTO `stanowiska` (`id`, `nazwa`) VALUES
(3, 'stanowisko 1'),
(5, 'stanowisko 2'),
(6, 'stanowisko 3'),
(20, 'stanowisko 4'),
(23, 'stanowisko 5');

ALTER TABLE `grupy`
    ADD CONSTRAINT `grupy_ibfk_1` FOREIGN KEY (`login`) REFERENCES `pracownicy` (`login`) ON DELETE CASCADE;

ALTER TABLE `pracownicy`
    ADD CONSTRAINT `pracownicy_ibfk_3` FOREIGN KEY (`departament`) REFERENCES `departamenty` (`id`) ON DELETE CASCADE,
    ADD CONSTRAINT `pracownicy_ibfk_4` FOREIGN KEY (`stanowisko`) REFERENCES `stanowiska` (`id`) ON DELETE CASCADE;