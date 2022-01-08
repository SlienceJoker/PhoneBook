package com.slience.common;

import java.util.Scanner;


/**
 * @author jiazhikai
 * 数据校验类
 */
public class TelNoteRegex {
    public int menuItemValidate(int min, int max) {
        String regex = "[1-9]{1}";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入正确的数字，最小是：" + min + "\t" + "最大是：" + max);
            String input = scanner.nextLine();
            if (input.matches(regex)) {
                int inputNum = Integer.parseInt(input);
                if (inputNum >= min && inputNum <= max) {
                    return inputNum;
                } else {
                    System.out.println("您输入的菜单项不符，请重新输入");
                }
            } else {
                System.out.println("输入数字错误，请检查！");
            }
        }

    }

    public String nameValidate() {
        String regex = "[a-zA-Z]{1,10}";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入姓名，格式为1-10之间的大写或者小写字母");
            String input = scanner.nextLine();
            if (input.matches(regex)) {
                return input;
            } else {
                System.out.println("您当前输入的姓名格式有误，请重新输入");
            }
        }
    }

    public String ageValidate() {
        String regex = "[1-9]{1}[0-9]{1,2}";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入年龄，格式为10-99之间");
            String input = scanner.nextLine();
            if (input.matches(regex)) {
                return input;
            } else {
                System.out.println("您输入的年龄格式有误，请重新输入！！！");
            }
        }
    }

    public String sexValidate() {
        String regex = "[m|M|f|F]{1}";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入性别：(男 M or m) | (女 F or f)");
            String input = scanner.nextLine();
            if (input.matches(regex)) {
                return input;
            } else {
                System.out.println("输入性别有误，请重新输入");
            }
        }
    }

    public String mobileValidate() {
        String regex = "(\\d{3,4}-\\d{7,8})|([1]{1}\\d{10})";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入电话号码，可以是座机号或者手机号");
            String input = scanner.nextLine();
            if (input.matches(regex)) {
                return input;
            } else {
                System.out.println("输入的电话号码格式有误，请重新输入");
            }
        }
    }

    public String addressValidate() {
        String regex = "[a-zA-Z]{1,50}";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入地址信息,格式为，长度为1-50");
            String input = scanner.nextLine();
            if (input.matches(regex)) {
                return input;
            } else {
                System.out.println("输入的地址信息格式有误，请重新输入");
            }
        }
    }

    public static void main(String[] args) {
        TelNoteRegex regex = new TelNoteRegex();
        int menuItem = regex.menuItemValidate(1,6);
        System.out.println(menuItem);
    }

}
