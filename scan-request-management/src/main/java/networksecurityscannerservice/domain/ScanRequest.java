package networksecurityscannerservice.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import networksecurityscannerservice.ScanRequestManagementApplication;

@Entity
@Table(name = "ScanRequest_table")
@Data
public class ScanRequest {

    private String ipAddress;

    private String status;

    private String hostname;

    private String toolName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String result;

    private String version;

    private String description;

    @PostPersist
    public void onPostPersist() {}

    @PrePersist
    public void onPrePersist() {}

    public static ScanRequestRepository repository() {
        ScanRequestRepository scanRequestRepository = ScanRequestManagementApplication.applicationContext.getBean(
            ScanRequestRepository.class
        );
        return scanRequestRepository;
    }

    public void initiateScan(InitiateScanCommand initiateScanCommand) {
        //implement business logic here:

        ScanInitiated scanInitiated = new ScanInitiated(this);
        scanInitiated.publishAfterCommit();
    }

    public void cancelScan(CancelScanCommand cancelScanCommand) {
        //implement business logic here:

        ScanCancelled scanCancelled = new ScanCancelled(this);
        scanCancelled.publishAfterCommit();
    }
}
