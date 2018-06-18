package skylark.intern.book.cinetic;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;


import skylark.intern.book.cinetic.model.Movie;

public class DataUtility {
    public static int[] movieArray = new int[] {R.drawable.inifinity_war,
                                                R.drawable.the_shape_of_water,
                                                R.drawable.dunkrik,
                                                R.drawable.the_greatest_showman};
    public static List<Movie> movielist = new ArrayList<>();

    public static void generalMovielist(Context context){
        Movie inifinitywar= new Movie(movieArray[0], context.getString(R.string.init));
        inifinitywar.setCast("Robert Downey Jr., Chris Hemsworth, Mark Ruffalo, Chris Evans, Scarlett Johansson, Don Cheadle, Benedict Cumberbatch, Tom Holland, Chadwick Boseman, Zoe Saldana, Karen Gillan, Tom Hiddleston, Paul Bettany, Elizabeth Olsen, Anthony Mackie.");
        inifinitywar.setDirector("Anthony Russo, Joe Russo");
        inifinitywar.setDescription("The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe.");
        inifinitywar.setType("3D");
        inifinitywar.setLanguage("English");
        inifinitywar.setGenere("Action | Adventure | Fantasy | Sci-Fi");
        inifinitywar.setRuntime("2 hr 29 min (149 min)");
        inifinitywar.setCertification("Argentina:13 (with warning)  Australia:M  Austria:12  Brazil:12 Canada:PG (Alberta)  Canada:PG (British Columbia)  Colombia:7 France:Tous publics  Germany:12  Hungary:16  India:UA Indonesia:13+  Ireland:12A  Malaysia:P13  Mexico:B Netherlands:12  New Zealand:M  Norway:12  Philippines:PG-13 Portugal:M/12  Russia:16+  Singapore:PG13  South Korea:12 Spain:12  Sweden:11  Switzerland:12  Taiwan:PG-12 Thailand:G  United Kingdom:12A United States:PG-13 (certificate #51517)");
        inifinitywar.setStory("As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain. Written by Marvel Studios");
        inifinitywar.setPhotoland(R.drawable.inifinity_landscape1);

        Movie theshapeofwater = new Movie(movieArray[1], context.getString(R.string.tsow));
        theshapeofwater.setCast("Sally Hawkins, Michael Shannon, Richard Jenkins, Octavia Spencer, Michael Stuhlbarg, Doug Jones, David Hewlett, Nick Searcy, Stewart Arnott, Nigel Bennett, Lauren Lee Smith.");
        theshapeofwater.setDirector("Guillermo del Toro");
        theshapeofwater.setDescription("At a top secret research facility in the 1960s, a lonely janitor forms a unique relationship with an amphibious creature that is being held in captivity.");
        theshapeofwater.setType("2D");
        theshapeofwater.setLanguage("English | American Sign Language | Russian | French");
        theshapeofwater.setGenere("Adventure | Drama | Fantasy | Horror | Romance | Thriller");
        theshapeofwater.setRuntime("2 hr 3 min (123 min)");
        theshapeofwater.setCertification("Argentina:13 (with warning)  Australia:MA15+  Austria:14 Brazil:16  Canada:14A (Alberta/British Columbia/Manitoba/Ontario) Canada:13+ (Quebec)  France:Tous publics (with warning) Germany:16  Greece:K-15  Hong Kong:III  Hungary:16 Indonesia:17+  Ireland:15A  Japan:R15+  Malaysia:18 Mexico:B15 (with warning)  Netherlands:16  New Zealand:R16 Norway:15  Philippines:R-13  Portugal:M/16  Russia:18+ Singapore:M18  South Africa:16  South Korea:18  Spain:12 Sweden:15  Switzerland:14  Taiwan:R-15  Thailand:15 Turkey:15+  United Kingdom:15  United States:R (certificate #51030)");
        theshapeofwater.setStory("From master storyteller Guillermo del Toro comes THE SHAPE OF WATER, an otherworldly fable set against the backdrop of Cold War era America circa 1962. In the hidden high-security government laboratory where she works, lonely Elisa (Sally Hawkins) is trapped in a life of isolation. Elisa's life is changed forever when she and co-worker Zelda (Octavia Spencer) discover a secret classified experiment. Rounding out the cast are Michael Shannon, Richard Jenkins, Michael Stuhlbarg, and Doug Jones. Written by Fox Searchlight Pictures\n" +
                "\n" +
                "Plot Summary | Plot Synopsis");
        theshapeofwater.setPhotoland(R.drawable.the_sow_landscape1);

        Movie dunkrik= new Movie(movieArray[2], context.getString(R.string.dun));
        dunkrik.setCast("Fionn Whitehead, Tom Glynn-Carney, Jack Lowden, Harry Styles, Aneurin Barnard, James D'Arcy, Barry Keoghan, Kenneth Branagh, Cillian Murphy, Mark Rylance, Tom Hardy");
        dunkrik.setDirector("Christopher Nolan");
        dunkrik.setDescription("Allied soldiers from Belgium, the British Empire and France are surrounded by the German Army, and evacuated during a fierce battle in World War II.");
        dunkrik.setType("3D");
        dunkrik.setLanguage("English | French | German");
        dunkrik.setGenere("Action | Drama | History | Thriller | War");
        dunkrik.setRuntime("1 hr 46 min (106 min)");
        dunkrik.setCertification("Argentina:13  Australia:M  Austria:14  Brazil:14 Canada:PG (Alberta)  Canada:PG (British Columbia)  Chile:TE France:Tous publics  Germany:12  Greece:K-13  Hong Kong:IIA Hungary:16  Indonesia:13+  Ireland:12A  Italy:T  Japan:G Malaysia:P13  Mexico:B  Netherlands:12  Norway:12 Philippines:PG-13  Portugal:M/12  Russia:16+  Singapore:PG13 South Korea:12  Spain:12  Sweden:15  Switzerland:12 Taiwan:R-12  Thailand:G  Turkey:13+  United Kingdom:12A United Kingdom:12 (video rating) United States:PG-13 (certificate #50964)");
        dunkrik.setStory("Evacuation of Allied soldiers from the British Empire, and France, who were cut off and surrounded by the German army from the beaches and harbor of Dunkirk, France, between May 26- June 04, 1940, during Battle of France in World War II. Written by Harvey");
        dunkrik.setPhotoland(R.drawable.dunkrik_landscape1);

        Movie thegreatestshowman = new Movie(movieArray[3], context.getString(R.string.tgsm));
        thegreatestshowman.setCast("Hugh Jackman, Zac Efron, Michelle Williams, Rebecca Ferguson, Zendaya");
        thegreatestshowman.setDirector("Michael Gracey");
        thegreatestshowman.setDescription("Celebrates the birth of show business, and tells of a visionary who rose from nothing to create a spectacle that became a worldwide sensation.");
        thegreatestshowman.setType("2D");
        thegreatestshowman.setLanguage("English");
        thegreatestshowman.setGenere("Biography | Drama | Musical");
        thegreatestshowman.setRuntime("1 hr 45 min (105 min)");
        thegreatestshowman.setCertification("Argentina:Atp  Australia:PG  Brazil:12 (original rating) Brazil:10 (re-rating)  Canada:PG (Alberta) Canada:PG (British Columbia)  Finland:K-7  France:Tous publics Germany:6  Greece:K-12  Hong Kong:IIA  Hungary:12 India:UA  Indonesia:13+  Ireland:PG  Italy:T  Japan:G Malaysia:P13  Mexico:A  Netherlands:9  New Zealand:PG Norway:7  Philippines:PG-13  Portugal:M/12  Singapore:PG South Korea:12  Spain:A  Sweden:11  Switzerland:6 Taiwan:GP  Turkey:13A  United Kingdom:PG United States:PG (certificate #51075)");
        thegreatestshowman.setStory("Orphaned, penniless but ambitious and with a mind crammed with imagination and fresh ideas, the American Phineas Taylor Barnum will always be remembered as the man with the gift to effortlessly blur the line between reality and fiction. Thirsty for innovation and hungry for success, the son of a tailor will manage to open a wax museum but will soon shift focus to the unique and peculiar, introducing extraordinary, never-seen-before live acts on the circus stage. Some will call Barnum's wide collection of oddities, a freak show; however, when the obsessed showman gambles everything on the opera singer Jenny Lind to appeal to a high-brow audience, he will somehow lose sight of the most important aspect of his life: his family. Will Barnum risk it all to be accepted? Written by Nick Riganas");
        thegreatestshowman.setPhotoland(R.drawable.the_gtsm_landscape1);

        movielist.add(inifinitywar);
        movielist.add(theshapeofwater);
        movielist.add(dunkrik);
        movielist.add(thegreatestshowman);

    }



}
