package packegOne;

import javax.swing.*;

public class Form2 {
    private JTable table1;
    private JLabel lblCompetationName;
    private JPanel panel2;
    private  JFrame frame;

    public Form2(String competationName){
        frame = new JFrame("Form 2");
        frame.setContentPane(panel2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.pack();

        lblCompetationName.setText(lblCompetationName.getText() + competationName);

    }
}
