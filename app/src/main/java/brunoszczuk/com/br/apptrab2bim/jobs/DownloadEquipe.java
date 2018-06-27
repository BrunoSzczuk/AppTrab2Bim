package brunoszczuk.com.br.apptrab2bim.jobs;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import brunoszczuk.com.br.apptrab2bim.R;
import brunoszczuk.com.br.apptrab2bim.entity.Equipe;
import brunoszczuk.com.br.apptrab2bim.util.WSUtil;

public class DownloadEquipe extends AsyncTask<String, String, ArrayList<String>> {
    private ProgressDialog progress;
    private Context context;

    private final static String URL = "http://54.233.136.203:8080/WSIntegraBolao/funcoes";
    private final static String NAMESPACE = "http://ws.wsintegrabolao.com.br/";
    public DownloadEquipe(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progress = new ProgressDialog(context);
        progress.setTitle("Download de Equipes");
        progress.setMessage("Aguarde Baixando registros de Equipes...");
        progress.setIcon(R.drawable.ic_launcher_background);
        progress.setCancelable(false);
        progress.show();
    }

    @Override
    protected ArrayList<String> doInBackground(String... strings) {

        String equipeListGson = WSUtil.consomeWS(URL, "getEquipeList", null,NAMESPACE);
        Type typeEquipe = new TypeToken<List<Equipe>>(){}.getType();
        List<Equipe> equipeList = new Gson().fromJson(equipeListGson, typeEquipe);
        Equipe.saveInTx(equipeList);

        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(ArrayList<String> strings) {
        super.onPostExecute(strings);
        progress.setIndeterminate(false);
        progress.cancel();
        Toast.makeText(context,"Equipes baixadas com sucesso",Toast.LENGTH_LONG).show();
    }
}
