package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import static org.example.Bot.getUserName;

public class GiftCommand extends ServiceCommand {
    private Logger logger = LoggerFactory.getLogger(GiftCommand.class);
    public GiftCommand(String identifier, String description) { super(identifier, description);}

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String userName = getUserName(user);
        logger.debug(String.format("Пользователь %s. Начато выполнение команды %s", userName,
                this.getCommandIdentifier()));
        sendAnswerGif(absSender, chat.getId(), this.getCommandIdentifier(), userName, "https://i.giphy.com/media/8DPc1FyGsWg9APUnDX/giphy.gif");
        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userName,
                "Ты получаешь неделю бесплатного кофе!☕️☕️☕️\n\n" +
                        "Чтобы воспользоваться подарком, тебе нужно позвать пить кофе одного дурачка,\n" +
                        "который придумал написать этого бота\n" +
                        "Так как речь о неделе, можно пользоваться подарком хоть 3 раза в день \n" +
                        "(если здоровья хватит, можно и десять)");
        logger.debug(String.format("Пользователь %s. Завершено выполнение команды %s", userName,
                this.getCommandIdentifier()));
    }
}
