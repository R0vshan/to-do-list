package com.example.todolist;

import com.example.todolist.telegram.TelegramBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.sql.Connection;
import java.util.Scanner;

@SpringBootApplication
public class ToDoListApplication {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);

		ConnectionUtil db = new ConnectionUtil();
		Connection conn = db.connect_to_db("postgres", "postgres", "mysecretpassword");


		try {
			TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
			botsApi.registerBot(new TelegramBot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}



	}

}
