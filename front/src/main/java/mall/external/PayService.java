package mall.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name = "front", url = "${api.url.front}")
public interface PayService {
    @RequestMapping(method= RequestMethod.GET, path="/pays/{payid}")
    public Pay getPay(@PathVariable("payid") Long payid);

    public void pay(Pay pay);
}

