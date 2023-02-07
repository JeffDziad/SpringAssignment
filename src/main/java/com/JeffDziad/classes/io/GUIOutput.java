package com.JeffDziad.classes.io;

import com.JeffDziad.interfaces.IOutput;

import javax.swing.*;
import java.awt.*;

public class GUIOutput extends Component implements IOutput {
    @Override
    public void out(String header, String msg) {
        JOptionPane.showMessageDialog(this, msg, header, JOptionPane.PLAIN_MESSAGE);
    }
}
