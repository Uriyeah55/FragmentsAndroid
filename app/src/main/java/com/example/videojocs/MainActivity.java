package com.example.videojocs;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements JocListener{
    private FragmentManager mgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final ArrayList<Joc> videojocs=getVideojocs();


        mgr=getSupportFragmentManager();
        ListFragments listFragment = (ListFragments) mgr.findFragmentById(R.id.FrgList);
        listFragment.SetJocListener(this);

        listFragment.addListData(videojocs);

/*
        final RecyclerView llistaJocs= findViewById(R.id.llistaElement);
        JocsAdapter adapter = new JocsAdapter(videojocs);
        llistaJocs.setHasFixedSize(true);
        llistaJocs.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        llistaJocs.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                TextView labelSelected = findViewById(R.id.labelSelected);
                ImageView imgSelected =findViewById(R.id.ImgSelected);

                Joc selectedjoc=videojocs.get(llistaJocs.getChildAdapterPosition(view));
                labelSelected.setText(selectedjoc.getNom());
                imgSelected.setImageResource(selectedjoc.getImatge());

                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra(DetailActivity.JOC_EXTRA, selectedjoc);
                startActivity(intent);
            }
        });
        */

/*
        llistaJocs.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Joc joc = videojocs[i];

                TextView labelSelected = findViewById(R.id.labelSelected);
                labelSelected.setText(joc.getNom());
                ImageView imgSelected =findViewById(R.id.ImgSelected);

                imgSelected.setImageResource(joc.getImatge());
            }
        });
        */

    }

    @Override
    public void onSelectedJoc(Joc joc) {

        DetailFragment detailFragment = (DetailFragment) mgr.findFragmentById(R.id.FrgDetail);
        if(detailFragment==null){ //versio movil
            Intent intent = new Intent(this,DetailActivity.class);
            intent.putExtra(DetailActivity.JOC_EXTRA, joc);
            startActivity(intent);
        }else{ //versio tablet
            detailFragment.fillData(joc);
        }
    }


    private ArrayList<Joc> getVideojocs()
    {
        ArrayList<Joc> jocs= new ArrayList<Joc>();
        jocs.add(new Joc("The Evil Within", 8, R.drawable.theevil));
                 jocs.add(new Joc("League of Legends", 10, R.drawable.lol));
                jocs.add(new Joc("Outlast", 1000, R.drawable.outlast));
                jocs.add(new Joc("Star Wars: Battlefront II", 100, R.drawable.starw));
                jocs.add(new Joc("Persona 4", 20, R.drawable.persona4));
                jocs.add(new Joc("Candy Crush", 1, R.drawable.raft));
                jocs.add(new Joc("Clash Of Clans", 2, R.drawable.raft));
                jocs.add(new Joc("Clash Royale", 4, R.drawable.outlast));
        return jocs;
    }
}
