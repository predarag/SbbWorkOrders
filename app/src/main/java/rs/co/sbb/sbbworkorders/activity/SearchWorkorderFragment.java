package rs.co.sbb.sbbworkorders.activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rs.co.sbb.sbbworkorders.R;
import rs.co.sbb.sbbworkorders.entity.response.GetWoResponse;
import rs.co.sbb.sbbworkorders.ws.rest.HttpMtClientWS;


public class SearchWorkorderFragment extends Fragment   {


    private OnFragmentInteractionListener mListener;

    Button searchWorkorderButton;

    private AbsListView mListView;




    public static SearchWorkorderFragment newInstance() {
        SearchWorkorderFragment fragment = new SearchWorkorderFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


       final View searchWorkFragmentView = inflater.inflate(R.layout.fragment_search_workorder, container, false);

        searchWorkorderButton = (Button) searchWorkFragmentView.findViewById(R.id.search_workorder_button);

        searchWorkorderButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                EditText workOrderNumber = (EditText) getActivity().findViewById(R.id.workorder);

                String transactionNo = workOrderNumber.getText().toString();

                if(transactionNo != null && !"".equals(transactionNo)) {

                    Toast.makeText(getActivity(), workOrderNumber.getText(), Toast.LENGTH_LONG).show();

                    HttpMtClientWS clientWS = new HttpMtClientWS(getActivity());

                    final Call<GetWoResponse>  getWoResponse = clientWS.getWoResponse(transactionNo);

                    getWoResponse.enqueue(new Callback<GetWoResponse>() {
                        @Override
                        public void onResponse(Call<GetWoResponse> call, Response<GetWoResponse> response) {

                            if(null != response && !response.isSuccessful() && response.errorBody() !=null){
                                //showProgress(false);

                                Log.i("logn",response.code()+"");

                                Toast.makeText(getActivity(),"Doslo je do greske prilikom dohvatanja transakcije",Toast.LENGTH_LONG);

                            }

                            GetWoResponse woResponse = response.body();

                            if(null != woResponse){

                                WorkorderResultFragment wra = new WorkorderResultFragment();
                                Bundle args = new Bundle();
                                args.putSerializable("etList",(Serializable) woResponse.getWOData().getETIZLAZ());
                                wra.setArguments(args);

                                FragmentTransaction tx = getActivity().getSupportFragmentManager().beginTransaction();
                                tx.replace(R.id.content_frame,wra);
                                tx.commit();

                 /*               Intent intent = new Intent(getActivity(), WorkorderResultFragment.class);
                                intent.putExtra("etList",(Serializable) woResponse.getWOData().getETIZLAZ());
                                startActivity(intent);*/

                            }

                        }

                        @Override
                        public void onFailure(Call<GetWoResponse> call, Throwable t) {

                        }
                    });



                }


            }
        });

        return searchWorkFragmentView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
