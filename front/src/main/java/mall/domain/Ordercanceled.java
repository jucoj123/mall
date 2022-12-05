package mall.domain;

import mall.domain.*;
import mall.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Ordercanceled extends AbstractEvent {

    private Long orderid;
    private String foodid;
    private String customerid;
    private String storeid;
    private String address;
    private String status;
    private String price;

    public Ordercanceled(Order aggregate){
        super(aggregate);
    }
    public Ordercanceled(){
        super();
    }
}
