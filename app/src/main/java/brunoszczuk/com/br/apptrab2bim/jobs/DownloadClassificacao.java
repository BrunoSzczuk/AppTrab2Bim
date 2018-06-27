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
        for (int i = 0; i < list.size(); i++){
            list.get(i).getDerrota().setCdEquipe(list.get(i).getCdEquipe());
            list.get(i).getEmpate().setCdEquipe(list.get(i).getCdEquipe());
            list.get(i).getJogos().setCdEquipe(list.get(i).getCdEquipe());
            list.get(i).getPontosGanhos().setCdEquipe(list.get(i).getCdEquipe());
            list.get(i).getVitoria().setCdEquipe(list.get(i).getCdEquipe());

            list.get(i).getVitoria().save();
            list.get(i).getPontosGanhos().save();
            list.get(i).getJogos().save();
            list.get(i).getEmpate().save();
            list.get(i).getDerrota().save();
            list.get(i).save();
        }

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
        Toast.makeText(context,"Classificação atualizada com sucesso",Toast.LENGTH_LONG).show();

    }
}