package org.example.save;

import org.example.accountManager.AccountManager;
import org.example.accountManager.AccountManagerList;
import org.example.dependencies.Dependencies;
import org.example.simpleClasses.Account;

import java.io.*;
import java.util.ArrayList;

public class SaveToFile implements Save{
    private final Dependencies dependencies;
    private ArrayList<Account> accounts = new ArrayList<>();

    public SaveToFile(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    @Override
    public void save() {
        try {
            FileOutputStream fileOut = null;
            fileOut = new FileOutputStream("accounts.txt");
            ObjectOutputStream out = null;
            out = new ObjectOutputStream(fileOut);
            out.writeObject(dependencies.getAccountManager().getAccounts());
            fileOut.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void load() {
        File file = new File("accounts.txt");
        if(file.exists()) {
            try {
                FileInputStream fileIn = new FileInputStream("accounts.txt");
                ObjectInputStream in  = new ObjectInputStream(fileIn);
                accounts = (ArrayList<Account>) in.readObject();
                in.close();
                fileIn.close();
                dependencies.getAccountManager().loadAccounts(accounts);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                if(file.createNewFile()) {
                    accounts = dependencies.getAccountManager().getAccounts();
                } else {
                    System.out.println("Failed to create file");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
