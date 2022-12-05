package org.example;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Суперкласс для сервисных команд
 */
abstract class ServiceCommand extends BotCommand {

    ServiceCommand(String identifier, String description) {
        super(identifier, description);
    }

    /**
     * Отправка ответа пользователю
     */
    void sendAnswer(AbsSender absSender, Long chatId, String commandName, String userName, String text) {
        SendMessage message = new SendMessage();
        message.enableMarkdown(true);
        message.setChatId(chatId.toString());
        message.setText(text);
        try {
            absSender.execute(message);
        } catch (TelegramApiException e) {
            //логируем сбой Telegram Bot API, используя commandName и userName
        }
    }

    void sendPoll(AbsSender absSender, Long chatId, String commandName, String userName) {
        SendPoll poll = new SendPoll(chatId.toString(), "Точно хочешь увидеть поздравление?", new ArrayList<>(Arrays.asList("Да", "Нет", "Затрудняюсь ответить")));
        poll.setChatId(chatId);
        try {
            absSender.execute(poll);
        } catch (TelegramApiException e) {
            //логируем сбой Telegram Bot API, используя commandName и userName
        }
    }

    void sendAnswerGif(AbsSender absSender, Long chatId, String commandName, String userName, String gifUrl) {
        InputFile gifPath = new InputFile(gifUrl);
        SendAnimation gif = new SendAnimation(chatId.toString(), gifPath);
        gif.setChatId(chatId.toString());
        try {
            absSender.execute(gif);
        } catch (TelegramApiException e) {
            //логируем сбой Telegram Bot API, используя commandName и userName
        }
    }
}