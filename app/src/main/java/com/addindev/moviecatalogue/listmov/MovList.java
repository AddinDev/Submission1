package com.addindev.moviecatalogue.listmov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.addindev.moviecatalogue.R;
import com.addindev.moviecatalogue.detailmov.MovDetail;

import java.util.ArrayList;

public class MovList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovListAdapter mAdapter;

    private ArrayList<MovModel> modelList = new ArrayList<>();
    public static final String SELECTED_MOVIE = "selected_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mov_list);
        findViews();
        setAdapter();
    }

    private void findViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }

    private void setAdapter() {

        modelList.add(new MovModel(getResources().getString(R.string.terminator), getString(R.string.ov_terminator),R.drawable.poster_terminator));
        modelList.add(new MovModel(getResources().getString(R.string.maleficent), getString(R.string.ov_maleficent),R.drawable.poster_maleficent));
        modelList.add(new MovModel(getResources().getString(R.string.joker), getString(R.string.ov_joker),R.drawable.poster_joker));
        modelList.add(new MovModel(getResources().getString(R.string.bohemian), getString(R.string.ov_bohemian),R.drawable.poster_bohemian));
        modelList.add(new MovModel(getResources().getString(R.string.bumblebee), getString(R.string.ov_bumblebee),R.drawable.poster_bumblebee));
        modelList.add(new MovModel(getResources().getString(R.string.creed), getString(R.string.ov_creed),R.drawable.poster_creed));
        modelList.add(new MovModel(getResources().getString(R.string.deadpool), getString(R.string.ov_deadpool),R.drawable.poster_deadpool));
        modelList.add(new MovModel(getResources().getString(R.string.dragonball), getString(R.string.ov_dragonball),R.drawable.poster_dragonball));
        modelList.add(new MovModel(getResources().getString(R.string.venom), getString(R.string.ov_venom),R.drawable.poster_venom));
        modelList.add(new MovModel(getResources().getString(R.string.premanpensiun), getString(R.string.ov_premanpensiun),R.drawable.poster_preman));
        modelList.add(new MovModel(getResources().getString(R.string.aquaman), getString(R.string.ov_aquaman),R.drawable.poster_aquaman));
        modelList.add(new MovModel(getResources().getString(R.string.avenger), getString(R.string.ov_avenger),R.drawable.poster_avengerinfinity));
        modelList.add(new MovModel(getResources().getString(R.string.birdbox), getString(R.string.ov_birdbox),R.drawable.poster_birdbox));





        mAdapter = new MovListAdapter(MovList.this, modelList);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(mAdapter);

        mAdapter.SetOnItemClickListener(new MovListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, MovModel model) {
                Intent goToDetailMovie = new Intent(MovList.this, MovDetail.class);
                goToDetailMovie.putExtra(MovList.SELECTED_MOVIE,model);
                startActivity(goToDetailMovie);
            }
        });

    }

}
