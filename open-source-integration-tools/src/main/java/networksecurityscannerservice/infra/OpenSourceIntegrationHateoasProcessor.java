package networksecurityscannerservice.infra;

import networksecurityscannerservice.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class OpenSourceIntegrationHateoasProcessor
    implements
        RepresentationModelProcessor<EntityModel<OpenSourceIntegration>> {

    @Override
    public EntityModel<OpenSourceIntegration> process(
        EntityModel<OpenSourceIntegration> model
    ) {
        return model;
    }
}
