package networksecurityscannerservice.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import networksecurityscannerservice.config.kafka.KafkaProcessor;
import networksecurityscannerservice.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OpenSourceIntegrationRepository openSourceIntegrationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ScanInitiated'"
    )
    public void wheneverScanInitiated_ExecuteScan(
        @Payload ScanInitiated scanInitiated
    ) {
        ScanInitiated event = scanInitiated;
        System.out.println(
            "\n\n##### listener ExecuteScan : " + scanInitiated + "\n\n"
        );

        // Sample Logic //
        OpenSourceIntegration.executeScan(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ScanCancelled'"
    )
    public void wheneverScanCancelled_CancelScan(
        @Payload ScanCancelled scanCancelled
    ) {
        ScanCancelled event = scanCancelled;
        System.out.println(
            "\n\n##### listener CancelScan : " + scanCancelled + "\n\n"
        );

        // Sample Logic //
        OpenSourceIntegration.cancelScan(event);
    }
}
