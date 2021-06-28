package com.example.videojocs;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class DetailActivity extends AppCompatActivity {
    public static final String JOC_EXTRA="joc";

    @Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);
    //joc seleccionat
    Joc joc = (Joc) getIntent().getSerializableExtra(JOC_EXTRA);


        FragmentManager mgr=getSupportFragmentManager();
        DetailFragment detailFragment = (DetailFragment) mgr.findFragmentById(R.id.FrgDetail);
        detailFragment.fillData(joc);
    }


}
