package adapter.challenge;

public class DataProcessor {
    public void processData(String format, String data) {
        if (format.equals("XML")) {
            XmlParser xmlParser = new XmlParser();
            xmlParser.parseXmlData(data);
        } else if (format.equals("JSON")) {
            JsonParser jsonParser = new JsonParser();
            jsonParser.readJsonString(data);
        } else if (format.equals("YAML")) {
            YamlParser yamlParser = new YamlParser();
            yamlParser.loadYamlContent(data);
        }
    }
}
