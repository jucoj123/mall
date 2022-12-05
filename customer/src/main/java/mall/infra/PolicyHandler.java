package mall.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import mall.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import mall.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired NotificationRepository notificationRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Accepted'")
    public void wheneverAccepted_NotifyKakao(@Payload Accepted accepted){

        Accepted event = accepted;
        System.out.println("\n\n##### listener NotifyKakao : " + accepted + "\n\n");


        

        // Sample Logic //
        Notification.notifyKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Rejected'")
    public void wheneverRejected_NotifyKakao(@Payload Rejected rejected){

        Rejected event = rejected;
        System.out.println("\n\n##### listener NotifyKakao : " + rejected + "\n\n");


        

        // Sample Logic //
        Notification.notifyKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Cookstarted'")
    public void wheneverCookstarted_NotifyKakao(@Payload Cookstarted cookstarted){

        Cookstarted event = cookstarted;
        System.out.println("\n\n##### listener NotifyKakao : " + cookstarted + "\n\n");


        

        // Sample Logic //
        Notification.notifyKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Cookfinished'")
    public void wheneverCookfinished_NotifyKakao(@Payload Cookfinished cookfinished){

        Cookfinished event = cookfinished;
        System.out.println("\n\n##### listener NotifyKakao : " + cookfinished + "\n\n");


        

        // Sample Logic //
        Notification.notifyKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Picked'")
    public void wheneverPicked_NotifyKakao(@Payload Picked picked){

        Picked event = picked;
        System.out.println("\n\n##### listener NotifyKakao : " + picked + "\n\n");


        

        // Sample Logic //
        Notification.notifyKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Deliverystarted'")
    public void wheneverDeliverystarted_NotifyKakao(@Payload Deliverystarted deliverystarted){

        Deliverystarted event = deliverystarted;
        System.out.println("\n\n##### listener NotifyKakao : " + deliverystarted + "\n\n");


        

        // Sample Logic //
        Notification.notifyKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Orderplaced'")
    public void wheneverOrderplaced_NotifyKakao(@Payload Orderplaced orderplaced){

        Orderplaced event = orderplaced;
        System.out.println("\n\n##### listener NotifyKakao : " + orderplaced + "\n\n");


        

        // Sample Logic //
        Notification.notifyKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Ordercanceled'")
    public void wheneverOrdercanceled_NotifyKakao(@Payload Ordercanceled ordercanceled){

        Ordercanceled event = ordercanceled;
        System.out.println("\n\n##### listener NotifyKakao : " + ordercanceled + "\n\n");


        

        // Sample Logic //
        Notification.notifyKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_NotifyKakao(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener NotifyKakao : " + paid + "\n\n");


        

        // Sample Logic //
        Notification.notifyKakao(event);
        

        

    }

}


