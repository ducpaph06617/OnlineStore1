package com.dev.onlinestore1.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.dev.onlinestore1.HomeActivity;
import com.dev.onlinestore1.LoginActivity;
import com.dev.onlinestore1.R;
import com.dev.onlinestore1.adapter.CartAdapter;
import com.dev.onlinestore1.adapter.ImageAdapter;
import com.dev.onlinestore1.adapter.ImageAdapter2;
import com.dev.onlinestore1.user.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

import pl.droidsonroids.gif.GifImageView;

public class Fragment_Cart extends BaseFragment {

    private RecyclerView recyclerviewcart;
    private DatabaseReference mDatabase;
    private ArrayList<User.cartsp> giohangArray = new ArrayList<>();
    private ArrayList<User.Product> products = new ArrayList<>();
    private ArrayList<User.BillDeltail> deltails = new ArrayList<>();
    private String id = "";
    private ArrayList<String> idspham = new ArrayList<>();
    private ArrayList<String> bills = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
    private CartAdapter cartAdapter;
    private ScrollView scrollView;
    private GifImageView loading;
    private Dialog dialog;
    private TextView txtProductB;
    private RecyclerView recyclerviewimg;
    private TextView txtpriceB;
    private TextView txtnameshop;
    private TextView txtSanPham;
    private TextView txtdate;
    private TextView txtloai;
    private TextView txttinhtrang;
    private TextView txttrangthai;
    private TextView txtsoluong;
    private TextView txtmota;
    private ImageView left;
    private TextView txtdiaChi;
    private TextView txtTongtien;
    private TextView muangay;
    private ImageView giohang;
    private LinearLayout layout;
    private EditText edtTenshop;
    private EditText edtTensp;
    private EditText edtGia;
    private Spinner spinner;
    private EditText edtSoluong;
    private Button btncallS;
    private Button btnhuyDon;
    private Button btnTinhtrang;
    private Button btnTrangthai;
    private EditText edtMota;
    private Button btnDangsp;
    private ArrayList<String> uri = new ArrayList<>();
    private ArrayList<String> productss = new ArrayList<>();
    private int i = 0;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cart, container, false);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        Intent intent = getActivity().getIntent();
        id = intent.getStringExtra("id");
        recyclerviewcart = view.findViewById(R.id.recyclerviewcart);
        loading = view.findViewById(R.id.loading);
        scrollView = view.findViewById(R.id.scrollView);
        loading.setVisibility(View.VISIBLE);
        scrollView.setAlpha(0.5f);
        cartAdapter = new CartAdapter(Fragment_Cart.this, products, giohangArray,deltails);
        recyclerviewcart.setLayoutManager(linearLayoutManager);
        recyclerviewcart.setHasFixedSize(true);
        recyclerviewcart.setAdapter(cartAdapter);
        getcart();

        return view;
    }

    private void getcart() {
        if (id != null) {
            giohangArray.clear();
            products.clear();
            idspham.clear();
            bills.clear();

            mDatabase.child("id").child("User").child(id).child("cart").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    User.cartsp cartsp = dataSnapshot.getValue(User.cartsp.class);
                    if (dataSnapshot.getKey() != null) {
                        Log.e("CHECK", dataSnapshot.getKey());
                        idspham.add(0,dataSnapshot.getKey());
                        loading.setVisibility(View.INVISIBLE);
                        scrollView.setAlpha(1f);
                    }
                    giohangArray.add(cartsp);
                    mDatabase.child("id").child(cartsp.getIdsp()).child("product").addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                            User.Product product = dataSnapshot.getValue(User.Product.class);
                            products.add(0, product);
                            cartAdapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        }

                        @Override
                        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                        }

                        @Override
                        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    Log.e("KEY", giohangArray.size() + "");
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    Log.e("KEY", "a");
                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                    Log.e("KEY", "b");
                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    Log.e("KEY", "c");
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.e("KEY", "d");
                }
            });
            mDatabase.child("id").child("User").child(id).child("bill").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    User.BillDeltail deltail = dataSnapshot.getValue(User.BillDeltail.class);
                    if (dataSnapshot.getKey() != null) {
                        Log.e("CHECK1", dataSnapshot.getKey());
                        bills.add(0,dataSnapshot.getKey());
                        Log.e("CHECK3", bills.get(0));
                    }
                    deltails.add(0,deltail);
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

    }

    public void deletesp(final int posion, String tensp, final int size){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có muốn xóa sản phẩm\t"+tensp+"\tkhỏi giỏ hàng không?");
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
            });

        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                loading.setVisibility(View.VISIBLE);
                scrollView.setAlpha(0.2f);
                mDatabase.child("id").child("User").child(id).child("cart").child(idspham.get(posion)).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        loading.setVisibility(View.INVISIBLE);
                        scrollView.setAlpha(1f);
                        getcart();
                        cartAdapter.notifyDataSetChanged();
                        if (size==1){
                            startActivity(new Intent(getActivity(), LoginActivity.class));
                            getActivity().finish();
                        }
                    }
                });
                mDatabase.child("id").child("User").child(id).child("bill").child(bills.get(posion)).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        loading.setVisibility(View.INVISIBLE);
                        scrollView.setAlpha(1f);
                        getcart();
                        if (size==1){

                        }
                    }
                });



            }
        });

        builder.show();

    }

    public void clickbill(final User.BillDeltail deltail) {


        final String nameShop = deltail.getNameShop();

        String soluong = deltail.getSoluong();
        String datebuy = deltail.getDateBuy();
        String trangthai = deltail.getTrangThaiB();

        String idshop = deltail.getIdShop();
        String idspB = deltail.getIdsp();

        String tenSP = deltail.getTenSP();
        String loaiSP = deltail.getLoaiSP();
        String giaSPM = deltail.getGiaSPM();
        String moTaSP = deltail.getMoTaSP();
        int giatien = Integer.parseInt(giaSPM)*Integer.parseInt(soluong) ;
        Log.e("idSPBILL", "clickbill: "+idspB );


        final Dialog dialog = new Dialog(getActivity(), R.style.PauseDialog1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_bill);
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.TOP;
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wlp.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(wlp);



        btncallS = dialog.findViewById(R.id.btncallS);
        btnhuyDon = dialog.findViewById(R.id.btnhuyDon);
        Button btnxacnhan = dialog.findViewById(R.id.btnxacnhan);
        layout = dialog.findViewById(R.id.layout);


        btncallS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNo = nameShop;

                    String dial = "tel:" + phoneNo;
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));

            }
        });
        if (trangthai.equalsIgnoreCase("Đã Hủy")||trangthai.equalsIgnoreCase("Đã Xác Nhận")){
            btnhuyDon.setEnabled(false);
            btnhuyDon.setBackgroundColor(Color.parseColor("#819ca9"));
        }else {
            btnhuyDon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Hủy Đơn");
                    builder.setMessage("Bạn có muốn hủy không?");
                    builder.setCancelable(false);
                    final String idShop = deltail.getIdShop();
                    builder.setPositiveButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    builder.setNegativeButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            deltail.setTrangThaiB("Đã Hủy");
                            mDatabase.child("id").child("User").child(id).child("bill").child(bills.get(0)).setValue(deltail).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    //Toast.makeText(getActivity(), "Đặt hàng thành công", Toast.LENGTH_SHORT).show();
                                }
                            });
                            mDatabase.child("id").child("User").child(idShop).child("bill").child(bills.get(0)).setValue(deltail).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                    Toast.makeText(getActivity(), "Đã Hủy", Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }
            });
        }
        if (trangthai.equalsIgnoreCase("Đã Hủy")||trangthai.equalsIgnoreCase("Đã Nhận Hàng")||trangthai.equalsIgnoreCase("Đang Chờ")){
            btnxacnhan.setEnabled(false);
            btnxacnhan.setBackgroundColor(Color.parseColor("#819ca9"));

        }else {
            btnxacnhan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Nhận được hàng");
                    builder.setMessage("Bạn đã nhận được sản phẩm?");
                    builder.setCancelable(false);
                    final String idShop = deltail.getIdShop();
                    builder.setPositiveButton("hủy", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    builder.setNegativeButton("Đã nhận", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            deltail.setTrangThaiB("Đã Nhận Hàng");
                            mDatabase.child("id").child("User").child(id).child("bill").child(bills.get(0)).setValue(deltail).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    //Toast.makeText(getActivity(), "Đặt hàng thành công", Toast.LENGTH_SHORT).show();
                                }
                            });
                            mDatabase.child("id").child("User").child(idShop).child("bill").child(bills.get(0)).setValue(deltail).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                    Toast.makeText(getActivity(), "Xác Nhận Thành Công", Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }
            });
        }
        txtloai = dialog.findViewById(R.id.txtloai);
        txttinhtrang = dialog.findViewById(R.id.txttinhtrang);
        txttrangthai = dialog.findViewById(R.id.txttrangthai);
        txtsoluong = dialog.findViewById(R.id.txtsoluong);
        txtmota = dialog.findViewById(R.id.txtmota);
        txtdiaChi = dialog.findViewById(R.id.txtDiachi);
        txtnameshop =dialog.findViewById(R.id.txShop);
        LinearLayoutManager imglayout;
        recyclerviewimg = dialog.findViewById(R.id.recyclerviewimg);
        txtTongtien = dialog.findViewById(R.id.txtTongtien);
        txtdate = dialog.findViewById(R.id.txtdate);
        txtProductB = dialog.findViewById(R.id.txtTenSPB);
        txtpriceB = dialog.findViewById(R.id.txGiaSPB);

        imglayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        uri.clear();
        ImageAdapter2 imageAdapter = new ImageAdapter2(Fragment_Cart.this, uri, R.layout.item_image);
        recyclerviewimg.setLayoutManager(imglayout);
        recyclerviewimg.setAdapter(imageAdapter);
        mDatabase.child("id").child("User").child("sp").child(idspB).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Object o = dataSnapshot.getValue();
                uri.add(o.toString());
                Log.e("2Taguri", uri.size() + "");
                Log.e("IMG", "onChildAdded: "+o.toString() );
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        imageAdapter.notifyDataSetChanged();



        txtdiaChi.setText(deltail.getDiaChi());
        txttrangthai.setText(trangthai);
        txtTongtien.setText(String.valueOf(giatien));
        txtsoluong.setText(soluong);
        txtnameshop.setText("Người bán: "+nameShop);
        txtmota.setText(moTaSP);
        txtpriceB.setText(giaSPM);
        txtProductB.setText(tenSP);
        txtloai.setText(loaiSP);
        txtdate.setText("Thời gian mua: "+datebuy);

        dialog.show();

    }


}
