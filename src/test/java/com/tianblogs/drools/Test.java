package com.tianblogs.drools;

import com.tianblogs.drools.entity.ComparisonOperatorEntity;
import com.tianblogs.drools.entity.Order;
import com.tianblogs.drools.entity.Student;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.kie.api.KieServices;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class Test {

    @org.junit.Test
    public void test1(){

        //1 获取kieServices
        KieServices kieServices = KieServices.Factory.get();
        //2 获取 kie 容器对象
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        //3 获取 kie会话对象
        KieSession session = kieContainer.newKieSession();

        //Fact对象,事实对象
        Order order = new Order();
        order.setOriginalPrice(152.0);

        //将 order对象 插入到工作内存中去
        session.insert(order);
        //激活规则，由drools框架自动进行规则匹配，如果规则匹配成功，则执行当前规则
        session.fireAllRules(); //这里已经修改了order数据，下面可以直接获取得到数据


        System.out.println("优惠后的价格"+order.getRealPrice());

        //关闭session
        session.dispose();

    }

    //测试匹配模式
    @org.junit.Test
    public void test2(){

        //1 获取kieServices
        KieServices kieServices = KieServices.Factory.get();
        //2 获取 kie 容器对象
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        //3 获取 kie会话对象
        KieSession session = kieContainer.newKieSession();

        //Fact对象,事实对象
        ComparisonOperatorEntity fact = new ComparisonOperatorEntity();
        fact.setNames("李四");
        ArrayList<String> list = new ArrayList<>();
        list.add("1李四");
        fact.setList(list);

        //将 order对象 插入到工作内存中去
        session.insert(fact);

        //激活规则，由drools框架自动进行规则匹配，如果规则匹配成功，则执行当前规则
        session.fireAllRules(); //这里已经修改了order数据，下面可以直接获取得到数据

        //关闭session
        session.dispose();

    }
    //测试自定的匹配规则
    @org.junit.Test
    public void test3(){

        //1 获取kieServices
        KieServices kieServices = KieServices.Factory.get();
        //2 获取 kie 容器对象
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        //3 获取 kie会话对象
        KieSession session = kieContainer.newKieSession();

        //Fact对象,事实对象
        ComparisonOperatorEntity fact = new ComparisonOperatorEntity();
        fact.setNames("李四");
        ArrayList<String> list = new ArrayList<>();
        list.add("1李四");
        fact.setList(list);

        //将 order对象 插入到工作内存中去
        session.insert(fact);

        //激活规则，由drools框架自动进行规则匹配，如果规则匹配成功，则执行当前规则
        //session.fireAllRules(new RuleNameEqualsAgendaFilter("rule_comparison_notcontains")); //这里已经修改了order数据，下面可以直接获取得到数据
        //以什么什么开始的规则
        session.fireAllRules(new RuleNameStartsWithAgendaFilter("rule_"));
        //关闭session
        session.dispose();

    }

    //测试Drools 内置方法 -update
    @org.junit.Test
    public void test4(){

        //1 获取kieServices
        KieServices kieServices = KieServices.Factory.get();
        //2 获取 kie 容器对象
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        //3 获取 kie会话对象
        KieSession session = kieContainer.newKieSession();

        //Fact对象,事实对象
        Student student = new Student();
        student.setAge(5);

        //将 order对象 插入到工作内存中去
        session.insert(student);

        //激活规则，由drools框架自动进行规则匹配，如果规则匹配成功，则执行当前规则
        session.fireAllRules(); //这里已经修改了order数据，下面可以直接获取得到数据

        //关闭session
        session.dispose();

    }

    //测试Drools 内置方法 -insert
    @org.junit.Test
    public void test5(){

        //1 获取kieServices
        KieServices kieServices = KieServices.Factory.get();
        //2 获取 kie 容器对象
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        //3 获取 kie会话对象
        KieSession session = kieContainer.newKieSession();

        //Fact对象,事实对象
        Student student = new Student();
        student.setAge(10);

        //将 order对象 插入到工作内存中去
        session.insert(student);

        //激活规则，由drools框架自动进行规则匹配，如果规则匹配成功，则执行当前规则
        session.fireAllRules(); //这里已经修改了order数据，下面可以直接获取得到数据

        //关闭session
        session.dispose();

    }
}
