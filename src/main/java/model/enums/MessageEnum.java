package model.enums;

public enum MessageEnum {
    PRIVATE_CHAT("pv"),
    PUBLIC_CHAT("pb"),
    ROOM("rm");
    String type;
    MessageEnum(String type){
        this.type = type;
    }
}
