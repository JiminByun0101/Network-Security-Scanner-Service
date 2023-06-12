package networksecurityscannerservice.domain;

import networksecurityscannerservice.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "scanRequests",
    path = "scanRequests"
)
public interface ScanRequestRepository
    extends PagingAndSortingRepository<ScanRequest, Integer> {}
