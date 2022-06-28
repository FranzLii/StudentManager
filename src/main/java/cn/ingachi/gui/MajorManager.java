/*
 * Created by JFormDesigner on Sat Jun 18 09:16:18 CST 2022
 */

package cn.ingachi.gui;

import cn.ingachi.dto.GradeDto;
import cn.ingachi.entity.Major;
import cn.ingachi.service.MajorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

/**
 * @author unknown
 */
@Component
@Slf4j
public class MajorManager extends JFrame {
    public MajorManager() {
        initComponents();
    }

    int selectedRows[] = {};

    @Autowired
    MajorService majorService;

    @Autowired
    MajorAdd majorAdd;

    public void initTable() {
        scrollPane1 = new JScrollPane();
//        从数据库中获取整个专业列表
        List<Major> list = majorService.list();

        Vector columnNames = new Vector();
        columnNames = new Vector<>();
        columnNames.add("专业id");
        columnNames.add("专业名称");
        Vector rowData = new Vector();
//        System.out.println(list);
//        将列表中各个元素添加至row，添加至rowdata中
        for (Major major : list) {
            Vector<java.io.Serializable> row = new Vector<>();
            row.add(major.getId());
            row.add(major.getName());
            rowData.add(row);
        }

//        将表设置为不可编辑与拖动
        table1.setModel(new DefaultTableModel(rowData, columnNames) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
    }

//    每次鼠标移开的时候获取表中选中的行
    private void table1MouseReleased(MouseEvent e) {
        selectedRows = table1.getSelectedRows();
    }

    private void button1MouseReleased(MouseEvent e) {
        initTable();
    }

    private void button2MouseReleased(MouseEvent e) {
        majorAdd.setVisible(true);
    }

//    获取上述选中的列的ID，通过数据库的方法将他删除
    private void button5MouseReleased(MouseEvent e) {
        for (int selectedRow : selectedRows) {
            majorService.removeById(Long.valueOf(table1.getValueAt(selectedRow, 0).toString()));
        }
        initTable();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button5 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    table1MouseReleased(e);
                }
            });
            scrollPane1.setViewportView(table1);
        }

        //---- button1 ----
        button1.setText("\u5237\u65b0\u6570\u636e");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                button1MouseReleased(e);
            }
        });

        //---- button2 ----
        button2.setText("\u6dfb\u52a0\u4e13\u4e1a\u4fe1\u606f");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                button1MouseReleased(e);
                button2MouseReleased(e);
            }
        });

        //---- button5 ----
        button5.setText("\u5220\u9664\u9009\u4e2d\u4e13\u4e1a\u4fe1\u606f");
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                button5MouseReleased(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 878, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(button5, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 495, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
