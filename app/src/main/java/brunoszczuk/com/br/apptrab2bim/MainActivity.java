package brunoszczuk.com.br.apptrab2bim;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.orm.SugarContext;

import java.util.List;

import brunoszczuk.com.br.apptrab2bim.adapter.AdapterEquipe;
import brunoszczuk.com.br.apptrab2bim.entity.Classificacao;
import brunoszczuk.com.br.apptrab2bim.entity.Equipe;
import brunoszczuk.com.br.apptrab2bim.jobs.DownloadClassificacao;
import brunoszczuk.com.br.apptrab2bim.jobs.DownloadEquipe;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    List<Classificacao> classificacaoList;
    Button btDownloadClassificacao;
    ListView lvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SugarContext.init(this);//Instancia o Sugar

        btDownloadClassificacao = findViewById(R.id.btDownloadClassificacao);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        btDownloadClassificacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownloadClassificacao download = new
                        DownloadClassificacao(MainActivity.this);
                download.executeOnExecutor
                        (AsyncTask.THREAD_POOL_EXECUTOR, new String[]{});
            }
        });
    }



    private void carregaLista() {
        classificacaoList = Classificacao.listAll(Classificacao.class);
        /*adapterEquipe = new AdapterEquipe(this,equipes);
        lvLista.setAdapter(adapterEquipe);*/
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
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent = new Intent(this, EquipeActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
