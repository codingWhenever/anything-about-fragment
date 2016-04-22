package dbh.leo.com.myfragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import dbh.leo.com.myfragment.R;

/**
 * Created by lulei on 2016/4/22.
 */
public class ContentFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "ContentFragment";
    private Button btn;


    private ContentFragmentClickListener mListener;

    public interface ContentFragmentClickListener {
        void onContentClick();
    }

    public void setContentClcikListener(ContentFragmentClickListener listener) {
        this.mListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        btn = (Button) view.findViewById(R.id.btn);
        btn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn) {
//            AnotherFragment anotherFragment = new AnotherFragment();
//            FragmentManager manager = getFragmentManager();
//            FragmentTransaction transition = manager.beginTransaction();
//            //使用hide而不是replace视图将不会重绘
//            //当back回来的时候，之前数据将会保留
//            transition.hide(this);
//            transition.add(R.id.id_content, anotherFragment, "another");
//            transition.addToBackStack("another");
//            transition.commit();

            if (this.mListener != null) {
                mListener.onContentClick();
            }
        }
    }
}
