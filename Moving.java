public class Moving {
    static final double SURCHARGE = 500;
    static final double TAXRATE = 0.1;
    static final double COST_PER_KM = 1.5;
    static final double COST_PER_KG = 0.5;
    static final double COST_PER_FLIGHT = 500;
    static final double COST_PER_APPLIANCE = 50;
    static final double COST_PER_PIANO = 200;

    private int distance;
    private int weight;
    private int flights;
    private int applicances;
    private int pianos;
    private int other;
    private int movers;
    private boolean elevator;
    private boolean surchargeApplicable;

    public Moving(int distance, int weight, int flights, int applicances, int pianos, int other, int movers, boolean elevator, boolean surchargeApplicable) {
        this.distance = distance;
        this.weight = weight;
        this.flights = flights;
        this.applicances = applicances;
        this.pianos = pianos;
        this.other = other;
        this.movers = movers;
        this.elevator = elevator;
        this.surchargeApplicable = surchargeApplicable;
    }

    public int getDistance() {
        return distance;
    }

    public int getWeight() {
        return weight;
    }

    public int getFlights() {
        return flights;
    }

    public int getApplicances() {
        return applicances;
    }

    public int getPianos() {
        return pianos;
    }

    public int getOther() {
        return other;
    }

    public int getMovers() {
        return movers;
    }

    public boolean isElevator() {
        return elevator;
    }

    public boolean isSurchargeApplicable() {
        return surchargeApplicable;
    }
    
    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setFlights(int flights) {
        this.flights = flights;
    }

    public void setApplicances(int applicances) {
        this.applicances = applicances;
    }

    public void setPianos(int pianos) {
        this.pianos = pianos;
    }

    public void setOther(int other) {
        this.other = other;
    }

    public void setMovers(int movers) {
        this.movers = movers;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    public void setSurchargeApplicable(boolean surchargeApplicable) {
        this.surchargeApplicable = surchargeApplicable;
    }

    public double calcMileageCost() {
        return distance * COST_PER_KM;
    }

    public double calcLabourCost() {
        double labourCost;
        if (movers > 4) {
            labourCost =  weight * COST_PER_KG;
        } else {
            labourCost = weight * COST_PER_KG * 1.5;
        }
        return labourCost * COST_PER_KG;
    }

    public double calcFlightCost() {
        // double perFlight = 400;
        return flights * COST_PER_FLIGHT;
    }

    public double calcApplianceCost() {
        return applicances * COST_PER_APPLIANCE;
    }

    public double calcPianoCost() {
        return pianos * COST_PER_PIANO;
    }

    public double calcMiscCost() {
        double otherCost = 0;
        if (surchargeApplicable && elevator)
            otherCost = other + SURCHARGE;
        else if (surchargeApplicable && !elevator)
            otherCost = other + SURCHARGE * 2;
        else 
            otherCost = other;
        
        return otherCost;
    } 

    public double calcSubtotal() {
        return calcMileageCost() + calcLabourCost() + calcFlightCost() + calcApplianceCost() + calcPianoCost() + calcMiscCost();
    }

    public double calcTax() {
        return calcSubtotal() * TAXRATE;
    }

    public double calcTotal() {
        return calcSubtotal() + calcTax();
    }

    
}