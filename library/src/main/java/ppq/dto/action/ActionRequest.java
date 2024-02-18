package ppq.dto.action;

import lombok.Data;
import ppq.dto.template.TemplateRequest;

/**
 * @author phongpq
 */
@Data
public class ActionRequest {
    private String type;
    private String category;
    private TemplateRequest templateRequest;
}
