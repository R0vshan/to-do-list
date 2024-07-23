package com.example.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.util.Scanner;
import java.sql.Connection;

@SpringBootApplication
public class ToDoListApplication {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);

		ConnectionUtil db = new ConnectionUtil();

		Connection conn = db.connect_to_db("postgres", "postgres", "mysecretpassword");

	}

}
