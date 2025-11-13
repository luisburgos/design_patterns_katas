package observer.challenge;

public class WeatherStation {
    private float temperature;
    private PhoneDisplay phoneDisplay;
    private WebDisplay webDisplay;
    private TvDisplay tvDisplay;

    public WeatherStation() {
        this.phoneDisplay = new PhoneDisplay();
        this.webDisplay = new WebDisplay();
        this.tvDisplay = new TvDisplay();
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;

        phoneDisplay.updateTemperature(temperature);
        webDisplay.updateTemperature(temperature);
        tvDisplay.updateTemperature(temperature);
    }
}
