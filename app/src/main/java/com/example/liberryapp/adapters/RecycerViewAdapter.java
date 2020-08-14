package com.example.liberryapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.liberryapp.R;

import java.util.ArrayList;

public class RecycerViewAdapter extends  RecyclerView.Adapter<RecycerViewAdapter.ViewHolder>{
    private static final String TAG = "RecycerViewAdapter";

    private ArrayList<String> mbookNames = new ArrayList<>();
    private Context mContext;

    public RecycerViewAdapter(Context mContext, ArrayList<String> mbookNames) {
        this.mbookNames = mbookNames;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        holder.booksName.setText(mbookNames.get(position));
        holder.parentLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d(TAG, "onLongClick: clicked on: "+ mbookNames.get(position));

                Toast.makeText(mContext, mbookNames.get(position), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mbookNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView booksName;
        private RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            booksName = itemView.findViewById(R.id.recycler_text);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

//    public interface OnBookListner{
//        void onBookClick(int position);
//    }
}
