package mall.domain;

import mall.domain.*;
import mall.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Paid extends AbstractEvent {

    private Long payid;
    private String orderid;
    private String status;
    private String price;
    private String option;

    public Paid(Pay aggregate){
        super(aggregate);
    }
    public Paid(){
        super();
    }
}
