package mall.infra;

import mall.domain.*;
import mall.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MynotifyViewHandler {


    @Autowired
    private MynotifyRepository mynotifyRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderplaced_then_CREATE_1 (@Payload Orderplaced orderplaced) {
        try {

            if (!orderplaced.validate()) return;

            // view 객체 생성
            Mynotify mynotify = new Mynotify();
            // view 객체에 이벤트의 Value 를 set 함
            mynotify.setOrderid(orderplaced.getOrderid());
            mynotify.setFoodid(orderplaced.getFoodid());
            mynotify.setOrderstatus(orderplaced.getStatus());
            // view 레파지 토리에 save
            mynotifyRepository.save(mynotify);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdercanceled_then_UPDATE_1(@Payload Ordercanceled ordercanceled) {
        try {
            if (!ordercanceled.validate()) return;
                // view 객체 조회
            Optional<Mynotify> mynotifyOptional = mynotifyRepository.findById(ordercanceled.getOrderid());

            if( mynotifyOptional.isPresent()) {
                 Mynotify mynotify = mynotifyOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                mynotify.setOrderstatus("canceled");    
                // view 레파지 토리에 save
                 mynotifyRepository.save(mynotify);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

