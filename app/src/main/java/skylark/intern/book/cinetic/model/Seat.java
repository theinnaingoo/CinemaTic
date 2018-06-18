package skylark.intern.book.cinetic.model;

import java.io.Serializable;

import skylark.intern.book.cinetic.R;

public class Seat implements Serializable {
    private int seatId,colour;
    private String seatName,seatType,seatPrice;


    public Seat(int seatId, String seatName, String seatType)  {
        this.seatId = seatId;
        this.seatName = seatName;
        this.seatType = seatType;
        if(seatType.equals("Y")){
            setColour(R.color.colorYellow);
            setSeatPrice("2000");
        }else if(seatType.equals("G")){
            setColour(R.color.colorGreen);
            setSeatPrice("3500");
        }else if(seatType.equals("R")){
            setColour(R.color.colorRed);
            setSeatPrice("4500");
        }
    }

    public void setSeatPrice(String seatPrice) {
        this.seatPrice = seatPrice;
    }

    public void setColour(int color) {
        this.colour = color;
    }

    public int getSeatId() {
        return seatId;
    }

    public String getSeatName() {
        return seatName;
    }

    public String getSeatType() {
        return seatType;
    }

    public String getSeatPrice() {
        return seatPrice;
    }

    public int getColour() {
        return colour;
    }
}
