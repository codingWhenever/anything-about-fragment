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
public class AnotherFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "AnotherFragment";
    private Button btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_another, container, false);
        btn = (Button) view.findViewById(R.id.btn);
        btn.setOnClickListener(this);
        return view;
    }

    private AnotherFragmentClickListener mListener;

    public interface AnotherFragmentClickListener {
        void onAnotherClick();
    }

    public void setAnotherClickListener(AnotherFragmentClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public void onClick(View v) {
//        if (v.getId() == R.id.btn) {
//            Toast.makeText(getActivity(), "I am another fragment", Toast.LENGTH_SHORT).show();
//        }
        if (mListener != null) {
            mListener.onAnotherClick();
        }
    }
}
