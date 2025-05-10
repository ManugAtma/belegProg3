package event.events;

import event.contract.CLIEvent;


public class GetKuchenEvent implements CLIEvent {
    String kuchenType;

    public GetKuchenEvent(String kuchenType){
        this.kuchenType = kuchenType; // no check for NPE, null means no type specified by user
    }

    // returns null if no kuchen type was specified by user
    public String getKuchenType(){
        return kuchenType;
    }
}
