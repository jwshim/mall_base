package mallbase.domain;

import java.util.*;
import lombok.*;
import mallbase.domain.*;
import mallbase.infra.AbstractEvent;

@Data
@ToString
public class OrderCanceled extends AbstractEvent {

    private Long id;
    private String productName;
    private Long customerId;
    private Long productId;
    private Integer qty;

    public OrderCanceled(Order aggregate) {
        super(aggregate);
    }

    public OrderCanceled() {
        super();
    }
}
