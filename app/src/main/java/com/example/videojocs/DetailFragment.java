package com.example.videojocs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)

    {
        View view =inflater.inflate(R.layout.fragment_detail, container,false);
        return view;
    }
 public void fillData(Joc joc){

        View view =getView();
     TextView labelSelected = view.findViewById(R.id.labelSelected);
     ImageView imgSelected =view.findViewById(R.id.ImgSelected);

     labelSelected.setText(joc.getNom());
     imgSelected.setImageResource(joc.getImatge());
 }
}
