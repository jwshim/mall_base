package mallbase.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import mallbase.config.kafka.KafkaProcessor;
import mallbase.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MyPageViewHandler {

    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            MyPage myPage = new MyPage();
            // view 객체에 이벤트의 Value 를 set 함
            myPage.setCustomerId(orderPlaced.getCustomerId());
            myPage.setProductName(orderPlaced.getProductName());
            myPage.setOrderId(orderPlaced.getId());
            myPage.setProductId(orderPlaced.getProductId());
            myPage.setStatus(OD);
            myPage.setQty(orderPlaced.getQty());
            // view 레파지 토리에 save
            myPageRepository.save(myPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_1(
        @Payload DeliveryStarted deliveryStarted
    ) {
        try {
            if (!deliveryStarted.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByOrderId(
                deliveryStarted.getOrderId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setStatus(DS);
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCanceled_then_UPDATE_2(
        @Payload DeliveryCanceled deliveryCanceled
    ) {
        try {
            if (!deliveryCanceled.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByOrderId(
                deliveryCanceled.getOrderId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setStatus(DC);
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_3(
        @Payload DeliveryStarted deliveryStarted
    ) {
        try {
            if (!deliveryStarted.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByOrderId(
                deliveryStarted.getOrderId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setAddress(deliveryStarted.getAddress());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
