package ppq.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;
import java.util.Map;

/**
 * @author phongpq
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(value = "notification_template")
public class NotificationTemplate {
    @PrimaryKey
    private String templateId;
    private String type;
    private String ver;
    private String data;
    private String template_schema;
    private Map<String, String> config;
    private String createdBy;
    private Timestamp createdOn;
    private String lastUpdatedBy;
    private Timestamp lastUpdatedOn;
}
