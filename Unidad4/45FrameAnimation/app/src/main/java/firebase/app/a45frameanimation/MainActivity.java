package firebase.app.a45frameanimation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private AnimationDrawable blackMen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        if (imageView == null) throw new AssertionError();

        imageView.setVisibility(View.INVISIBLE);
        imageView.setBackgroundResource(R.drawable.animation_list);

        blackMen = (AnimationDrawable) imageView.getBackground();
        blackMen.setOneShot(true);

    }

    public void onStartBtnClick(View v) {
        imageView.setVisibility(View.VISIBLE);
        if (blackMen.isRunning()) {
            blackMen.stop();
        }
        blackMen.start();
    }

    public void onStopBtnClick(View v) {
        blackMen.stop();
    }
}
