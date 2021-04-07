package com.telkom.smartlogistic.ui.order;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.telkom.smartlogistic.R;
import com.telkom.smartlogistic.models.PortModel;

import java.util.ArrayList;
import java.util.List;

public class PortRecyclerView extends RecyclerView.Adapter<PortRecyclerView.ViewHolder> implements Filterable {
    List<PortModel> portsList;
    List<PortModel> portsListAll;

    public PortRecyclerView(List<PortModel> portsList) {
        this.portsList = portsList;
        portsListAll = new ArrayList<>();
        portsListAll.addAll(portsListAll);
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rv_item_port, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvName, tvCity, tvProvince, tvCountry;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_port_name);
            tvCity = itemView.findViewById(R.id.tv_port_city);
            tvProvince = itemView.findViewById(R.id.tv_port_province);
            tvCountry = itemView.findViewById(R.id.tv_port_country);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
