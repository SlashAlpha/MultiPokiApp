package slash.code.table.services;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import slash.code.table.river.Card;
import slash.code.table.river.CardRepository;
import slash.code.table.river.River;
import slash.code.table.river.RiverRepository;

@ConfigurationProperties(prefix = "slash.code")
@Service
public class RiverServices implements RiverService {

    public final static String RIVER_PATH_V1 = "http://localhost:8080/api/v1/dealer/river/card";

    private final RestTemplate restTemplate;

    private String dealerServiceHost;


    RiverRepository riverRepository;

    CardService cardService;

    public RiverServices(RestTemplateBuilder restTemplate, RiverRepository riverRepository, CardService cardService) {

        this.restTemplate = restTemplate.build();
        this.riverRepository = riverRepository;
        this.cardService = cardService;
    }


    public void setRiverServiceHost(String riverServiceHost) {
        this.dealerServiceHost = riverServiceHost;
    }

    @Override
    public void getFirstWave(River river) {

        river.setOne(cardService.getOne());

        river.setTwo(cardService.getOne());

        river.setThree(cardService.getOne());

        riverRepository.save(river);


    }

    @Override
    public void getSecondWave(River river) {

        river.setFour(cardService.getOne());

        riverRepository.save(river);
    }

    @Override
    public void getThirdWave(River river) {

        river.setFive(cardService.getOne());
        riverRepository.save(river);
    }
}
