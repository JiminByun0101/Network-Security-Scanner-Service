package networksecurityscannerservice.domain;

import java.util.*;
import lombok.*;
import networksecurityscannerservice.domain.*;
import networksecurityscannerservice.infra.AbstractEvent;

@Data
@ToString
public class ScanCancelled extends AbstractEvent {

    private Integer id;
    private String errorMessage;

    public ScanCancelled(ScanRequest aggregate) {
        super(aggregate);
    }

    public ScanCancelled() {
        super();
    }
}
