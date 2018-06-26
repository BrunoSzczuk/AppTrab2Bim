package brunoszczuk.com.br.apptrab2bim.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import brunoszczuk.com.br.apptrab2bim.R;
import brunoszczuk.com.br.apptrab2bim.entity.Equipe;

public class AdapterEquipe extends BaseAdapter {
    List<Equipe> equipeList;
    LayoutInflater inflater;

    public AdapterEquipe(Context context, List<Equipe> equipeList) {
        this.equipeList = equipeList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return equipeList.size();
    }

    @Override
    public Object getItem(int position) {
        return equipeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Equipe p = equipeList.get(position);
        view =  inflater.inflate(R.layout.item_equipe, null);

        ((TextView) view.findViewById(R.id.tvNome)).setText(p.getNmComum());
        ((TextView) view.findViewById(R.id.tvSigla)).setText(p.getSgEquipe());
        Picasso.with(view.getContext()).load(p.getBrEquipe()).into((ImageView)view.findViewById(R.id.ivImagem));
        return view;
    }

    public int getPosition(Equipe p){
        return equipeList.indexOf(p);
    }
}
