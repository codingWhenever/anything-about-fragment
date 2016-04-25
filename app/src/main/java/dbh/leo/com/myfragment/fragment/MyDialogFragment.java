package dbh.leo.com.myfragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import dbh.leo.com.myfragment.R;

/**
 * Created by leo on 2016/4/25.
 */
public class MyDialogFragment extends DialogFragment {
    private EditText etName;
    private EditText etPassword;

    public interface OnLoginCompleteListener {
        void onLoginInputComplete(String name, String password);
    }

//    @NonNull
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_login, null);
//        etName = (EditText) view.findViewById(R.id.et_name);
//        etPassword = (EditText) view.findViewById(R.id.et_password);
//
//        builder.setView(view)
//                .setPositiveButton("sign in", new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        OnLoginCompleteListener listener = (OnLoginCompleteListener) getActivity();
//                        listener.onLoginInputComplete(etName.getText().toString(), etPassword.getText().toString());
//                    }
//                })
//                .setNegativeButton("cancel", null);
//
//        return builder.create();
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_name, container, false);
        return view;
    }
}
