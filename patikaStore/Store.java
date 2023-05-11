package patikaStore;

import patikaStore.products.MobilePhone;
import patikaStore.products.NoteBook;
import patikaStore.products.Products;
import patikaStore.tradeMark.TradeMark;

import java.sql.SQLOutput;
import java.util.*;

public class Store {
    private Scanner input=new Scanner(System.in);

    LinkedList<TradeMark> tradeMarks=new LinkedList<>();
    ArrayList<Products> noteBooks=new ArrayList<Products>();
    ArrayList<Products> mobilePhones=new ArrayList<>();

    public Store(){
        tradeMarks.add(new TradeMark(1,"Samsung"));
        tradeMarks.add(new TradeMark(2,"Lenovo"));
        tradeMarks.add(new TradeMark(3,"Apple"));
        tradeMarks.add(new TradeMark(4,"Huawei"));
        tradeMarks.add(new TradeMark(5,"Casper"));
        tradeMarks.add(new TradeMark(6,"Asus"));
        tradeMarks.add(new TradeMark(7,"HP"));
        tradeMarks.add(new TradeMark(8,"Xiaomi"));
        tradeMarks.add(new TradeMark(9,"Mosnter"));
    }




    public void start(){

        System.out.println("*==============* PATIKA STORE *==============*");
        boolean menu=true;

        while(menu){
            System.out.println();
            System.out.println("1- NoteBook Islemleri");
            System.out.println("2- Cep Telefonu Islemleri");
            System.out.println("3- Marka Listeleme");
            System.out.println("4- Exit");
            System.out.println("Seciminiz :    ");

            int selected=input.nextInt();
            switch (selected){
                case 1:
                    System.out.println("NoteBook Menu");
                    this.productMenu(noteBooks);
                    break;
                case 2:
                    System.out.println("Cep Telefonu Menu");
                    this.productMenu(mobilePhones);
                    break;
                case 3:
                    System.out.println("Markalar");
                    tradeMarkList();
                    break;
                case 4:
                    System.out.println("Cikis Yapildi");
                    menu=false;
                    break;
                default:
                    System.out.println("Cikis Yapildi");

            }
        }


    }

    public void tradeMarkList(){
        System.out.println("------------------------------");
        System.out.println("Markalarimiz");
        tradeMarks.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        for(TradeMark t:tradeMarks){
            System.out.println("- "+ t.getName());
        }
    }

    public void productMenu(ArrayList<Products> products){
        boolean menu=true;
        System.out.println("=====Urun Islemleri =====");
        while(menu){
            System.out.println("1- Urun ekleme");
            System.out.println("2- urun silme");
            System.out.println("3- Urun Listesi");
            System.out.println("4- Markaya Gore Filitreleme");
            System.out.println("5- Exit");
            System.out.println("Seciminiz  : ");
            int selectedMenu=input.nextInt();
            switch (selectedMenu){
                case 1:
                    System.out.println("------Urun Ekleme Menusu--------");
                    this.addProduct(products);
                    break;
                case 2:
                    System.out.println("------Urun Silme Menusu---------");
                    this.deleteProduct(products);
                    break;
                case 3:
                    this.listProducts(products);
                    break;
                case 4:
                    this.productsByTradeMark();
                    break;
                case 5:
                    menu=false;
                    break;
            }
        }
    }

    public void addProduct(ArrayList<Products> products){
        int id=products.size()+1;
        Scanner inputName=new Scanner(System.in);
        System.out.println("Urun adini giriniz:");
        String productName=inputName.nextLine();
        System.out.println("Urunun fiyatini giriniz");
        int productPrice=input.nextInt();
        System.out.println("Indirim oranini giriniz");
        int productDiscount=input.nextInt();
        System.out.println("Stock miktarini giriniz");
        int productStock=input.nextInt();
        System.out.println("Marka Seciniz");
        TradeMark tradeMark=choseMark();
        if(products==noteBooks){
            System.out.println("Ram miktarini giriniz");
            String noteBookRam=inputName.nextLine();
            System.out.println("Hard Disk Boyutunu giriniz");
            String noteBookHardDisk=inputName.nextLine();
            System.out.println("Ekran Buyuklugunu giriniz");
            String noteBookScreenSize=inputName.nextLine();
            products.add(new NoteBook(id,productName,productPrice,productDiscount,productStock,tradeMark,noteBookRam,noteBookHardDisk,noteBookScreenSize));
            System.out.println("Yeni Urun Eklendi");
        }else{
            System.out.println("Hafiza Miktarini giriniz");
            String phoneMemory=inputName.nextLine();
            System.out.println("Ekran Buyuklugunu giriniz");
            String phoneScreen=inputName.nextLine();
            System.out.println("Batarya Ozelligini giriniz");
            String phoneBattary=inputName.nextLine();
            System.out.println("Ram miktarini giriniz");
            String phoneRam=inputName.nextLine();
            System.out.println("Rengini giriniz");
            String phoneColor=inputName.nextLine();
            products.add(new MobilePhone(id,productName,productPrice,productDiscount,productStock,tradeMark,phoneMemory,phoneScreen,phoneBattary,phoneRam,phoneColor));
            System.out.println("Yeni Urun eklendi");
        }
        productMenu(products);
    }

    public void deleteProduct(ArrayList<Products> products){
        System.out.println("Silmek Istediginiz Urunun id sini giriniz");
        listProducts(products);
        int delId=input.nextInt();
        try{
            if(products.size()<1){
                System.out.println("Silinecek Herhangi bir urun bulunamadi");
            }else{
                for(Products p:products){
                    if(p.getId()==delId){
                        products.remove(p);
                        System.out.println("Urun Basariyla silindi");
                    }else{
                        System.out.println("Gecerli bir id numarasi giriniz");
                    }
                }
            }
        }catch (Exception e){

        }

        productMenu(products);
    }

    public void listProducts(ArrayList<Products> products){
        System.out.println("Urunlerin Listesi");
        System.out.println("| ID |      Ürün Adı            |   Fiyat      |  Marka       |");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        for(Products p: products){
            System.out.println("| "+ p.getId() +"  |   "+p.getName()+"        |    "+p.getPrice()+" TL   |   "+p.getTradeMark().getName());
        }
    }

    public TradeMark choseMark(){
        for (TradeMark t : this.tradeMarks){
            System.out.println(t.getId() + " - " + t.getName());
        }
        System.out.println("Hangi Markayi Seciyorsunuz ? ");
        int markSelect = input.nextInt();
        return this.tradeMarks.get(markSelect-1);
    }

    public void productsByTradeMark(){
        TradeMark tradeMark=this.choseMark();
        ArrayList<Products> filteredProducts=new ArrayList<>();
        for(Products p:noteBooks){
            if(p.getTradeMark()==tradeMark){
                filteredProducts.add(p);
            }
        }
        for(Products p:mobilePhones){
            if(p.getTradeMark()==tradeMark){
                filteredProducts.add(p);
            }
        }
        listProducts(filteredProducts);
        start();
    }

}
