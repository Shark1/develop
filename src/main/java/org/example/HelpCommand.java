package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import static org.example.Bot.getUserName;
public class HelpCommand extends ServiceCommand {
    private Logger logger = LoggerFactory.getLogger(HelpCommand.class);
    public HelpCommand(String identifier, String description) {
        super(identifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String userName = getUserName(user);
        logger.debug(String.format("Пользователь %s. Начато выполнение команды %s", userName,
                this.getCommandIdentifier()));

        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userName,
                "Я решил поздравить тебя так, чтобы не получить в ответ \"как же оригинально\"\uD83D\uDE04\n\n" +
                        "Используй команды:\n\n" +
                        "❗*Список команд*\n" +
                        "/help - помогите, я забыла, что тут делать\n" +
                        "/gift - эту команду точно нужно использовать\n" +
                        "/hb - можно использовать эту команду, она несильно обязательна\n\n" +
                        "Не стоит ломать этого бота. Разработчик уже будет рад его запуску.\n" +
                        "Поздравляю!!!\uD83D\uDCE3\uD83E\uDD73");
        logger.debug(String.format("Пользователь %s. Завершено выполнение команды %s", userName,
                this.getCommandIdentifier()));
    }
}