package mall.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="Mynotify_table")
@Data
public class Mynotify {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long orderid;
        private String foodid;
        private String deliveryid;
        private String deliverystatus;
        private String orderstatus;


}