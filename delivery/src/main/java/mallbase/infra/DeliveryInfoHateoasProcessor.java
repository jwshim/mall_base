package mallbase.infra;

import mallbase.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DeliveryInfoHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<DeliveryInfo>> {

    @Override
    public EntityModel<DeliveryInfo> process(EntityModel<DeliveryInfo> model) {
        return model;
    }
}
