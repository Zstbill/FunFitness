package org.uml.funfitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uml.funfitness.pojo.ClassOrder;
import org.uml.funfitness.pojo.ClassTable;
import org.uml.funfitness.service.ClassOrderService;
import org.uml.funfitness.service.ClassTableService;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassTableService classTableService;

    @Autowired
    private ClassOrderService classOrderService;

    //查询课程
    @RequestMapping("/selClass")
    public String selectClass(Model model) {
        List<ClassTable> classList = classTableService.findAll();
        model.addAttribute("classList", classList);
        return "selectClass";
    }

    //跳转新增课程页面
    @RequestMapping("/toAddClass")
    public String toAddClass() {
        return "addClass";
    }

    //新增课程
    @RequestMapping("/addClass")
    public String addClass(ClassTable classTable) {
        classTableService.insertClass(classTable);
        return "redirect:selClass";
    }

    //删除课程
    @RequestMapping("/delClass")
    public String deleteClass(Integer classId) {
        classTableService.deleteClassByClassId(classId);
        classTableService.deleteOrderByClassId(classId);
        return "redirect:selClass";
    }

    //查询课程报名信息
    @RequestMapping("/selClassOrder")
    public String selectClassOrder(Integer classId, Model model) {
        List<ClassOrder> classOrderList = classOrderService.selectMemberOrderList(classId);
        model.addAttribute("classOrderList", classOrderList);
        return "selectClassOrder";
    }
}
