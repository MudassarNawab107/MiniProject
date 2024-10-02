CREATE TABLE 01_mini_plans (
    plan_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    plan_name VARCHAR(255) NOT NULL,
    plan_description VARCHAR(255),
    plan_category_id int(10),
    plan_budget int(255),
    is_plan_active int(10),
    lastupdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    lastupdatedby VARCHAR(255) DEFAULT NULL,
    logged_by VARCHAR(255) DEFAULT NULL,
    loggeddate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    rowstate int(10) DEFAULT 1;
);





CREATE TABLE 01_mini_category_master (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL,
    lastupdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    lastupdatedby VARCHAR(255) DEFAULT NULL,
    logged_by VARCHAR(255) DEFAULT NULL,
    loggeddate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    rowstate int(10)DEFAULT 1
);


ALTER TABLE `dev_schema`.`01_mini_category_master` 
CHANGE COLUMN `rowstate` `rowstate` INT NULL DEFAULT 1 ;



CREATE TABLE course (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    faculty_name VARCHAR(100) NOT NULL,
    course_start_date DATE NOT NULL,
    fee DECIMAL(10, 2) NOT NULL,
    training_mode VARCHAR(50) NOT NULL,
    last_updated_by VARCHAR(100),
    last_update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    location VARCHAR(100),
    admin_contact_number VARCHAR(15) NOT NULL
);


INSERT INTO course (course_id, course_name, faculty_name, course_start_date, fee, training_mode, last_updated_by, location, admin_contact_number)
VALUES
(1, 'Python Programming', 'Alice Smith', '2024-01-10', 500.00, 'Online', 'Alice Smith', 'Room 101', '123-456-7890'),
(2, 'Python Programming', 'Bob Johnson', '2024-02-01', 500.00, 'In-Person', 'Bob Johnson', 'Room 102', '234-567-8901'),
(3, 'Java Programming', 'Charlie Brown', '2024-01-15', 600.00, 'Hybrid', 'Charlie Brown', 'Room 103', '345-678-9012'),
(4, 'Java Programming', 'Diana Prince', '2024-02-15', 600.00, 'Online', 'Diana Prince', 'Room 104', '456-789-0123'),
(5, 'C++ Programming', 'Eve Adams', '2024-03-05', 700.00, 'In-Person', 'Eve Adams', 'Room 105', '567-890-1234'),
(6, 'C++ Programming', 'Frank Castle', '2024-03-20', 700.00, 'Hybrid', 'Frank Castle', 'Room 106', '678-901-2345'),
(7, 'JavaScript Programming', 'Grace Hopper', '2024-04-01', 650.00, 'Online', 'Grace Hopper', 'Room 107', '789-012-3456'),
(8, 'JavaScript Programming', 'Hank Pym', '2024-04-15', 650.00, 'In-Person', 'Hank Pym', 'Room 108', '890-123-4567'),
(9, 'Ruby Programming', 'Ivy League', '2024-05-01', 550.00, 'Hybrid', 'Ivy League', 'Room 109', '901-234-5678'),
(10, 'Ruby Programming', 'Jack Ryan', '2024-05-20', 550.00, 'Online', 'Jack Ryan', 'Room 110', '012-345-6789'),
(11, 'C# Programming', 'Karen Gillan', '2024-06-05', 600.00, 'In-Person', 'Karen Gillan', 'Room 111', '123-456-7891'),
(12, 'C# Programming', 'Larry Page', '2024-06-20', 600.00, 'Hybrid', 'Larry Page', 'Room 112', '234-567-8902'),
(13, 'Go Programming', 'Mona Lisa', '2024-07-01', 700.00, 'Online', 'Mona Lisa', 'Room 113', '345-678-9013'),
(14, 'Go Programming', 'Nina Simone', '2024-07-15', 700.00, 'In-Person', 'Nina Simone', 'Room 114', '456-789-0124'),
(15, 'Swift Programming', 'Oscar Wilde', '2024-08-01', 650.00, 'Hybrid', 'Oscar Wilde', 'Room 115', '567-890-1235'),
(16, 'Swift Programming', 'Paul Atreides', '2024-08-15', 650.00, 'Online', 'Paul Atreides', 'Room 116', '678-901-2346'),
(17, 'Kotlin Programming', 'Quinn Fabray', '2024-09-01', 700.00, 'In-Person', 'Quinn Fabray', 'Room 117', '789-012-3457'),
(18, 'Kotlin Programming', 'Rick Sanchez', '2024-09-15', 700.00, 'Hybrid', 'Rick Sanchez', 'Room 118', '890-123-4568'),
(19, 'PHP Programming', 'Steve Rogers', '2024-10-01', 600.00, 'Online', 'Steve Rogers', 'Room 119', '901-234-5679'),
(20, 'PHP Programming', 'Tony Stark', '2024-10-15', 600.00, 'In-Person', 'Tony Stark', 'Room 120', '012-345-6780');


INSERT INTO course (course_id, course_name, faculty_name, course_start_date, fee, training_mode, last_updated_by, location, admin_contact_number) VALUES
(21, 'Python Programming', 'Alice Smith', '2024-01-10', 500.00, 'Online', 'Alice Smith', 'Room 101', '123-456-7890'),
(22, 'Java Programming', 'Bob Johnson', '2024-01-15', 550.00, 'Online', 'Bob Johnson', 'Room 102', '123-456-7891'),
(23, 'JavaScript Programming', 'Charlie Brown', '2024-01-20', 600.00, 'In-Person', 'Charlie Brown', 'Room 103', '123-456-7892'),
(24, 'C++ Programming', 'Diana Prince', '2024-01-25', 650.00, 'Online', 'Diana Prince', 'Room 104', '123-456-7893'),
(25, 'C# Programming', 'Edward Norton', '2024-02-01', 600.00, 'Hybrid', 'Edward Norton', 'Room 105', '123-456-7894'),
(26, 'Ruby Programming', 'Fiona Apple', '2024-02-05', 500.00, 'In-Person', 'Fiona Apple', 'Room 106', '123-456-7895'),
(27, 'Go Programming', 'George Lucas', '2024-02-10', 700.00, 'Online', 'George Lucas', 'Room 107', '123-456-7896'),
(28, 'Swift Programming', 'Hannah Arendt', '2024-02-15', 600.00, 'Hybrid', 'Hannah Arendt', 'Room 108', '123-456-7897'),
(29, 'Kotlin Programming', 'Ian McKellen', '2024-02-20', 650.00, 'In-Person', 'Ian McKellen', 'Room 109', '123-456-7898'),
(30, 'PHP Programming', 'Julia Roberts', '2024-02-25', 500.00, 'Online', 'Julia Roberts', 'Room 110', '123-456-7899'),
(31, 'TypeScript Programming', 'Kevin Spacey', '2024-03-01', 550.00, 'Hybrid', 'Kevin Spacey', 'Room 111', '123-456-7800'),
(32, 'Rust Programming', 'Laura Linney', '2024-03-05', 600.00, 'In-Person', 'Laura Linney', 'Room 112', '123-456-7801'),
(33, 'Scala Programming', 'Michael Caine', '2024-03-10', 700.00, 'Online', 'Michael Caine', 'Room 113', '123-456-7802'),
(34, 'Elixir Programming', 'Nina Simone', '2024-03-15', 650.00, 'Hybrid', 'Nina Simone', 'Room 114', '123-456-7803'),
(35, 'Perl Programming', 'Oscar Isaac', '2024-03-20', 500.00, 'In-Person', 'Oscar Isaac', 'Room 115', '123-456-7804'),
(36, 'Haskell Programming', 'Penelope Cruz', '2024-03-25', 600.00, 'Online', 'Penelope Cruz', 'Room 116', '123-456-7805'),
(37, 'Objective-C Programming', 'Quentin Tarantino', '2024-03-30', 650.00, 'Hybrid', 'Quentin Tarantino', 'Room 117', '123-456-7806'),
(38, 'MATLAB Programming', 'Rachel McAdams', '2024-04-05', 700.00, 'In-Person', 'Rachel McAdams', 'Room 118', '123-456-7807'),
(39, 'Lua Programming', 'Steve Jobs', '2024-04-10', 500.00, 'Online', 'Steve Jobs', 'Room 119', '123-456-7808'),
(40, 'Visual Basic Programming', 'Tina Fey', '2024-04-15', 600.00, 'Hybrid', 'Tina Fey', 'Room 120', '123-456-7809'),
(41, 'Dart Programming', 'Uma Thurman', '2024-04-20', 550.00, 'In-Person', 'Uma Thurman', 'Room 121', '123-456-7810'),
(42, 'Scheme Programming', 'Vince Vaughn', '2024-04-25', 500.00, 'Online', 'Vince Vaughn', 'Room 122', '123-456-7811'),
(43, 'Solidity Programming', 'Will Smith', '2024-05-01', 700.00, 'Hybrid', 'Will Smith', 'Room 123', '123-456-7812'),
(44, 'COBOL Programming', 'Xena Warrior', '2024-05-05', 600.00, 'In-Person', 'Xena Warrior', 'Room 124', '123-456-7813'),
(45, 'FORTRAN Programming', 'Yara Shahidi', '2024-05-10', 650.00, 'Online', 'Yara Shahidi', 'Room 125', '123-456-7814'),
(46, 'Ada Programming', 'Zach Galifianakis', '2024-05-15', 500.00, 'Hybrid', 'Zach Galifianakis', 'Room 126', '123-456-7815'),
(47, 'Crystal Programming', 'Amanda Seyfried', '2024-05-20', 600.00, 'In-Person', 'Amanda Seyfried', 'Room 127', '123-456-7816'),
(48, 'Nim Programming', 'Ben Stiller', '2024-05-25', 700.00, 'Online', 'Ben Stiller', 'Room 128', '123-456-7817'),
(49, 'Hack Programming', 'Cameron Diaz', '2024-06-01', 650.00, 'Hybrid', 'Cameron Diaz', 'Room 129', '123-456-7818'),
(50, 'OCaml Programming', 'Daniel Craig', '2024-06-05', 600.00, 'In-Person', 'Daniel Craig', 'Room 130', '123-456-7819'),
(51, 'Smalltalk Programming', 'Ellen DeGeneres', '2024-06-10', 500.00, 'Online', 'Ellen DeGeneres', 'Room 131', '123-456-7820'),
(52, 'Prolog Programming', 'Felicity Jones', '2024-06-15', 700.00, 'Hybrid', 'Felicity Jones', 'Room 132', '123-456-7821'),
(53, 'ActionScript Programming', 'Gordon Ramsay', '2024-06-20', 550.00, 'In-Person', 'Gordon Ramsay', 'Room 133', '123-456-7822'),
(54, 'Bash Scripting', 'Hugh Jackman', '2024-06-25', 400.00, 'Online', 'Hugh Jackman', 'Room 134', '123-456-7823'),
(55, 'F# Programming', 'Idris Elba', '2024-07-01', 650.00, 'Hybrid', 'Idris Elba', 'Room 135', '123-456-7824'),
(56, 'R Programming', 'Jessica Chastain', '2024-07-05', 600.00, 'In-Person', 'Jessica Chastain', 'Room 136', '123-456-7825'),
(57, 'SAS Programming', 'Keira Knightley', '2024-07-10', 700.00, 'Hybrid', 'Keira Knightley', 'Room 137', '123-456-7826'),
(58, 'VHDL Programming', 'Liam Neeson', '2024-07-15', 500.00, 'In-Person', 'Liam Neeson', 'Room 138', '123-456-7827'),
(59, 'Puppet Programming', 'Mila Kunis', '2024-07-20', 600.00, 'Online', 'Mila Kunis', 'Room 139', '123-456-7828'),
(60, 'Django Programming', 'Natalie Portman', '2024-07-25', 700.00, 'Hybrid', 'Natalie Portman', 'Room 140', '123-456-7829');


INSERT INTO course (course_id, course_name, faculty_name, course_start_date, fee, training_mode, last_updated_by, location, admin_contact_number) VALUES
(61, 'Erlang Programming', 'Alice Johnson', '2024-08-01', 600.00, 'Online', 'Alice Johnson', 'Room 141', '123-456-7830'),
(62, 'Julia Programming', 'Bob Smith', '2024-08-05', 500.00, 'Hybrid', 'Bob Smith', 'Room 142', '123-456-7831'),
(63, 'Bash Scripting', 'Charlie Davis', '2024-08-10', 400.00, 'In-Person', 'Charlie Davis', 'Room 143', '123-456-7832'),
(64, 'Nashorn Programming', 'Diana Evans', '2024-08-15', 550.00, 'Online', 'Diana Evans', 'Room 144', '123-456-7833'),
(65, 'Haxe Programming', 'Edward Green', '2024-08-20', 650.00, 'Hybrid', 'Edward Green', 'Room 145', '123-456-7834'),
(66, 'Xojo Programming', 'Fiona White', '2024-08-25', 600.00, 'In-Person', 'Fiona White', 'Room 146', '123-456-7835'),
(67, 'APL Programming', 'George Black', '2024-09-01', 500.00, 'Online', 'George Black', 'Room 147', '123-456-7836'),
(68, 'Io Programming', 'Hannah Grey', '2024-09-05', 550.00, 'Hybrid', 'Hannah Grey', 'Room 148', '123-456-7837'),
(69, 'D Programming', 'Ian Brown', '2024-09-10', 600.00, 'In-Person', 'Ian Brown', 'Room 149', '123-456-7838'),
(70, 'Chapel Programming', 'Julia Adams', '2024-09-15', 700.00, 'Online', 'Julia Adams', 'Room 150', '123-456-7839'),
(71, 'PL/SQL Programming', 'Kevin Black', '2024-09-20', 650.00, 'Hybrid', 'Kevin Black', 'Room 151', '123-456-7840'),
(72, 'PostScript Programming', 'Laura Hill', '2024-09-25', 500.00, 'In-Person', 'Laura Hill', 'Room 152', '123-456-7841'),
(73, 'ActionScript Programming', 'Michael Young', '2024-10-01', 600.00, 'Online', 'Michael Young', 'Room 153', '123-456-7842'),
(74, 'Bourne Shell Programming', 'Nina Hall', '2024-10-05', 400.00, 'Hybrid', 'Nina Hall', 'Room 154', '123-456-7843'),
(75, 'Nim Programming', 'Oscar King', '2024-10-10', 500.00, 'In-Person', 'Oscar King', 'Room 155', '123-456-7844'),
(76, 'Solidity Programming', 'Penelope Wright', '2024-10-15', 700.00, 'Online', 'Penelope Wright', 'Room 156', '123-456-7845'),
(77, 'Smalltalk Programming', 'Quentin Reed', '2024-10-20', 650.00, 'Hybrid', 'Quentin Reed', 'Room 157', '123-456-7846'),
(78, 'Prolog Programming', 'Rachel Scott', '2024-10-25', 600.00, 'In-Person', 'Rachel Scott', 'Room 158', '123-456-7847'),
(79, 'Squirrel Programming', 'Steve Wright', '2024-11-01', 500.00, 'Online', 'Steve Wright', 'Room 159', '123-456-7848'),
(80, 'VBScript Programming', 'Tina Green', '2024-11-05', 450.00, 'Hybrid', 'Tina Green', 'Room 160', '123-456-7849'),
(81, 'OpenCL Programming', 'Uma Blue', '2024-11-10', 650.00, 'In-Person', 'Uma Blue', 'Room 161', '123-456-7850'),
(82, 'PureScript Programming', 'Victor White', '2024-11-15', 600.00, 'Online', 'Victor White', 'Room 162', '123-456-7851'),
(83, 'Rebol Programming', 'Wendy Black', '2024-11-20', 500.00, 'Hybrid', 'Wendy Black', 'Room 163', '123-456-7852'),
(84, 'XSLT Programming', 'Xander Gray', '2024-11-25', 450.00, 'In-Person', 'Xander Gray', 'Room 164', '123-456-7853'),
(85, 'Vala Programming', 'Yvonne King', '2024-12-01', 600.00, 'Online', 'Yvonne King', 'Room 165', '123-456-7854'),
(86, 'ChucK Programming', 'Zachary Young', '2024-12-05', 500.00, 'Hybrid', 'Zachary Young', 'Room 166', '123-456-7855'),
(87, 'Frege Programming', 'Abigail Scott', '2024-12-10', 650.00, 'In-Person', 'Abigail Scott', 'Room 167', '123-456-7856'),
(88, 'Red Programming', 'Benjamin Hall', '2024-12-15', 700.00, 'Online', 'Benjamin Hall', 'Room 168', '123-456-7857'),
(89, 'Pike Programming', 'Clara Adams', '2024-12-20', 600.00, 'Hybrid', 'Clara Adams', 'Room 169', '123-456-7858'),
(90, 'Zig Programming', 'David Johnson', '2024-12-25', 550.00, 'In-Person', 'David Johnson', 'Room 170', '123-456-7859');

{
  "courseName": "Java Programming",
  "trainingMode": "",
  "facultyName": "",
  "courseStartDate": "",
  "pageNo": "0",
  "pageSize": "5"
}

{
  "courseName": "",
  "trainingMode": "",
  "facultyName": "",
  "courseStartDate": "",
  "pageNo": "0",
  "pageSize": "90"
}


  String base64Image = "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";