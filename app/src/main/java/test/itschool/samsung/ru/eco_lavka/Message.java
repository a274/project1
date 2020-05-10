package test.itschool.samsung.ru.eco_lavka;

public class Message {
    private String text; // message 
    private MemberData memberData; // data of the user that sent this message


    public Message(String text, MemberData memberData, boolean belongsToCurrentUser) {
        this.text = text;
        this.memberData = memberData;

    }

    public String getText() {
        return text;
    }

    public MemberData getMemberData() {
        return memberData;
    }

}

