package sink.task;

import java.util.Map;

public class HexGraphFileContent {
    private String imagePath;

    private Map<String, Integer> counts;

    public HexGraphFileContent(String imagePath, Map<String, Integer> counts) {
        this.imagePath = imagePath;
        this.counts = counts;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Map<String, Integer> getCounts() {
        return counts;
    }

    @Override
    public String toString() {
        return "HexGraphFileContent{" +
                "imagePath='" + imagePath + '\'' +
                ", counts=" + counts +
                '}';
    }
}
