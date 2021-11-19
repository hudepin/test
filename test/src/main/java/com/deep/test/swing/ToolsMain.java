package com.deep.test.swing;

import com.deep.test.swing.listener.BtnClickListener;

import javax.swing.*;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName ToolsMain
 * @create_date 2021.09.10 14:58
 * @since
 */
public class ToolsMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            createGUI();
        });
    }
    public static void createGUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame jFrame = new JFrame("deep tools");
        jFrame.setSize(600, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        jFrame.add(panel);//添加面板
        addComponent(panel);
        jFrame.setVisible(true);

    }

    private static void addComponent(JPanel panel) {
        panel.setLayout(null);
        JLabel label = new JLabel("时间");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        label.setBounds(10,20,80,20);
        panel.add(label);
        JTextField textField = new JTextField(20);
        textField.setBounds(100,20,100,20);
        panel.add(textField);
        JButton button = new JButton("复制");
        button.setBounds(200,20,100,20);
        panel.add(button);

        JButton covBtn = new JButton("转换");
        covBtn.setBounds(100,40,100,20);
        covBtn.addMouseListener(new BtnClickListener(MouseClickType.convertBtn.getCode()));
        panel.add(covBtn);

        JLabel label2 = new JLabel("本地时间(GMT +08)");
        label2.setBounds(10,80,80,20);
        panel.add(label2);
        JTextField textField1 = new JTextField(20);
        textField1.setBounds(100,80,100,20);
        panel.add(textField1);
        JButton button1 = new JButton("复制");
        button1.setBounds(200,80,100,20);
        panel.add(button1);

    }
}
