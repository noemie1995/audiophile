package com.searce.musicplayer;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by debowin on 7/9/14.
 */
public class MiniPlayerFragment extends Fragment implements View.OnClickListener {
    RelativeLayout rlMiniPlayer;
    TextView tvSongTitle;
    TextView tvArtist;
    Communicator comm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mini_player, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rlMiniPlayer = (RelativeLayout) getActivity().findViewById(R.id.rlPlayer);
        tvSongTitle = (TextView) getActivity().findViewById(R.id.tvSongTitle_MiniPlayerFrag);
        tvArtist = (TextView) getActivity().findViewById(R.id.tvArtist_MiniPlayerFrag);
        rlMiniPlayer.setOnClickListener(this);
        comm = (Communicator) getActivity();
        updateTags();
    }

    public void updateTags() {
        tvArtist.setText(comm.get_artist());
        tvSongTitle.setText(comm.get_title());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rlPlayer:
                comm.goToPlayer();
        }
    }
}
