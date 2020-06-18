package fr.arinonia.valkyria.bootstrap.ui.components;

import fr.arinonia.valkyria.bootstrap.ui.BootstrapPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

/**
 * Created by Arinonia on 18/06/2020 inside the package - fr.arinonia.valkyria.bootstrap.ui.components
 */
public class CustomButton extends JButton implements MouseListener {

    private String text;
    private int width;
    private int height;

    public CustomButton(String text, int width, int height) {
        super(text);
        this.text = text;
        this.width = width;
        this.height = height;
        this.addMouseListener(this);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.setSize(this.width, this.height);
        Color[] gradients;
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);

        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        Shape firstClip = g.getClip();
        RoundRectangle2D rect = new RoundRectangle2D.Double();
        double arc = Math.ceil(getSize().getHeight() / 3);
        rect.setRoundRect(0, 0, Math.ceil(getSize().getWidth()), Math.ceil(getSize().getHeight()), arc, arc);
        Area secondClip = new Area(getBounds());
        secondClip.subtract(new Area(rect));
        Area finalClip = new Area(firstClip);
        finalClip.subtract(secondClip);
        g2.setClip(finalClip);
        g2.drawString(text, 70, 120);
        super.paintComponent(g2);
        gradients = new Color[]{new Color(34, 69, 161), new Color(57, 69, 191), new Color(81, 142, 213)};

        for (int i = 0; i < gradients.length; i++) {
            arc -= 2;
            g2.setColor(gradients[i]);
            g2.drawRoundRect(i + 1, i + 1, (int) Math.ceil(getSize().getWidth() - 2) - (i * 2), (int) Math.ceil(getSize().getHeight() - 2) - (i * 2), (int) arc, (int) arc);
        }

        if (this.getModel().isSelected()) {

        } else if (this.getModel().isRollover()) {
            this.setForeground(new Color(72, 147, 160));
        } else {
            this.setForeground(new Color(255, 255, 255));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}

