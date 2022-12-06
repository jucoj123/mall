package mall.domain;

import mall.CustomerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Notification_table")
@Data

public class Notification  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String customerid;
    
    
    
    
    
    private String message;


    public static NotificationRepository repository(){
        NotificationRepository notificationRepository = CustomerApplication.applicationContext.getBean(NotificationRepository.class);
        return notificationRepository;
    }




    public static void notifyKakao(Accepted accepted){

        // Example 1:  new item 
        Notification notification = new Notification();
        notification.setCustomerid(accepted.getCustomerid());
        repository().save(notification);

        

        /** Example 2:  finding and process
        
        repository().findById(accepted.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }
    public static void notifyKakao(Rejected rejected){

        // Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        

        /** Example 2:  finding and process
        
        repository().findById(rejected.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }
    public static void notifyKakao(Cookstarted cookstarted){

        // Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        

        /** Example 2:  finding and process
        
        repository().findById(cookstarted.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }
    public static void notifyKakao(Cookfinished cookfinished){

        // Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        

        /** Example 2:  finding and process
        
        repository().findById(cookfinished.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }
    public static void notifyKakao(Picked picked){

        // Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        

        /** Example 2:  finding and process
        
        repository().findById(picked.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }
    public static void notifyKakao(Deliverystarted deliverystarted){

        // Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        

        /** Example 2:  finding and process
        
        repository().findById(deliverystarted.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }
    public static void notifyKakao(Orderplaced orderplaced){

        // Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

    

        /** Example 2:  finding and process
        
        repository().findById(orderplaced.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }
    public static void notifyKakao(Ordercanceled ordercanceled){

        // Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        

        /** Example 2:  finding and process
        
        repository().findById(ordercanceled.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }
    public static void notifyKakao(Paid paid){

        // Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }


}
