package skylark.intern.book.cinetic.model;

public class History {
    String moviename;
    String date;
    String noofseat;
    String cinema;
    int photo;

    public History(String moviename, String date, String noofseat, String cinema, int photo) {
        this.moviename = moviename;
        this.date = date;
        this.noofseat = noofseat;
        this.cinema = cinema;
        this.photo= photo;
    }

    public String getMoviename() {
        return moviename;
    }

    public String getDate() {
        return date;
    }

    public String getNoofseat() {
        return noofseat;
    }

    public String getCinema() {
        return cinema;
    }

    public int getPhoto() {
        return photo;
    }
}
