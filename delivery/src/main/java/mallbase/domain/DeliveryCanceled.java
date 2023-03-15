package mallbase.domain;

import java.util.*;
import lombok.*;
import mallbase.domain.*;
import mallbase.infra.AbstractEvent;

@Data
@ToString
public class DeliveryCanceled extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long productId;
    private String productName;
    private Long customerId;
    private String address;
    private String status;
    private int qty;

    public DeliveryCanceled(DeliveryInfo aggregate) {
        super(aggregate);
    }

    public DeliveryCanceled() {
        super();
    }
}
