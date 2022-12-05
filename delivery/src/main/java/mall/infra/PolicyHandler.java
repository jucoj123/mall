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
    @Autowired DeliveryRepository deliveryRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Cookfinished'")
    public void wheneverCookfinished_UpdateStatus(@Payload Cookfinished cookfinished){

        Cookfinished event = cookfinished;
        System.out.println("\n\n##### listener UpdateStatus : " + cookfinished + "\n\n");


        

        // Sample Logic //
        Delivery.updateStatus(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Orderplaced'")
    public void wheneverOrderplaced_AddToOrderlist(@Payload Orderplaced orderplaced){

        Orderplaced event = orderplaced;
        System.out.println("\n\n##### listener AddToOrderlist : " + orderplaced + "\n\n");


        

        // Sample Logic //
        Delivery.addToOrderlist(event);
        

        

    }

}


