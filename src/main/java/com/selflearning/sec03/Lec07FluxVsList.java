package com.selflearning.sec03;

import com.selflearning.common.Util;
import com.selflearning.sec03.helper.NameGenerator;

import javax.naming.Name;

public class Lec07FluxVsList {

    public static void main(String[] args) {
       // var list = NameGenerator.getNameList(10);
       // System.out.println(list);

        var list1 = NameGenerator.getNameListFlux(10);
        list1.subscribe(Util.subscriber());
    }
}
