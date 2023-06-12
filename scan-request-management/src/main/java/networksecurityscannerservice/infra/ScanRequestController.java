package networksecurityscannerservice.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import networksecurityscannerservice.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/scanRequests")
@Transactional
public class ScanRequestController {

    @Autowired
    ScanRequestRepository scanRequestRepository;
    InitiateScanCommand initiateScanCommand;
    CancelScanCommand cancelScanCommand;

    @RequestMapping(
        value = "scanRequests/",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public ScanRequest initiateScan(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ScanRequest scanRequest
    ) throws Exception {
        System.out.println("##### /scanRequest/initiateScan  called #####");
        scanRequest.initiateScan(initiateScanCommand);
        scanRequestRepository.save(scanRequest);
        return scanRequest;
    }

    @RequestMapping(
        value = "scanRequests/{id}/cancelscan",
        method = RequestMethod.DELETE,
        produces = "application/json;charset=UTF-8"
    )
    public ScanRequest cancelScan(
        @PathVariable(value = "id") Integer id,
        @RequestBody CancelScanCommand cancelScanCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /scanRequest/cancelScan  called #####");
        Optional<ScanRequest> optionalScanRequest = scanRequestRepository.findById(
            id
        );

        optionalScanRequest.orElseThrow(() -> new Exception("No Entity Found"));
        ScanRequest scanRequest = optionalScanRequest.get();
        scanRequest.cancelScan(cancelScanCommand);

        scanRequestRepository.save(scanRequest);
        return scanRequest;
    }
}
