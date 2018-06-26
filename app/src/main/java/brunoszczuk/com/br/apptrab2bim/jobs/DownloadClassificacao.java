package brunoszczuk.com.br.apptrab2bim.jobs;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import brunoszczuk.com.br.apptrab2bim.R;
import brunoszczuk.com.br.apptrab2bim.entity.Classificacao;
import brunoszczuk.com.br.apptrab2bim.entity.Equipe;
import brunoszczuk.com.br.apptrab2bim.util.WSUtil;

public class DownloadClassificacao extends AsyncTask<String, String, ArrayList<String>> {
        private ProgressDialog progress;
        private Context context;

        private final static String URL = "http://54.233.136.203:8080/WSIntegraBolao/funcoes";
        private final static String NAMESPACE = "http://ws.wsintegrabolao.com.br/";
        public DownloadClassificacao(Context context) {
            this.context = context;
    }

        @Override
        protected void onPreExecute () {
        super.onPreExecute();
        progress = new ProgressDialog(context);
        progress.setTitle("Download de Equipes");
        progress.setMessage("Aguarde Baixando registros de Classificacao...");
        progress.setIcon(R.drawable.ic_launcher_background);
        progress.setCancelable(false);
        progress.show();
    }

        @Override
        protected ArrayList<String> doInBackground (String...strings){

        String classificacaoList = WSUtil.consomeWS(URL, "getClassificacaoList", null, NAMESPACE);
        Type type = new TypeToken<List<Classificacao>>() {}.getType();
        List<Classificacao> list = new Gson().fromJson(classificacaoList, type);
        Classificacao.saveInTx(list);

        return null;
    }

        @Override
        protected void onProgressUpdate (String...values){
        super.onProgressUpdate(values);
    }

        @Override
        protected void onPostExecute (ArrayList < String > strings) {
        super.onPostExecute(strings);
        progress.setIndeterminate(false);
        progress.cancel();
    }
    }