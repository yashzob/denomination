/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.greatlearning.service.paymoney;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author DELL
 */
public class PayMoney {

    public static void main(String[] args) {

        //Enter the Size of transaction array by User
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of currency denomination");
        int size = sc.nextInt();
        int[] CurrencyArray = new int[size];

        //amount of transaction by user
        int i = 0;
        for (i = 0; i < size; i++) {
            CurrencyArray[i] = sc.nextInt();

        }

        int target = 0, flag = 0;

        //target given by user
        System.out.println("Enter the amount you want to pay");
        target = sc.nextInt();
        bubbleSort ob = new bubbleSort();
        ob.bubbleSort(CurrencyArray);
        Arrays.sort(CurrencyArray);
        int CurrencyNote = 0;
        for (i = size; i > 0; i--) {

            //System.out.println(i+" "+ size);
            while (target >= CurrencyArray[i - 1]) {
                target = target - CurrencyArray[i - 1];
                CurrencyNote++;
            }
            if (CurrencyNote != 0) {
                System.out.println("currency of "+CurrencyNote + " " + "may required to get " + CurrencyArray[i - 1]);
            }
            if (target == 0) {
                System.out.println("denomination is possible with above mentioned notes");
                flag = 1;
                break;
            }
            CurrencyNote = 0;
        }
        if (flag ==0)
            //trying above all messages
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.print("\f");
            System.out.println("denomination is not possible with above mentioned notes");

        //
    }

}
