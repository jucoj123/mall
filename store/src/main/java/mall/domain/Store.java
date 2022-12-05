package mall.domain;

import mall.domain.Accepted;
import mall.domain.Rejected;
import mall.domain.Cookstarted;
import mall.domain.Cookfinished;
import mall.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Store_table")
@Data

public class Store  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long storeid;
    
    
    
    
    
    private String orderid;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String price;
    
    
    
    
    
    private String customerid;

    @PostPersist
    public void onPostPersist(){


        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();



        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();



        Cookstarted cookstarted = new Cookstarted(this);
        cookstarted.publishAfterCommit();



        Cookfinished cookfinished = new Cookfinished(this);
        cookfinished.publishAfterCommit();

    }

    public static StoreRepository repository(){
        StoreRepository storeRepository = StoreApplication.applicationContext.getBean(StoreRepository.class);
        return storeRepository;
    }




    public static void updateStatus(Paid paid){

        /** Example 1:  new item 
        Store store = new Store();
        repository().save(store);

        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(store->{
            
            store // do something
            repository().save(store);


         });
        */

        
    }
    public static void addToOrderlist(Orderplaced orderplaced){

        /** Example 1:  new item 
        Store store = new Store();
        repository().save(store);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderplaced.get???()).ifPresent(store->{
            
            store // do something
            repository().save(store);


         });
        */

        
    }


}
