package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.myapplication.R;
import com.example.myapplication.adapters.PostInfoAdapter;
import com.example.myapplication.adapters.WorkerInfoAdapter;
import com.example.myapplication.models.Post;
import com.example.myapplication.models.Worker;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    GridView gv;
    ListView lv;
    WorkerInfoAdapter adapter;
    PostInfoAdapter adapter2;
    ArrayList<Worker> workers;
    ImageView profileIcon;
    ImageView logoutIcon;
    ArrayList<Post> posts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);
        profileIcon=findViewById(R.id.profile);
        logoutIcon=findViewById(R.id.logout);
        logoutIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListViewActivity.this, Login.class);
                startActivity(intent);
            }
        });
        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListViewActivity.this, Setting.class);
                startActivity(intent);
            }
        });
        gv=findViewById(R.id.workers);
        lv=findViewById(R.id.posts);
        workers=new ArrayList<>();
       posts=new ArrayList<>();
       posts.add(new Post(1,"blacksmith","gaza",R.drawable.girl,"Ahmed kh","I am applying for the position in the blacksmithing field, as I have the skills and experience required for this job."));
        posts.add(new Post(2,"blacksmith","Deir_el_balah",R.drawable.girl,"yaseen kh","I am applying for the position in the blacksmithing field, as I have the skills and experience required for this job."));

        workers.add(new Worker(1,R.drawable.girl,"asmaa"));
        workers.add(new Worker(2,R.drawable.girl,"hadil"));
        workers.add(new Worker(3,R.drawable.girl,"asil"));
        workers.add(new Worker(4,R.drawable.girl,"malak"));
        workers.add(new Worker(5,R.drawable.girl,"layan"));
        workers.add(new Worker(6,R.drawable.girl,"byan"));

        adapter=new WorkerInfoAdapter(ListViewActivity.this,workers);
        adapter2=new PostInfoAdapter(ListViewActivity.this,posts);
        gv.setAdapter(adapter);
        lv.setAdapter(adapter2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}