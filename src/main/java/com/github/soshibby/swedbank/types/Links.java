package com.github.soshibby.swedbank.types;

/**
 * Created by Henrik on 29/01/2017.
 */
public class Links {

    private NextLink next;
    private EditLink edit;
    private EditLink delete;

    public NextLink getNext() {
        return next;
    }

    public void setNext(NextLink next) {
        this.next = next;
    }

    public EditLink getEdit() {
        return edit;
    }

    public void setEdit(EditLink edit) {
        this.edit = edit;
    }

    public EditLink getDelete() {
        return delete;
    }

    public void setDelete(EditLink delete) {
        this.delete = delete;
    }
}
