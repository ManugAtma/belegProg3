package console.contract;

import event.cli.handlers.*;

public interface Console {

    /*void setHandler(Operator operator, CLIHandler<?> handler);*/
    void execute();

    void setAddHerstellerHandler(AddHerstellerHandler handler);
    void setAddKuchenHandler(AddKuchenHandler handler);
    void setGetAllergeneHandler(GetAllergeneHandler handler);
    void setGetHerstellerHandler(GetHerstellerHandler handler);
    void setGetKuchenHandler(GetKuchenHandler handler);
    void setLoadHandler(LoadHandler handler);
    void setRemoveHerstellerHandler(RemoveHerstellerHandler handler);
    void setRemoveKuchenHandler(RemoveKuchenHandler handler);
    void setSaveHandler(SaveHandler handler);
    void setSetInspektionsdatumHandler(SetInspektionsdatumHandler handler);

}
