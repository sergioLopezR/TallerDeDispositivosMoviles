package firebase.app.a46animacinobjectanimator;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private RelativeLayout canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.faceIcon);
        canvas = findViewById(R.id.animationCanvas);
    }

    public void onButtonClick(View v) {

        int screenHeight = canvas.getHeight();
        int targetY = screenHeight - imageView.getHeight();

        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", (canvas.getHeight()-150), 1)
                .setDuration(4000);

        animator.setInterpolator(new BounceInterpolator());
        //animator.setInterpolator(new AnticipateOvershootInterpolator(2));
        //animator.setInterpolator(new AnticipateInterpolator());
        //animator.setInterpolator(new LinearInterpolator());
        //animator.setInterpolator(new OvershootInterpolator());
        animator.start();

    }
    public void onButton1Click(View v){
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", (canvas.getHeight()-150), 1)
                .setDuration(4000);

        animator.setInterpolator(new CycleInterpolator(3));
        //animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.start();

    }
    public void onButton2Click(View v){
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", (canvas.getHeight()-150), 1)
                .setDuration(4000);

        animator.setInterpolator(new DecelerateInterpolator());
        //animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
    }
}
