package com.example.quanlyts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NhanVienAdapter extends BaseAdapter {
    private ActivityNhanVien context;
    private int layout;
    private List<NhanVien> nhanViens;

    public NhanVienAdapter(ActivityNhanVien context, int layout, List<NhanVien> listNhanvien) {
        this.context = context;
        this.layout = layout;
        this.nhanViens = listNhanvien;
    }

    private class ViewHolder{
        TextView maNV;
        TextView tvTenNV, tvDiaChiNV, tvDienThoaiNV;
    }
    @Override
    public int getCount() {
        return nhanViens.size();
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
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.maNV =  (TextView) view.findViewById(R.id.tv_MaNV);
            holder.tvTenNV = (TextView) view.findViewById(R.id.tv_TenNV);
            holder.tvDiaChiNV = (TextView) view.findViewById(R.id.tv_DiaChiNV);
            holder.tvDienThoaiNV = (TextView) view.findViewById(R.id.tv_DienThoaiNV);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        final NhanVien nhanVien = nhanViens.get(i);
        holder.maNV.setText(nhanVien.maNV);
        holder.tvTenNV.setText(nhanVien.tenNV);
        holder.tvDiaChiNV.setText(nhanVien.diaChi);
        holder.tvDienThoaiNV.setText(nhanVien.soDT);
        return view;
    }
}
