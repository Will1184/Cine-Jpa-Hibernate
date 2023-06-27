INSERT INTO actores (CodActor, nombre,FNacimiento,LNacimiento,nacionalidad,FMuerte,LMuerte)  VALUES (1,'Kevin Costner','1955-01-18 00:00:00','Lywood, California','Estados Unidos',NULL,NULL),(2,'Héctor Alterio','1929-10-21 00:00:00','Buenos Aires','Argentina',NULL,NULL),(3,'Ricardo Darín','1957-01-16 00:00:00','Buenos Aires','Argentina',NULL,NULL),(4,'Viggo Mortensen','1958-10-20 00:00:00','Manhattan, New York','Estados Unidos',NULL,NULL),(5,'Liv Tyler','1977-07-01 00:00:00','Portland, Maine','Estados Unidos',NULL,NULL),(6,'Orlando Bloom','1977-01-13 00:00:00','Canterbury, Kent','Gran Bretaña',NULL,NULL),(7,'Javier Bardem','1969-03-01 00:00:00','Las Palmas de Gran Canaria','España',NULL,NULL),(8,'Belén Rueda','1965-03-16 00:00:00','Madrid','España',NULL,NULL),(9,'Lola Dueñas',NULL,NULL,'España',NULL,NULL),(10,'Humphrey Bogart','1899-12-25 00:00:00','New York, New York','Estados Unidos','1957-01-14 00:00:00','Los Angeles, California'),(11,'Ingrid Bergman','1915-08-29 00:00:00',' Stockholm','Suecia','1982-08-28 00:00:00','Londres'),(12,'Juan Jose Ballesta','1987-11-12 00:00:00',NULL,'España',NULL,NULL),(13,'Chus Lampreave','1930-12-11 00:00:00','Madrid','España',NULL,NULL),(14,'Tony Leblanc','1922-05-07 00:00:00','Madrid','España',NULL,NULL),(15,'Ana Fernández','1968-01-01 00:00:00','Valenciana de la Consepción, Sevilla','España',NULL,NULL),(16,'Maria Galiana','1935-01-01 00:00:00','Sevilla','España',NULL,NULL),(22,'Tom Hanks','1956-09-07 00:00:00','Concord (California)','Estados Unidos',NULL,NULL),(23,'Antonio Banderas','1960-10-08 00:00:00','Málaga','España',NULL,NULL),(33,'Tom Cruise','1962-07-03 00:00:00','Syracuse, Nueva York','Estados Unidos',NULL,NULL),(34,'Jonh Travolta','1954-02-18 00:00:00','Englewood, Nueva Jersey','Estados Unidos',NULL,NULL),(35,'Jhony Deep','1971-01-14 00:00:00','Syracuse, Nueva York','Estados Unidos',NULL,NULL);
INSERT INTO directores (CodDirector,nombre,FNacimiento,Nacionalidad,LNacimiento,FMuerte,LMuerte) VALUES (1,'Achero Mañas','1966-09-05 00:00:00','Madrid','España',NULL,NULL),(2,'Pedro Almodóvar','1951-09-25 00:00:00','Calzada de Calatrava','España',NULL,NULL),(3,'Alejandro Amenábar','1972-03-31 00:00:00','Santiago de Chile','Chile',NULL,NULL),(4,'Santiago Segura','1965-07-17 00:00:00','Madrid','España',NULL,NULL),(5,'Juan José Campanella','1959-07-19 00:00:00','Buenos Aires','Argentina',NULL,NULL),(6,'Roger Donaldson','1945-11-15 00:00:00','Ballarat','Australia',NULL,NULL),(7,'Peter Jackson','1961-10-31 00:00:00','Pukerua Bay, North Isla','Nueva Zelanda',NULL,NULL),(8,'Michael Curtiz','1886-12-24 00:00:00','Budapest','Hungría','1962-04-10 00:00:00','Hollywood, California'),(9,'Benito Zambrano','1964-01-01 00:00:00','Nebrija','España',NULL,NULL),(10,'Wolfgang Petersen','1941-03-14 00:00:00','Emdem','Alemania',NULL,NULL),(11,'Clint Eastwood','1930-05-31 00:00:00','San Francisco (California)','Estados Unidos',NULL,NULL),(12,'David Dobkin',NULL,NULL,NULL,NULL,NULL);
INSERT INTO generos (IdGenero, nombre) VALUES (1,'Terror'),(2,'Drama'),(3,'Ficcion'),(4,'Sci-fi'),(5,'Romance');
INSERT INTO peliculas(codpelicula, titulo,anyo,nacionalidad,duracion,fechaEstreno,genero,taquilla,productora,Distribuidora,director) VALUES (3,'31 dias','2000','Estados Unidos',145,'2001-03-23 00:00:00',1,1103731.95,'Beacon Pictures','Manga Films S.L.',6),(4,'El hijo de la novia','2001','España Argentina',124,'2001-11-23 00:00:00',2,7230415.69,'Tornasol Films, S.A.','Alta Classics S.L.',5),(5,'El Señor de los Anillos. La Comunidad del Anillo','2001','Nueva Zelanda',180,'2001-12-19 00:00:00',3,31263314.97,'Wingnut Films','Aurum Producciones S.A.',7),(6,'Mar Adentro','2004','España',105,'2004-09-03 00:00:00',2,21469765.482,'SOGECINE','SOGEPAQ S.A.',3),(7,'Casablanca','1942','Estados Unidos',108,'1946-12-19 00:00:00',5,318310.24,'Warner Bros Pictures','C.B. Fimls S.A.',8),(8,'El Bola','2000','España',98,'2000-10-20 00:00:00',5,3298489.172,'Tesela Producciones Cinematográficas','Wanda Vision, S.A.',1),(9,'Torrente, el brazo tonto de la ley','1998','España',107,'1998-03-13 00:00:00',3,11992815.945,'Cartel Producciones Audiovisuales, S.L.','Columbia Tri-Star Films de España, S.A.',4),(10,'Solas','1998','España',101,'1999-03-05 00:00:00',2,4042664.417,'Maestranza Films, S.L.','Wanda Vision, S.A.',9),(11,'Poseidón','2005','Estados Unidos',105,'2005-06-25 00:00:00',3,0,NULL,NULL,10),(12,'Flags of our fathers','2005','Estados Unidos',108,'2005-07-02 00:00:00',3,0,'Warner Bros',NULL,11),(13,'Piratas del Caribe','2004','Estados Unidos',130,'2004-07-02 00:00:00',3,11992815.945,'Warner Bros','Columbia Tri-Star Films de España, S.A.',10);
INSERT INTO premios (codPremio, premio) VALUES (1,'Espiga de Plata'),(2,'Premio del Público'),(3,'Mejor Banda Sonora'),(4,'Mejor Fotografía'),(5,'Mejor Maquillaje y/o Peluqueria'),(6,'Mejores Efectos Visuales'),(7,'Mejor Película'),(8,'Mejor Actriz de Reparto'),(9,'Mejor Guión Original'),(10,'Mejor Dirección'),(11,'Mejor Actor'),(12,'Mejor Película Extranjera'),(13,'Mejor Actor Revelación'),(14,'Mejor Actriz'),(15,'Mejor Actor de Reparto'),(16,'Mejor Actriz Revelación'),(17,'Mejor Guión'),(18,'Mejor Guión Original'),(19,'Mejor Dirección Novel'),(20,'Mejor Actriz Secundaria'),(21,'Mejor Actor Secundario'),(22,'Mejor Actriz de Reparto'),(23,'Gran Premio del Jurado'),(24,'Mejor Dirección de Producción');
INSERT INTO ganaPremio (codPelicula,CodPremio,anyo)VALUES (4,1,2001),(4,2,2001),(5,3,2002),(5,4,2002),(5,5,2002),(5,6,2002),(6,3,2005),(6,4,2005),(6,5,2005),(6,7,2005),(6,9,2005),(6,10,2004),(6,11,2004),(6,12,2005),(6,13,2005),(6,14,2005),(6,15,2005),(6,16,2005),(6,22,2005),(6,23,2004),(6,24,2005),(7,7,1943),(7,10,1943),(7,17,1943),(8,7,2001),(8,9,2001),(8,19,2001),(10,2,1999),(10,9,2000),(10,13,2000),(10,16,2000),(10,19,2000),(10,20,2000);
INSERT INTO participa (CodActor,CodPelicula) VALUES (1,3),(2,4),(3,4),(4,5),(5,5),(6,5),(7,6),(8,6),(9,6),(10,7),(11,7),(12,8),(13,9),(14,9),(15,10),(16,10),(6,13),(35,13);


