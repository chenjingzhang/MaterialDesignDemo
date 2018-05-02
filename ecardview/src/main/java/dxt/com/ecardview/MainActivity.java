package dxt.com.ecardview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dxt.com.ecardview.adapter.FruitAdapter;
import dxt.com.ecardview.bean.Fruit;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Fruit[] fruits = {
            new Fruit("aaa", R.drawable.a),
            new Fruit("bbbb", R.drawable.b),
            new Fruit("cccc", R.drawable.c),
    };
    private List<Fruit> fruitslist = new ArrayList<>();
    private FruitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        navigationView.setCheckedItem(R.id.nav_call);//将call菜单项设置为默认选中
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        drawerLayout.closeDrawers();//将滑动菜单关闭
                        return true;
                    }
                }
        );


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

       initFruits();

        GridLayoutManager l= new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(l);
        adapter = new FruitAdapter(fruitslist,this);
        recyclerView.setAdapter(adapter);

    }

    private void initFruits() {
        fruitslist.clear();
        for(int i = 0;i<50;i++){

            Random rn = new Random();
            int index = rn.nextInt(fruits.length);
            fruitslist.add(fruits[index]);
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home://HomeAdUp按钮的id永远是android.R.id.home
                drawerLayout.openDrawer(GravityCompat.START);//将滑动菜单展示出来
                break;
        }
        return true;
    }
}

