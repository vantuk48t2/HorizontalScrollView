package com.example.gridview;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView txtMsg;
    ViewGroup scrollView;
    ImageView imageSelected;
    ImageView icon;
    TextView caption;


    Integer [] thumbnails ={R.drawable.mot, R.drawable.hai, R.drawable.ba, R.drawable.bon, R.drawable.nam,
    R.drawable.sau, R.drawable.bay, R.drawable.tam, R.drawable.chin};
    String [] data ={"Mot", "Hai", "Ba", "Bon", "Nam", "Sau", "Bay", "Tam", "Chin"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // di toi day da loi roi
        txtMsg = (TextView)findViewById(R.id.txtMsg);
        imageSelected = (ImageView) findViewById(R.id.imageSelected);
        scrollView = (ViewGroup) findViewById(R.id.viewgroup);
        //Dien vao scrollView
        for(int i=0; i< data.length; i++){
            //Create single frame(icon + caption) using xml inflater
            //LayoutInflater chuyen ma tu 1 file layout xml len view
            final View singleFrame = getLayoutInflater().inflate(R.layout.frame_icon_caption, null);
            //Frame 0, 1,...
            singleFrame.setId(i);
            ImageView icon = singleFrame.findViewById(R.id.icon);
            TextView caption = singleFrame.findViewById(R.id.caption);
            //put data (icon +caption) len moi frame
            icon.setImageResource(thumbnails[i]);
            caption.setText(data[i]);
            caption.setBackgroundColor(Color.YELLOW);

            //add frame to the scrollView
            scrollView.addView(singleFrame);
            singleFrame.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View v) {
                    String text = "Selected position: " + data[singleFrame.getId()];
                    txtMsg.setText(text);
                    //Show up large image
                    Drawable selectedLargeImage = getResources().getDrawable(thumbnails[singleFrame.getId()],getTheme());
                    imageSelected.setBackground(selectedLargeImage);
                }
            });
        }
    }

}
