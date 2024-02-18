package ppq.dto.template;

import lombok.Data;
import ppq.enummeration.TemplateType;

/**
 * @author phongpq
 */
@Data
public class TemplateRequest {
    private String id;
    private TemplateType type;
    private String ver;
    private String data;
}
