package packegOne;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form1 {
    private JLabel lblCountry;
    private JTextField textFieldCountry;
    private JLabel lblTeamName;
    private JTextField textFieldTeamName;
    private JComboBox comboBoxCompetations;
    private JButton btnSubmit;
    private JLabel lblCompetationName;
    private JPanel mainPanel;
    private JLabel lblRanking;
    private JTextField textFieldRanking;
    private  JFrame frame1 = new JFrame("Frame 1");
    public Form1(){
        frame1.setContentPane(mainPanel);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(500,500);
        frame1.setVisible(true);
        frame1.pack();
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // hide the current panel
                // insert into the database the team
                if(e.getSource()==btnSubmit){
                    frame1.dispose();
                    Form2 form2 = new Form2(comboBoxCompetations.getToolTipText());
                }
            }
        });
    }
    public static void main(String[] args){
        Form1 frame = new Form1();

    }
}
