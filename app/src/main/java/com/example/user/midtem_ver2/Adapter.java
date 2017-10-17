package com.example.user.midtem_ver2;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by USER on 2017-10-07.
 */

public class Adapter extends PagerAdapter {
    private LayoutInflater inflater;
    private Context context;

    private int[] images = new int[]{
            R.drawable.danggu,
            R.drawable.diy,
            R.drawable.song,
            R.drawable.shopping,
            R.drawable.sleep,
            R.drawable.food
    };
    public Adapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.slider, container, false);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        imageView.setImageResource(images[position]);
        textView.setText((position + 1 ) + "번째 관심사입니다.");
        container.addView(v);
        return v;
    }
    public void destoryItem(ViewGroup container, int position, Object object ){
//        container.invalidate();
        container.removeView((View)object);
        Log.i("Debug", "detroy image");
    }
}
// 0. Main3Activity와 함께 이용
// 1. 해당 레이아웃에 다른 xml을 띄우는 기능인 inflater을 만든다.
// 2. images배열을 만들어와 img를 넣어 준다.
// 3. count를 해줘 이미지의 개수를 세어준다.
// 4. 이미지를 linearLayout의 형태로 해준다.
// 5. 이미지와 텍스트를 정의해주는 메소드를 만든다.
// 6. 파괴해주는 메소드도 만든다.