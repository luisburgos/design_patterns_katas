package factory.challenge;

public class NotificationService {
    public void sendNotification(String type, String message) {
        if (type.equals("EMAIL")) {
            EmailNotification email = new EmailNotification();
            email.setMessage(message);
            email.send();
        } else if (type.equals("SMS")) {
            SmsNotification sms = new SmsNotification();
            sms.setMessage(message);
            sms.send();
        } else if (type.equals("PUSH")) {
            PushNotification push = new PushNotification();
            push.setMessage(message);
            push.send();
        }
    }
}