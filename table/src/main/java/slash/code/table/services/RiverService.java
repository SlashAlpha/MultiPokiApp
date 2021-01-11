package slash.code.table.services;

import slash.code.table.Card;
import slash.code.table.river.River;

public interface RiverService {


     Card getCard();

     void getFirstWave(River river);

     void getSecondWave(River river);

     void getThirdWave(River river);

}
