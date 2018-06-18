package skylark.intern.book.cinetic;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import skylark.intern.book.cinetic.fragment.Show;

/**
 * Created by deepshikha on 8/5/17.
 */

public class ScreenShot extends AppCompatActivity {
    ImageView iv_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_shot);
        init();
    }

    private void init() {
        String s ="TIC_"+BookingDetail.tickt.getCinema()+"_"+BookingDetail.tickt.getMoviename()+"_"+ Show.seats+".jpg";
        iv_image = (ImageView) findViewById(R.id.iv_image);
        String completePath = Environment.getExternalStorageDirectory() + "/" + s;
        Glide.with(ScreenShot.this).load(completePath).error(R.drawable.ic_launcher_background).into(iv_image);

    }


}