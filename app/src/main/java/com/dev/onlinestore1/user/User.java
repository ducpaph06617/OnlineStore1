package com.dev.onlinestore1.user;

public class User {

    public static class Info{
        public String name;
        public String phone;
        public String uri;
        public String address;
        public String email;
        public String gender;

        public Info() {
        }

        public Info(String name, String phone, String uri, String address, String email, String gender) {
            this.name = name;
            this.phone = phone;
            this.uri = uri;
            this.address = address;
            this.email = email;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }
    public static class Product{

        public String idU;
        public String nameshop;
        public String nameproduct;
        public String priceproduct;
        public String colorproduct;
        public String lovestatus;
        public String status;
        public String describe;
        public String idsp;
        public String uri;
        public String loaisp;

        public String thoigian;
        public Product() {
        }

        public Product(String idU,String nameshop, String nameproduct, String priceproduct, String colorproduct, String lovestatus, String status, String describe, String idsp, String uri, String loaisp,  String thoigian) {
            this.idU = idU;
            this.nameshop = nameshop;
            this.nameproduct = nameproduct;
            this.priceproduct = priceproduct;
            this.colorproduct = colorproduct;
            this.lovestatus = lovestatus;
            this.status = status;
            this.describe = describe;
            this.idsp = idsp;
            this.uri = uri;
            this.loaisp = loaisp;

            this.thoigian = thoigian;
        }

        public String getIdU() {
            return idU;
        }

        public void setIdU(String idU) {
            this.idU = idU;
        }

        public String getNameshop() {
            return nameshop;
        }

        public void setNameshop(String nameshop) {
            this.nameshop = nameshop;
        }

        public String getNameproduct() {
            return nameproduct;
        }

        public void setNameproduct(String nameproduct) {
            this.nameproduct = nameproduct;
        }

        public String getPriceproduct() {
            return priceproduct;
        }

        public void setPriceproduct(String priceproduct) {
            this.priceproduct = priceproduct;
        }

        public String getColorproduct() {
            return colorproduct;
        }

        public void setColorproduct(String colorproduct) {
            this.colorproduct = colorproduct;
        }

        public String getLovestatus() {
            return lovestatus;
        }

        public void setLovestatus(String lovestatus) {
            this.lovestatus = lovestatus;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public String getIdsp() {
            return idsp;
        }

        public void setIdsp(String idsp) {
            this.idsp = idsp;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getLoaisp() {
            return loaisp;
        }

        public void setLoaisp(String loaisp) {
            this.loaisp = loaisp;
        }


        public String getThoigian() {
            return thoigian;
        }

        public void setThoigian(String thoigian) {
            this.thoigian = thoigian;
        }
    }
    public static class Uriimg{
        private String uri;

        public Uriimg() {
        }

        public Uriimg(String uri) {
            this.uri = uri;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }
    }
     public static class Id{
        String id;

         public Id() {
         }

         public String getId() {
             return id;
         }

         public void setId(String id) {
             this.id = id;
         }

         public Id(String id) {

             this.id = id;
         }
     }

     public static class cartsp{
        public String idsp;
        public String soluong;
        public String idShop;

         public cartsp() {
         }

         public cartsp(String idsp, String soluong,String idShop) {
             this.idsp = idsp;
             this.soluong = soluong;
             this.idShop = idShop;
         }

         public String getIdShop() {
             return idShop;
         }

         public void setIdShop(String idShop) {
             this.idShop = idShop;
         }

         public String getIdsp() {
             return idsp;
         }

         public void setIdsp(String idsp) {
             this.idsp = idsp;
         }

         public String getSoluong() {
             return soluong;
         }

         public void setSoluong(String soluong) {
             this.soluong = soluong;
         }
     }
     public static class BillDeltail{
         public String idsp;
         public String idShop;
         public String idbilll;
         public String nameShop;
         public String nameMua;
         public String trangThaiB;
         public String giaTien;
         public String soluong;
         public String dateBuy;
         public String idMua;
         public String diaChi;
         public String tenSP;
         public String loaiSP;
         public String giaSPM;
         public String moTaSP;




         public BillDeltail(String idsp,String idMua,String idShop, String nameShop,String diaChi, String nameMua,String idbilll,String trangThaiB,String dateBuy,String soluong,String giaTien,String tenSP,String loaiSP,String giaSPM,String moTaSP) {
             this.idsp = idsp;
             this.idbilll = idbilll;
             this.nameShop = nameShop;
             this.nameMua = nameMua;
             this.trangThaiB =trangThaiB;
             this.idShop = idShop;
             this.idMua = idMua;
             this.dateBuy = dateBuy;
             this.soluong = soluong;
             this.giaTien = giaTien;
             this.diaChi = diaChi;
             this.tenSP = tenSP;
             this.loaiSP = loaiSP;
             this.giaSPM = giaSPM;
             this.moTaSP = moTaSP;

         }
         public BillDeltail() {

         }


         public String getTenSP() {
             return tenSP;
         }

         public void setTenSP(String tenSP) {
             this.tenSP = tenSP;
         }

         public String getLoaiSP() {
             return loaiSP;
         }

         public void setLoaiSP(String loaiSP) {
             this.loaiSP = loaiSP;
         }

         public String getGiaSPM() {
             return giaSPM;
         }

         public void setGiaSPM(String giaSPM) {
             this.giaSPM = giaSPM;
         }

         public String getMoTaSP() {
             return moTaSP;
         }

         public void setMoTaSP(String moTaSP) {
             this.moTaSP = moTaSP;
         }

         public String getDiaChi() {
             return diaChi;
         }

         public void setDiaChi(String diaChi) {
             this.diaChi = diaChi;
         }

         public String getSoluong() {
             return soluong;
         }

         public void setSoluong(String soluong) {
             this.soluong = soluong;
         }

         public String getIdMua() {
             return idMua;
         }

         public void setIdMua(String idMua) {
             this.idMua = idMua;
         }

         public String getGiaTien() {
             return giaTien;
         }

         public void setGiaTien(String giaTien) {
             this.giaTien = giaTien;
         }

         public String getDateBuy() {
             return dateBuy;
         }

         public void setDateBuy(String dateBuy) {
             this.dateBuy = dateBuy;
         }

         public String getIdShop() {
             return idShop;
         }

         public void setIdShop(String idShop) {
             this.idShop = idShop;
         }

         public String getTrangThaiB() {
             return trangThaiB;
         }

         public void setTrangThaiB(String trangThaiB) {
             this.trangThaiB = trangThaiB;
         }

         public String getIdbilll() {
             return idbilll;
         }

         public void setIdbilll(String idbilll) {
             this.idbilll = idbilll;
         }

         public String getIdsp() {
             return idsp;
         }

         public void setIdsp(String idsp) {
             this.idsp = idsp;
         }

         public String getNameShop() {
             return nameShop;
         }

         public void setNameShop(String nameShop) {
             this.nameShop = nameShop;
         }

         public String getNameMua() {
             return nameMua;
         }

         public void setNameMua(String nameMua) {
             this.nameMua = nameMua;
         }
     }


}
