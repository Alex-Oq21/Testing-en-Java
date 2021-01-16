CREATE TABLE IF NOT EXISTS movies(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
minutes INT NOT NULL,
genre VARCHAR(50) NOT NULL
);

INSERT INTO movies (name, minutes, genre) values
    ('the raid redemption', 152, 'ACTION'),
    ('Rapidos y furiosos', 130, 'ACTION'),
    ('Son como niños', 145, 'COMEDIA'),
    ('Jepper Creepers', 130, 'HORROR'),
    ('La morgue', 120, 'THRILLER');
