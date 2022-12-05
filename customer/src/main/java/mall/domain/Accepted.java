package mall.domain;

import mall.domain.*;
import mall.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Accepted extends AbstractEvent {

    private Long storeid;
    private String orderid;
    private String status;
    private String address;
    private String price;
    private String customerid;
}


