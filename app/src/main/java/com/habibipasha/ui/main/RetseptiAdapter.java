package com.habibipasha.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.habibipasha.R;
import com.habibipasha.models.Restepti;

import java.util.ArrayList;

public class RetseptiAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Restepti> objects;
    MainPresenter presenter;

    public RetseptiAdapter(Context context, ArrayList<Restepti> objects, MainPresenter presenter) {
        this.context = context;
        this.objects = objects;
        this.presenter = presenter;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return objects.get(position).getId();
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null){
            view = layoutInflater.inflate(R.layout.li_main, parent, false);
        }

        final Restepti restepti = objects.get(position);
        ((TextView) view.findViewById(R.id.tvName)).setText(restepti.getName());
        ((TextView) view.findViewById(R.id.tvChashka)).setText(restepti.getChashka());
        ((TextView) view.findViewById(R.id.tvTabak)).setText(restepti.getTabak());
        ((TextView) view.findViewById(R.id.tvJidkost)).setText(restepti.getJidkosti());

        ((CheckBox) view.findViewById(R.id.checkBox)).setChecked(restepti.isFavorite());
        ((CheckBox) view.findViewById(R.id.checkBox)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.changeFavorit(restepti.getId(), ((CheckBox) v).isChecked());
                Toast.makeText(context, "check = " + restepti.getName(), Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}
