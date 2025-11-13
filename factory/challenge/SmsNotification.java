package factory.challenge;

public class SmsNotification {
    private String message;
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public void send() {
        System.out.println("Sending SMS: " + message);
    }
}