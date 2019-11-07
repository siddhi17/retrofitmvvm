package com.example.retrofitmvvm.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitmvvm.Model.Venue;
import com.example.retrofitmvvm.R;

import java.util.List;

public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.VenueViewHolder> {

        Context mCtx;
        List<Venue> venueList;

        public VenueAdapter(Context mCtx, List<Venue> venueList) {
            this.mCtx = mCtx;
            this.venueList = venueList;
        }

        @NonNull
        @Override
        public VenueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout, parent, false);
            return new VenueViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull VenueViewHolder holder, int position) {
            Venue venue = venueList.get(position);


            holder.textView_id.setText(Integer.toString(venue.getId()));
            holder.textView_name.setText(venue.getName());
            holder.textView_username.setText(venue.getUsername());
            holder.textView_email.setText(venue.getEmail());

            holder.textView_street.setText(venue.getAddress().getStreet());
            holder.textView_city.setText(venue.getAddress().getCity());
            holder.textView_companyName.setText(venue.getCompany().getName());
            holder.textView_lat.setText((venue.getAddress().getGeo().getLat()));
            holder.textView_long.setText(venue.getAddress().getGeo().getLng());

        }

        @Override
        public int getItemCount() {
            return venueList.size();
        }

        class VenueViewHolder extends RecyclerView.ViewHolder {

            TextView textView_id,textView_name,textView_username,textView_email,textView_street,
                    textView_city,textView_companyName,textView_lat,textView_long;

            public VenueViewHolder(View itemView) {
                super(itemView);

                textView_id = itemView.findViewById(R.id.textView_id);
                textView_name = itemView.findViewById(R.id.textView_name);
                textView_username = itemView.findViewById(R.id.textView_username);
                textView_email = itemView.findViewById(R.id.textView_email);
                textView_street = itemView.findViewById(R.id.textView_street);
                textView_city = itemView.findViewById(R.id.textView_city);
                textView_companyName = itemView.findViewById(R.id.textView_companyname);
                textView_lat = itemView.findViewById(R.id.textView_lat);
                textView_long = itemView.findViewById(R.id.textView_long);


            }
        }
}
