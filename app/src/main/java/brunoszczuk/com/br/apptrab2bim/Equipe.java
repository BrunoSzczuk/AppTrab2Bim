package brunoszczuk.com.br.apptrab2bim;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

import brunoszczuk.com.br.apptrab2bim.adapter.AdapterEquipe;
import brunoszczuk.com.br.apptrab2bim.jobs.DownloadEquipe;

public class Equipe extends AppCompatActivity {


    Button btDownloadEquipe, btAtt;
    ListView lvLista;
    AdapterEquipe adapterEquipe;
    List<brunoszczuk.com.br.apptrab2bim.entity.Equipe> equipes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btDownloadEquipe = findViewById(R.id.btDownloadEquipe);
        lvLista = findViewById(R.id.lvLista);
        btAtt = findViewById(R.id.btAtt);
        btDownloadEquipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownloadEquipe downloadEquipe = new
                        DownloadEquipe(Equipe.this);
                downloadEquipe.executeOnExecutor
                        (AsyncTask.THREAD_POOL_EXECUTOR, new String[]{});
            }
        });
        carregaLista();
        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Equipe.this, Time.class);
                Bundle bundle = new Bundle();
                bundle.putString("cdEquipe", ((brunoszczuk.com.br.apptrab2bim.entity.Equipe)lvLista.getItemAtPosition(i)).getCdEquipe()+ "");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btAtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carregaLista();
            }
        });
    }

    private void carregaLista() {
        equipes = brunoszczuk.com.br.apptrab2bim.entity.Equipe.listAll(brunoszczuk.com.br.apptrab2bim.entity.Equipe.class);
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
