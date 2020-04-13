package com.example.pablo.view.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pablo.R;
import com.example.pablo.model.hands.PokerHand;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlayerLastPokerHandsListAdapter extends RecyclerView.Adapter<PlayerLastPokerHandsListAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<PokerHand> pokerHands;

    public PlayerLastPokerHandsListAdapter(Context mContext, ArrayList<PokerHand> pokerHands) {
        this.mContext = mContext;
        this.pokerHands = new ArrayList<>(pokerHands);
    }

    public void updatePokerHands(ArrayList<PokerHand> pokerHands) {
        this.pokerHands = new ArrayList<>(pokerHands);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.player_last_called_poker_hand_item,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int adapterPosition = holder.getAdapterPosition();
        holder.pokerHandView.setText(pokerHands.get(adapterPosition).toString());
        if (adapterPosition == pokerHands.size() - 1) {
            holder.dividerView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return pokerHands.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView pokerHandView;
        private View dividerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pokerHandView = itemView.findViewById(R.id.pokerHandView);
            dividerView = itemView.findViewById(R.id.dividerView);
        }
    }
}
