package giftview;
import giftcontroller.GiftController;
import giftmodel.Gift;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class GiftShop {
    final int SENTINEL = 0;
    int n;
    Scanner scanner = new Scanner(System.in);
    GiftController controller = new GiftController();

    public static void main(String[] args) {
            GiftShop gs = new GiftShop();
            gs.ViewShop();
    }

    public void menu(){
        System.out.println("============================");
        System.out.println("1 - hien thi danh sach");
        System.out.println("2 - nhap thong tin ");
        System.out.println("3 - nhap id sach muon xoa");
    }
    public void addBook(){
        System.out.println("Id:");
        int id = scanner.nextInt();
        System.out.println("Name");
        String name = scanner.nextLine();
        System.out.println("Price");
        double price = scanner.nextDouble();
        System.out.println("Qty");
        int qty = scanner.nextInt();
        Gift gift = new Gift(id, name, price, qty);
        controller.InsertGift(gift);
    }

    public void deleteBook(){
        System.out.println("Id");
        int id = scanner.nextInt();
        controller.DeleteGift(id);
    }
    public void ViewShop(){
        System.out.println("=======");
        GiftShop gs = new GiftShop();
        gs.menu();
        n = scanner.nextInt();
        while (n != SENTINEL){
            switch (n){
                case 1:
                    System.out.println("Book");
                    controller.selectBook();
                    break;
                case 2:
                    gs.addBook();
                    break;
                case 3:
                    gs.deleteBook();
                    break;
            }
            gs.menu();
            n = scanner.nextInt();
        }
    }

}
