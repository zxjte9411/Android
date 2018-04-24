package com.example.admin.hw6;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameResultFragment extends Fragment {

    private EditText mEdtCountSet,
            mEdtCountPlayerWin,
            mEdtCountComWin,
            mEdtCountDraw;

    public GameResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_result, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        mEdtCountSet = (EditText) getActivity().findViewById(R.id.edtCountSet);
        mEdtCountPlayerWin = (EditText) getActivity().findViewById(R.id.edtCountPlayerWin);
        mEdtCountComWin = (EditText) getActivity().findViewById(R.id.edtCountComWin);
        mEdtCountDraw = (EditText) getActivity().findViewById(R.id.edtCountDraw);

        ((MainActivity) getActivity()).mGameResultType = MainFragment.GameResultType.TYPE_1;
        ((MainActivity) getActivity()).fragResult = this;

        getActivity().findViewById(R.id.fragment_container).setVisibility(View.VISIBLE);
        ((MainActivity) getActivity()).InvokeUpdateResult(); // Update values immediately
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().findViewById(R.id.fragment_container).setVisibility(View.GONE);
    }

    public void updateGameResult(int iCountSet,
                                 int iCountPlayerWin,
                                 int iCountComWin,
                                 int iCountDraw) {
        mEdtCountSet.setText(String.valueOf(iCountSet));
        mEdtCountDraw.setText(String.valueOf(iCountDraw));
        mEdtCountComWin.setText(String.valueOf(iCountComWin));
        mEdtCountPlayerWin.setText(String.valueOf(iCountPlayerWin));
    }
}
