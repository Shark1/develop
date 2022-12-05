package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import static org.example.Bot.getUserName;

public class HappyBirthDay extends ServiceCommand {
    private Logger logger = LoggerFactory.getLogger(HappyBirthDay.class);
    public HappyBirthDay(String identifier, String description) { super(identifier, description);}

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String userName = getUserName(user);
        logger.debug(String.format("Пользователь %s. Начато выполнение команды %s", userName,
                this.getCommandIdentifier()));
        sendAnswerGif(absSender, chat.getId(), this.getCommandIdentifier(), userName, "https://i.giphy.com/media/r4VXLxbFvOlouZ3jrE/giphy.gif");
        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userName,
                "\uD83E\uDD21ПАЗДРАВЛЯЯЮ ПАААЗДРАВЛЯЮ\uD83E\uDD21\n" +
                        "Желаю достигнуть высоких высот\n" +
                        "Бабла, бабла, бабла©️\n" +
                        "Подопечных не дурачков (это не обещаю)\n" +
                        "Зубы без брекетов‼️\n" +
                        "Отсутствие растениевых потопов\n" +
                        "И чтоб всё было хорошо✨✨");
        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userName,"🎉");
        logger.debug(String.format("Пользователь %s. Завершено выполнение команды %s", userName,
                this.getCommandIdentifier()));
    }
}
