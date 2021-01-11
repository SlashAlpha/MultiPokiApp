package slash.code.table.services;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import slash.code.table.Card;
import slash.code.table.river.River;

import java.util.Optional;

@ConfigurationProperties(prefix = "slash.code")
@Service
public class RiverServices implements RiverService {

    public final static String RIVER_PATH_V1 = "http://localhost:8080/api/v1/dealer/river/card";

    private final RestTemplate restTemplate;

    private  String dealerServiceHost;

    public RiverServices(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    @Override
    public Card getCard(){
        return restTemplate.getForObject(RIVER_PATH_V1,Card.class);

    }


    public void setRiverServiceHost(String riverServiceHost) {
        this.dealerServiceHost = riverServiceHost;
    }

    @Override
    public void getFirstWave(River river) {
        Card one=getCard();
        Card two=getCard();
        Card three=getCard();
        river.getRiverCards().add(one);
        river.getRiverCards().add(two);
        river.getRiverCards().add(three);
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);

    }

    @Override
    public void getSecondWave(River river) {
        Card one=getCard();
        river.getRiverCards().add(one);
        System.out.println(one);
    }

    @Override
    public void getThirdWave(River river) {
        Card one=getCard();
        river.getRiverCards().add(one);
        System.out.println(one);
    }
}
