package ge.edu.freeuni.asignment3.ui.textediting;

/*
 * created by tgeldiashvili on 5/10/2019
 */

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import ge.edu.freeuni.asignment3.R;

public class SaveFileDialogFragment extends DialogFragment {

    public interface NoticeDialogListener {
        void onDialogPositiveClick(DialogFragment dialog, String name);

        void onDialogNegativeClick(DialogFragment dialog);
    }

    NoticeDialogListener listener;
    private static final String ARG_FILENAME = "filename";

    public static SaveFileDialogFragment newInstance(String filename) {
        Bundle args = new Bundle();
        args.putString(ARG_FILENAME, filename);
        SaveFileDialogFragment fragment = new SaveFileDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private String filename;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        filename = getArguments().getString(ARG_FILENAME);
        listener = (NoticeDialogListener) getContext();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final View view = requireActivity().getLayoutInflater().inflate(R.layout.dialog_save_file, null);
        EditText etFilename = view.findViewById(R.id.et_file_name);
        etFilename.setText(filename);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view)
                .setMessage(R.string.dilaog_save_file)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        listener.onDialogPositiveClick(SaveFileDialogFragment.this, ((EditText) view.findViewById(R.id.et_file_name)).getText().toString());
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        listener.onDialogNegativeClick(SaveFileDialogFragment.this);
                    }
                });
        return builder.create();
    }
}
