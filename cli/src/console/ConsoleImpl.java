package console;

import console.contract.Console;
import console.contract.InputMode;
import console.modes.*;
import event.cli.events.*;
import event.cli.handlers.*;
import observe.contract.ObservableAutomat;

import java.util.Scanner;


public class ConsoleImpl implements Console {

    private final ObservableAutomat model;

    private InputMode currentMode;
    private final CMode cMode = new CMode();
    private final RMode rMode = new RMode();
    private final UMode uMode = new UMode();
    private final DMode dMode = new DMode();
    private final PMode pMode = new PMode();

    private AddHerstellerHandler addHerstellerHandler;
    private AddKuchenHandler addKuchenHandler;
    private GetAllergeneHandler getAllergeneHandler;
    private GetHerstellerHandler getHerstellerHandler;
    private GetKuchenHandler getKuchenHandler;
    private LoadHandler loadHandler;
    private RemoveHerstellerHandler removeHerstellerHandler;
    private RemoveKuchenHandler removeKuchenHandler;
    private SaveHandler saveHandler;
    private SetInspektionsdatumHandler setInspektionsdatumHandler;


    public ConsoleImpl(ObservableAutomat model) {
        if (model == null) throw new NullPointerException("model ist null");
        this.model = model;
    }

    public void execute() {

        System.out.println("welcome!");
        this.currentMode = this.cMode;
        System.out.println("you are in create mode");
        Scanner scanner = new Scanner(System.in);

        // read user input
        while (true) {

            System.out.print("> ");
            String input = scanner.nextLine();

            // read mode
            if (input.startsWith(":")) {

                switch (input) {
                    case ":c":
                        this.currentMode = this.cMode;
                        System.out.println("you are in create mode");
                        break;
                    case ":r":
                        this.currentMode = this.rMode;
                        System.out.println("you are in read mode");
                        break;
                    case ":u":
                        this.currentMode = this.uMode;
                        System.out.println("you are in update mode");
                        break;
                    case ":d":
                        this.currentMode = this.dMode;
                        System.out.println("you are in delete mode");
                        break;
                    case ":p":
                        this.currentMode = this.pMode;
                        System.out.println("you are in persistence mode");
                        break;
                    case ":x":
                        System.out.println("exiting...");
                        System.exit(0);
                    default:
                        System.out.println("no such mode available"); // list available modes?
                }
            }

            // read command
            else {
                Operator operator = currentMode.parse(input);

                if (operator != null) {

                    switch (operator) {

                        case ADD_HERSTELLER:
                            AddHerstellerEvent addHerstellerEvent = this.cMode.getAddHerstellerEvent();
                            if (addHerstellerHandler == null) {
                                this.printWarning(operator);
                                break;
                            }
                            this.addHerstellerHandler.handle(addHerstellerEvent);
                            break;

                        case ADD_KUCHEN:
                            AddKuchenEvent addKuchenEvent = this.cMode.getAddKuchenEvent();
                            if (addKuchenHandler == null) {
                                this.printWarning(operator);
                                break;
                            }
                            this.addKuchenHandler.handle(addKuchenEvent);
                            break;

                        case GET_ALLERGENE:
                            GetAllergeneEvent getAllergeneEvent = this.rMode.getGetAllergeneEvent();
                            if (getAllergeneHandler == null) {
                                this.printWarning(operator);
                                break;
                            }
                            this.getAllergeneHandler.handle(getAllergeneEvent);
                            break;

                        case GET_HERSTELLER:
                            GetHerstellerEvent getHerstellerEvent = this.rMode.getGetHerstellerEvent();
                            if (getHerstellerHandler == null) {
                                this.printWarning(operator);
                                break;
                            }
                            this.getHerstellerHandler.handle(getHerstellerEvent);
                            break;

                        case GET_KUCHEN:
                            GetKuchenEvent getKuchenEvent = this.rMode.getGetKuchenEvent();
                            if (getKuchenHandler == null) {
                                this.printWarning(operator);
                                break;
                            }
                            this.getKuchenHandler.handle(getKuchenEvent);
                            break;

                        case LOAD:
                            LoadEvent loadEvent = this.pMode.getLoadEvent();
                            if (loadHandler == null) {
                                this.printWarning(operator);
                                break;
                            }
                            this.loadHandler.handle(loadEvent);
                            break;

                        case REMOVE_HERSTELLER:
                            RemoveHerstellerEvent removeHerstellerEvent = this.dMode.getRemoveHerstellerEvent();
                            if (removeHerstellerHandler == null) {
                                this.printWarning(operator);
                                break;
                            }
                            this.removeHerstellerHandler.handle(removeHerstellerEvent);
                            break;

                        case REMOVE_KUCHEN:
                            RemoveKuchenEvent removeKuchenEvent = this.dMode.getRemoveKuchenEvent();
                            if (removeKuchenHandler == null) {
                                this.printWarning(operator);
                                break;
                            }
                            this.removeKuchenHandler.handle(removeKuchenEvent);
                            break;

                        case SAVE:
                            SaveEvent saveEvent = this.pMode.getSaveEvent();
                            if (saveHandler == null) {
                                this.printWarning(operator);
                                break;
                            }
                            this.saveHandler.handle(saveEvent);
                            break;

                        case SET_FACHNUMMER:
                            SetInspektionsdatumEvent setFachnummerEvent = this.uMode.getSetFachnummerEvent();
                            if (setInspektionsdatumHandler == null) {
                                this.printWarning(operator);
                                break;
                            }
                            this.setInspektionsdatumHandler.handle(setFachnummerEvent);
                            break;
                    }
                }
            }
        }
    }


    private void printWarning(Operator operator) {
        System.out.println("functionality " + operator + " is not available");
    }

    @Override
    public void setAddHerstellerHandler(AddHerstellerHandler handler) {
        if (handler == null) throw new NullPointerException("addHerstellerHandler is null");
        this.addHerstellerHandler = handler;
    }

    @Override
    public void setAddKuchenHandler(AddKuchenHandler handler) {
        if (handler == null) throw new NullPointerException("addKuchenHandler is null");
        this.addKuchenHandler = handler;
    }

    @Override
    public void setGetAllergeneHandler(GetAllergeneHandler handler) {
        if (handler == null) throw new NullPointerException("getAllergeneHandler is null");
        this.getAllergeneHandler = handler;
    }

    @Override
    public void setGetHerstellerHandler(GetHerstellerHandler handler) {
        if (handler == null) throw new NullPointerException("getHerstellerHandler is null");
        this.getHerstellerHandler = handler;
    }

    @Override
    public void setGetKuchenHandler(GetKuchenHandler handler) {
        if (handler == null) throw new NullPointerException("getKuchenHandler is null");
        this.getKuchenHandler = handler;
    }

    @Override
    public void setLoadHandler(LoadHandler handler) {
        if (handler == null) throw new NullPointerException("loadHandler is null");
        this.loadHandler = handler;
    }

    @Override
    public void setRemoveHerstellerHandler(RemoveHerstellerHandler handler) {
        if (handler == null) throw new NullPointerException("removeHerstellerHandler is null");
        this.removeHerstellerHandler = handler;
    }

    @Override
    public void setRemoveKuchenHandler(RemoveKuchenHandler handler) {
        if (handler == null) throw new NullPointerException("removeKuchenHandler is null");
        this.removeKuchenHandler = handler;
    }

    @Override
    public void setSaveHandler(SaveHandler handler) {
        if (handler == null) throw new NullPointerException("saveHandler is null");
        this.saveHandler = handler;
    }

    @Override
    public void setSetInspektionsdatumHandler(SetInspektionsdatumHandler handler) {
        if (handler == null) throw new NullPointerException("setInspektionsdatumHandler is null");
        this.setInspektionsdatumHandler = handler;
    }
}
