package packegOne;
import packegOne.MySqlConn;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
        frame1.setSize(430,300);
        frame1.setVisible(true);
        String country[]={"India","Aus","U.S.A","England","Newzealand"};
        JComboBox cb=new JComboBox(country);

        comboBoxCompetations.setModel(cb.getModel());
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // hide the current panel
                // insert into the database the team
                if(e.getSource()==btnSubmit){
                    frame1.dispose();
                    String url = "jdbc:mysql://localhost/java_project1";
                    String user = "root";
                    String password = "root";
                    MySqlConn conn= new MySqlConn(url,user,password);

                    Form2 form2 = new Form2(comboBoxCompetations.getItemAt(comboBoxCompetations.getSelectedIndex()).toString());
                }
            }
        });
        comboBoxCompetations.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource()==comboBoxCompetations){
                    lblRanking.setVisible(true);
                    textFieldRanking.setVisible(true);
                }
            }
        });
    }
    public static void main(String[] args){
        Form1 frame = new Form1();

    }
}
