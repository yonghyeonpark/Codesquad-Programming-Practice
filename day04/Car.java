public enum Car {

    TUSCANI("Tuscani", true, "Coupe", 2, 200109, 200810),
    POTER("Poter", true, "TRUCK", 3, 197702, 200405),
    CORTINA("Cortina", true, "Sedan", 5, 196801, 198004),
    ELANTRA("Elantra", true, "Sedan", 5, 199010, 199512),
    EQUUS("Equus", true, "Sedan", 5, 199904, 200912),
    GRANDEUR("Grandeur", false, "Sedan", 5, 198607, 202305),
    PONY("Pony", true, "Sedan", 5, 197512, 198201),
    SANTAFE("SantaFe", false, "RV", 7, 200006, 202305),
    AEROTOWN("Aerotown", false, "Bus", 30, 199406, 202305),
    UNIVERSE("Universe", false, "Bus", 45, 200612, 202305);

    private String name;
    private boolean isExtinction;
    private String type;
    private int passengerNumber;
    private int productionStart;
    private int productionEnd;

    Car(String name, boolean isExtinction, String type, int passengerNumber, int productionStart, int productionEnd) {
        this.name = name;
        this.isExtinction = isExtinction;
        this.type = type;
        this.passengerNumber = passengerNumber;
        this.productionStart = productionStart;
        this.productionEnd = productionEnd;
    }

    public String getName() {
        return name;
    }

    public boolean isExtinction() {
        return isExtinction;
    }

    public String getType() {
        return "(" + type + ")";
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public int getProductionStart() {
        return productionStart;
    }

    public int getProductionEnd() {
        return productionEnd;
    }
}
