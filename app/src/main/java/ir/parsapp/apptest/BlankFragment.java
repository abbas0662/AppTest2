package ir.parsapp.apptest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class BlankFragment extends Fragment {


    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebRequest request = new WebRequest();
                String response = request.getWebContent("http://parsapp1.ir/json.php");
                List<ProductModel> lstProducts=new ArrayList<>();

                try {



                    //JSON PARSE
                    JSONObject objJson = new JSONObject(response);
                    if(objJson.getBoolean("success")==true){
                        JSONArray arrProducts= objJson.getJSONArray("products");

                        for (int i=0;i<arrProducts.length();i++){
                            JSONObject item = arrProducts.getJSONObject(i);
                            ProductModel temp=new ProductModel();

                            temp.Id = item.getInt("id");
                            temp.Name = item.getString("name");
                            temp.Price = item.getString("price");
                            temp.Thumb = item.getString("thumb");

                            lstProducts.add(temp);
                        }
                    }


                    MyAdapter adapter=new MyAdapter(lstProducts);
                    RecyclerView recyclerView=view.findViewById(R.id.recycler1);
                    LinearLayoutManager manager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setHasFixedSize(true);


                }catch (Exception e){
                }

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }


    public void clearText() {
    }

}
