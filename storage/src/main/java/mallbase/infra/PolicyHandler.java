package mallbase.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import mallbase.config.kafka.KafkaProcessor;
import mallbase.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ItemStorageRepository itemStorageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryStarted'"
    )
    public void wheneverDeliveryStarted_ItemCountIncrese(
        @Payload DeliveryStarted deliveryStarted
    ) {
        DeliveryStarted event = deliveryStarted;
        System.out.println(
            "\n\n##### listener ItemCountIncrese : " + deliveryStarted + "\n\n"
        );

        // Sample Logic //
        ItemStorage.itemCountIncrese(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryCanceled'"
    )
    public void wheneverDeliveryCanceled_ItemCountDecrese(
        @Payload DeliveryCanceled deliveryCanceled
    ) {
        DeliveryCanceled event = deliveryCanceled;
        System.out.println(
            "\n\n##### listener ItemCountDecrese : " + deliveryCanceled + "\n\n"
        );

        // Sample Logic //
        ItemStorage.itemCountDecrese(event);
    }
}
