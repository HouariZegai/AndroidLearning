CREATE DATABASE asyctask_android_db;

USE asyctask_android_db;

CREATE TABLE post (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50),
	comment TEXT
);