/*
 * Created by JFormDesigner on Fri Jun 24 15:15:49 CST 2022
 */

package cn.ingachi.gui;

import cn.ingachi.entity.Classes;
import cn.ingachi.service.ClassesService;
import cn.ingachi.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.util.List;
import java.util.Map;

/**
 * @author unknown
 */
@Component
@Slf4j
public class StudentScoreMap extends JFrame {
    @Autowired
    private ClassesService classesService;
    @Autowired
    private ScoreService scoreService;

    private List<Classes> classesList;

    private List<String> scoreNames;


    public StudentScoreMap() {
//        setVisible(true);
        initComponents();
    }

    public void initcombox1() {
        List<Classes> list = classesService.list();

        classesList = list;
//        将获取到的班级对象转化为名字数组，设置为第一个下拉框的选项内容
        comboBox1.setModel(new DefaultComboBoxModel(list.stream().map(Classes::getClassName).toArray()));
//        获取选中的项目
        String className = comboBox1.getSelectedItem().toString();
//        获取当前选中班级的id
        Integer cid = classesList.stream().filter(iter -> iter.getClassName().equals(className)).findFirst().get().getId();
//        通过班级id去初始话当前科目列表
        initcombox2(cid);
    }

    public void initcombox2(Integer cid) {
//        通过班级id获取所有科目
        scoreNames = scoreService.getScoreNamesByClassId(cid);

        comboBox2.setModel(new DefaultComboBoxModel(scoreNames.toArray()));
    }


    private void button1MouseClicked(MouseEvent e) {
        DefaultPieDataset dataSet = new DefaultPieDataset();

        String className = comboBox1.getSelectedItem().toString();
        Integer cid = classesList.stream().filter(iter -> iter.getClassName().equals(className)).findFirst().get().getId();

//        通过班级的id和科目的名字，获取不同分数段的人数
        List<Map<String, Object>> scoreMap = scoreService.getScoreMap(String.valueOf(comboBox2.getSelectedItem()), cid);

//        设置饼状图数据，根据数据生成饼状图
        dataSet.setValue("90,100 " +"  " + (Number) scoreMap.get(0).get("90,100") + "人", (Number) scoreMap.get(0).get("90,100"));
        dataSet.setValue("<60"+ "  " +(Number) scoreMap.get(0).get("<60") + "人", (Number) scoreMap.get(0).get("<60"));
        dataSet.setValue("70,79"+ "  " +(Number) scoreMap.get(0).get("70,79") + "人", (Number) scoreMap.get(0).get("70,79"));
        dataSet.setValue("60,69"+ "  " +(Number) scoreMap.get(0).get("60,69") + "人", (Number) scoreMap.get(0).get("60,69"));
        dataSet.setValue("80,89"+ "  " +(Number) scoreMap.get(0).get("80,89") + "人", (Number) scoreMap.get(0).get("80,89"));


        JFreeChart chart = ChartFactory.createPieChart(comboBox1.getSelectedItem() + " " + comboBox2.getSelectedItem() + "情况表", (PieDataset) dataSet, true, true, true);

        Font ftt = new Font("黑体", Font.BOLD, 40);
        Font ft = new Font("SimSun", 30, 30);//宋体

        LegendTitle legend = null;
        TextTitle txtTitle = null;
        PiePlot categoryplot = null;

        legend = chart.getLegend();
        txtTitle = chart.getTitle();
        categoryplot = (PiePlot) chart.getPlot();

        txtTitle.setFont(ftt); // 设置标题字体
        categoryplot.setLabelFont(ft);// 设置图片上固定指示文字字体
        legend.setItemFont(ft);// 设置图例字体

        ChartFrame chartFrame = new ChartFrame(comboBox1.getSelectedItem() + " " + comboBox2.getSelectedItem() + "结构图", chart);
        chartFrame.pack();
        chartFrame.setVisible(true);
    }

    private void button2MouseClicked(MouseEvent e) {
        initcombox1();
    }

//    监听下拉框选项改变
    private void comboBox1ItemStateChanged(ItemEvent e) {
        String className = comboBox1.getSelectedItem().toString();
        Integer cid = classesList.stream().filter(iter -> iter.getClassName().equals(className)).findFirst().get().getId();

        initcombox2(cid);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        comboBox1 = new JComboBox();
        comboBox2 = new JComboBox();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u73ed\u7ea7");

        //---- label2 ----
        label2.setText("\u79d1\u76ee");

        //---- comboBox1 ----
        comboBox1.addItemListener(e -> comboBox1ItemStateChanged(e));

        //---- button1 ----
        button1.setText("\u67e5\u8be2");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //---- button2 ----
        button2.setText("\u5237\u65b0");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(54, 54, 54)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(32, 32, 32)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(button1)
                    .addGap(18, 18, 18)
                    .addComponent(button2)
                    .addContainerGap(128, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2)
                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addContainerGap(79, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
