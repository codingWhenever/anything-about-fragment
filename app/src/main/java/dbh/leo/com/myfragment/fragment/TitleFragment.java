package dbh.leo.com.myfragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import dbh.leo.com.myfragment.R;

/**
 * title
 * Created by lulei on 2016/4/22.
 */
public class TitleFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "TitleFragment";
    private Button btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView()");
        View view = inflater.inflate(R.layout.fragment_title, container, false);
        btn = (Button) view.findViewById(R.id.btn);
        btn.setOnClickListener(this);
        return view;
    }


    public interface FragmentTitleClickListener {
        void onTitleBtnClick();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn) {
//            ContentFragment contentFragment = new ContentFragment();
//            FragmentManager manager = getFragmentManager();
//            FragmentTransaction transaction = manager.beginTransaction();
//            transaction.replace(R.id.id_content, contentFragment, "content");
//            transaction.addToBackStack("content");
//            transaction.commit();

            if (getActivity() instanceof FragmentTitleClickListener) {
                ((FragmentTitleClickListener) getActivity()).onTitleBtnClick();
            }
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_title, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_fragments:
                Toast.makeText(getActivity(), "click in fragment ---> fragment", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        setHasOptionsMenu(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }
}
