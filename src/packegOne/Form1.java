package packegOne;

import javax.swing.*;

public class Form1 extends JFrame{
    private JLabel lblCountry;
    private JTextField textFieldCountry;
    private JLabel lblTeamName;
    private JTextField textFieldTeamName;
    private JComboBox comboBoxCompetations;
    private JButton btnSubmit;
    private JLabel lblCompetationName;
    private JPanel mainPanel;

    public Form1(){
        setTitle("Main Frame");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        this.pack();
    }
    public static void main(String[] args){
        JFrame frame = new Form1();
        frame.setVisible(true);
    }
}
