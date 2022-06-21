package com.zedr.dhaivat.businessgrowth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class ResepAdapter extends RecyclerView.Adapter<ResepAdapter.ResepHolder> {
    private String mJudul[];
    //private String mLangkah[];
    private ResepListener mListener;
    public ResepAdapter(String[] titleresep, ResepListener listener){
        mJudul = titleresep;
        //mLangkah = langkah;
        mListener = listener;
    }
    interface ResepListener{
        void onClick(int position);
    }
    @Override
    public ResepHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.list_resep, parent, false);
        return new ResepHolder(view);
    }

    @Override
    public void onBindViewHolder(ResepHolder holder, int position) {
        String judul = mJudul[position];
        //String langkah = mLangkah[position];
        holder.setResep(judul);
    }

    @Override
    public int getItemCount() {
        return mJudul.length;
    }
    public String getJudul(int position){
        return mJudul[position];
    }

    public class ResepHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textView1;
        private TextView textView2;
        public ResepHolder(View itemView) {
            super(itemView);
            textView1 = (TextView) itemView.findViewById(R.id.titleresep);
            //textView2 = (TextView) itemView.findViewById(R.id.langkah);
            itemView.setOnClickListener(this);
        }
        public void setResep(String judul){
            textView1.setText(judul);
            //textView2.setText(ket);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(getAdapterPosition());
        }
    }
}