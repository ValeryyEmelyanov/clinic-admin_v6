-- Вставка данных в таблицу специализаций
INSERT INTO specialization (name, code_lat, description, is_active, created_at) VALUES
                                                                                    ('Cardiology', 'CARD', 'Heart specialist', true, CURRENT_TIMESTAMP),
                                                                                    ('Neurology', 'NEUR', 'Brain specialist', true, CURRENT_TIMESTAMP),
                                                                                    ('Dermatology', 'DERM', 'Skin specialist', true, CURRENT_TIMESTAMP),
                                                                                    ('Pediatrics', 'PEDI', 'Children specialist', true, CURRENT_TIMESTAMP),
                                                                                    ('Orthopedics', 'ORTH', 'Bone specialist', true, CURRENT_TIMESTAMP),
                                                                                    ('Ophthalmology', 'OPHTH', 'Eye specialist', false, CURRENT_TIMESTAMP),
                                                                                    ('Gastroenterology', 'GASTRO', 'Digestive system specialist', false, CURRENT_TIMESTAMP);

-- Вставка данных в таблицу врачей
INSERT INTO doctor (first_name, last_name, experience, is_active) VALUES
                                                                      ('John', 'Doe', 10, true),
                                                                      ('Jane', 'Smith', 8, true),
                                                                      ('Alice', 'Johnson', 12, true),
                                                                      ('Bob', 'Bruown', 7, false),
                                                                      ('Charlie', 'Davis', 9, true),
                                                                      ('Dana', 'Evans', 6, true),
                                                                      ('Frank', 'Green', 15, false),
                                                                      ('Grace', 'Harris', 5, true),
                                                                      ('Henry', 'Lewis', 20, true),
                                                                      ('Irene', 'Martinez', 11, true),
                                                                      ('Jack', 'Nguyen', 13, true),
                                                                      ('Karen', 'Ortiz', 14, true),
                                                                      ('Larry', 'Perez', 3, false),
                                                                      ('Monica', 'Quinn', 4, true),
                                                                      ('Nick', 'Robinson', 2, true);

-- Вставка данных в таблицу связей между врачами и специализациями
INSERT INTO doctor_specialization (doctor_id, specialization_id) VALUES
                                                                     (1, 1), (1, 3),
                                                                     (2, 1), (2, 2),
                                                                     (3, 2), (3, 5),
                                                                     (4, 3), (4, 6),
                                                                     (5, 4), (5, 7),
                                                                     (6, 5), (6, 6),
                                                                     (7, 1), (7, 7),
                                                                     (8, 2), (8, 6),
                                                                     (9, 3), (9, 7),
                                                                     (10, 4), (10, 5),
                                                                     (11, 1), (11, 4),
                                                                     (12, 3), (12, 6),
                                                                     (13, 2), (13, 5),
                                                                     (14, 5), (14, 7),
                                                                     (15, 1), (15, 4);
