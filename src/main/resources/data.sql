INSERT INTO instructors (instructor_name, email) VALUES
                                                     ('Alice Johnson',  'alice.johnson@school.com'),
                                                     ('Bob Martinez',   'bob.martinez@school.com'),
                                                     ('Carol White',    'carol.white@school.com'),
                                                     ('David Lee',      'david.lee@school.com'),
                                                     ('Emma Brown',     'emma.brown@school.com');

INSERT INTO courses (course_name, description, instructor_id) VALUES
                                                                  ('Introduction to Java',    'Core Java concepts and OOP.',                1),
                                                                  ('Spring Boot Fundamentals','Building REST APIs with Spring Boot.',        1),
                                                                  ('Advanced Algorithms',     'Sorting, graphs, and dynamic programming.',  2),
                                                                  ('Database Design',         'Relational model, SQL, and PostgreSQL.',     2),
                                                                  ('Web Development',         'UI development using React and TypeScript.', 3),
                                                                  ('Python for Data Science', 'Data manipulation with Pandas.',             3),
                                                                  ('Machine Learning Basics', 'Supervised and unsupervised learning.',      4),
                                                                  ('DevOps and CI/CD',        'Docker, Kubernetes, and pipelines.',         4),
                                                                  ('Cybersecurity Essentials','Encryption and secure coding practices.',    5),
                                                                  ('Cloud Computing with AWS','EC2, S3, RDS, Lambda, and Terraform.',       5);

INSERT INTO students (student_name, email, phone_number) VALUES
                                                             ('Sophea Chan',   'sophea.chan@email.com',   '012-111-001'),
                                                             ('Dara Khmer',    'dara.khmer@email.com',    '012-111-002'),
                                                             ('Maly Pov',      'maly.pov@email.com',      '012-111-003'),
                                                             ('Piseth Nou',    'piseth.nou@email.com',     '012-111-004'),
                                                             ('Sreyleak Heng', 'sreyleak.heng@email.com', '012-111-005'),
                                                             ('Vichet Sorn',   'vichet.sorn@email.com',   '012-111-006'),
                                                             ('Channary Yim',  'channary.yim@email.com',  '012-111-007'),
                                                             ('Borey Lim',     'borey.lim@email.com',     '012-111-008'),
                                                             ('Sokunthea Ros', 'sokunthea.ros@email.com', '012-111-009'),
                                                             ('Ratanak Pen',   'ratanak.pen@email.com',   '012-111-010');

INSERT INTO student_course (student_id, course_id) VALUES
                                                       (1, 1), (1, 2), (1, 4),
                                                       (2, 3), (2, 1), (2, 8),
                                                       (3, 5), (3, 6), (3, 7),
                                                       (4, 7), (4, 6), (4, 10),
                                                       (5, 2), (5, 3), (5, 5),
                                                       (6, 9), (6, 8), (6, 10),
                                                       (7, 1), (7, 5), (7, 6),
                                                       (8, 1), (8, 3), (8, 4),
                                                       (9, 10),(9, 8), (9, 2),
                                                       (10, 7),(10, 3),(10, 6);
