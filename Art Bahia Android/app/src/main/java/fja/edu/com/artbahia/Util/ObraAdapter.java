package fja.edu.com.artbahia.Util;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;
import fja.edu.com.artbahia.Models.ObraDTO;
import fja.edu.com.artbahia.R;
import fja.edu.com.artbahia.Repositories.ObraRepository;

import static fja.edu.com.artbahia.Util.Utilidades.GetCategoria;

public class ObraAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<ObraDTO> obras;

    public ObraAdapter(Activity activity, List<ObraDTO> obras) {
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.obras = obras;
    }

    @Override
    public int getCount() {
        return obras.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View viewLinha = layoutInflater.inflate(R.layout.obra_viewitem,null);
        final ObraDTO obra = obras.get(position);

        TextView titulo = viewLinha.findViewById(R.id.obraView_Titulo);
        TextView tipo = viewLinha.findViewById(R.id.obraView_Tipo);
        TextView curtidas = viewLinha.findViewById(R.id.obraView_Curtidas);

        Button btnCurtir = (Button)viewLinha.findViewById(R.id.obraView_btn_Curtir);

        titulo.setText(obra.Id + " - " + obra.Titulo);
        tipo.setText("Tipo: " + GetCategoria(obra.Tipo));
        curtidas.setText("Curtidas: " + obra.Curtidas);

        //Evento dos Botões
        btnCurtir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObraRepository.Curtir(obra.Id);
                notifyDataSetChanged();
            }
        });

        return viewLinha;
    }
}
