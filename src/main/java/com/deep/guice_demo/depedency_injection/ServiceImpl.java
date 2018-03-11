package com.deep.guice_demo.depedency_injection;

/**
 * Created by deepanshu.saxena on 05/06/16.
 */
public class ServiceImpl {
    private MessageService messageService;

    public ServiceImpl(MessageService messageService) {
        this.messageService = messageService;
    }

    public void processMessage() {
        messageService.sendMessage();
    }
}
