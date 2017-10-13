package com.ufs.tep.sgr_final;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.Stack;

public class Utils {

    public static Stack<Bundle> fragmentData = new Stack();
    public static Stack<Fragment> toBack = new Stack();

    public static void openFragment(FragmentManager fragmentManager, Fragment frag, Bundle dados) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (dados != null)
            frag.setArguments(dados);
        fragmentTransaction.replace(R.id.frameLayout, frag);
        fragmentTransaction.commit();
    }

    public static void cleanBackStack() {
        fragmentData = new Stack();
        toBack = new Stack();
    }

    public static void backToStart()
    {
        Bundle b = new Bundle();
        b.putInt("mode", 1);

        Utils.toBack.push(new SelecionarMesa());
        Utils.fragmentData.push(b);
    }
}
