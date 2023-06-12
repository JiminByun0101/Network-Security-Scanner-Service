package networksecurityscannerservice.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import networksecurityscannerservice.OpenSourceIntegrationToolsApplication;
import networksecurityscannerservice.domain.ScanCancelled;
import networksecurityscannerservice.domain.ScanExecuted;

@Entity
@Table(name = "OpenSourceIntegration_table")
@Data
public class OpenSourceIntegration {

    private String toolName;

    private String description;

    private String version;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String result;

    private String ipAddress;

    private String hostname;

    @PostPersist
    public void onPostPersist() {
        ScanExecuted scanExecuted = new ScanExecuted(this);
        scanExecuted.publishAfterCommit();

        ScanCancelled scanCancelled = new ScanCancelled(this);
        scanCancelled.publishAfterCommit();
    }

    public static OpenSourceIntegrationRepository repository() {
        OpenSourceIntegrationRepository openSourceIntegrationRepository = OpenSourceIntegrationToolsApplication.applicationContext.getBean(
            OpenSourceIntegrationRepository.class
        );
        return openSourceIntegrationRepository;
    }

    public static void executeScan(ScanInitiated scanInitiated) {
        //implement business logic here:

        /** Example 1:  new item 
        OpenSourceIntegration openSourceIntegration = new OpenSourceIntegration();
        repository().save(openSourceIntegration);

        ScanExecuted scanExecuted = new ScanExecuted(openSourceIntegration);
        scanExecuted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(scanInitiated.get???()).ifPresent(openSourceIntegration->{
            
            openSourceIntegration // do something
            repository().save(openSourceIntegration);

            ScanExecuted scanExecuted = new ScanExecuted(openSourceIntegration);
            scanExecuted.publishAfterCommit();

         });
        */

    }

    public static void cancelScan(ScanCancelled scanCancelled) {
        //implement business logic here:

        /** Example 1:  new item 
        OpenSourceIntegration openSourceIntegration = new OpenSourceIntegration();
        repository().save(openSourceIntegration);

        ScanCancelled scanCancelled = new ScanCancelled(openSourceIntegration);
        scanCancelled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(scanCancelled.get???()).ifPresent(openSourceIntegration->{
            
            openSourceIntegration // do something
            repository().save(openSourceIntegration);

            ScanCancelled scanCancelled = new ScanCancelled(openSourceIntegration);
            scanCancelled.publishAfterCommit();

         });
        */

    }
}
