package com.benny.carddemo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.benny.carddemo.widget.StackCardsView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Benny on 2018/2/6.
 */

public class UltraPageAdapter extends PagerAdapter {

    private Context context;

    public UltraPageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LinearLayout linearLayout =(LinearLayout) LayoutInflater.from(container.getContext()).inflate(R.layout.item_vp,null);
        StackCardsView stackCardsView =linearLayout.findViewById(R.id.stack_card_view);

        final CardAdapter cardAdapter =new CardAdapter();

        stackCardsView.setAdapter(cardAdapter);

        stackCardsView.addOnCardSwipedListener(new StackCardsView.OnCardSwipedListener() {
            @Override
            public void onCardDismiss(int direction) {
                cardAdapter.remove(0);
            }

            @Override
            public void onCardScrolled(View view, float progress, int direction) {

            }
        });

        cardAdapter.appendItems(loadData(20));


        container.addView(linearLayout);


        return linearLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        LinearLayout view= (LinearLayout) object;
        container.removeView(view);
    }


    private List<BaseCardItem> loadData(int startIndex) {
        List<BaseCardItem> result = new ArrayList<>();
        for (int i = 0; i <= startIndex; i++) {
            ImageCardItem item = new ImageCardItem(context);
            item.dismissDir = StackCardsView.SWIPE_UP;
            item.fastDismissAllowed = true;
            result.add(item);
        }

        return result;
    }
}
