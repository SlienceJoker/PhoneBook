package com.slience.common;

import com.slience.entity.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

/**
 * @author jiazhikai
 * 核心业务类
 */
public class Operate {
    private List<Person> list;

    public Operate() {
        this.list = new ArrayList<>();
    }


    public void addLogic() {
        out.println("控制添加业务逻辑");
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while (true) {
            menu.addMenu();
            int item = regex.menuItemValidate(1, 3);
            switch (item) {
                case 1:
                    this.addOperation();
                    break;
                case 2:
                    this.showAll();
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
    }

    public void searchLogic() {
        out.println("控制查询业务逻辑");
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while (true) {
            menu.searchMenu();
            int item = regex.menuItemValidate(1, 7);
            switch (item) {
                case 1:
                    this.searchByName();
                    break;
                case 2:
                    this.searchByAge();
                    break;
                case 3:
                    this.searchBySex();
                    break;
                case 4:
                    this.searchByMobile();
                    break;
                case 5:
                    this.searchByAddress();
                    break;
                case 6:
                    this.showAll();
                    break;
                case 7:
                    return;
                default:
                    break;
            }
        }
    }

    public void modifyLogic() {
        out.println("控制修改业务逻辑");
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while (true) {
            menu.modifyMenu();
            int item = regex.menuItemValidate(1, 3);
            switch (item) {
                case 1:
                    this.showAll();
                    break;
                case 2:
                    this.modifyOperate();
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
    }

    public void deleteLogic() {
        out.println("控制删除业务逻辑");
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while (true) {
            menu.deleteMenu();
            int item = regex.menuItemValidate(1, 4);
            switch (item) {
                case 1:
                    this.showAll();
                    break;
                case 2:
                    this.deleteOperate();
                    break;
                case 3:
                    this.deleteAllOperate();
                    break;
                case 4:
                    return;
                default:
                    break;
            }
        }
    }

    public void orderLogic() {
        out.println("控制排序业务逻辑");
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while (true) {
            menu.orderMenu();
            int item = regex.menuItemValidate(1, 5);
            switch (item) {
                case 1:
                    this.orderByName();
                    break;
                case 2:
                    this.orderByAge();
                    break;
                case 3:
                    this.orderBySex();
                    break;
                case 4:
                    this.showAll();
                    break;
                case 5:
                    return;
                default:
                    break;
            }
        }
    }

    public void addOperation() {
        out.println("添加新记录");
        TelNoteRegex regex = new TelNoteRegex();
        String name = regex.nameValidate();
        String age = regex.ageValidate();
        String sex = regex.sexValidate();
        String mobile = regex.mobileValidate();
        String address = regex.addressValidate();
        Person person = new Person(name, age, sex, mobile, address);
        this.list.add(person);
        person.setId(this.list.size());
    }

    public void showAll() {
        out.println("查看全记录");
        if (this.list.isEmpty()) {
            out.println("没有任何记录");
            return;
        }
        for (Person person : this.list) {
            out.println(person);
        }
    }

    public void searchByName() {
        out.println("按姓名查找，完全匹配 ");
        TelNoteRegex regex = new TelNoteRegex();
        String name = regex.nameValidate();
        boolean flag = true;
        for (Person person : this.list) {
            if (name.equals(person.getName())) {
                out.println(person);
                flag = false;
            }
        }
        if (flag) {
            out.println("没有此人记录");
        }
    }

    public void searchByAge() {
        out.println("按年龄查找");
        TelNoteRegex regex = new TelNoteRegex();
        String age = regex.ageValidate();
        boolean flag = true;
        for (Person person : this.list) {
            if (age.equals(person.getAge())) {
                out.println(person);
                flag = false;
            }
        }
        if (flag) {
            out.println("没有相关记录");
        }
    }

    public void searchBySex() {
        out.println("按性别查找");
        TelNoteRegex regex = new TelNoteRegex();
        String sex = regex.sexValidate();
        boolean flag = true;
        for (Person person : this.list) {
            if (sex.equalsIgnoreCase(person.getSex())) {
                out.println(person);
                flag = false;
            }
        }
        if (flag) {
            out.println("没有相关记录");
        }
    }

    public void searchByMobile() {
        out.println("按电话查找");
        TelNoteRegex regex = new TelNoteRegex();
        String mobile = regex.mobileValidate();
        boolean flag = true;
        for (Person person : this.list) {
            if (mobile.equals(person.getMobile())) {
                out.println(person);
                flag = false;
            }
        }
        if (flag) {
            out.println("没有相关记录");
        }
    }

    public void searchByAddress() {
        out.println("按地址信息查找");
        TelNoteRegex regex = new TelNoteRegex();
        String address = regex.addressValidate();
        boolean flag = true;
        for (Person person : this.list) {
            if (address.equals(person.getAddress())) {
                out.println(person);
                flag = false;
            }
        }
        if (flag) {
            out.println("没有相关记录");
        }
    }

    public void modifyOperate() {
        out.println("修改指定记录");
        TelNoteRegex regex = new TelNoteRegex();
        Menu menu = new Menu();
        out.println("请输入记录的序号");
        int item = regex.menuItemValidate(1, this.list.size());
        menu.subModifyMenu();
        int menuItem = regex.menuItemValidate(1, 6);
        switch (menuItem) {
            case 1:
                String name = regex.nameValidate();
                this.list.get(item - 1).setName(name);
                break;
            case 2:
                String age = regex.ageValidate();
                this.list.get(item - 1).setAge(age);
                break;
            case 3:
                String sex = regex.sexValidate();
                this.list.get(item - 1).setSex(sex);
                break;
            case 4:
                String mobile = regex.mobileValidate();
                this.list.get(item - 1).setMobile(mobile);
                break;
            case 5:
                String address = regex.addressValidate();
                this.list.get(item - 1).setAddress(address);
                break;
            case 6:
                return;
            default:
                break;
        }
    }

    public void deleteOperate() {
        out.println("删除指定记录");
        TelNoteRegex regex = new TelNoteRegex();
        out.println("请输入记录序号");
        int item = regex.menuItemValidate(1, this.list.size());
        this.list.remove(item - 1);
        //重新为记录设置新的序号
        for (int i = 0; i < this.list.size(); i++) {
            this.list.get(i).setId(i + 1);
        }
        out.println("删除成功，请继续操作");
    }

    public void deleteAllOperate() {
        out.println("删除所有记录");
        this.list.clear();
        out.println("电话本中的内容清空，请继续操作");
    }

    public void orderByName() {
        out.println("按名称排序");
        this.list.sort(new OrderByName());
        for (int i = 0; i < this.list.size(); i++) {
            this.list.get(i).setId(i + 1);
        }

    }

    public void orderByAge() {
        out.println("按年龄排序");
        this.list.sort(new OrderByAge());
        for (int i = 0; i < this.list.size(); i++) {
            this.list.get(i).setId(i + 1);
        }
    }

    public void orderBySex() {
        out.println("按性别排序");
        this.list.sort(new OrderBySex());
        for (int i = 0; i < this.list.size(); i++) {
            this.list.get(i).setId(i + 1);
        }
    }

    class OrderByName implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    class OrderByAge implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getAge().compareTo(o2.getAge());
        }
    }

    class OrderBySex implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getSex().compareTo(o2.getSex());
        }
    }
}
