package brunoszczuk.com.br.apptrab2bim;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import brunoszczuk.com.br.apptrab2bim.adapter.AdapterEquipe;
import brunoszczuk.com.br.apptrab2bim.entity.Equipe;

public class Time extends AppCompatActivity {



    TextView tvCdEquipe, tvNmEquipe, tvSgEquipe, tvNmSlug;
    ImageView ivImagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvCdEquipe = findViewById(R.id.tvCdEquipe);
        tvNmEquipe = findViewById(R.id.tvNmEquipe);
        tvSgEquipe = findViewById(R.id.tvSgEquipe);
        tvNmSlug = findViewById(R.id.tvNmSlug);
        ivImagem = findViewById(R.id.ivImagem);
        Intent intent = getIntent();
        carregaEquipe(intent.getExtras().getString("cdEquipe"));

    }



    private void carregaEquipe(String cdEquipe) {
        Equipe e = Equipe.find(Equipe.class,"cd_equipe = ?",cdEquipe).get(0);
        if (e != null){
            tvCdEquipe.setText(e.getCdEquipe() + "");
            tvNmEquipe.setText(e.getNmComum());
            tvSgEquipe.setText(e.getSgEquipe());
            tvNmSlug.setText(e.getNmSlug());
            Picasso.with(getApplicationContext()).load(e.getBrEquipe()).into(ivImagem);

        }

    }
}
