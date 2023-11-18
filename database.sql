create database ROBOTGEARdb;
use  ROBOTGEARdb;
CREATE TABLE Categories (
    category_id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT
);
CREATE TABLE Robots (
    robot_id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category_id INT,
    size VARCHAR(50),
    weight DECIMAL(10,2),
    speed DECIMAL(5,2),
    capacity DECIMAL(10,2),
    description TEXT,
    FOREIGN KEY (category_id) REFERENCES Categories(category_id)
);
CREATE TABLE Components (
    component_id INT PRIMARY KEY,
    robot_id INT,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    FOREIGN KEY (robot_id) REFERENCES Robots(robot_id)
);
CREATE TABLE SpecificationTechnique (
    spec_id INT PRIMARY KEY,
    robot_id INT,
    spec_name VARCHAR(255) NOT NULL,
    spec_value VARCHAR(255) NOT NULL,
    FOREIGN KEY (robot_id) REFERENCES Robots(robot_id)
);