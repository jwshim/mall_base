package mallbase.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MyPage_table")
@Data
public class MyPage {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long customerId;
    private String productName;
    private Integer qty;
    private Long productId;
    private String status;
    private String address;
    private Long orderId;
}
