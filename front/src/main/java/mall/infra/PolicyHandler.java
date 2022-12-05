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
    @Autowired OrderRepository orderRepository;
    @Autowired PayRepository payRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Cookstarted'")
    public void wheneverCookstarted_Cancel(@Payload Cookstarted cookstarted){

        Cookstarted event = cookstarted;
        System.out.println("\n\n##### listener Cancel : " + cookstarted + "\n\n");


        

        // Sample Logic //
        Order.cancel(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Rejected'")
    public void wheneverRejected_UpdateStatus(@Payload Rejected rejected){

        Rejected event = rejected;
        System.out.println("\n\n##### listener UpdateStatus : " + rejected + "\n\n");


        

        // Sample Logic //
        Order.updateStatus(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Rejected'")
    public void wheneverRejected_CancelPay(@Payload Rejected rejected){

        Rejected event = rejected;
        System.out.println("\n\n##### listener CancelPay : " + rejected + "\n\n");


        

        // Sample Logic //
        Pay.cancelPay(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Ordercanceled'")
    public void wheneverOrdercanceled_CancelPay(@Payload Ordercanceled ordercanceled){

        Ordercanceled event = ordercanceled;
        System.out.println("\n\n##### listener CancelPay : " + ordercanceled + "\n\n");


        

        // Sample Logic //
        Pay.cancelPay(event);
        

        

    }

}


