package guice_demo.depedency_injection;

/**
 * Created by deepanshu.saxena on 05/06/16.
 */
public class SMSServiceImpl implements MessageService {
    @Override
    public void sendMessage() {
        System.out.println("Sending SMS Message.... ");

    }
}
