package slash.code.table.services;

import slash.code.table.river.Card;
import slash.code.table.river.River;

public interface RiverService {


    void getFirstWave(River river);

    void getSecondWave(River river);

    void getThirdWave(River river);

}
