package analytic_events;

public enum App {
    PICSART(1),
    PICSART_WEBSITE(22);


    private int appNumber;

    App(int appNumber) {
        this.appNumber = appNumber;
    }

    public int getAppNumber() {
        return appNumber;
    }

    public void setAppNumber(int appNumber) {
        this.appNumber = appNumber;
    }
}
