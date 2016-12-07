package restful;

import com.fisher.model.Spittle;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * Created by fisbii on 16-12-7.
 */

public class RestfulTest {
    @Test
    public void fetchSpittle(){
        RestTemplate restTemplate = new RestTemplate();
        Spittle spittle = restTemplate.getForObject("http://localhost:8888/spittles/{id}",Spittle.class,1);
        System.out.println(spittle);
    }

    @Test
    public void updateSpittle(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8888/spittles/";
        Spittle spittle = new Spittle(1l,"aa",new Date(),0.123,0.456);
        restTemplate.put(url,spittle);
    }
}
