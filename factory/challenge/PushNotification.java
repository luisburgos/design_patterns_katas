package factory.challenge;

public class PushNotification {
    private String message;
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public void send() {
        System.out.println("Sending push notification: " + message);
    }
}
