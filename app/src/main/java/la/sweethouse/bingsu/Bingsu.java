package la.sweethouse.bingsu;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class Bingsu implements Parcelable {


    private String name = "";
    private String description = "";
    private int priceS;
    private int priceM;
    private int priceL;
    private int image;

    protected Bingsu(Parcel in) {
        name = in.readString();
        description = in.readString();
        priceS = in.readInt();
        priceM = in.readInt();
        priceL = in.readInt();
        image = in.readInt();
    }

    public static final Creator<Bingsu> CREATOR = new Creator<Bingsu>() {
        @Override
        public Bingsu createFromParcel(Parcel in) {
            return new Bingsu(in);
        }

        @Override
        public Bingsu[] newArray(int size) {
            return new Bingsu[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(priceS);
        dest.writeInt(priceM);
        dest.writeInt(priceL);
        dest.writeInt(image);
    }
}
