package com.javarush.task.task19.task1903;
/* 
Адаптация нескольких интерфейсов
*/
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static void main(String[] args) {
//        IncomeData data = new IncomeData() {
//            @Override
//            public String getCountryCode() {
//                return null;
//            }
//
//            @Override
//            public String getCompany() {
//                return null;
//            }
//
//            @Override
//            public String getContactFirstName() {
//                return null;
//            }
//
//            @Override
//            public String getContactLastName() {
//                return null;
//            }
//
//            @Override
//            public int getCountryPhoneCode() {
//                return 7;
//            }
//
//            @Override
//            public int getPhoneNumber() {
//                return 12345678;
//            }
//        };
//        IncomeDataAdapter incomeDataAdapter = new IncomeDataAdapter(data);
//        System.out.println(incomeDataAdapter.getPhoneNumber());
//
    }

    public static class IncomeDataAdapter implements Customer, Contact{// унаследовались от покупателя и контакта
        private IncomeData data;

        public IncomeDataAdapter(IncomeData incomeData){
            this.data = incomeData;
        }

        @Override
        public String getCompanyName() { // название компании
            return data.getCompany();
        }

        @Override
        public String getCountryName() { // название страны
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() { // имя

            return  data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() { // телефон
            String phone = String.format("%010d",data.getPhoneNumber());//получили номер телефона c нулями
String phoneNumber = String.format("%+d(%s)%s-%s-%s", data.getCountryPhoneCode(),phone.substring(0,3),phone.substring(3,6), phone.substring(6,8), phone.substring(8,10)); //+38(050)123-45-67
//                                                                       substring(невключительно, включительно)

            return phoneNumber;
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }
// покупатель
    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }
// контакт
    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}