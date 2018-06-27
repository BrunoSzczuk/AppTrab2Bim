package brunoszczuk.com.br.apptrab2bim.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import brunoszczuk.com.br.apptrab2bim.R;
import brunoszczuk.com.br.apptrab2bim.entity.Classificacao;
import brunoszczuk.com.br.apptrab2bim.entity.Equipe;

/**
 * Created by Bruno on 26/06/2018.
 */

public class AdapterClassificacao extends BaseAdapter {
    List<Classificacao> list;
    LayoutInflater inflater;

    public AdapterClassificacao(Context context, List<Classificacao> list) {
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.item_classificacao, null);
        if (list == null) return view;
        Classificacao p = list.get(position);
        try{
        if (Equipe.findAll(Equipe.class).hasNext()) {
            Equipe eq = Equipe.find(Equipe.class, "cd_equipe = ?", p.getCdEquipe()).get(0);
            ((TextView) view.findViewById(R.id.tvPosicao)).setText(p.getPos());
            ((TextView) view.findViewById(R.id.tvSigla)).setText(eq.getSgEquipe());
            Picasso.with(view.getContext()).load(eq.getBrEquipe()).into((ImageView) view.findViewById(R.id.ivImagem));
            ((TextView) view.findViewById(R.id.tvGolsPro)).setText(p.getGolsPro() + "");
            ((TextView) view.findViewById(R.id.tvPontosGols)).setText(String.valueOf(p.getGolsContra()));
        }
        }catch(Exception e){
            e.printStackTrace();
        }

        return view;
    }

    public int getPosition(Classificacao p){
        return list.indexOf(p);
    }
}
