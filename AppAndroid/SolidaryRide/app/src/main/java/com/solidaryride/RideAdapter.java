package com.solidaryride;

import android.app.AppComponentFactory;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.solidaryride.dominio.entidades.Carona;

import java.util.List;

public class RideAdapter extends RecyclerView.Adapter<RideAdapter.ViewHolderRide> {

    private List<Carona> dados;

    public RideAdapter(List<Carona> dados){
        this.dados = dados;
    }

    @Override
    public RideAdapter.ViewHolderRide onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.linha_rides, parent, false);
        ViewHolderRide holderRide = new ViewHolderRide(view, parent.getContext());
        return holderRide;
    }

    @Override
    public void onBindViewHolder(RideAdapter.ViewHolderRide holder, int position) {
        if((dados!=null)&&(dados.size()>0)) {
            Carona carona = dados.get(position);

            holder.txtNome.setText(carona.getName());
            holder.txtNumber.setText(carona.getNumber());
            }
        }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class ViewHolderRide extends RecyclerView.ViewHolder{

        public TextView txtNome;
        public TextView txtNumber;

        public ViewHolderRide(View itemView, final Context context) {
            super(itemView);
            txtNome = (TextView)itemView.findViewById(R.id.txtNome);
            txtNumber = (TextView)itemView.findViewById(R.id.txtNumero);

            itemView.setOnClickListener(new  View.OnClickListener(){

                @Override
                public void onClick(View v) {

                    if (dados.size() > 0) {
                        Carona carona = dados.get(getLayoutPosition());
                        Intent it = new Intent(context, ActRide.class);
                        it.putExtra("RIDE", carona);
                        ((AppCompatActivity) context).startActivityForResult(it, 0);
                    }
                }
            });
        }

    }
}
