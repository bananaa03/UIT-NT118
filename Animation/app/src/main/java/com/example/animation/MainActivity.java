package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnFadeInXml;
    private Button btnFadeInCode;
    private Button btnFadeOutXml;
    private Button btnFadeOutCode;
    private Button btnBlinkXml;
    private Button btnBlinkCode;
    private Button btnZoomInXml;
    private Button btnZoomInCode;
    private Button btnZoomOutXml;
    private Button btnZoomOutCode;
    private Button btnRotateXml;
    private Button btnRotateCode;
    private Button btnMoveXml;
    private Button btnMoveCode;
    private Button btnSlideUpXml;
    private Button btnSlideUpCode;
    private Button btnBounceXml;
    private Button btnBounceCode;
    private Button btnCombineXml;
    private Button btnCombineCode;
    private ImageView ivUitLogo;
    private Animation.AnimationListener animationListener;
    private void findViewsByIds() {
        ivUitLogo = findViewById(R.id.iv_uit_logo);
        btnFadeInXml = findViewById(R.id.btn_fade_in_xml);
        btnFadeInCode = findViewById(R.id.btn_fade_in_code);
        btnFadeOutXml = findViewById(R.id.btn_fade_out_xml);
        btnFadeOutCode = findViewById(R.id.btn_fade_out_code);
        btnBlinkXml = findViewById(R.id.btn_blink_xml);
        btnBlinkCode = findViewById(R.id.btn_blink_code);
        btnZoomInXml = findViewById(R.id.btn_zoom_in_xml);
        btnZoomInCode = findViewById(R.id.btn_zoom_in_code);
        btnZoomOutXml = findViewById(R.id.btn_zoom_out_xml);
        btnZoomOutCode = findViewById(R.id.btn_zoom_out_code);
        btnRotateXml = findViewById(R.id.btn_rotate_xml);
        btnRotateCode = findViewById(R.id.btn_rotate_code);
        btnMoveXml = findViewById(R.id.btn_move_xml);
        btnMoveCode = findViewById(R.id.btn_move_code);
        btnSlideUpXml = findViewById(R.id.btn_slide_up_xml);
        btnSlideUpCode = findViewById(R.id.btn_slide_up_code);
        btnBounceXml = findViewById(R.id.btn_bounce_xml);
        btnBounceCode = findViewById(R.id.btn_bounce_code);
        btnCombineXml = findViewById(R.id.btn_combine_xml);
        btnCombineCode = findViewById(R.id.btn_combine_code);
    }
    private void initVariables() {
        animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getApplicationContext(), "Animation Stopped",
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        };
    }

    private void handleCLickAnimationXML()
    {
        //fade in
        final Animation animation_fade_in = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.anim_fade_in);
        animation_fade_in.setAnimationListener((animationListener));
        btnFadeInXml.setOnClickListener(v -> ivUitLogo.startAnimation(animation_fade_in));

        //fade out
        final Animation animation_fade_out = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.anim_fade_out);
        animation_fade_out.setAnimationListener((animationListener));
        btnFadeOutXml.setOnClickListener(v -> ivUitLogo.startAnimation(animation_fade_out));

        //blink
        final Animation animation_blink = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.anim_blink);
        animation_blink.setAnimationListener((animationListener));
        btnBlinkXml.setOnClickListener(v -> ivUitLogo.startAnimation(animation_blink));

        //zoom in
        final Animation animation_zoom_in = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.anim_zoom_in);
        animation_zoom_in.setAnimationListener((animationListener));
        btnZoomInXml.setOnClickListener(v -> ivUitLogo.startAnimation(animation_zoom_in));

        //zoom out
        final Animation animation_zoom_out = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.anim_zoom_out);
        animation_zoom_out.setAnimationListener((animationListener));
        btnZoomOutXml.setOnClickListener(v -> ivUitLogo.startAnimation(animation_zoom_out));

        //rotate
        final Animation animation_rotate = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.anim_rotate);
        animation_rotate.setAnimationListener((animationListener));
        btnRotateXml.setOnClickListener(v -> ivUitLogo.startAnimation(animation_rotate));

        //move
        final Animation animation_move = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.anim_move);
        animation_move.setAnimationListener((animationListener));
        btnMoveXml.setOnClickListener(v -> ivUitLogo.startAnimation(animation_move));

        //slide up
        final Animation animation_slide_up = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.anim_slide_up);
        animation_slide_up.setAnimationListener((animationListener));
        btnSlideUpXml.setOnClickListener(v -> ivUitLogo.startAnimation(animation_slide_up));

        //bounce
        final Animation animation_bounce = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.anim_bounce);
        animation_bounce.setAnimationListener((animationListener));
        btnBounceXml.setOnClickListener(v -> ivUitLogo.startAnimation(animation_bounce));

        //combine
        final Animation animation_combine = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.anim_combine);
        animation_combine.setAnimationListener((animationListener));
        btnCombineXml.setOnClickListener(v -> ivUitLogo.startAnimation(animation_combine));
    }

    //Sử dụng animation từ code
    private void handleClickAnimationCode(Button btn, final Animation animation) {
        // Handle onclickListenner to start animation
        btn.setOnClickListener(v -> ivUitLogo.startAnimation(animation));
    }
    private Animation initFadeInAnimation()
    {
        AlphaAnimation animation = new AlphaAnimation(0f, 1f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private Animation initFadeOutAnimation()
    {
        AlphaAnimation animation = new AlphaAnimation(1f, 0f);
        animation.setStartOffset(500);
        animation.setDuration(500);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }
    private Animation initBlinkAnimation()
    {
        AlphaAnimation animation = new AlphaAnimation(0f, 1f);
        animation.setDuration(200);
        animation.setStartOffset(200);
        animation.setRepeatMode(Animation.RESTART);
        animation.setRepeatCount(Animation.RELATIVE_TO_PARENT);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private  Animation initZoomInAnimation()
    {
        ScaleAnimation animation = new ScaleAnimation(1f, 2f, 1f, 2f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private  Animation initZoomOutAnimation()
    {
        ScaleAnimation animation = new ScaleAnimation(1f, 0.5f, 1f, 0.5f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private  Animation initRotateAnimation()
    {
        RotateAnimation animation = new RotateAnimation(0f, 360f, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private  Animation initMoveAnimation()
    {
        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 1f,
                Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0f
        );
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setRepeatMode(Animation.RESTART);
        animation.setRepeatCount(Animation.RESTART);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private  Animation initSlideUpAnimation()
    {
        AnimationSet animationSet = new AnimationSet(true);

        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, -1f
        );
        translateAnimation.setDuration(3000);
        translateAnimation.setFillAfter(true);
        animationSet.addAnimation(translateAnimation);

        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1f, 1f,
                1f, 0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0f
        );
        scaleAnimation.setDuration(3000);
        scaleAnimation.setFillAfter(true);
        animationSet.addAnimation(scaleAnimation);

        animationSet.setAnimationListener(animationListener);
        return animationSet;
    }

    private  Animation initBounceAnimation()
    {
        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, -1f,
                Animation.RELATIVE_TO_SELF, 0f
        );
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setInterpolator(new BounceInterpolator());
        return animation;
    }

    private  Animation initCombineAnimation()
    {
        TranslateAnimation animation1 = new TranslateAnimation(0f, 0f, 0f, 200f);
        animation1.setDuration(3000);
        animation1.setFillAfter(true);

        // Tạo animation 2
        RotateAnimation animation2 = new RotateAnimation(0f, 360f, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animation2.setDuration(3000);
        animation2.setFillAfter(true);

        // Kết hợp hai animation lại
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(animation1);
        animationSet.addAnimation(animation2);

        return animationSet;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsByIds();
        initVariables();

        //HandleClickAnimationXML
        handleCLickAnimationXML();
        handleCLickAnimationXML();
        handleCLickAnimationXML();
        handleCLickAnimationXML();
        handleCLickAnimationXML();
        handleCLickAnimationXML();
        handleCLickAnimationXML();
        handleCLickAnimationXML();
        handleCLickAnimationXML();
        handleCLickAnimationXML();

        //HandleClickAnimationCode
        handleClickAnimationCode(btnFadeInCode, initFadeInAnimation());
        handleClickAnimationCode(btnFadeOutCode, initFadeOutAnimation());
        handleClickAnimationCode(btnBlinkCode, initBlinkAnimation());
        handleClickAnimationCode(btnZoomInCode, initZoomInAnimation());
        handleClickAnimationCode(btnZoomOutCode, initZoomOutAnimation());
        handleClickAnimationCode(btnRotateCode, initRotateAnimation());
        handleClickAnimationCode(btnMoveCode, initMoveAnimation());
        handleClickAnimationCode(btnSlideUpCode, initSlideUpAnimation());
        handleClickAnimationCode(btnBounceCode, initBounceAnimation());
        handleClickAnimationCode(btnCombineCode, initCombineAnimation());

        ivUitLogo = findViewById(R.id.iv_uit_logo);
        ivUitLogo.setOnClickListener(view -> {
            Intent iNewActivity = new Intent(MainActivity.this, NewActivity.class);
            startActivity(iNewActivity);
            createPendingResult(R.anim.right_in,iNewActivity,R.layout.new_activity);
            ActivityOptionsCompat.makeCustomAnimation(MainActivity.this, R.anim.right_in, R.anim.right_out);
            finish();
        });
    }
}
