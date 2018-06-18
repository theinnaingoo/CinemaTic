package skylark.intern.book.cinetic.model;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.List;
import java.util.TreeMap;

@SuppressWarnings("serial")
public class TicketBooking implements Serializable{
    private String date;
    private String cinema;
    private String showtime;
    private List<Seat> seatlist;
    private User user;
    private String moviename,seat;
    private Bitmap bmap;


    public TicketBooking(String date, String cinema, String showtime,String moviename) {
        this.date = date;
        this.cinema = cinema;
        this.showtime = showtime;
        this.moviename = moviename;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSeatlist(List<Seat> seatlist) {
        this.seatlist = seatlist;
    }

    public String getDate(){
        return date;
    }

    public String getCinema() {
        return cinema;
    }

    public String getShowtime() {
        return showtime;
    }

    public List<Seat> getSeatlist() {
        return seatlist;
    }

    public User getUser() {
        return user;
    }

    public String getMoviename() {
        return moviename;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public Bitmap getBmap() {
        return bmap;
    }

    public void setBmap(Bitmap bmap) {
        this.bmap = bmap;
    }

    public static class ChildTicketBooking implements Serializable{
        public ChildTicketBooking() {
        }
    }
}
