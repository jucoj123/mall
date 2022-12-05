package mall.domain;

import mall.domain.*;
import mall.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Picked extends AbstractEvent {

    private Long deliveryid;
    private String storeid;
    private String address;
    private String orderid;
    private String customerid;
    private String status;
}


