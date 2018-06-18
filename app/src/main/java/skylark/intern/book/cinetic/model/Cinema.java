package skylark.intern.book.cinetic.model;

public class Cinema {
    private String name;
    private String ph;
    private String add;
    private int photo;

    public Cinema(String name, String ph, String add) {
        this.name = name;
        this.ph = ph;
        this.add = add;
    }

    public String getName() {
        return name;
    }

    public String getPh() {
        return ph;
    }

    public String getAdd() {
        return add;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
