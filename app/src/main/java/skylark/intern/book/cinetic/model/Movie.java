package skylark.intern.book.cinetic.model;

public class Movie {


    private  String title;
    private int photo;
    private  String cast;
    private  String director;
    private  String description;
    private  String type;
    private String language;
    private String genere;
    private String runtime;
    private String certification;
    private String story;
    private  int photoland;

    public Movie(int photo, String title) {
        this.photo = photo;
        this.title = title;

    }


    public String getTitle() {
        return title;
    }


    public int getPhoto(){

        return photo;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public int getPhotoland() {
        return photoland;
    }

    public void setPhotoland(int photoland) {
        this.photoland = photoland;
    }
}

