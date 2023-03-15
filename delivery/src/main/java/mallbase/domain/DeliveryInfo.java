package mallbase.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import mallbase.DeliveryApplication;
import mallbase.domain.DeliveryCanceled;
import mallbase.domain.DeliveryStarted;

@Entity
@Table(name = "DeliveryInfo_table")
@Data
public class DeliveryInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private Long productId;

    private String productName;

    private Long customerId;

    private String address;

    private String status;

    private int qty;

    /* 직접 호출하거나 @PostPersist를 이용하거나 둘중 하나
    @PostPersist
    public void onPostPersist() {
        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();
    }
    */

    /* 
    @PostUpdate
    public void onPostUpdate() {
        DeliveryCanceled deliveryCanceled = new DeliveryCanceled(this);
        deliveryCanceled.publishAfterCommit();
    }
    */

    public static DeliveryInfoRepository repository() {
        DeliveryInfoRepository deliveryInfoRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryInfoRepository.class
        );
        return deliveryInfoRepository;
    }

    //<<< Clean Arch / Port Method
    public static void startDelivery(OrderPlaced orderPlaced) {
        /** Example 1:  new item */
        DeliveryInfo deliveryInfo = new DeliveryInfo();
        deliveryInfo.setOrderId(orderPlaced.getId());
        deliveryInfo.setCustomerId(orderPlaced.getCustomerId());
        deliveryInfo.setProductId(orderPlaced.getProductId());
        deliveryInfo.setProductName(orderPlaced.getProductName());
        deliveryInfo.setQty(orderPlaced.getQty());
        deliveryInfo.setStatus("DS");
        deliveryInfo.setAddress("SomeWhere...");
        repository().save(deliveryInfo);

        DeliveryStarted deliveryStarted = new DeliveryStarted(deliveryInfo);
        deliveryStarted.publishAfterCommit();

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(deliveryInfo->{
            
            deliveryInfo // do something
            repository().save(deliveryInfo);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void cancelDelivery(OrderCanceled orderCanceled) {
        /** Example 1:  new item 
        DeliveryInfo deliveryInfo = new DeliveryInfo();
        repository().save(deliveryInfo);

        */
               
        repository().findByOrderId(orderCanceled.getId()).ifPresent(deliveryInfo->{
            deliveryInfo.setStatus("DC");
            repository().save(deliveryInfo);
            DeliveryCanceled deliveryCanceled = new DeliveryCanceled(deliveryInfo);
            deliveryCanceled.publishAfterCommit();
        });
        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(deliveryInfo->{
            
            deliveryInfo // do something
            repository().save(deliveryInfo);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
