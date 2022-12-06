package mall.domain;

import mall.domain.Ordercanceled;
import mall.domain.Orderplaced;
import mall.FrontApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long orderid;
    
    
    
    
    
    private String foodid;
    
    
    
    
    
    private String customerid;
    
    
    
    
    
    private String storeid;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String price;

    @PostPersist
    public void onPostPersist(){


        Orderplaced orderplaced = new Orderplaced(this);
        orderplaced.publishAfterCommit();

        Ordercanceled ordercanceled = new Ordercanceled(this);
        ordercanceled.publishAfterCommit();

        mall.external.Pay pay = new mall.external.Pay();
        // mappings goes here
        FrontApplication.applicationContext.getBean(mall.external.PayService.class)
            .pay(pay);


        // Get request from Pay
        //mall.external.Pay pay =
        //    Application.applicationContext.getBean(mall.external.PayService.class)
        //    .getPay(/** mapping value needed */);

    }
    @PrePersist
    public void onPrePersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }




    public static void cancel(Cookstarted cookstarted){

        // Example 1:  new item 
        Order order = new Order();
        order.setOrderid(Long.getLong(cookstarted.getOrderid()));
        repository().save(order);

        

        /** Example 2:  finding and process
        
        repository().findById(cookstarted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void updateStatus(Rejected rejected){

        // Example 1:  new item 
        Order order = new Order();
        order.setOrderid(Long.getLong(rejected.getOrderid()));
        repository().save(order);

        

        /** Example 2:  finding and process
        
        repository().findById(rejected.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }


}
