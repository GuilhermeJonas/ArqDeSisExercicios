package com.usjt.guilherme.caixaeletronico.caixaeletronico.model;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas_000 on 05/11/2016.
 */
public class ExtratoAdapter extends BaseAdapter{

    public void updateExtratoList(List<Extrato> newlist) {
        List<Extrato> extrato = new ArrayList<>();
        extrato.addAll(newlist);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
