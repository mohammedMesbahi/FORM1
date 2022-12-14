package packegOne;
import java.sql.*;

public class MySqlConn{
    private static Connection conn;
    String url = "jdbc:mysql://localhost/java_project1";
    String user = "root";
    String password = "root";
    public MySqlConn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public  static Integer getCompetitionId(String competitionName) throws SQLException {
        String qr = "select competition_id from competition where competition_name = \"" + competitionName + "\"";
        int competition_id = -1;
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(qr);
        if (rs.next()) {
            competition_id = rs.getInt(1);
        }
        return competition_id;

    }
    public static int createTeam(String country, String teamName) throws SQLException {

        int generatedKey = -1;

        String qr = "insert into Team(country,team_name) values(?,?)";
        PreparedStatement ps = conn.prepareStatement(qr, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,country);
        ps.setString(2,teamName);
        ps.execute();

        ResultSet rs = ps.getGeneratedKeys();

        if (rs.next()) {
            generatedKey = rs.getInt(1);
        }
        return generatedKey;
    }

    public static void insertInputs(String country,
                                    String teamName,
                                    String selectedItem,
                                    String ranking) throws SQLException {
        Integer team_id = createTeam(country,teamName); // create the team and store the generated key
        Integer competition_id = getCompetitionId(selectedItem);
        insertInto_competition_participants(competition_id,team_id,ranking);
    }

    private static void insertInto_competition_participants(Integer competitionId,
                                                            Integer teamId,
                                                            String ranking) throws SQLException {
        PreparedStatement stmt=conn.prepareStatement("insert into competition_participants values(?,?,?)");
        stmt.setInt(1,competitionId);
        stmt.setInt(2,teamId);
        stmt.setInt(3,Integer.parseInt(ranking));
        stmt.executeUpdate();
    }

    public static ResultSet getTable(String competitionName) throws SQLException {
        Integer competition_id = MySqlConn.getCompetitionId(competitionName);
        Statement stm=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        String qry = "select team_name,ranking from competition_participants,team,competition where competition.competition_id = "+competition_id+" and competition_participants.competition_id = competition.competition_id and competition_participants.team_id = team.team_id;";
        return stm.executeQuery(qry);
    }
}