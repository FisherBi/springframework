package jpa;

import com.fisher.config.database.JpaConfig;
import com.fisher.model.Spittle;
import com.fisher.repository.spittle.SpittleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by fisbii on 16-12-9.
 */
@ContextConfiguration(classes= JpaConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SpittleRepositoryTest {
    @Autowired
    SpittleRepository spittleRepository;

    @Test
    public void saveSpittle(){
        for(int i = 0; i < 8; i++){
            Spittle spittle = createSpittle();
            spittleRepository.save(spittle);
        }

    }

    @Test
    public void getSpittle(){
        List<Spittle> spittleList = spittleRepository.findSpittles(50,0,5);
        spittleList.stream().forEach(System.out::println);
    }

    private Spittle createSpittle(){
        Spittle spittle = new Spittle();
        spittle.setMessage("Hiya!");
        spittle.setTime(new Date());
        spittle.setLatitude(28.419468);
        spittle.setLongitude(-81.581195);
        return spittle;
    }
}
