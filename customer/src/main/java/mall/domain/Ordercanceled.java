package mall.domain;

import mall.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class Ordercanceled extends AbstractEvent {

    private Long orderid;
    private String foodid;
    private String customerid;
    private String storeid;
    private String address;
    private String status;
    private String price;
}
