package mallbase.domain;

import java.util.*;
import lombok.Data;
import mallbase.infra.AbstractEvent;

@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String product_name;
    private Long customer_id;
    private Long product_id;
    private Integer qty;
}
