package com.example.androidmvc.llistView;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidmvc.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mDatas;

    public ListAdapter(Context context, List<String> datas) {
        this.mContext = context;
        mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.activity_list, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        /*if(mDatas != null && mDatas.size() > position) {
            GameRankingItemBean bean = mDatas.get(position);
            if(bean == null)
                return ;

            GlideUtil.loadCircleImage(mContext, bean.getHead_image(), holder.imgvAvatar, R.drawable.ic_head_loading, R.drawable.ic_head_loading);
            int gold = bean.getAgold();
            holder.tvGold.setText(gold >= 10000 ? gold / 1000 + "." + Math.min(9, (int) Math.ceil((gold % 1000) / 100f)) + "k" : gold + "");
            holder.tvName.setText(bean.getNickname());
            TextView tvRanking = holder.tvRanking;

            if(position == 0 || position == 1 || position == 2) {
                tvRanking.setText("");
                tvRanking.setBackground(ContextCompat.getDrawable(mContext, getRankImage(position)));
            } else {
                tvRanking.setBackground(null);
                tvRanking.setText(String.valueOf(position + 1));
            }
            holder.clRanking.setBackgroundColor(ContextCompat.getColor(App.getInstance(), position % 2 == 0 ?  R.color.cfff8e8 : R.color.common_white));
        }*/
    }

    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    private int getRankImage(int pos) {
//        switch(pos) {
//            case 1:
//                return R.drawable.ic_poker_rank_2;
//            case 2:
//                return R.drawable.ic_poker_rank_3;
//            default:
//                return R.drawable.ic_poker_rank_1;
//        }
        return 0;
    }
    
    class ViewHolder extends RecyclerView.ViewHolder {
        
        public ConstraintLayout clRanking;
        public ImageView imgvAvatar;
        public TextView tvRanking;
        public TextView tvGold;
        public TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
//            clRanking = itemView.findViewById(R.id.cl_poker_ranking);
//            imgvAvatar = itemView.findViewById(R.id.imgv_avatar);
//            tvRanking = itemView.findViewById(R.id.tv_dino_ranking);
//            tvGold = itemView.findViewById(R.id.tv_ranking_gold);
//            tvName = itemView.findViewById(R.id.tv_dino_username);
        }
    }

    public static class GameRankSpace extends RecyclerView.ItemDecoration {

        /**
         * 水平边距
         */
        private int hSpace;

        /**
         * 垂直距离
         */
        private int vSpace;

        public GameRankSpace(Context context) {
            if (context == null)
                return;
//            this.hSpace = context.getResources().getDimensionPixelSize(R.dimen.dino_game_rank_h_space);
//            this.vSpace = context.getResources().getDimensionPixelSize(R.dimen.dino_game_rank_v_space);
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = hSpace;
            outRect.top = vSpace;
            outRect.right = hSpace;
            outRect.bottom = vSpace;
        }
    }

}
