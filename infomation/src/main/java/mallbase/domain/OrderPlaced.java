package mallbase.domain;

import java.util.*;
import lombok.Data;
import mallbase.infra.AbstractEvent;

@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String productName;
    private Long customerId;
    private Long productId;
    private Integer qty;
}
