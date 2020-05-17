-- inicjowanie użytkowników
INSERT IGNORE users (id, username, password, enabled) VALUES (1, 'admin', 'admin', true);
INSERT IGNORE authorities (id, username, authority) VALUES (1, 'admin', 'USER');
INSERT IGNORE authorities (id, username, authority) VALUES (1, 'admin', 'ADMIN');

INSERT IGNORE users (id, username, password, enabled) VALUES (2, 'user', 'user', true);
INSERT IGNORE authorities (id, username, authority) VALUES (2, 'user', 'USER');

INSERT IGNORE users (id, username, password, enabled) VALUES (3, 'user2', 'user2', true);
INSERT IGNORE authorities (id, username, authority) VALUES (3, 'user2', 'USER');

-- inicjowanie przykładowych fiszek
INSERT IGNORE flashcards_sets (id, title, detail, languages) VALUES (1, N'Food', N'Because Kibi likes to eat!', 1);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (1 ,N'cake', N'ciasto', 1);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (2 ,N'apple pie', N'placek z jabłkami', 1);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (3 ,N'pasta', N'makaron', 1);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (4 ,N'chips', N'frytki', 1);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (5 ,N'fried egg', N'jajko sadzone', 1);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (6 ,N'soup', N'zupa', 1);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (7 ,N'pancake', N'naleśnik', 1);

INSERT IGNORE flashcards_sets (id, title, detail, languages) VALUES (2, N'Animals', N'Roar!', 1);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (8 ,N'lion', N'lew', 2);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (9 ,N'kangaroo', N'kangur', 2);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (10 ,N'racon', N'szop', 2);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (11 ,N'baboon', N'pawian', 2);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (12 ,N'beaver', N'bóbr', 2);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (13 ,N'bumblebee', N'trzmiel', 2);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (14 ,N'caterpillar', N'gąsienica', 2);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (15 ,N'wolf', N'wilk', 2);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (16 ,N'pig', N'świnia', 2);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (17 ,N'cat', N'kot', 2);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (18 ,N'dog', N'pies', 2);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (19 ,N'rat', N'szczur', 2);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (20 ,N'cow', N'krowa', 2);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (21 ,N'falcon', N'sokół', 2);

INSERT IGNORE flashcards_sets (id, title, languages) VALUES (3, N'Sentimientos y emociones', 5);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (22 ,N'feliz', N'szczęśliwy', 3);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (23 ,N'triste', N'smutny', 3);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (24 ,N'enojado, enfadado', N'zły, rozzłoszczony', 3);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (25 ,N'gustar', N'lubić', 3);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (26 ,N'aburrido', N'znudzony, nudny', 3);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (27 ,N'adorar', N'uwielbiać', 3);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (28 ,N'deprimido', N'załamany', 3);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (29 ,N'emocionado', N'podekscytowany', 3);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (30 ,N'odiar', N'nienawidzić', 3);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (31 ,N'solitario', N'samotny', 3);

INSERT IGNORE flashcards_sets (id, title, languages) VALUES (4, N'Vehículo', 5);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (32 ,N'wóz strażacki', N'camión de bomberos', 4);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (33 ,N'skuter', N'escúter', 4);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (34 ,N'radiowóz policyjny', N'coche patrulla', 4);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (35 ,N'ciągnik siodłowy', N'camión tractor', 4);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (36 ,N'betoniarka', N'hormigonera', 4);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (37 ,N'karetka więzienna', N'furgón celular', 4);
INSERT IGNORE flashcards (id, left_side, right_side, flashcards_set_id) VALUES (38 ,N'samochód osobowy', N'turismo', 4);