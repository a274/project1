package test.itschool.samsung.ru.eco_lavka.chat;

import java.util.Date;

public class Message1 {
    public String userName;
    public String textMessage;
    private long messageTime;

    public Message1() { }

    public Message1(String userName, String textMessage) {
        this.userName = userName;
        this.textMessage = textMessage;
        this.messageTime = new Date().getTime();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }


}
