package factory.challenge;

public class Main {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        
        service.sendNotification("EMAIL", "Welcome to our platform!");
        service.sendNotification("SMS", "Your code is: 1234");
        service.sendNotification("PUSH", "You have a new message");
    }
}