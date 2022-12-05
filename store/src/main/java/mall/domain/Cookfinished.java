package mall.domain;

import mall.domain.*;
import mall.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Cookfinished extends AbstractEvent {

    private Long storeid;
    private String orderid;
    private String status;
    private String address;
    private String price;
    private String customerid;

    public Cookfinished(Store aggregate){
        super(aggregate);
    }
    public Cookfinished(){
        super();
    }
}
