package networksecurityscannerservice.domain;

import java.util.*;
import lombok.*;
import networksecurityscannerservice.domain.*;
import networksecurityscannerservice.infra.AbstractEvent;

@Data
@ToString
public class ScanInitiated extends AbstractEvent {

    private Integer id;
    private String ipAddress;
    private String status;
    private String hostname;
    private String toolName;

    public ScanInitiated(ScanRequest aggregate) {
        super(aggregate);
    }

    public ScanInitiated() {
        super();
    }
}
