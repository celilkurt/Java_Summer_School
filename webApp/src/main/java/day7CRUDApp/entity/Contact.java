package day7CRUDApp.entity;

public class Contact {


    private String name;
    private String telNum;

    public Contact() {
    }

    public Contact(String name, String telNum) {
        this.name = name;
        this.telNum = telNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", telNum='" + telNum + '\'' +
                '}';
    }
}
