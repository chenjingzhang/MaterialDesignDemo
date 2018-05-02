package dxt.com.fappbarlayou;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import adapter.FruitAdapter;
import bean.Fruit;

//由于RecyclerView和Toolbar都是放在CoordinationLayout
//CoordinationLayout 是一个加强版的FrameLayout,默认都放在布局的左上角，从而出现遮挡的现象
//传统情况下，1使用偏移解决，让RecyclerView向下偏移一个Toolbar的高度 2使用AppBarLayout
//1.将Toolbar嵌套在AppBarLayout中，2给RecyclerView指定一个布局行为
public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Fruit[] fruits = {
            new Fruit("aaa", R.drawable.a),
            new Fruit("bbbb", R.drawable.b),
            new Fruit("cccc", R.drawable.c),
    };
    private List<Fruit> fruitslist = new ArrayList<>();
    private FruitAdapter adapter;

    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        initFruits();
        GridLayoutManager l= new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(l);
        adapter = new FruitAdapter(fruitslist,this);
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);

        swipeRefreshLayout.setColorSchemeColors(R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshList();
            }


        });
    }

    private void refreshList() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initFruits();
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        });
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
