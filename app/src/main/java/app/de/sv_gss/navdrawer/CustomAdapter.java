package app.de.sv_gss.navdrawer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<String> name;
    private ArrayList<String> beschreibung;
    private ArrayList<String> leiter;
    private ArrayList<String> termine;
    private Context context;

    protected CustomAdapter(Context context, ArrayList<String> name, ArrayList<String> beschreibung, ArrayList<String> leiter, ArrayList<String> termine) {
        this.context = context;
        this.name = name;
        this.beschreibung = beschreibung;
        this.leiter = leiter;
        this.termine = termine;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        return new MyViewHolder(v);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
        holder.name.setText(name.get(position));
        holder.email.setText(beschreibung.get(position));
        holder.leiter.setText(leiter.get(position));
        holder.mobileNo.setText(termine.get(position));
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                Toast.makeText(context, name.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return name.size();
    }

 /*   @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }*/

    protected class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, email, mobileNo, leiter;// init the item view's

        protected MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            leiter = itemView.findViewById(R.id.leiter);
            mobileNo = itemView.findViewById(R.id.mobileNo);

        }
    }
}
