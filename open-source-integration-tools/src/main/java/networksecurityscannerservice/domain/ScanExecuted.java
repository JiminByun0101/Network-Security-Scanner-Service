package networksecurityscannerservice.domain;

import java.util.*;
import lombok.*;
import networksecurityscannerservice.domain.*;
import networksecurityscannerservice.infra.AbstractEvent;

@Data
@ToString
public class ScanExecuted extends AbstractEvent {

    private String toolName;
    private Integer id;
    private String description;
    private String version;
    private String result;
    private String ipAddress;
    private String hostname;
    private String scanRequestId;

    public ScanExecuted(OpenSourceIntegration aggregate) {
        super(aggregate);
    }

    public ScanExecuted() {
        super();
    }
}
