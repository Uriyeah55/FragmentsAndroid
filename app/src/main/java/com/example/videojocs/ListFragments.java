package com.example.videojocs;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListFragments extends Fragment {

    private JocListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)

    {
        View view =inflater.inflate(R.layout.fragment_list, container,false);
        return view;
    }

    public void addListData(final ArrayList<Joc> jocs){

        View view = getView();
        final RecyclerView llistaJocs= view.findViewById(R.id.llistaElement);
        JocsAdapter adapter = new JocsAdapter(jocs);
        llistaJocs.setHasFixedSize(true);
        llistaJocs.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        llistaJocs.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Joc selectedJoc=jocs.get(llistaJocs.getChildAdapterPosition(view));
            listener.onSelectedJoc(selectedJoc);

            }
        });


    }

    public void SetJocListener(JocListener listener){
        this.listener=listener;
    }
}
