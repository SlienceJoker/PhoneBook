package com.slience;

import com.slience.common.Menu;
import com.slience.common.Operate;
import com.slience.common.TelNoteRegex;

/**
 * @author jiazhikai
 * 入口类
 */
public class Main {
    /**
     * 启动电话本项目
     *
     * @param args
     */
    public static void main(String[] args) {
        // write your code here
        Main main = new Main();
        main.start();
    }

    /**
     * 控制主菜单
     */
    public void start() {
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        Operate operate = new Operate();
        while (true) {
            menu.mainMenu();
            int item = regex.menuItemValidate(1, 6);
            switch (item) {
                case 1:
                    operate.addLogic();
                    break;
                case 2:
                    operate.searchLogic();
                    break;
                case 3:
                    operate.modifyLogic();
                    break;
                case 4:
                    operate.deleteLogic();
                    break;
                case 5:
                    operate.orderLogic();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + item);
            }
        }
    }
}
