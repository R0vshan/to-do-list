package com.example.todolist.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramBot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
    }

    public String getBotUsername() {
        return "CrudToDoBot";
    }

    public String getBotToken() {
        return "7235046360:AAErkaJ7FUVtF6OI86OaR_OhBpSPYDiUsoA";
    }

}
