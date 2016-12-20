package guice_demo.depedency_injection;

/**
 * Created by deepanshu.saxena on 05/06/16.
 */
public class MessageClient {
    public static void main(String[] args) {
        MessageService messageService = new SMSServiceImpl();
        ServiceImpl service = new ServiceImpl(messageService);
        service.processMessage();
    }
}
