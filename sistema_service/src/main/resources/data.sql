-- ==================================================
-- 👨‍👩‍👧 APODERADOS (30)
-- ==================================================

INSERT IGNORE INTO legal_guardians
(legal_guardian_id, dni, nombre, apellido, telefono, email, direccion, fecha_registro, is_active)
VALUES
(1, '12345678','Juan',     'Pérez García',     '999888777','juan.perez@gmail.com',     'Av. Lima 123, Callao', NOW(), 1),
(2, '23456789','María',    'López Torres',     '999777666','maria.lopez@gmail.com',    'Av. Brasil 456, Lima', NOW(), 1),
(3, '34567890','Carlos',   'Ramírez Soto',     '999666555','carlos.ramirez@gmail.com', 'Av. Arequipa 789, Lince', NOW(), 1),
(4, '45678901','Ana',      'Vargas Mendoza',   '999555444','ana.vargas@gmail.com',     'Av. Javier Prado 321, San Borja', NOW(), 1),
(5, '56789012','Pedro',    'Castillo Flores',  '999444333','pedro.castillo@gmail.com', 'Jr. Cusco 654, Barranco', NOW(), 1),
(6, '67890123','Lucía',    'Gutiérrez Bravo',  '999333222','lucia.gutierrez@gmail.com','Av. La Marina 987, San Miguel', NOW(), 1),
(7, '78901234','Roberto',  'Cruz Vega',        '999222111','roberto.cruz@gmail.com',   'Av. Salaverry 159, Jesús María', NOW(), 1),
(8, '89012345','Sandra',   'Morales Rivera',   '999111000','sandra.morales@gmail.com', 'Av. Benavides 753, Miraflores', NOW(), 1),
(9, '90123456','Miguel',   'Paredes Núñez',    '988999888','miguel.paredes@gmail.com', 'Jr. Junín 246, Lima Centro', NOW(), 1),
(10,'01234567','Patricia', 'Silva Romero',     '988888777','patricia.silva@gmail.com', 'Av. Colonial 369, Cercado', NOW(), 1),
(11,'11234567','Javier',   'Espinoza León',    '988777666','javier.espinoza@gmail.com','Av. Tomás Marsano 852', NOW(), 1),
(12,'21234567','Elena',    'Rojas Cárdenas',   '988666555','elena.rojas@gmail.com',    'Av. Aviación 741', NOW(), 1),
(13,'31234567','Andrés',   'Vásquez Ortiz',    '988555444','andres.vasquez@gmail.com', 'Av. Petit Thouars 963', NOW(), 1),
(14,'41234560','Mónica',   'Herrera Salinas',  '988444333','monica.herrera@gmail.com', 'Jr. Ayacucho 147, Pueblo Libre', NOW(), 1),
(15,'51234567','Daniel',   'Cabrera Martínez', '988333222','daniel.cabrera@gmail.com', 'Av. Universitaria 258', NOW(), 1),
(16,'61234567','Verónica', 'Acuña Delgado',    '988222111','veronica.acuna@gmail.com', 'Av. Argentina 369', NOW(), 1),
(17,'71234567','Fernando', 'Díaz Pérez',       '988111000','fernando.diaz@gmail.com',  'Av. Tacna 471', NOW(), 1),
(18,'81234567','Carmen',   'Quispe Mamani',    '977999888','carmen.quispe@gmail.com',  'Av. Wilson 582', NOW(), 1),
(19,'91234567','Jorge',    'Huamán Flores',    '977888777','jorge.huaman@gmail.com',   'Jr. Lampa 693', NOW(), 1),
(20,'02345678','Rosa',     'Mendoza Rojas',    '977777666','rosa.mendoza@gmail.com',   'Av. Garcilaso 714', NOW(), 1),
(21,'12345670','Luis',     'Torres Salazar',   '977666555','luis.torres@gmail.com',    'Av. Bolívar 825', NOW(), 1),
(22,'22345678','Pamela',   'Castro Lima',      '977555444','pamela.castro@gmail.com',  'Jr. Apurímac 936', NOW(), 1),
(23,'32345678','Ricardo',  'Salazar Vega',     '977444333','ricardo.salazar@gmail.com','Av. Sucre 147', NOW(), 1),
(24,'42345678','Diana',    'Núñez Bravo',      '977333222','diana.nunez@gmail.com',    'Av. Brasil 258', NOW(), 1),
(25,'52345678','Hugo',     'Romero Aguilar',   '977222111','hugo.romero@gmail.com',    'Jr. Tarapacá 369', NOW(), 1),
(26,'62345678','Karina',   'Bravo Quispe',     '977111000','karina.bravo@gmail.com',   'Av. Iquitos 471', NOW(), 1),
(27,'72345678','Eduardo',  'Aguirre Soto',     '966999888','eduardo.aguirre@gmail.com','Av. Grau 582', NOW(), 1),
(28,'82345678','Susana',   'Ruiz Mendoza',     '966888777','susana.ruiz@gmail.com',    'Jr. Huallaga 693', NOW(), 1),
(29,'92345678','Mario',    'Ortega Cruz',      '966777666','mario.ortega@gmail.com',   'Av. Abancay 714', NOW(), 1),
(30,'03456789','Liliana',  'Flores Vargas',    '966666555','liliana.flores@gmail.com', 'Av. Emancipación 825', NOW(), 1);


-- ==================================================
-- 🎓 ESTUDIANTES (30)
-- ==================================================

INSERT IGNORE INTO students
(student_id, dni, nombre, apellido, fecha_nacimiento, direccion, telefono, email, legal_guardian_id, fecha_registro, is_active)
VALUES
(1, '70000001','Pedro',    'Pérez García',     '2018-05-10','Av. Lima 123',         '988000001','pedro.perez@edu.pe',     1,  NOW(), 1),
(2, '70000002','Ana',      'Pérez García',     '2017-08-15','Av. Lima 123',         '988000002','ana.perez@edu.pe',       1,  NOW(), 1),
(3, '70000003','Carlos',   'López Torres',     '2016-03-20','Av. Brasil 456',       '988000003','carlos.lopez@edu.pe',    2,  NOW(), 1),
(4, '70000004','Sofía',    'López Torres',     '2015-09-12','Av. Brasil 456',       '988000004','sofia.lopez@edu.pe',     2,  NOW(), 1),
(5, '70000005','Diego',    'Ramírez Soto',     '2014-11-30','Av. Arequipa 789',     '988000005','diego.ramirez@edu.pe',   3,  NOW(), 1),
(6, '70000006','Valeria',  'Vargas Mendoza',   '2013-07-25','Av. Javier Prado 321', '988000006','valeria.vargas@edu.pe',  4,  NOW(), 1),
(7, '70000007','Mateo',    'Castillo Flores',  '2012-02-14','Jr. Cusco 654',        '988000007','mateo.castillo@edu.pe',  5,  NOW(), 1),
(8, '70000008','Camila',   'Gutiérrez Bravo',  '2011-06-08','Av. La Marina 987',    '988000008','camila.gutierrez@edu.pe',6,  NOW(), 1),
(9, '70000009','Lucas',    'Cruz Vega',        '2010-10-22','Av. Salaverry 159',    '988000009','lucas.cruz@edu.pe',      7,  NOW(), 1),
(10,'70000010','Isabella', 'Morales Rivera',   '2009-12-04','Av. Benavides 753',    '988000010','isabella.morales@edu.pe',8,  NOW(), 1),
(11,'70000011','Sebastián','Paredes Núñez',    '2018-04-18','Jr. Junín 246',        '988000011','sebastian.paredes@edu.pe',9, NOW(), 1),
(12,'70000012','Mariana',  'Silva Romero',     '2017-01-29','Av. Colonial 369',     '988000012','mariana.silva@edu.pe',   10, NOW(), 1),
(13,'70000013','Joaquín',  'Espinoza León',    '2016-05-17','Av. Tomás Marsano 852','988000013','joaquin.espinoza@edu.pe',11, NOW(), 1),
(14,'70000014','Renata',   'Rojas Cárdenas',   '2015-08-09','Av. Aviación 741',     '988000014','renata.rojas@edu.pe',    12, NOW(), 1),
(15,'70000015','Adrián',   'Vásquez Ortiz',    '2014-03-23','Av. Petit Thouars 963','988000015','adrian.vasquez@edu.pe',  13, NOW(), 1),
(16,'70000016','Antonella','Herrera Salinas',  '2013-10-11','Jr. Ayacucho 147',     '988000016','antonella.herrera@edu.pe',14,NOW(), 1),
(17,'70000017','Gabriel',  'Cabrera Martínez', '2012-07-05','Av. Universitaria 258','988000017','gabriel.cabrera@edu.pe', 15, NOW(), 1),
(18,'70000018','Valentina','Acuña Delgado',    '2011-11-19','Av. Argentina 369',    '988000018','valentina.acuna@edu.pe', 16, NOW(), 1),
(19,'70000019','Thiago',   'Díaz Pérez',       '2010-09-27','Av. Tacna 471',        '988000019','thiago.diaz@edu.pe',     17, NOW(), 1),
(20,'70000020','Emma',     'Quispe Mamani',    '2009-04-13','Av. Wilson 582',       '988000020','emma.quispe@edu.pe',     18, NOW(), 1),
(21,'70000021','Maximiliano','Huamán Flores',  '2018-08-30','Jr. Lampa 693',        '988000021','max.huaman@edu.pe',      19, NOW(), 1),
(22,'70000022','Luciana',  'Mendoza Rojas',    '2017-02-16','Av. Garcilaso 714',    '988000022','luciana.mendoza@edu.pe', 20, NOW(), 1),
(23,'70000023','Benjamín', 'Torres Salazar',   '2016-06-21','Av. Bolívar 825',      '988000023','benjamin.torres@edu.pe', 21, NOW(), 1),
(24,'70000024','Martina',  'Castro Lima',      '2015-12-07','Jr. Apurímac 936',     '988000024','martina.castro@edu.pe',  22, NOW(), 1),
(25,'70000025','Alonso',   'Salazar Vega',     '2014-05-26','Av. Sucre 147',        '988000025','alonso.salazar@edu.pe',  23, NOW(), 1),
(26,'70000026','Catalina', 'Núñez Bravo',      '2013-09-03','Av. Brasil 258',       '988000026','catalina.nunez@edu.pe',  24, NOW(), 1),
(27,'70000027','Bruno',    'Romero Aguilar',   '2012-04-15','Jr. Tarapacá 369',     '988000027','bruno.romero@edu.pe',    25, NOW(), 1),
(28,'70000028','Emilia',   'Bravo Quispe',     '2011-08-28','Av. Iquitos 471',      '988000028','emilia.bravo@edu.pe',    26, NOW(), 1),
(29,'70000029','Santiago', 'Aguirre Soto',     '2010-01-09','Av. Grau 582',         '988000029','santiago.aguirre@edu.pe',27, NOW(), 1),
(30,'70000030','Olivia',   'Ruiz Mendoza',     '2009-07-24','Jr. Huallaga 693',     '988000030','olivia.ruiz@edu.pe',     28, NOW(), 1);


-- ==================================================
-- 👨‍🏫 DOCENTES (30)
-- ==================================================

INSERT IGNORE INTO docentes
(docente_id, dni, nombre, apellido, especialidad, telefono, email, fecha_contratacion, is_active)
VALUES
(1, '40000001','María',    'Quispe Mamani',    'Matemáticas',              '987100001','maria.quispe@educonecta.edu.pe',    NOW(), 1),
(2, '40000002','Carlos',   'Huamán Flores',    'Comunicación',             '987100002','carlos.huaman@educonecta.edu.pe',   NOW(), 1),
(3, '40000003','Rosa',     'Vargas Chávez',    'Ciencia y Tecnología',     '987100003','rosa.vargas@educonecta.edu.pe',     NOW(), 1),
(4, '40000004','Luis',     'Mendoza Rojas',    'Personal Social',          '987100004','luis.mendoza@educonecta.edu.pe',    NOW(), 1),
(5, '40000005','Ana',      'Torres Salazar',   'Arte y Cultura',           '987100005','ana.torres@educonecta.edu.pe',      NOW(), 1),
(6, '40000006','Pedro',    'Castillo Aguilar', 'Educación Física',         '987100006','pedro.castillo@educonecta.edu.pe',  NOW(), 1),
(7, '40000007','Jorge',    'Ramírez Soto',     'Matemáticas',              '987100007','jorge.ramirez@educonecta.edu.pe',   NOW(), 1),
(8, '40000008','Patricia', 'López García',     'Comunicación',             '987100008','patricia.lopez@educonecta.edu.pe',  NOW(), 1),
(9, '40000009','Fernando', 'Díaz Pérez',       'Ciencia y Tecnología',     '987100009','fernando.diaz@educonecta.edu.pe',   NOW(), 1),
(10,'40000010','Carmen',   'Silva Romero',     'Ciencias Sociales',        '987100010','carmen.silva@educonecta.edu.pe',    NOW(), 1),
(11,'40000011','Roberto',  'Cruz Vega',        'Educación Física',         '987100011','roberto.cruz@educonecta.edu.pe',    NOW(), 1),
(12,'40000012','Sandra',   'Morales Rivera',   'Inglés',                   '987100012','sandra.morales@educonecta.edu.pe',  NOW(), 1),
(13,'40000013','Miguel',   'Paredes Núñez',    'Arte y Cultura',           '987100013','miguel.paredes@educonecta.edu.pe',  NOW(), 1),
(14,'40000014','Lucía',    'Gutiérrez Bravo',  'Religión',                 '987100014','lucia.gutierrez@educonecta.edu.pe', NOW(), 1),
(15,'40000015','Javier',   'Espinoza León',    'Educación para el Trabajo','987100015','javier.espinoza@educonecta.edu.pe', NOW(), 1),
(16,'40000016','Elena',    'Rojas Cárdenas',   'Tutoría',                  '987100016','elena.rojas@educonecta.edu.pe',     NOW(), 1),
(17,'40000017','Andrés',   'Vásquez Ortiz',    'Matemáticas',              '987100017','andres.vasquez@educonecta.edu.pe',  NOW(), 1),
(18,'40000018','Mónica',   'Herrera Salinas',  'Comunicación',             '987100018','monica.herrera@educonecta.edu.pe',  NOW(), 1),
(19,'40000019','Daniel',   'Cabrera Martínez', 'Ciencia y Tecnología',     '987100019','daniel.cabrera@educonecta.edu.pe',  NOW(), 1),
(20,'40000020','Verónica', 'Acuña Delgado',    'Inglés',                   '987100020','veronica.acuna@educonecta.edu.pe',  NOW(), 1),
(21,'40000021','Ricardo',  'Salazar Vega',     'Matemáticas',              '987100021','ricardo.salazar@educonecta.edu.pe', NOW(), 1),
(22,'40000022','Diana',    'Núñez Bravo',      'Comunicación',             '987100022','diana.nunez@educonecta.edu.pe',     NOW(), 1),
(23,'40000023','Hugo',     'Romero Aguilar',   'Ciencias Sociales',        '987100023','hugo.romero@educonecta.edu.pe',     NOW(), 1),
(24,'40000024','Karina',   'Bravo Quispe',     'Inglés',                   '987100024','karina.bravo@educonecta.edu.pe',    NOW(), 1),
(25,'40000025','Eduardo',  'Aguirre Soto',     'Educación Física',         '987100025','eduardo.aguirre@educonecta.edu.pe', NOW(), 1),
(26,'40000026','Susana',   'Ruiz Mendoza',     'Arte y Cultura',           '987100026','susana.ruiz@educonecta.edu.pe',     NOW(), 1),
(27,'40000027','Mario',    'Ortega Cruz',      'Religión',                 '987100027','mario.ortega@educonecta.edu.pe',    NOW(), 1),
(28,'40000028','Liliana',  'Flores Vargas',    'Educación para el Trabajo','987100028','liliana.flores@educonecta.edu.pe',  NOW(), 1),
(29,'40000029','Pamela',   'Castro Lima',      'Tutoría',                  '987100029','pamela.castro@educonecta.edu.pe',   NOW(), 1),
(30,'40000030','Gonzalo',  'Pinto Maldonado',  'Matemáticas',              '987100030','gonzalo.pinto@educonecta.edu.pe',   NOW(), 1);


-- ==================================================
-- 🏫 GRADOS Y SECCIONES (30)
-- ==================================================

INSERT IGNORE INTO grado_secciones
(grado_seccion_id, grado, seccion, anio_escolar, capacidad, is_active)
VALUES
(1,  '1°',     'A', 2026, 30, 1),
(2,  '1°',     'B', 2026, 30, 1),
(3,  '1°',     'C', 2026, 30, 1),
(4,  '2°',     'A', 2026, 30, 1),
(5,  '2°',     'B', 2026, 30, 1),
(6,  '2°',     'C', 2026, 30, 1),
(7,  '3°',     'A', 2026, 30, 1),
(8,  '3°',     'B', 2026, 30, 1),
(9,  '3°',     'C', 2026, 30, 1),
(10, '4°',     'A', 2026, 30, 1),
(11, '4°',     'B', 2026, 30, 1),
(12, '4°',     'C', 2026, 30, 1),
(13, '5°',     'A', 2026, 30, 1),
(14, '5°',     'B', 2026, 30, 1),
(15, '5°',     'C', 2026, 30, 1),
(16, '6°',     'A', 2026, 30, 1),
(17, '6°',     'B', 2026, 30, 1),
(18, '6°',     'C', 2026, 30, 1),
(19, '1° Sec', 'A', 2026, 30, 1),
(20, '1° Sec', 'B', 2026, 30, 1),
(21, '2° Sec', 'A', 2026, 30, 1),
(22, '2° Sec', 'B', 2026, 30, 1),
(23, '3° Sec', 'A', 2026, 30, 1),
(24, '3° Sec', 'B', 2026, 30, 1),
(25, '4° Sec', 'A', 2026, 30, 1),
(26, '4° Sec', 'B', 2026, 30, 1),
(27, '5° Sec', 'A', 2026, 30, 1),
(28, '5° Sec', 'B', 2026, 30, 1),
(29, '5° Sec', 'C', 2026, 30, 1),
(30, '6°',     'D', 2026, 30, 1);


-- ==================================================
-- 📝 MATRÍCULAS (30)
-- ==================================================

INSERT IGNORE INTO enrollments
(enrollment_id, student_id, grado_seccion_id, fecha_matricula, estado, is_active)
VALUES
(1,  1,  1,  CURDATE(), 'APROBADA', 1),
(2,  2,  4,  CURDATE(), 'APROBADA', 1),
(3,  3,  7,  CURDATE(), 'APROBADA', 1),
(4,  4,  10, CURDATE(), 'APROBADA', 1),
(5,  5,  13, CURDATE(), 'APROBADA', 1),
(6,  6,  16, CURDATE(), 'APROBADA', 1),
(7,  7,  19, CURDATE(), 'APROBADA', 1),
(8,  8,  21, CURDATE(), 'APROBADA', 1),
(9,  9,  23, CURDATE(), 'APROBADA', 1),
(10, 10, 25, CURDATE(), 'APROBADA', 1),
(11, 11, 2,  CURDATE(), 'APROBADA', 1),
(12, 12, 5,  CURDATE(), 'APROBADA', 1),
(13, 13, 8,  CURDATE(), 'APROBADA', 1),
(14, 14, 11, CURDATE(), 'APROBADA', 1),
(15, 15, 14, CURDATE(), 'APROBADA', 1),
(16, 16, 17, CURDATE(), 'APROBADA', 1),
(17, 17, 20, CURDATE(), 'APROBADA', 1),
(18, 18, 22, CURDATE(), 'APROBADA', 1),
(19, 19, 24, CURDATE(), 'APROBADA', 1),
(20, 20, 27, CURDATE(), 'APROBADA', 1),
(21, 21, 3,  CURDATE(), 'APROBADA', 1),
(22, 22, 6,  CURDATE(), 'APROBADA', 1),
(23, 23, 9,  CURDATE(), 'APROBADA', 1),
(24, 24, 12, CURDATE(), 'APROBADA', 1),
(25, 25, 15, CURDATE(), 'APROBADA', 1),
(26, 26, 18, CURDATE(), 'APROBADA', 1),
(27, 27, 26, CURDATE(), 'APROBADA', 1),
(28, 28, 28, CURDATE(), 'APROBADA', 1),
(29, 29, 29, CURDATE(), 'APROBADA', 1),
(30, 30, 30, CURDATE(), 'APROBADA', 1);


-- ==================================================
-- 💵 CUOTAS (30)
-- ==================================================

INSERT IGNORE INTO quotas
(quota_id, enrollment_id, monto, fecha_vencimiento, estado, is_active)
VALUES
(1,  1,  250.00, '2026-07-30', 'PAGADA',    1),
(2,  1,  250.00, '2026-08-30', 'PENDIENTE', 1),
(3,  2,  250.00, '2026-07-30', 'PAGADA',    1),
(4,  2,  250.00, '2026-08-30', 'PENDIENTE', 1),
(5,  3,  250.00, '2026-07-30', 'PAGADA',    1),
(6,  3,  250.00, '2026-08-30', 'PENDIENTE', 1),
(7,  4,  280.00, '2026-07-30', 'PAGADA',    1),
(8,  4,  280.00, '2026-08-30', 'PENDIENTE', 1),
(9,  5,  280.00, '2026-07-30', 'PAGADA',    1),
(10, 5,  280.00, '2026-08-30', 'PENDIENTE', 1),
(11, 6,  280.00, '2026-07-30', 'PAGADA',    1),
(12, 7,  300.00, '2026-07-30', 'PAGADA',    1),
(13, 7,  300.00, '2026-08-30', 'PENDIENTE', 1),
(14, 8,  300.00, '2026-07-30', 'PAGADA',    1),
(15, 9,  300.00, '2026-07-30', 'PAGADA',    1),
(16, 10, 320.00, '2026-07-30', 'PAGADA',    1),
(17, 11, 250.00, '2026-07-30', 'PAGADA',    1),
(18, 12, 280.00, '2026-07-30', 'PENDIENTE', 1),
(19, 13, 280.00, '2026-07-30', 'PAGADA',    1),
(20, 14, 300.00, '2026-07-30', 'PAGADA',    1),
(21, 15, 300.00, '2026-07-30', 'PENDIENTE', 1),
(22, 16, 320.00, '2026-07-30', 'PAGADA',    1),
(23, 17, 320.00, '2026-07-30', 'PENDIENTE', 1),
(24, 18, 350.00, '2026-07-30', 'PAGADA',    1),
(25, 19, 350.00, '2026-07-30', 'PENDIENTE', 1),
(26, 20, 350.00, '2026-07-30', 'PAGADA',    1),
(27, 21, 250.00, '2026-07-30', 'PAGADA',    1),
(28, 22, 280.00, '2026-07-30', 'PENDIENTE', 1),
(29, 23, 300.00, '2026-07-30', 'PAGADA',    1),
(30, 24, 320.00, '2026-07-30', 'PENDIENTE', 1);


-- ==================================================
-- 💰 PAGOS (30)
-- ==================================================

INSERT IGNORE INTO payments
(payment_id, quota_id, monto_pagado, fecha_pago, metodo_pago, is_active)
VALUES
(1,  1,  250.00, '2026-07-15', 'YAPE',          1),
(2,  3,  250.00, '2026-07-16', 'PLIN',          1),
(3,  5,  250.00, '2026-07-17', 'EFECTIVO',      1),
(4,  7,  280.00, '2026-07-18', 'TRANSFERENCIA', 1),
(5,  9,  280.00, '2026-07-19', 'TARJETA',       1),
(6,  11, 280.00, '2026-07-20', 'YAPE',          1),
(7,  12, 300.00, '2026-07-21', 'PLIN',          1),
(8,  14, 300.00, '2026-07-22', 'EFECTIVO',      1),
(9,  15, 300.00, '2026-07-23', 'TRANSFERENCIA', 1),
(10, 16, 320.00, '2026-07-24', 'TARJETA',       1),
(11, 17, 250.00, '2026-07-25', 'YAPE',          1),
(12, 19, 280.00, '2026-07-26', 'PLIN',          1),
(13, 20, 300.00, '2026-07-27', 'EFECTIVO',      1),
(14, 22, 320.00, '2026-07-28', 'TRANSFERENCIA', 1),
(15, 24, 350.00, '2026-07-29', 'TARJETA',       1),
(16, 26, 350.00, '2026-07-30', 'YAPE',          1),
(17, 27, 250.00, '2026-08-01', 'PLIN',          1),
(18, 29, 300.00, '2026-08-02', 'EFECTIVO',      1),
(19, 1,  100.00, '2026-08-03', 'YAPE',          1),
(20, 3,  100.00, '2026-08-04', 'PLIN',          1),
(21, 5,  150.00, '2026-08-05', 'EFECTIVO',      1),
(22, 7,  130.00, '2026-08-06', 'TRANSFERENCIA', 1),
(23, 9,  140.00, '2026-08-07', 'TARJETA',       1),
(24, 12, 150.00, '2026-08-08', 'YAPE',          1),
(25, 14, 150.00, '2026-08-09', 'PLIN',          1),
(26, 16, 160.00, '2026-08-10', 'EFECTIVO',      1),
(27, 17, 125.00, '2026-08-11', 'TRANSFERENCIA', 1),
(28, 19, 140.00, '2026-08-12', 'TARJETA',       1),
(29, 20, 150.00, '2026-08-13', 'YAPE',          1),
(30, 22, 160.00, '2026-08-14', 'PLIN',          1);


-- ==================================================
-- 🕒 HORARIOS (30)
-- ==================================================

INSERT IGNORE INTO horarios
(horario_id, grado_seccion_id, docente_id, curso, dia_semana, hora_inicio, hora_fin, is_active)
VALUES
(1,  1,  1, 'Matemáticas',               'LUNES',     '08:00:00', '09:00:00', 1),
(2,  1,  2, 'Comunicación',              'LUNES',     '09:00:00', '10:00:00', 1),
(3,  1,  3, 'Ciencia y Tecnología',      'MARTES',    '08:00:00', '09:00:00', 1),
(4,  1,  4, 'Personal Social',           'MIERCOLES', '08:00:00', '09:00:00', 1),
(5,  1,  6, 'Educación Física',          'VIERNES',   '10:00:00', '11:00:00', 1),
(6,  2,  1, 'Matemáticas',               'LUNES',     '08:00:00', '09:00:00', 1),
(7,  2,  2, 'Comunicación',              'MARTES',    '09:00:00', '10:00:00', 1),
(8,  2,  5, 'Arte y Cultura',            'JUEVES',    '11:00:00', '12:00:00', 1),
(9,  4,  1, 'Matemáticas',               'LUNES',     '08:00:00', '09:00:00', 1),
(10, 4,  2, 'Comunicación',              'MARTES',    '08:00:00', '09:00:00', 1),
(11, 4,  3, 'Ciencia y Tecnología',      'MIERCOLES', '09:00:00', '10:00:00', 1),
(12, 7,  1, 'Matemáticas',               'LUNES',     '08:00:00', '09:00:00', 1),
(13, 7,  4, 'Personal Social',           'JUEVES',    '10:00:00', '11:00:00', 1),
(14, 10, 7, 'Matemáticas',               'LUNES',     '08:00:00', '09:00:00', 1),
(15, 10, 8, 'Comunicación',              'MARTES',    '09:00:00', '10:00:00', 1),
(16, 13, 7, 'Matemáticas',               'MIERCOLES', '08:00:00', '09:00:00', 1),
(17, 13, 9, 'Ciencia y Tecnología',      'JUEVES',    '09:00:00', '10:00:00', 1),
(18, 16, 7, 'Matemáticas',               'LUNES',     '10:00:00', '11:00:00', 1),
(19, 16, 11,'Educación Física',          'VIERNES',   '11:00:00', '12:00:00', 1),
(20, 19, 7, 'Matemáticas',               'LUNES',     '08:00:00', '09:00:00', 1),
(21, 19, 8, 'Comunicación',              'MARTES',    '09:00:00', '10:00:00', 1),
(22, 19, 10,'Ciencias Sociales',         'JUEVES',    '11:00:00', '12:00:00', 1),
(23, 19, 12,'Inglés',                    'VIERNES',   '12:00:00', '13:00:00', 1),
(24, 21, 7, 'Matemáticas',               'LUNES',     '08:00:00', '09:00:00', 1),
(25, 21, 14,'Religión',                  'VIERNES',   '12:00:00', '13:00:00', 1),
(26, 23, 7, 'Matemáticas',               'LUNES',     '08:00:00', '09:00:00', 1),
(27, 23, 15,'Educación para el Trabajo', 'JUEVES',    '11:00:00', '12:00:00', 1),
(28, 25, 7, 'Matemáticas',               'LUNES',     '08:00:00', '09:00:00', 1),
(29, 27, 7, 'Matemáticas',               'LUNES',     '08:00:00', '09:00:00', 1),
(30, 27, 16,'Tutoría',                   'VIERNES',   '13:00:00', '14:00:00', 1);