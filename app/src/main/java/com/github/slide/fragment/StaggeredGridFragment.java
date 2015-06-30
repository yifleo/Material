package com.github.slide.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.base.BaseFragment;
import com.github.material.R;
import com.github.slide.adapter.StaggeredGridAdapter;

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * {@link StaggeredGridFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StaggeredGridFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StaggeredGridFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // The URL to +1.  Must be a valid URL.
    private final String PLUS_ONE_URL = "http://developer.android.com";

    private RecyclerView recycler_staggered_view;
    private SwipeRefreshLayout swipe_refresh_staggered_fragment;
    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StaggeredGridFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StaggeredGridFragment newInstance(String param1, String param2) {
        StaggeredGridFragment fragment = new StaggeredGridFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public StaggeredGridFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plus_one, container, false);
        iniitView(view);
        initListener();
        return view;
    }

    private void initListener() {
        swipe_refresh_staggered_fragment.setOnRefreshListener(this);
    }

    private void iniitView(View view) {
        recycler_staggered_view = (RecyclerView) view.findViewById(R.id.recycler_staggered_view);
        swipe_refresh_staggered_fragment = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_staggered_fragment);
        StaggeredGridAdapter staggeredGridAdapter = new StaggeredGridAdapter(getActivity());
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recycler_staggered_view.setLayoutManager(staggeredGridLayoutManager);
        recycler_staggered_view.setAdapter(staggeredGridAdapter);

        swipe_refresh_staggered_fragment.post(new Runnable() {
            @Override
            public void run() {
                swipe_refresh_staggered_fragment.setRefreshing(true);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        // Refresh the state of the +1 button each time the activity receives focus.
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
          /*  throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");*/
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipe_refresh_staggered_fragment.setRefreshing(false);
            }
        }, 2000);

    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
