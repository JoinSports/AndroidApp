package org.joinsports.joinsports;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.joinsports.joinsports.R;
import org.joinsports.joinsports.utils.CustomFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateUserFragment extends CustomFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_user, container, false);

        final Button commitChangesBt = (Button) view.findViewById(R.id.update_user_bt_commitChanges);
        commitChangesBt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                commitChanges();
                //change to update user fragment
                replaceFragmentWith(getActivity(), R.id.fragment_container, new HomeFragment());
            }
        });

        final Button abortChangesBt = (Button) view.findViewById(R.id.update_user_bt_abortChanges);
        abortChangesBt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //change to update user fragment
                replaceFragmentWith(getActivity(), R.id.fragment_container, new HomeFragment());
            }
        });

        return view;
    }

    private void commitChanges() {

    }

}
