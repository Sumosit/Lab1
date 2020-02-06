package com.example.springboot.lab1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class MagicSquareController {

    @GetMapping(value = "/magicsquare")
    public String magicSquare(ModelMap model) {
        int[] key = {
                12, 13,  2, 7,
                6, 16,  9, 5,
                11, 10,  1, 4,
                3, 15, 14, 8};
        char[] word = {'0', 'e','r','l','a','n'};
        char[] ans = {
                '-','-','-','-',
                '-','-','-','-',
                '-','-','-','-',
                '-','-','-','-' };
        int i, j;
        for (i = 0; i < word.length; i++) {
            j = 0;
            for (int k : key) {
                if (i == k) {
                    System.out.println(word[i]);
                    ans[j] = word[i];
                }
                j++;
            }
        }
        model.addAttribute("a", ans);
        return "magicsquare.html";
    }
    @GetMapping(value = "/encodemagicsquare")
    public String magicSquare(ModelMap model,
                              @RequestParam(name = "magic") String magic) {
        int[] key = {
                12, 13,  2, 7,
                6, 16,  9, 5,
                11, 10,  1, 4,
                3, 15, 14, 8};
        magic = '0' + magic;
        StringBuilder eq = new StringBuilder();
        char[] word = magic.toCharArray();
        int i = 0, j, pivot = 0, number = 1;
        while (i < word.length) {
            char[] ans = {
                    '-','-','-','-',
                    '-','-','-','-',
                    '-','-','-','-',
                    '-','-','-','-' };
            for (i = pivot; i < pivot + 16; i++) {
                j = 0;
                for (int k : key) {
                    if (i == k) {
                        ans[j] = word[i];
                    }
                    j++;
                }
            }
            pivot = i;
            System.out.println("a" + number);
            System.out.println(ans);
            number++;
            eq.append(Arrays.toString(ans));
        }
        model.addAttribute("a1", eq);
        return "magicsquare.html";
    }
}
