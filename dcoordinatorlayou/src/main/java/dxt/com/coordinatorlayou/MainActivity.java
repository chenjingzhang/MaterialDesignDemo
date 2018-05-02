package dxt.com.coordinatorlayou;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

//Snackbar竟然将悬浮按钮给遮挡住了，虽然不是什么bug,因为过一会Snackbar会自动消失
//CoordinatorLayout是一个加强版的FrameLayout ,它可以监听其所有子控件的各种事件
//我们让CoordinatorLayout监听到Snackbar的弹出事件，那么她自动将内部的FloatingActionButton向上偏移，从而确保不会被Snackbar遮挡住
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"fab",Toast.LENGTH_LONG).show();
                Snackbar.make(v, "Data deleted", Snackbar.LENGTH_SHORT)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "Data restored", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
                //调用make()来创建一个Snackbar对象，
                //第一个参数传view,只要是当前界面布局的任意一个view都可以，Snackbar会
                //使用这个view自动查找最外层的布局，用于展示Snackbar，第二个参数是Snackbar中显示的内容。
                //setAction 设置一个动作，让Snackbar不仅仅是一个提示，而是可以和用户进行交互的。


            }
        });

    }
}
