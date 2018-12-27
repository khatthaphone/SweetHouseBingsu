package la.sweethouse.bingsu;

import android.graphics.drawable.Drawable;

public class Bingsu {


    private String name = "";
    private String description = "";
    private int priceS;
    private int priceM;
    private int priceL;
    private int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriceS() {
        return priceS;
    }

    public void setPriceS(int priceS) {
        this.priceS = priceS;
    }

    public int getPriceM() {
        return priceM;
    }

    public void setPriceM(int priceM) {
        this.priceM = priceM;
    }

    public int getPriceL() {
        return priceL;
    }

    public void setPriceL(int priceL) {
        this.priceL = priceL;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Bingsu(String name, String description, int priceS, int priceM, int priceL, int image) {
        this.name = name;
        this.description = description;
        this.priceS = priceS;
        this.priceM = priceM;
        this.priceL = priceL;
        this.image = image;
    }
}
