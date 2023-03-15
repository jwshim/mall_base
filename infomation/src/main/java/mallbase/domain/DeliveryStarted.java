package mallbase.domain;

import java.util.*;
import lombok.Data;
import mallbase.infra.AbstractEvent;

@Data
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private Long order_id;
    private Long product_id;
    private String product_name;
    private Long customer_id;
    private String address;
    private String status;
}
