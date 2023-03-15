package mallbase.infra;

import mallbase.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ItemStorageHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ItemStorage>> {

    @Override
    public EntityModel<ItemStorage> process(EntityModel<ItemStorage> model) {
        return model;
    }
}
