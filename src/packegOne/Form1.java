package packegOne;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
public class Form1 {
    //region components : Labels TextFields ..
    //region Lables
    private JLabel lblCountry;
    private JLabel lblTeamName;
    private JLabel lblCompetationName;
    private JLabel lblRanking;
    //endregion
    //region Textfields
    private JTextField textFieldCountry;
    private JTextField textFieldTeamName;
    private JTextField textFieldRanking;
    //endregion
    //region comboBoxes
    private JComboBox comboBoxCompetitions;
    //endregion
    //region buttons
    private JButton btnSubmit;
    //endregion
    //region Panels
    private JPanel mainPanel;
    //endregion
    //region frames
    private final JFrame frame1 = new JFrame("Form 1");
    //endregion
    //endregion

    //region Default constructor Form1()
    public Form1() {

        frame1.setContentPane(mainPanel);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(500, 300);
        frame1.setLocation(450,200);
        frame1.setVisible(true);

        MySqlConn.init();

        String[] competitions = {"AI competition", "machine learning competition", "sisco competition"};
        DefaultComboBoxModel cb = new DefaultComboBoxModel(competitions);
        comboBoxCompetitions.setModel(cb);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnSubmit) {

                    frame1.dispose();

                    try {
                        MySqlConn.insertInputs(textFieldCountry.getText(),
                                textFieldTeamName.getText(),
                                comboBoxCompetitions.getItemAt(comboBoxCompetitions.getSelectedIndex()).toString(),
                                textFieldRanking.getText());
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    String selectedCompetition = comboBoxCompetitions.getItemAt(comboBoxCompetitions.getSelectedIndex()).toString();
                    new Form2(selectedCompetition);
                }
            }
        });

        comboBoxCompetitions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == comboBoxCompetitions) {
                    lblRanking.setVisible(true);
                    textFieldRanking.setVisible(true);
                    btnSubmit.setEnabled(true);
                }
            }
        });
    }
    //endregion
}
