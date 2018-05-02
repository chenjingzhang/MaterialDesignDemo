package dxt.com.ecardview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import dxt.com.ecardview.R;
import dxt.com.ecardview.bean.Fruit;

/**
 * Created by Administrator on 2018/4/30 0030.
 */
public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.MyViewHolder> {
    private Context context;
    private List<Fruit> fruits;

    public FruitAdapter(List<Fruit> list,Context contet) {
        fruits = list;
        context = contet;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fruit_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Fruit fruit = fruits.get(position);
        holder.fruittext.setText(fruit.getName());
        Glide.with(context).load(fruit.getImageId()).into(holder.fruitimage);

    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView fruittext;
        private ImageView fruitimage;

        public MyViewHolder(View itemView) {
            super(itemView);
            fruitimage = (ImageView) itemView.findViewById(R.id.fruit_image);
            fruittext = (TextView) itemView.findViewById(R.id.fruit_name);
        }
    }
}
