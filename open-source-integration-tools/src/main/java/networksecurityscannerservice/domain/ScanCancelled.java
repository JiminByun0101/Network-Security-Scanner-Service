package networksecurityscannerservice.domain;

import java.util.*;
import lombok.*;
import networksecurityscannerservice.domain.*;
import networksecurityscannerservice.infra.AbstractEvent;

@Data
@ToString
public class ScanCancelled extends AbstractEvent {

    private Integer id;
    private Integer scanRequestId;

    public ScanCancelled(OpenSourceIntegration aggregate) {
        super(aggregate);
    }

    public ScanCancelled() {
        super();
    }
}
