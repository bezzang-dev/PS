import java.util.*;
import java.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] initialPrices;
    static List<List<Discount>> discountsInfo;
    static int minCost = Integer.MAX_VALUE;

    static class Discount {
        int potionIndex;
        int discountAmount;

        public Discount(int potionIndex, int discountAmount) {
            this.potionIndex = potionIndex;
            this.discountAmount = discountAmount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        initialPrices = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            initialPrices[i] = Integer.parseInt(st.nextToken());
        }
        discountsInfo = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            discountsInfo.add(new ArrayList<>());
            int p = Integer.parseInt(br.readLine());
            for (int j = 0; j < p; j++) {
                st = new StringTokenizer(br.readLine());
                int potionIndex = Integer.parseInt(st.nextToken());
                int discountAmount = Integer.parseInt(st.nextToken());
                discountsInfo.get(i).add(new Discount(potionIndex, discountAmount));
            }
        }

        boolean[] purchased = new boolean[n];
        int[] currentDiscounts = new int[n];
        backtrack(0, 0, purchased, currentDiscounts);

        System.out.println(minCost);
    }

    static void backtrack(int count, int currentCost, boolean[] purchased, int[] currentDiscounts) {
        if (count == n) {
            minCost = Math.min(minCost, currentCost);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!purchased[i]) {
                purchased[i] = true;
                int price = Math.max(1, initialPrices[i] - currentDiscounts[i]);
                int nextCost = currentCost + price;
                int[] nextDiscounts = currentDiscounts.clone();

                for (Discount discount : discountsInfo.get(i)) {
                    nextDiscounts[discount.potionIndex - 1] += discount.discountAmount;
                }

                backtrack(count + 1, nextCost, purchased, nextDiscounts);
                purchased[i] = false; // Backtrack
            }
        }
    }
}