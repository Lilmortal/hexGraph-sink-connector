package sink.task;

import java.time.LocalDateTime;
import java.util.Map;

public class HexGraphResult {
    private String imagePath;

    private String creationDate;

    private Map<String, Integer> counts;

    public String getImagePath() {
        return imagePath;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public Map<String, Integer> getCounts() {
        return counts;
    }

    @Override
    public String toString() {
        return "HexGraphResult{" +
                "imagePath='" + imagePath + '\'' +
                ", creationDate=" + creationDate +
                ", counts=" + counts +
                '}';
    }
}
