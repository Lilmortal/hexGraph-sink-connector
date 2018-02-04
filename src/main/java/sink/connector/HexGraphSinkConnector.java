package sink.connector;

import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.utils.AppInfoParser;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.errors.ConnectException;
import org.apache.kafka.connect.sink.SinkConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sink.task.HexGraphSinkTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static sink.config.HexGraphSinkConnectorConfig.DIRECTORY_SINK;

public class HexGraphSinkConnector extends SinkConnector {
    public static Logger LOGGER = LoggerFactory.getLogger(HexGraphSinkConnector.class);

    private String directorySink;

    @Override
    public String version() {
        return AppInfoParser.getVersion();
    }

    @Override
    public void start(Map<String, String> props) {
        LOGGER.info("Hex graph sink connector is starting.");

        directorySink = props.get(DIRECTORY_SINK);

        if (StringUtils.isBlank(directorySink)) {
            throw new ConnectException("Directory sink must not be empty.");
        }
    }

    @Override
    public Class<? extends Task> taskClass() {
        return HexGraphSinkTask.class;
    }

    @Override
    public List<Map<String, String>> taskConfigs(int maxTasks) {
        List<Map<String, String>> configs = new ArrayList<>();

        Map<String, String> config = new HashMap<>();
        config.put(DIRECTORY_SINK, directorySink);

        configs.add(config);
        return configs;
    }

    @Override
    public void stop() {
        LOGGER.info("Hex graph sink connector is stopping.");
    }

    @Override
    public ConfigDef config() {
        return new ConfigDef()
                .define(DIRECTORY_SINK, ConfigDef.Type.STRING, ConfigDef.Importance.HIGH, "Directory sink");
    }
}
