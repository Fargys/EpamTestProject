DROP TABLE IF EXISTS championship;
DROP TABLE IF EXISTS team;

CREATE TABLE IF NOT EXISTS championship (
id                  INTEGER PRIMARY KEY AUTO_INCREMENT,
version             INTEGER,
name                VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS team (
    id                  INTEGER PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER,
    name                VARCHAR(30),
    games               INTEGER default 0,
    wins                INTEGER default 0,
    draws               INTEGER default 0,
    losses              INTEGER default 0,
    scored              INTEGER default 0,
    missed              INTEGER default 0,
    points              INTEGER default 0,
    champ_id            INTEGER,

    FOREIGN KEY (champ_id) REFERENCES championship(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);