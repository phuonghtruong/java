public class gasMileage{
    private int miles;
    private int gallons;
    private double usage;

    public gasMileage(int miles, int gallons){
        this.miles = miles;
        this.gallons = gallons;
    }

    public void setMiles(int miles){
        this.miles = miles;
    }

    public int getMiles(){
        return miles;
    }

    public void setGallons(int gallons){
        this.gallons = gallons;
    }

    public int getGallons(){
        return gallons;
    }

    public double Cal_OneTripUsage(){
        usage = (double) miles/gallons;
        return usage;
    }
}

