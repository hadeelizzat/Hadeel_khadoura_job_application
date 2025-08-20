package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.models.Post;

import java.util.ArrayList;

public class PostInfoAdapter extends BaseAdapter {
    Context context;
    ArrayList<Post> postInfoArrayList=new ArrayList<>();
    LayoutInflater infalter;

    public PostInfoAdapter(Context context, ArrayList<Post> postInfoArrayList) {
        this.context = context;
        this.postInfoArrayList = postInfoArrayList;
        infalter=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return postInfoArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return postInfoArrayList.get(position).getId();
    }

    @Override
    public long getItemId(int position) {
        return postInfoArrayList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View root=infalter.inflate(R.layout.list_worker_post,parent, false);
        TextView city=root.findViewById(R.id.city);
        TextView job=root.findViewById(R.id.job);
        ImageView image= root.findViewById(R.id.image);
        TextView name=root.findViewById(R.id.name);
        TextView description=root.findViewById(R.id.description);
        city.setText(postInfoArrayList.get(position).getCity());
        job.setText(postInfoArrayList.get(position).getWorkmanship());
        name.setText(postInfoArrayList.get(position).getWorker_name());
        image.setImageResource(postInfoArrayList.get(position).getImage());
        description.setText(postInfoArrayList.get(position).getPost_description());
    return root;
    }
}
