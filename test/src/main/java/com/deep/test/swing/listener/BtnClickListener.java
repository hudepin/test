package com.deep.test.swing.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName TimeConvertBtnClickListner
 * @create_date 2021.09.10 15:21
 * @since
 */
public class BtnClickListener implements MouseListener {
    private Integer type;

    public BtnClickListener(Integer type) {
        this.type = type;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("hdadad");
        System.out.println(e);

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
