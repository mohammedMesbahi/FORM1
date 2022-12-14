package packegOne;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.sql.*;

public class Form2 {
    private JTable table1;
    private JLabel lblCompetationName;
    private JPanel panel2;
    private  JFrame frame;
    private String competationName;
    private ResultSet res;
    private PreparedStatement stmt;

    public Form2(String competitionName) {
        frame = new JFrame("Form 2");
        frame.setContentPane(panel2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocation(450,200);
        frame.setVisible(true);
        lblCompetationName.setText(lblCompetationName.getText() + competitionName);
        this.competationName = competitionName;
        loadTable(competationName);
    }

    private void loadTable(String competitionName) {
        try {
            res = MySqlConn.getTable(competitionName);
            table1.setModel(DbUtils.resultSetToTableModel(res));
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

    }

}
