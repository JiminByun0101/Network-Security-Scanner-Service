package networksecurityscannerservice.domain;

import networksecurityscannerservice.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "openSourceIntegrations",
    path = "openSourceIntegrations"
)
public interface OpenSourceIntegrationRepository
    extends PagingAndSortingRepository<OpenSourceIntegration, Integer> {}
