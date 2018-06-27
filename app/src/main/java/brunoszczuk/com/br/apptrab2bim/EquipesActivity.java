package brunoszczuk.com.br.apptrab2bim;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

import brunoszczuk.com.br.apptrab2bim.adapter.AdapterEquipe;
import brunoszczuk.com.br.apptrab2bim.entity.Equipe;
import brunoszczuk.com.br.apptrab2bim.jobs.DownloadEquipe;

public class EquipesActivity extends AppCompatActivity {


    Button btDownloadEquipe;
    ListView lvLista;
    AdapterEquipe adapterEquipe;
    List<Equipe> equipes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btDownloadEquipe = findViewById(R.id.btDownloadEquipe);
        lvLista = findViewById(R.id.lvLista);

        btDownloadEquipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownloadEquipe downloadEquipe = new
                        DownloadEquipe(EquipesActivity.this);
                downloadEquipe.executeOnExecutor
                        (AsyncTask.THREAD_POOL_EXECUTOR, new String[]{});
            }
        });
        carregaLista();
    }

    private void carregaLista() {
        equipes = Equipe.listAll(Equipe.class);
        adapterEquipe = new AdapterEquipe(this,equipes);
        lvLista.setAdapter(adapterEquipe);
        calculaTamanhoAdapater();
    }

    private void calculaTamanhoAdapater(){
        int totalHeight =0;
        ListAdapter adapter = lvLista.getAdapter();
        int length = adapter.getCount();
        for (int i =0; i< length; i++){
            View listView = adapter.getView(i, null, lvLista);
            listView.measure(0,0);
            totalHeight+= listView.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = lvLista.getLayoutParams();
        params.height = totalHeight + (lvLista.getDividerHeight() * (adapter.getCount() -1) +10);
        lvLista.setLayoutParams(params);
        lvLista.requestLayout();
    }
}
