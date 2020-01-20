package com.addindev.moviecatalogue.detailmov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.addindev.moviecatalogue.R;
import com.addindev.moviecatalogue.listmov.MovList;
import com.addindev.moviecatalogue.listmov.MovModel;

public class MovDetail extends AppCompatActivity {
    private TextView tvTitle, tvOverview;
    private ImageView imgPoster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mov_detail);

        tvTitle = findViewById(R.id.tvTitle);
        tvOverview = findViewById(R.id.tv_txt_overview);
        imgPoster = findViewById(R.id.img_poster);

        MovModel movieModel = getIntent().getParcelableExtra(MovList.SELECTED_MOVIE);

        tvTitle.setText(movieModel.getTitle());
        tvOverview.setText(movieModel.getOverview());
        imgPoster.setImageResource(movieModel.getPoster());

        setTitle(movieModel.getTitle());


    }
}
