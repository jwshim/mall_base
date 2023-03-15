package mallbase.domain;

import java.util.*;
import lombok.*;
import mallbase.domain.*;
import mallbase.infra.AbstractEvent;

@Data
@ToString
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long productId;
    private String productName;
    private Long customerId;
    private String address;
    private String status;

    public DeliveryStarted(DeliveryInfo aggregate) {
        super(aggregate);
    }

    public DeliveryStarted() {
        super();
    }
}