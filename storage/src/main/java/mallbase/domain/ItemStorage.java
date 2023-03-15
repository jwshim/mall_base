package mallbase.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import mallbase.StorageApplication;

@Entity
@Table(name = "ItemStorage_table")
@Data
public class ItemStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long productId;

    private String productName;

    private Integer stock;

    public static ItemStorageRepository repository() {
        ItemStorageRepository itemStorageRepository = StorageApplication.applicationContext.getBean(
            ItemStorageRepository.class
        );
        return itemStorageRepository;
    }

    //<<< Clean Arch / Port Method
    public static void itemCountIncrese(DeliveryStarted deliveryStarted) {
        /** Example 1:  new item 
        ItemStorage itemStorage = new ItemStorage();
        repository().save(itemStorage);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(itemStorage->{
            
            itemStorage // do something
            repository().save(itemStorage);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void itemCountDecrese(DeliveryCanceled deliveryCanceled) {
        /** Example 1:  new item 
        ItemStorage itemStorage = new ItemStorage();
        repository().save(itemStorage);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCanceled.get???()).ifPresent(itemStorage->{
            
            itemStorage // do something
            repository().save(itemStorage);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
