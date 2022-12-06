package mall.domain;

import mall.domain.Paid;
import mall.FrontApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Pay_table")
@Data

public class Pay  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long payid;
    
    
    
    
    
    private String orderid;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String price;
    
    
    
    
    
    private String option;

    @PostPersist
    public void onPostPersist(){
    }
    @PrePersist
    public void onPrePersist(){


        Paid paid = new Paid(this);
        paid.publishAfterCommit();

    }

    public static PayRepository repository(){
        PayRepository payRepository = FrontApplication.applicationContext.getBean(PayRepository.class);
        return payRepository;
    }




    public static void cancelPay(Rejected rejected){

        // Example 1:  new item 
        Pay pay = new Pay();
        pay.setOrderid(rejected.getOrderid());
        repository().save(pay);

        

        /** Example 2:  finding and process
        
        repository().findById(rejected.get???()).ifPresent(pay->{
            
            pay // do something
            repository().save(pay);


         });
        */

        
    }
    public static void cancelPay(Ordercanceled ordercanceled){

        //Example 1:  new item 
        Pay pay = new Pay();
        pay.setOrderid(String.valueOf(ordercanceled.getOrderid()));
        repository().save(pay);

        

        /** Example 2:  finding and process
        
        repository().findById(ordercanceled.get???()).ifPresent(pay->{
            
            pay // do something
            repository().save(pay);


         });
        */

        
    }


}
