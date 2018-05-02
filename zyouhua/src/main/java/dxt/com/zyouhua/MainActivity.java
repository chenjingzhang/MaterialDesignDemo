package dxt.com.zyouhua;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

//让背景图和系统状态栏融合，需要借助android.fitSystemWindows这个属性来实现
//将控件的android:fitsSystemWindows属性设置成true,就表示该控件会出现在系统状态栏中
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView) findViewById(R.id.fruit_image);
        TextView textView = (TextView) findViewById(R.id.fruit_content_text);
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle("你好G");
        imageView.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.a));
        String content = generateContent("fff");
        textView.setText(content);

    }

    private String generateContent(String fff) {
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<50;i++){
            sb.append("dfs");
        }
        return sb.toString();
    }
    }

