package mallbase.domain;

import mallbase.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "itemStorages",
    path = "itemStorages"
)
public interface ItemStorageRepository
    extends PagingAndSortingRepository<ItemStorage, Long> {}
