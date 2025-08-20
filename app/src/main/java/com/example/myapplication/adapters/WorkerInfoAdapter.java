package com.example.myapplication.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplication.R;
import com.example.myapplication.models.Worker;

import java.util.ArrayList;

public class WorkerInfoAdapter extends BaseAdapter {
    Context context;
    ArrayList<Worker> workerInfoArrayList=new ArrayList<>();
    LayoutInflater infalter;

    public WorkerInfoAdapter(Context context, ArrayList<Worker> workerInfoArrayList) {
        this.context = context;
        this.workerInfoArrayList = workerInfoArrayList;
        infalter=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return workerInfoArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return workerInfoArrayList.get(position).getId();
    }

    @Override
    public long getItemId(int position) {
        return workerInfoArrayList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View root=infalter.inflate(R.layout.list_worker_inforamation, parent, false);
        ImageView workerImage= root.findViewById(R.id.worker_image);
        TextView workerName=root.findViewById(R.id.worker_name);
        workerImage.setImageResource(workerInfoArrayList.get(position).getImage());
        workerName.setText(workerInfoArrayList.get(position).getName());
        return root;
    }
}
