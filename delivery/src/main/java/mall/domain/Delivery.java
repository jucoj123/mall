package mall.domain;

import mall.domain.Picked;
import mall.domain.Deliverystarted;
import mall.DeliveryApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Delivery_table")
@Data

public class Delivery  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long deliveryid;
    
    
    
    
    
    private String storeid;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String orderid;
    
    
    
    
    
    private String customerid;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        Picked picked = new Picked(this);
        picked.publishAfterCommit();



        Deliverystarted deliverystarted = new Deliverystarted(this);
        deliverystarted.publishAfterCommit();

    }

    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(DeliveryRepository.class);
        return deliveryRepository;
    }




    public static void updateStatus(Cookfinished cookfinished){

        // Example 1:  new item 
        Delivery delivery = new Delivery();
        delivery.setOrderid(cookfinished.getOrderid());
        repository().save(delivery);

        

        /** Example 2:  finding and process
        
        repository().findById(cookfinished.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        
    }
    public static void addToOrderlist(Orderplaced orderplaced){

        // Example 1:  new item 
        Delivery delivery = new Delivery();
        delivery.setOrderid(String.valueOf(orderplaced.getOrderid()));
        repository().save(delivery);

        

        /** Example 2:  finding and process
        
        repository().findById(orderplaced.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        
    }


}
