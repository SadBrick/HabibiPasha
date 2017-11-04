package com.habibipasha.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.habibipasha.R;
import com.habibipasha.models.Restepti;

import java.util.ArrayList;

public class RetseptiAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Restepti> objects;

    public RetseptiAdapter(Context context, ArrayList<Restepti> objects) {
        this.context = context;
        this.objects = objects;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null){
            view = layoutInflater.inflate(R.layout.li_main, parent, false);
        }

        final Restepti restepti = objects.get(position);
        ((TextView) view.findViewById(R.id.tvName)).setText(restepti.getName());
        ((TextView) view.findViewById(R.id.tvChashka)).setText(restepti.getChashka());
        ((TextView) view.findViewById(R.id.tvTabak)).setText(restepti.getTabak());
        ((TextView) view.findViewById(R.id.tvJidkost)).setText(restepti.getJidkosti());

        return view;
    }
}
