package com.dev.onlinestore1.adapter;


import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.dev.onlinestore1.R;
import com.dev.onlinestore1.fragment.Fragment_Cart;
import com.dev.onlinestore1.user.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartHolder> {
    private Fragment_Cart context;
    private ArrayList<User.Product> products;
    private ArrayList<User.cartsp> cartsps;
    private ArrayList<User.BillDeltail> deltails;
    private ArrayList<Integer> integers=new ArrayList<>();

    public CartAdapter(Fragment_Cart context, ArrayList<User.Product> products, ArrayList<User.cartsp> cartsps,ArrayList<User.BillDeltail> deltails) {
        this.context = context;
        this.products = products;
        this.cartsps = cartsps;
        this.deltails = deltails;

    }

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_cart,parent,false);
       return new CartHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CartHolder holder, final int position) {
         final User.Product product=products.get(position);
         final User.BillDeltail deltail = deltails.get(position);
         holder.txtnameproduct.setText(product.getNameproduct());
         holder.txtnameshop.setText(product.getNameshop());

         holder.txtTrangthai.setText(deltails.get(position).getTrangThaiB());
         String trangthai = deltails.get(position).getTrangThaiB();
         if (trangthai.equalsIgnoreCase("Đã Xác Nhận")) {
             holder.txtTrangthai.setTextColor(Color.parseColor("#00c853"));
             holder.btndeletecart.setEnabled(false);
         }
        if (trangthai.equalsIgnoreCase("Đã Hủy")) {
            holder.txtTrangthai.setTextColor(Color.parseColor("#fa0e0e"));
            holder.btndeletecart.setVisibility(View.VISIBLE);
        }
        if (trangthai.equalsIgnoreCase("Đã Nhận Hàng")) {
            holder.txtTrangthai.setTextColor(Color.parseColor("#1a237e"));
            holder.btndeletecart.setVisibility(View.VISIBLE);
        }
        if (trangthai.equalsIgnoreCase("Đang Chờ")) {
//            holder.txtTrangthai.setTextColor(Color.parseColor("#1a237e"));
            holder.btndeletecart.setVisibility(View.INVISIBLE);
        }
         Picasso.get().load(product.getUri()).into(holder.imgnameproduct);



        holder.btndeletecart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.deletesp(position,product.getNameproduct(),products.size());
            }
        });
        holder.cvCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.clickbill(deltail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class CartHolder extends RecyclerView.ViewHolder {
        public CheckBox cbok;
        public TextView txtnameshop;
        public ImageView btndeletecart;
        public ImageView imgnameproduct;
        public TextView txtnameproduct;
        public TextView txtTrangthai;

        public TextView txtsoluong;

        public TextView txtgia;
        public CardView cvCart;




        public CartHolder(View itemView) {
            super(itemView);
            txtnameshop =  itemView.findViewById(R.id.txtnameshop);
            btndeletecart =  itemView.findViewById(R.id.btndeletecart);
            imgnameproduct =  itemView.findViewById(R.id.imgnameproduct);
            txtnameproduct =  itemView.findViewById(R.id.txtnameproduct);
            txtTrangthai =  itemView.findViewById(R.id.txtTrangthai);
            cvCart = itemView.findViewById(R.id.cvBill);

        }
    }


}
