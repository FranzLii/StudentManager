/*
 * Created by JFormDesigner on Fri Jun 03 21:35:20 CST 2022
 */

package cn.ingachi.gui;


import cn.ingachi.entity.Score;
import cn.ingachi.service.ClassesService;
import cn.ingachi.service.ScoreService;
import cn.ingachi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import cn.ingachi.dto.StudentDto;

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

/**
 * @author unknown
 */
@Component
public class ScoreManager extends JFrame {


    int selectedRows[] = {};
    @Autowired
    StudentService studentService;


    @Autowired
    ClassesService classesService;

    @Autowired
    ScoreAddGui scoreAddGui;

    @Autowired
    ScoreService scoreService;



    private Integer userId;

    public ScoreManager() {
        initComponents();
    }


    public void initTable(Integer id) {
        userId = id;
        Vector<String> columnNames = new Vector<>();
        columnNames.add("id");
        columnNames.add("科目");
        columnNames.add("成绩");
        columnNames.add("课程班级排名");
        StudentDto studentDto = studentService.getStudentDtoById(Long.valueOf(id));

        StudentDto studentDtoById = scoreService.getStudentScoreAndRankingById(id);
        Vector rowData = new Vector();
        if (studentDtoById!=null){
            for (Score score : studentDtoById.getScores()) {
                Vector<Serializable> row = new Vector<>();
                row.add(score.getId());
                row.add(score.getName());
                row.add(score.getScore());
                row.add(score.getRanking());
                rowData.add(row);
            }
        }

        table1.getTableHeader().setReorderingAllowed(false);
        table1.setModel(new DefaultTableModel(rowData, columnNames) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

    }

    private void button1KeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void button1MouseClicked(MouseEvent e) {
        initTable(userId);
    }

    private void button2MouseClicked(MouseEvent e) {
        for (int selectedRow : selectedRows) {
            scoreService.removeById((Serializable) table1.getValueAt(selectedRow, 0));
        }
        initTable(userId);
    }

    private void button3MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void button5MouseReleased(MouseEvent e) {
        // TODO add your code here
    }

    private void button5MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void button6MouseReleased(MouseEvent e) {
        // TODO add your code here
    }

    private void button3MouseReleased(MouseEvent e) {
        scoreAddGui.setVisible(true);
        scoreAddGui.initStudentId(userId);
    }

    private void scrollPane1MouseReleased(MouseEvent e) {

    }

    private void table1MouseReleased(MouseEvent e) {
        selectedRows = table1.getSelectedRows();
    }

    private void button4MouseReleased(MouseEvent e) {
        String text = textField1.getText();
        Vector<String> columnNames = new Vector<>();
        columnNames.add("id");
        columnNames.add("科目");
        columnNames.add("成绩");
        columnNames.add("课程班级排名");
        StudentDto studentDtoById = studentService.getStudentDtoById(Long.valueOf(userId));
        Vector rowData = new Vector();
        for (Score score : studentDtoById.getScores()) {
            if (text != null && text.length() != 0) {
                if (!score.getName().contains(text)) {
                    continue;
                }
            }
            Vector<Serializable> row = new Vector<>();
            row.add(score.getId());
            row.add(score.getName());
            row.add(score.getScore());
            rowData.add(row);
        }

        table1.getTableHeader().setReorderingAllowed(false);
        table1.setModel(new DefaultTableModel(rowData, columnNames) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });


        
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label1 = new JLabel();
        textField1 = new JTextField();
        button4 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    scrollPane1MouseReleased(e);
                }
            });

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
        button1.setText("\u5237\u65b0\u4fe1\u606f");
        button1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                button1KeyPressed(e);
                button1KeyPressed(e);
            }
        });
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
                button1MouseClicked(e);
            }
        });

        //---- button2 ----
        button2.setText("\u5220\u9664\u9009\u4e2d\u6210\u7ee9");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
                button2MouseClicked(e);
                button2MouseClicked(e);
            }
        });

        //---- button3 ----
        button3.setText("\u6dfb\u52a0\u6210\u7ee9");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
                button3MouseClicked(e);
                button3MouseClicked(e);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                button3MouseReleased(e);
            }
        });

        //---- label1 ----
        label1.setText("\u79d1\u76ee");

        //---- button4 ----
        button4.setText("\u67e5\u8be2");
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                button4MouseReleased(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button2)
                                .addComponent(button3)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(18, 18, 18)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                            .addGap(217, 217, 217)
                            .addComponent(button4)))
                    .addContainerGap(81, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button4))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button1)
                            .addGap(5, 5, 5)
                            .addComponent(button2)
                            .addGap(10, 10, 10)
                            .addComponent(button3))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(72, 72, 72)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(53, Short.MAX_VALUE))
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
    private JButton button3;
    private JLabel label1;
    private JTextField textField1;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
