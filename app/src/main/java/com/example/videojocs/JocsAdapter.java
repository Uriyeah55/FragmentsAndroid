package com.example.videojocs;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


class JocsAdapter extends RecyclerView.Adapter<JocsAdapter.ViewHolder> implements View.OnClickListener {

    private ArrayList<Joc> jocs;
    private View.OnClickListener listener;

    public JocsAdapter(ArrayList<Joc> jocs)
    {
        this.jocs=jocs;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView lblName;
        TextView lblJugadors;
        ImageView imgJoc;

        public ViewHolder(@NonNull View item) {
            super(item);
            lblName= item.findViewById(R.id.lblnom);
            lblJugadors= item.findViewById(R.id.numJugadors);
            imgJoc= item.findViewById(R.id.ImgPlanet);
        }

        void bindJoc(Joc joc){
            lblName.setText(joc.getNom());
            lblJugadors.setText("Jugadors: " + joc.getJugadors());
            imgJoc.setImageResource(joc.getImatge());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View item=LayoutInflater.from(parent.getContext()).
                inflate(R.layout.joc_layout, parent, false);

        item.setOnClickListener(this);
        return new ViewHolder(item);
    }
    public void onBindViewHolder(ViewHolder holder, int position){
        holder.bindJoc(jocs.get(position));
    }

    public int getItemCount(){
        return jocs.size();
    }
    public void setOnClickListener(View.OnClickListener listener){
this.listener=listener;
    }

    @Override
    public void onClick(View view){
    if(listener !=null){
        listener.onClick(view);
        }
    }
}
