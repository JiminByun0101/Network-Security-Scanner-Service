package networksecurityscannerservice.infra;

import networksecurityscannerservice.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ScanRequestHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ScanRequest>> {

    @Override
    public EntityModel<ScanRequest> process(EntityModel<ScanRequest> model) {
        model.add(
            Link.of(model.getRequiredLink("self").getHref() + "/").withRel("")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/cancelscan")
                .withRel("cancelscan")
        );

        return model;
    }
}
