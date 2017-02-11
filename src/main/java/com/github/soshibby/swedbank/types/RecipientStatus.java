package com.github.soshibby.swedbank.types;

/**
 * Created by Henrik on 29/01/2017.
 */
public class RecipientStatus {

    private boolean allowed;
    private Message notAllowedMessage;

    public boolean isAllowed() {
        return allowed;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }

    public Message getNotAllowedMessage() {
        return notAllowedMessage;
    }

    public void setNotAllowedMessage(Message notAllowedMessage) {
        this.notAllowedMessage = notAllowedMessage;
    }
}
