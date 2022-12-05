package mall.domain;

import mall.domain.*;
import mall.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Orderplaced extends AbstractEvent {

    private Long orderid;
    private String foodid;
    private String customerid;
    private String storeid;
    private String address;
    private String status;
    private String price;
}


