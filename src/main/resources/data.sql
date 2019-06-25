--Championship--
INSERT INTO Championship (id, version, name)
VALUES (1, 0, 'Russia');

INSERT INTO Championship (id, version, name)
VALUES (2, 0, 'England');

INSERT INTO Championship (id, version, name)
VALUES (3, 0, 'Spain');

-- --Team for Russia--
INSERT INTO Team (id, version, name, champ_id)
VALUES (1, 0, 'Lokomotiv', 1);

INSERT INTO Team (id, version, name, champ_id)
VALUES (2, 0, 'Spartak', 1);

INSERT INTO Team (id, version, name, champ_id)
VALUES (3, 0, 'Krasnodar', 1);

INSERT INTO Team (id, version, name, champ_id)
VALUES (4, 0, 'Zenit', 1);

--Team for England--
INSERT INTO Team (id, version, name, champ_id)
VALUES (5, 0, 'Man. United', 2);

INSERT INTO Team (id, version, name, champ_id)
VALUES (6, 0, 'Man. City', 2);

INSERT INTO Team (id, version, name, champ_id)
VALUES (7, 0, 'Chelsea', 2);

INSERT INTO Team (id, version, name, champ_id)
VALUES (8, 0, 'Liverpool', 2);

--Team for Spain--
INSERT INTO Team (id, version, name, champ_id)
VALUES (9, 0, 'Barcelona', 3);

INSERT INTO Team (id, version, name, champ_id)
VALUES (10, 0, 'Real Madrid', 3);

INSERT INTO Team (id, version, name, champ_id)
VALUES (11, 0, 'Atletico', 3);

INSERT INTO Team (id, version, name, champ_id)
VALUES (12, 0, 'Valencia', 3);