package dxt.com.gcollaspingtoolbarlayou;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

//CollapsingToolbarLayout是一个作用于Toolbar基础之上的布局
//不能单独使用，它在设计的时候就被限定只能作为AppbarLayout的直接子布局来使用
//而AppbarLayout又必须结合CoordinatorLayout的子布局
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