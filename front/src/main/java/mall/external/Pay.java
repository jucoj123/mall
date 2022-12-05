package mall.external;

import lombok.Data;
import java.util.Date;
@Data
public class Pay {

    private Long payid;
    private String orderid;
    private String status;
    private String price;
    private String option;
}


