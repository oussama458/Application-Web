create database ROBOTGEARdb;
use  ROBOTGEARdb;
CREATE TABLE Categories (
    category_id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT
);
create TABLE Robots (
    robot_id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category_id INT,
    width decimal(4,2),
    height decimal(4,2),
    length decimal(4,2),
    weight DECIMAL(10,2),
    speed DECIMAL(5,2),
    description TEXT,
    FOREIGN KEY (category_id) REFERENCES Categories(category_id)
);
create TABLE Components (
    component_id INT PRIMARY KEY,
    robot_id INT,
    core text,
    software text,
    power text ,
    sensors text,
    actuators text ,
    FOREIGN KEY (robot_id) REFERENCES Robots(robot_id)
);
